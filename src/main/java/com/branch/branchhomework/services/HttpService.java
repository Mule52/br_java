package com.branch.branchhomework.services;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import com.branch.branchhomework.domain.HttpGetResponse;

@Service
public class HttpService {

  /**
   * Gets an HttpGetResponse object representing the Github request response.
   * 
   * @param url A string of the URL endpoint to request.
   * @return HttpGetResponse object
   * @throws Exception
   */
  public HttpGetResponse getResponse(String url) throws Exception {

    URL urlObject;
    try {
      urlObject = new URL(url);
    } catch (MalformedURLException e) {
      return new HttpGetResponse(HttpStatus.BAD_REQUEST.value(),
          String.format("The requested URL is invalid: %s", url));
    }

    HttpURLConnection httpConnection = (HttpURLConnection) urlObject.openConnection();
    httpConnection.setRequestMethod("GET");
    httpConnection.setRequestProperty("Content-Type", "application/json; utf-8");
    httpConnection.setRequestProperty("Accept", "application/json");
    httpConnection.connect();

    int responseCode = httpConnection.getResponseCode();

    switch (responseCode) {
      case 200:
      case 201:
        // Get the body from the response
        BufferedReader reader = new BufferedReader(
            new InputStreamReader(httpConnection.getInputStream(), "utf-8"));
        StringBuilder sb = new StringBuilder();
        String line;
        while ((line = reader.readLine()) != null) {
          sb.append(line);
        }
        reader.close();
        return new HttpGetResponse(responseCode, httpConnection.getResponseMessage(), sb.toString());
    }

    // Return non 200/201 responses
    return new HttpGetResponse(responseCode, httpConnection.getResponseMessage());
  }
}
