package cn.bigsmart.designpattern.demo.chain;

import cn.bigsmart.designpattern.chain.Chain;
import org.springframework.stereotype.Component;

import javax.servlet.http.HttpServletRequest;

/**
 * 授权参数校验处理器
 */
@Component
public class AuthValidationChainHandler implements Chain<HttpServletRequest> {
    @Override
    public String key() {
        return "Req_Param_Validation";
    }

    @Override
    public int order() {
        return 2;
    }

    @Override
    public void execute(HttpServletRequest request) {
        System.out.println("授权验证校验，执行顺序:" + order());
    }
}
