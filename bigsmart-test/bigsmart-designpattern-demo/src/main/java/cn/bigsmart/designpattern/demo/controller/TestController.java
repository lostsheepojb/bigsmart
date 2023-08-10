package cn.bigsmart.designpattern.demo.controller;

import cn.bigsmart.base.result.Result;
import cn.bigsmart.base.result.ResultUtils;
import cn.bigsmart.designpattern.chain.ChainContext;
import cn.bigsmart.designpattern.strategy.StrategySelector;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.ServletRequest;
import javax.servlet.http.HttpServletRequest;
import java.math.BigDecimal;

@RestController
@AllArgsConstructor
public class TestController {

    private final StrategySelector strategySelector;
    private final ChainContext chainContext;

    @GetMapping("/pay")
    public Result pay(String payType, BigDecimal amount){

        Object o = strategySelector.selectAndExecuteAndReturn(payType, amount);

        return ResultUtils.success(o);
    }

    @GetMapping("/chain/execute")
    public Result pay(String key , HttpServletRequest request){

       chainContext.execute(key, request);

        return ResultUtils.success();
    }
}
