package com.example.customerservice.config;

import lombok.Getter;
import lombok.Setter;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.cloud.context.config.annotation.RefreshScope;

@ConfigurationProperties(prefix = "global.params")
@Getter
@Setter
@RefreshScope
public class GlobalConfig{
  private int p1;
  private int p2;
}
