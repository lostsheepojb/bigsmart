package cn.bigsmart.web.initialization;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;

/**
 * @author cjj
 * @date 2023/8/12 14:36
 * @description
 **/
@Data
@ConfigurationProperties(prefix = "bigsmart.web.initialize")
public class InitializeProperties {

    private Boolean enabled = true;

    private String protocol = "http";

}
