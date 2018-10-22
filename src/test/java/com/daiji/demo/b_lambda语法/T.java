package com.daiji.demo.b_lambda语法;

import com.daiji.demo.metadata.BaseInterface1;
import com.daiji.demo.metadata.BaseInterface2;
import com.daiji.demo.metadata.BaseInterface3;
import java.util.function.BiFunction;
import java.util.function.Function;
import java.util.function.Supplier;
import java.util.function.UnaryOperator;
import org.junit.Test;
import org.springframework.boot.autoconfigure.kafka.KafkaProperties.Producer;

/**
 * lambda表达式语法
 * @author zenglw
 * @date 2018/10/2
 */
public class T {

    @Test
    public void 测试语法() {
        //语法 1 ：(入参) -> 表达式（表达式的结果会作为返回值）
        BaseInterface1 b1 = () -> System.out.println("1".toString());
        BaseInterface2 b2 = () -> 1;
        BaseInterface3 b3 = (a,b) -> a+b;
        b1.doSomething();
        System.out.println(b2.doSomething());
        System.out.println(b3.doSomething(1,2));

        //语法 2：(入参) -> {方法体}
        BaseInterface1 c1 = () -> {System.out.println("1".toString());};
        BaseInterface2 c2 = () -> {return 1;};
        BaseInterface3 c3 = (a,b) -> {return a+b;};
        c1.doSomething();
        System.out.println(c2.doSomething());
        System.out.println(c3.doSomething(1,2));
    }

    @Test
    public void 测试方法引用() {

        String s = "abc";
        // 1. 静态方法引用
        Function<String, Integer> function = Integer::parseInt;
        Function<String, Integer> function2 = new Function<String, Integer>() {
            @Override
            public Integer apply(String s) {
                return Integer.parseInt(s);
            }
        };

        // 2. 实例方法引用
        // 2.1 任意对象
        Function<Integer, String> function1 = Object::toString;

        // 2.2 当前对象
        Supplier<String> supplier = s::toString;

        // 应用
        System.out.println(function.apply("567"));
        System.out.println(function1.apply(123));
        System.out.println(supplier.get());
    }
}
