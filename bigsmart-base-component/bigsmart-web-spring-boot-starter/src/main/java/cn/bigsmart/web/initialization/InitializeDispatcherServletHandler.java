package cn.bigsmart.web.initialization;

import cn.bigsmart.web.config.WebAutoConfig;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.CommandLineRunner;
import org.springframework.core.env.ConfigurableEnvironment;
import org.springframework.http.HttpMethod;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.servlet.DispatcherServlet;

/**
 * 通过 {@link InitializeDispatcherServletController} 初始化 {@link DispatcherServlet}
 */
@RequiredArgsConstructor
@Slf4j
public final class InitializeDispatcherServletHandler implements CommandLineRunner {

    private final RestTemplate restTemplate;
    private final ConfigurableEnvironment configurableEnvironment;

    private String protocol;

    @Override
    public void run(String... args) {
        String url = String.format("%s://127.0.0.1:%s%s%s",
                protocol,
                configurableEnvironment.getProperty("server.port", "8080"),
                configurableEnvironment.getProperty("server.servlet.context-path", ""),
                WebAutoConfig.INITIALIZE_PATH);
        try {
            restTemplate.execute(url, HttpMethod.GET, null, null);
        } catch (Throwable e) {
            log.error("Initialize dispatcherServlet fail, initialize url: {}", url);
        }
    }

    public String getProtocol() {
        return protocol;
    }

    public void setProtocol(String protocol) {
        this.protocol = protocol;
    }

}
