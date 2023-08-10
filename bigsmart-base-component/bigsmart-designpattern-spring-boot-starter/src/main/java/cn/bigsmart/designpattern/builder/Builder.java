package cn.bigsmart.designpattern.builder;

import java.io.Serializable;

/**
 * 建造者设计模式的抽象接口
 *
 * @param <T>
 */
public interface Builder<T> extends Serializable {

    T builder();

}
