package com.branch.branchhomework.util;

import java.io.IOException;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;

import com.fasterxml.jackson.core.JacksonException;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.deser.std.StdDeserializer;

/**
 * Custom deserializer to convert UTC dates into a custom string format.
 * Changes the format from yyyy-MM-dd'T'HH:mm:ssz to yyyy-MM-dd HH:mm:ss.
 */
public class UtcStringDateDeserializer extends StdDeserializer<String> {

  protected UtcStringDateDeserializer() {
    this(null);
  }

  protected UtcStringDateDeserializer(Class<?> vc) {
    super(vc);
  }

  @Override
  public String deserialize(JsonParser p, DeserializationContext ctxt) throws IOException, JacksonException {
    DateTimeFormatter sourceFormat = DateTimeFormatter.ofPattern("yyyy-MM-dd'T'HH:mm:ssz");
    DateTimeFormatter targetFormat = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
    LocalDateTime dateTime = LocalDateTime.parse(p.getValueAsString(),
        sourceFormat);
    String formatedDateTime = dateTime.atZone(ZoneId.of("UTC")).format(targetFormat);
    return formatedDateTime;
  }
}
