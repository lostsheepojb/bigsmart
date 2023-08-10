package cn.bigsmart.designpattern.demo.chain;

import cn.bigsmart.designpattern.chain.Chain;
import org.springframework.stereotype.Component;

import javax.servlet.http.HttpServletRequest;

/**
 * 登录参数校验处理器
 */
@Component
public class LonginValidationChainHandler implements Chain<HttpServletRequest> {
    @Override
    public String key() {
        return "Req_Param_Validation";
    }

    @Override
    public int order() {
        return 1;
    }

    @Override
    public void execute(HttpServletRequest request) {
        System.out.println("登录验证校验，执行顺序:" + order());
    }
}
