package cn.bigsmart.designpattern.strategy;

/**
 * 策略设计模式的抽象执行接口
 *
 * @param <Req>  执行策略的请求参数类型
 * @param <Resp> 执行策略的返回参数类型
 */
public interface Strategy<Req, Resp> {

    /**
     * 策略的标记，每种策略的key是不同的，是唯一的
     *
     * @return
     */
    String key();

    /**
     * 执行策略的抽象方法，不返回结果
     *
     * @param req 执行策略的请求参数
     */
    default void execute(Req req) {
    }

    /**
     * 执行策略的抽象方法，返回结果
     *
     * @param req 执行策略的请求参数
     * @return 执行策略后返回值
     */
    default Resp executeAndReturn(Req req) {
        return null;
    }

}
