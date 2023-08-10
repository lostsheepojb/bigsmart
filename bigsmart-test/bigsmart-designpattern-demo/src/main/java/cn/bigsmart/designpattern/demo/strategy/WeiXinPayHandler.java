package cn.bigsmart.designpattern.demo.strategy;

import cn.bigsmart.designpattern.strategy.Strategy;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;

@Component
public class WeiXinPayHandler implements Strategy<BigDecimal, Boolean> {
    @Override
    public String key() {
        return "WeiXinPay";
    }

    @Override
    public Boolean executeAndReturn(BigDecimal amount) {
        System.out.println("Wei xin pay!" + amount);
        return true;
    }

}
