package cn.bigsmart.web.initialization;

import cn.bigsmart.web.config.WebAutoConfig;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * 初始化 {@link org.springframework.web.servlet.DispatcherServlet}
 */
@Slf4j(topic = "Initialize DispatcherServlet")
@RestController
public final class InitializeDispatcherServletController {

    @GetMapping(WebAutoConfig.INITIALIZE_PATH)
    public void initializeDispatcherServlet() {
        log.info("Initialized the dispatcherServlet to improve the first response time of the interface...");
    }
}
