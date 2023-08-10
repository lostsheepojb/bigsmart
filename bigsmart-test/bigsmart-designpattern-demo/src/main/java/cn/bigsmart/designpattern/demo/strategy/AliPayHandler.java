package cn.bigsmart.designpattern.demo.strategy;

import cn.bigsmart.designpattern.strategy.Strategy;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;

@Component
public class AliPayHandler implements Strategy<BigDecimal,Boolean> {
    @Override
    public String key() {
        return "AliPay";
    }

    @Override
    public Boolean  executeAndReturn(BigDecimal amount){
        System.out.println("Ali pay:" + amount);
        return true;
    }

}
