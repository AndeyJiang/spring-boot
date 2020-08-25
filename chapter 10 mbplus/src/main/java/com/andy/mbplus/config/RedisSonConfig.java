package com.andy.mbplus.config;

import org.redisson.Redisson;
import org.redisson.api.RedissonClient;
import org.redisson.config.Config;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.ClassPathResource;

import java.io.IOException;

/**
 * @Description  Stand-alone verison > Redisson
 * @Date         Struggling in present
 */
@Configuration
public class RedisSonConfig {
    @Bean(destroyMethod = "shutdown")
    public RedissonClient redisson() throws IOException {
        RedissonClient redisson= Redisson.create(
                Config.fromYAML(new ClassPathResource("redisson-single.yml").getInputStream())
        );
        return  redisson;
    }

}
