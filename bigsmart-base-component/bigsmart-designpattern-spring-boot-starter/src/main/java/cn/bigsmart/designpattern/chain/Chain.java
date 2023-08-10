package cn.bigsmart.designpattern.chain;

/**
 * 责任链设计模式抽象接口
 *
 * @param <Req>
 */
public interface Chain<Req> {

    /**
     * 责任链标识
     *
     * @return
     */
    String key();

    /**
     * 责任链执行顺序
     *
     * @return
     */
    int order();

    /**
     * 责任链具体执行
     *
     * @param req 责任链执行请求参数
     */
    void execute(Req req);
}
