package com.oddcc.leetcode.utils;

import lombok.Getter;
import lombok.Setter;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

@Component
@ConfigurationProperties(prefix = "leetcode")
@Getter
@Setter
public class Config {
    private String account;
    private String password;
}
