package cn.bigsmart.designpattern.chain;

import cn.bigsmart.base.ApplicationContextHolder;
import cn.bigsmart.base.exception.ServiceException;
import org.springframework.boot.CommandLineRunner;

import java.util.*;
import java.util.stream.Collectors;

/**
 * 责任链上下文
 */
public class ChainContext implements CommandLineRunner {

    private Map<String, List<Chain>> chainContainer = new HashMap<>();

    /**
     * 获取责任链
     *
     * @param key 责任链标识
     * @return 返回责任链
     */
    public List<Chain> getChain(String key) {
        List<Chain> chains = chainContainer.get(key);
        if (chains == null) {
            throw new ServiceException(String.format("[%s] Chain of Responsibility ID is undefined", key));
        }
        return chains;
    }

    /**
     * 依次执行责任链
     *
     * @param key   责任链标识
     * @param req   请求参数
     * @param <Req> 请求参数类型
     */
    public <Req> void execute(String key, Req req) {
        List<Chain> chain = getChain(key);
        chain.forEach(each -> each.execute(req));
    }

    /**
     * 项目启动后，将责任链加载到责任链上下文中
     *
     * @param args
     * @throws Exception
     */
    @Override
    public void run(String... args) throws Exception {
        Map<String, Chain> beans = ApplicationContextHolder.getBeansOfType(Chain.class);
        beans.forEach((beanName, chain) -> {
            List<Chain> chains = chainContainer.get(chain.key());
            if (chains == null) {
                chains = new ArrayList<>();
            }
            chains.add(chain);
            chains = chains.stream().sorted(Comparator.comparing(Chain::order)).collect(Collectors.toList());
            chainContainer.put(chain.key(), chains);
        });
    }
}
