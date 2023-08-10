package cn.bigsmart.base.config;

import cn.bigsmart.base.ApplicationContextHolder;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.context.annotation.Bean;

public class ApplicationBaseAutoConfig {

    @Bean
    @ConditionalOnMissingBean
    public ApplicationContextHolder applicationContextHolder(){
        return new ApplicationContextHolder();
    }

}
