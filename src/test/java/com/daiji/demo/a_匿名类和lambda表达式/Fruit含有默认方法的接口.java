package com.daiji.demo.a_匿名类和lambda表达式;

/**
 * @Note 函数式接口
 * @author zenglw
 * @date 2018/10/2
 */
public interface Fruit含有默认方法的接口 {

    default String getColor() {
        return "red";
    }

    Integer getWeight();

}
