package com.daiji.demo.g_实战;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;
import org.junit.Test;
import org.springframework.util.StreamUtils;
import org.springframework.util.StringUtils;

/**
 * @author zenglw
 * @date 2018/10/6
 */
public class T {

    /**
     * filter, skip, limit
     */
    @Test
    public void test从0_100中提取前10个偶数但不包括不包括024() {
        List<Integer> intArray = new ArrayList();
        for (int i = 0; i < 100; i++) {
            intArray.add(i);
        }
        List<Integer> list = intArray.stream().filter(a -> a % 2 == 0)
            .skip(0)
            .skip(2)
            .skip(4)
            .limit(10)
            .collect(Collectors.toList());

        list.forEach(a -> System.out.println(a));
    }


    @Test
    public void testMap映射() {
        // 元数据
        String metaData = "java8 实战";

        // 在metaData的每个字符后面加上一个逗号
        String[] split = metaData.split("");
        System.out.println("----元数据：" + Arrays.toString(split));
        System.out.println();

        // 示例1：给字符串的每个字符后面加上一个逗号
        String collect = Arrays.stream(split).map(a -> a + ",").collect(Collectors.joining());
        System.out.println("示例1：给字符串的每个字符后面加上一个逗号");
        System.out.println(collect);
    }

    /**
     * flatmap方法让你把一个流中的每个值都换成另一个流
     * @ for for
     */
    @Test
    public void testFlatMap扁平映射() {
        // 元数据
        List<String> words = Arrays.asList("Java 8", "实战", "你有在学吗");

        words.stream()
            .map(word -> word.split(""))

            ;
        // 如何得到words中的所有字符
        // 方案1 ： 非java 8 方法
        System.out.println("-----------方案1 ： 非java 8 方法");
        String[] no8 = String.join("", words).split("");
        System.out.println(Arrays.toString(no8));

        // 如何得到words中的所有字符并去重
        // 方案2 ： java 8
        System.out.println("-----------方案2 ： java 8");
        List<String> collect1 = words.stream().map(word -> {
            System.out.println("执行map:" + word);
            return word.split("");
        }).flatMap(word -> {
            System.out.println("执行flatMap:" + Arrays.toString(word));
            return Arrays.stream(word);
        }).filter(a -> {
            System.out.println("执行filter: " + a);
            return !a.equals(" ");
        }).distinct().collect(Collectors.toList());

        System.out.println(collect1);
    }
}
