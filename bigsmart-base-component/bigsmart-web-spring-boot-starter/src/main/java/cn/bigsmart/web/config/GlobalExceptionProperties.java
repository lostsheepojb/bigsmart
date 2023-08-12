package cn.bigsmart.web.config;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;

/**
 * @author cjj
 * @date 2023/8/12 14:36
 * @description
 **/
@Data
@ConfigurationProperties(prefix = "bigsmart.web.global.exception")
public class GlobalExceptionProperties {

    private Boolean enabled = true;

}
