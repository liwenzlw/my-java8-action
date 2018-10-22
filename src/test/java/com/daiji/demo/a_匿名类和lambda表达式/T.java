package com.daiji.demo.a_匿名类和lambda表达式;

import org.junit.Test;

/**
 * @Target 验证匿名类和lambda表达式的管理
 *
 * @author zenglw
 * @date 2018/10/2
 */
public class T {

    @Test
    public void 含有多个方法的匿名类() {

        Fruit有两个方法的接口 apple = new Fruit有两个方法的接口() {

            public double getWeight() {
                return 100;
            }

            public String getColor() {
                return "红色";
            }
        };

        //Fruit有两个方法的接口 orangin = () -> {};
    }

    @Test
    public void 含有一个方法的匿名类() {

        // 使用匿名类
        Fruit只有一个抽象方法的接口 apple = new Fruit只有一个抽象方法的接口() {

            @Override
            public double getWeight() {
                return 100;
            }
        };

        // 使用lambda表达式
        Fruit只有一个抽象方法的接口 apple2 = () -> 100;
    }

    public void 默认方法() {

        // 使用匿名类
        Fruit含有默认方法的接口 apple = new Fruit含有默认方法的接口() {

            @Override
            public Integer getWeight() {
                return 100;
            }
        };

        // 使用lambda表达式
        Fruit含有默认方法的接口 apple2 = () -> 100;
    }
}
