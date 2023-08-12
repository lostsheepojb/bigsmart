package cn.bigsmart.web.initialization;

import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.core.env.ConfigurableEnvironment;
import org.springframework.http.client.ClientHttpRequestFactory;
import org.springframework.http.client.SimpleClientHttpRequestFactory;
import org.springframework.web.client.RestTemplate;

/**
 * @author cjj
 * @date 2023/8/12 10:58
 * @description
 **/
@EnableConfigurationProperties({InitializeProperties.class})
@ConditionalOnProperty(name = "bigsmart.web.initialize.enabled", havingValue = "true", matchIfMissing = true)
public class InitializeAutoConfig {

    public final static String INITIALIZE_PATH="/dispatcher-servlet/initialize";

    @Bean
    public InitializeDispatcherServletController initializeDispatcherServletController() {
        return new InitializeDispatcherServletController();
    }

    @Bean
    public InitializeDispatcherServletHandler initializeDispatcherServletHandler(RestTemplate simpleRestTemplate, ConfigurableEnvironment configurableEnvironment,InitializeProperties initializeProperties) {
        InitializeDispatcherServletHandler handler = new InitializeDispatcherServletHandler(simpleRestTemplate, configurableEnvironment);
        handler.setProtocol(initializeProperties.getProtocol());
        return handler;
    }

    @Bean
    public RestTemplate simpleRestTemplate(ClientHttpRequestFactory factory) {
        return new RestTemplate(factory);
    }

    @Bean
    public ClientHttpRequestFactory simpleClientHttpRequestFactory() {
        SimpleClientHttpRequestFactory factory = new SimpleClientHttpRequestFactory();
        factory.setReadTimeout(5000);
        factory.setConnectTimeout(5000);
        return factory;
    }

}
