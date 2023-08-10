package cn.bigsmart.config;

import cn.bigsmart.base.config.ApplicationBaseAutoConfig;
import cn.bigsmart.designpattern.chain.ChainContext;
import cn.bigsmart.designpattern.strategy.StrategySelector;
import org.springframework.boot.autoconfigure.ImportAutoConfiguration;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.context.annotation.Bean;

@ImportAutoConfiguration(ApplicationBaseAutoConfig.class)
public class DesignPatternAutoConfig {

    @Bean
    @ConditionalOnMissingBean
    public StrategySelector strategySelector(){
        return new StrategySelector();
    }

    @Bean
    @ConditionalOnMissingBean
    public ChainContext chainContext(){
        return new ChainContext();
    }

}
