package com.branch.branchhomework.services;

import java.io.IOException;

import org.springframework.cache.annotation.Cacheable;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import com.branch.branchhomework.domain.HttpGetResponse;
import com.branch.branchhomework.domain.UserDto;
import com.branch.branchhomework.domain.UserRepoDto;
import com.branch.branchhomework.exceptions.BadRequestException;
import com.branch.branchhomework.exceptions.UserNotFoundException;
import com.branch.branchhomework.exceptions.UserRepoNotFoundException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.json.JsonMapper;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;

@Service
public class UserService {

  private final String USER_URL = "https://api.github.com/users";
  private final String USER_REPOS_URL = "https://api.github.com/users";

  final HttpService httpService;

  public UserService(HttpService httpService) {
    this.httpService = httpService;
  }

  /**
   * Gets a UserDto object by calling HttpService.
   * 
   * @param userId A string of the userId to request.
   * @return UserDto
   * @throws Exception
   */
  @Cacheable(cacheNames = "users")
  public UserDto getUser(String userId) throws Exception {

    if (userId == null)
      throw new UserNotFoundException(userId);

    // Clean up the userId. Validate min and max characters.
    userId = userId.trim();
    if (userId.length() < 1 || userId.length() > 39)
      throw new UserNotFoundException(userId);

    // Get the user data from an HTTP GET request
    HttpGetResponse getUserResponse = httpService.getResponse(
        String.format("%s/%s", USER_URL, userId));

    if (getUserResponse.statusCode == HttpStatus.BAD_REQUEST.value())
      throw new BadRequestException(getUserResponse.message);

    if (getUserResponse.statusCode != HttpStatus.OK.value())
      throw new UserNotFoundException(userId);

    ObjectMapper mapper = JsonMapper.builder()
        .addModule(new JavaTimeModule())
        .build();

    UserDto user = null;
    try {
      user = mapper.readValue(getUserResponse.response, UserDto.class);
    } catch (IOException e) {
      e.printStackTrace();
    }

    if (user != null) {
      // Get the user repo data from an HTTP GET request
      HttpGetResponse getUserReposResponse = httpService
          .getResponse(String.format("%s/%s/repos", USER_REPOS_URL, userId));

      if (getUserReposResponse.statusCode != HttpStatus.OK.value())
        throw new UserRepoNotFoundException(userId);

      user.repos = mapper.readValue(getUserReposResponse.response, UserRepoDto[].class);
    }

    return user;
  }

}
