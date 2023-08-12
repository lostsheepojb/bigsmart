package cn.bigsmart.web.exception;

import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;

/**
 * @author cjj
 * @date 2023/8/12 10:58
 * @description
 **/
@EnableConfigurationProperties({GlobalExceptionProperties.class})
@ConditionalOnProperty(name = "bigsmart.web.global.exception.enabled", havingValue = "true", matchIfMissing = true)
public class GlobalExceptionAutoConfig {

    @Bean
    public GlobalExceptionHandler globalExceptionHandler() {
        return new GlobalExceptionHandler();
    }

}
