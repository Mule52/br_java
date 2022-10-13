package com.branch.branchhomework.domain;

import com.branch.branchhomework.util.UtcStringDateDeserializer;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import com.fasterxml.jackson.annotation.JsonSetter;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;

@JsonPropertyOrder({ "user_name", "display_name", "avatar", "geo_location", "email", "url", "created_at", "repos" })
@JsonIgnoreProperties(ignoreUnknown = true)
public class UserDto {

  @JsonProperty("user_name")
  @JsonSetter("login")
  public String userName;

  @JsonProperty("display_name")
  @JsonSetter("name")
  public String displayName;

  @JsonProperty("avatar")
  @JsonSetter("avatar_url")
  public String avatar;

  @JsonProperty("geo_location")
  @JsonSetter("location")
  public String geoLocation;

  public String email;

  @JsonProperty("url")
  @JsonSetter("html_url")
  public String url;

  @JsonDeserialize(using = UtcStringDateDeserializer.class)
  public String created_at;

  public UserRepoDto[] repos;
}
