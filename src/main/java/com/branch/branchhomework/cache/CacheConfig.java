package com.branch.branchhomework.cache;

import com.github.benmanes.caffeine.cache.Caffeine;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.cache.CacheManager;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.cache.caffeine.CaffeineCacheManager;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.concurrent.TimeUnit;

@Configuration
@EnableCaching
public class CacheConfig {

  @Value("${cache.expiration.seconds}")
  int cacheExpirationInSeconds;

  @Bean
  public Caffeine caffeineConfig() {
    return Caffeine.newBuilder()
        .expireAfterWrite(cacheExpirationInSeconds, TimeUnit.SECONDS);
  }

  @Bean
  public CacheManager cacheManager(Caffeine caffeine) {
    CaffeineCacheManager caffeineCacheManager = new CaffeineCacheManager();
    caffeineCacheManager.getCache("users");
    caffeineCacheManager.setCaffeine(caffeine);
    return caffeineCacheManager;
  }

}
