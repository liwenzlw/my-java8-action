package com.daiji.demo.c_使用局部变量;

import com.daiji.demo.metadata.Apple;

/**
 * @author zenglw
 * @date 2018/10/2
 */
public class T {

    /**
     * 但局部变量必须显式声明为final，或事实上是final
     * 如果局部变量允许修改，会导致线程安全问题
     */
    public void 测试基础数据类型() {
        int portNumber = 8080;
        // 不允许在lambda表达式中修改portNumber
        Runnable r = () -> System.out.println(portNumber);

        // 不允许重新赋值
        //portNumber = 900;
    }

    public void 测试引用数据类型() {
        Apple apple1 = new Apple("绿色",100);
        // 不允许在lambda表达式中修改portNumber
        Runnable r = () -> {
            apple1.setColor("红色");
        };

        // 不允许重新赋值
        //apple1 = new Apple("",0);
    }

    public void 测试匿名内部类() {
        Apple apple1 = new Apple("绿色",100);
        // 不允许在lambda表达式中修改portNumber
        Runnable r = new Runnable() {
            @Override
            public void run() {
                apple1.setColor("红色");
            }
        };
        // 不允许重新赋值
        //apple1 = new Apple("",0);
    }
}
