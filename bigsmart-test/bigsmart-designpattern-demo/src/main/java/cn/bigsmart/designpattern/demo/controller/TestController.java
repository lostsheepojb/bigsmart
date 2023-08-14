package cn.bigsmart.designpattern.demo.controller;

import cn.bigsmart.base.result.Result;
import cn.bigsmart.designpattern.chain.ChainContext;
import cn.bigsmart.designpattern.strategy.StrategySelector;
import cn.bigsmart.web.ResultUtils;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.AllArgsConstructor;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import javax.validation.constraints.NotBlank;
import java.math.BigDecimal;

@RestController
@AllArgsConstructor
@Validated
@Api(tags = "测试")
public class TestController {

    private final StrategySelector strategySelector;
    private final ChainContext chainContext;

    @GetMapping("/pay")
    public Result pay( @NotBlank String payType, BigDecimal amount) {

        Object o = strategySelector.selectAndExecuteAndReturn(payType, amount);

        return ResultUtils.success(o);
    }

    @GetMapping("/chain/execute")
    public Result chain(String key, HttpServletRequest request) {

        chainContext.execute(key, request);

        return ResultUtils.success();
    }

    @PostMapping("/post")
    public Result post(@RequestBody @Validated TestReqArg arg) {

        if (arg.getId() == 1) {
            throw new RuntimeException();
        }

        return ResultUtils.success(arg);
    }

    @GetMapping("/get")
    @ApiOperation("get方法测试")
    public Result get(@Validated TestReqArg arg) {

        if (arg.getId() == 1) {
            throw new RuntimeException();
        }

        return ResultUtils.success(arg);
    }
}
