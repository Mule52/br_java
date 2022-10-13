package com.branch.branchhomework.domain;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import com.fasterxml.jackson.annotation.JsonSetter;

@JsonPropertyOrder({ "name", "url" })
@JsonIgnoreProperties(ignoreUnknown = true)
public class UserRepoDto {

  public String name;

  @JsonSetter("html_url")
  @JsonProperty("url")
  public String url;
}
