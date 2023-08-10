package cn.bigsmart.designpattern.strategy;

import cn.bigsmart.base.ApplicationContextHolder;
import cn.bigsmart.base.exception.ServiceException;
import org.springframework.boot.CommandLineRunner;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

/**
 * 策略模式选择器
 */
public class StrategySelector implements CommandLineRunner {

    private final Map<String, Strategy> strategyContainer = new HashMap<>();

    /**
     * 选择策略
     *
     * @param key 策略的唯一标识
     * @return 返回策略执行器
     * @see cn.bigsmart.designpattern.strategy.Strategy#key()
     */
    public Strategy select(String key) {
        return Optional.ofNullable(strategyContainer.get(key))
                .orElseThrow(() -> new ServiceException(String.format("[%s]策略未定义", key)));
    }

    /**
     * 选择策略执行器并执行，不返回结果
     *
     * @param key   策略的唯一标识
     * @param req   策略的入参
     * @param <Req> 策略的入参类型
     */
    public <Req> void selectAndExecute(String key, Req req) {
        Strategy strategy = this.select(key);
        strategy.execute(req);
    }

    /**
     * 选择策略执行器并执行，返回结果
     *
     * @param key    策略的唯一标识
     * @param req    策略的入参
     * @param <Req>  策略的入参类型
     * @param <Resp> 策略的返回参数类型
     * @return
     */
    public <Req, Resp> Resp selectAndExecuteAndReturn(String key, Req req) {
        Strategy strategy = this.select(key);
        return (Resp) strategy.executeAndReturn(req);
    }


    /**
     * springboot 应用启动后所有策略加载到策略容器
     *
     * @param args
     */
    @Override
    public void run(String... args) {
        Map<String, Strategy> actual = ApplicationContextHolder.getBeansOfType(Strategy.class);
        actual.forEach((beanName, bean) -> {
            Strategy beanExist = strategyContainer.get(bean.key());
            if (beanExist != null) {
                throw new ServiceException(String.format("[%s] Duplicate execution policy", bean.key()));
            }
            strategyContainer.put(bean.key(), bean);
        });
    }
}
