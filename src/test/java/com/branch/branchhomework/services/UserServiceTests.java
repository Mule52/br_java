package com.branch.branchhomework.services;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.when;

import java.io.InputStream;
import java.nio.charset.StandardCharsets;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import com.branch.branchhomework.domain.HttpGetResponse;
import com.branch.branchhomework.domain.UserDto;
import com.branch.branchhomework.exceptions.UserNotFoundException;

@SpringBootTest
@TestInstance(TestInstance.Lifecycle.PER_CLASS)
public class UserServiceTests {

  @MockBean
  HttpService httpService;

  String userResponseJson;
  String userReposResponseJson;

  @BeforeAll
  void beforeAll() {
    try (InputStream in = Thread.currentThread().getContextClassLoader()
        .getResourceAsStream("testData/user.json")) {
      userResponseJson = new String(in.readAllBytes(), StandardCharsets.UTF_8);
    } catch (Exception e) {
      throw new RuntimeException(e);
    }

    try (InputStream in = Thread.currentThread().getContextClassLoader()
        .getResourceAsStream("testData/userRepos.json")) {
      userReposResponseJson = new String(in.readAllBytes(), StandardCharsets.UTF_8);
    } catch (Exception e) {
      throw new RuntimeException(e);
    }
  }

  @Test
  public void getUserShouldReturnAValidUserDto() throws Exception {

    HttpGetResponse getUserResponse = new HttpGetResponse(200, "OK", userResponseJson);
    HttpGetResponse getUserReposResponse = new HttpGetResponse(200, "OK", userReposResponseJson);
    when(httpService.getResponse(anyString())).thenReturn(getUserResponse, getUserReposResponse);

    UserService service = new UserService(httpService);
    UserDto result = service.getUser("octocat");

    assertEquals("octocat", result.userName);
    assertEquals(8, result.repos.length);
  }

  @Test()
  public void getUserShouldThrowUserNotFoundExceptionWhenUserIsNotFound() throws Exception {

    HttpGetResponse getUserResponse = new HttpGetResponse(404, "Not Found");
    when(httpService.getResponse(anyString())).thenReturn(getUserResponse);

    UserService service = new UserService(httpService);

    UserNotFoundException thrown = assertThrows(
        UserNotFoundException.class,
        () -> service.getUser("octocat"));

    assertTrue(thrown.getMessage().contains("No Github user was found with this user name: octocat"));
  }

}
