package com.branch.branchhomework.controllers;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

import java.io.InputStream;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultHandlers;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import com.branch.branchhomework.domain.UserDto;
import com.branch.branchhomework.domain.UserRepoDto;
import com.branch.branchhomework.services.UserService;
import com.fasterxml.jackson.databind.ObjectMapper;

@SpringBootTest
@TestInstance(TestInstance.Lifecycle.PER_CLASS)
public class UserControllerTests {

  MockMvc mvc;

  @Autowired
  WebApplicationContext webApplicationContext;

  @MockBean
  UserService userService;

  UserDto testUser;

  @BeforeAll
  void beforeAll() {
    ObjectMapper mapper = new ObjectMapper();
    try (InputStream in = Thread.currentThread().getContextClassLoader()
        .getResourceAsStream("testData/user.json")) {
      testUser = mapper.readValue(in, UserDto.class);
    } catch (Exception e) {
      throw new RuntimeException(e);
    }

    try (InputStream in = Thread.currentThread().getContextClassLoader()
        .getResourceAsStream("testData/userRepos.json")) {
      testUser.repos = mapper.readValue(in, UserRepoDto[].class);
    } catch (Exception e) {
      throw new RuntimeException(e);
    }
  }

  @BeforeEach
  void beforeEach() {
    mvc = MockMvcBuilders.webAppContextSetup(webApplicationContext).build();
  }

  @Test
  public void getUserShouldReturnAValidUserDto() throws Exception {

    when(userService.getUser("octocat")).thenReturn(testUser);
    
    UserController controller = new UserController(userService);
    ResponseEntity<UserDto> result = controller.getUser("octocat");

    assertEquals(HttpStatus.OK, result.getStatusCode());
    assertEquals(testUser.userName, result.getBody().userName);
    assertEquals(testUser.repos.length, result.getBody().repos.length);
  }

  @Test
  public void getUserShouldReturnAValidResponseWithFormattedJsonProperties() throws Exception {
    when(userService.getUser("octocat")).thenReturn(testUser);

    mvc.perform(MockMvcRequestBuilders
      .get("/api/v1/users/octocat")
      .accept(MediaType.APPLICATION_JSON))
      .andDo(MockMvcResultHandlers.print())
      .andExpect(MockMvcResultMatchers.status().isOk())
      .andExpect(MockMvcResultMatchers.jsonPath("$.user_name").value("octocat"))
      .andExpect(MockMvcResultMatchers.jsonPath("$.display_name").value("The Octocat"))
      .andExpect(MockMvcResultMatchers.jsonPath("$.avatar").value("https://avatars.githubusercontent.com/u/583231?v=4"))
      .andExpect(MockMvcResultMatchers.jsonPath("$.geo_location").value("San Francisco"))
      .andExpect(MockMvcResultMatchers.jsonPath("$.email").doesNotExist())
      .andExpect(MockMvcResultMatchers.jsonPath("$.url").value("https://github.com/octocat"))
      .andExpect(MockMvcResultMatchers.jsonPath("$.created_at").value("2011-01-25 18:44:36"))
      .andExpect(MockMvcResultMatchers.jsonPath("$.repos[0].name").value("boysenberry-repo-1"))
      .andExpect(MockMvcResultMatchers.jsonPath("$.repos[0].url").value("https://github.com/octocat/boysenberry-repo-1"))
      .andExpect(MockMvcResultMatchers.jsonPath("$.repos.length()").value(8));
  }
}
