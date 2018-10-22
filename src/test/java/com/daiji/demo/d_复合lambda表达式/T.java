package com.daiji.demo.d_复合lambda表达式;

import com.daiji.demo.metadata.Apple;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;
import org.junit.Before;
import org.junit.Test;

/**
 * @author zenglw
 * @date 2018/10/6
 */
public class T {

    private ArrayList<Apple> appleList = new ArrayList<>();

    @Before
    public void init() {
        Apple apple1 = new Apple("红色", 50);
        Apple apple2 = new Apple("红色", 150);
        Apple apple3 = new Apple("红色", 100);
        Apple apple4 = new Apple("绿色", 100);
        Apple apple5 = new Apple("绿色", 160);
        appleList.add(apple1);
        appleList.add(apple2);
        appleList.add(apple3);
        appleList.add(apple4);
        appleList.add(apple5);
    }

    @Test
    public void 测试复合lambda表达式() {

        // 示例1：查找颜色为红色并且重量超过100g的苹果
        Predicate<Apple> predicateColor = a -> "红色".equals(a.getColor());
        Predicate<Apple> predicateWeight = a -> 100 < a.getWeight();
        Predicate<Apple> colorAndWeightPredict = predicateColor.and(predicateWeight);

        List<Apple> list = appleList.stream().filter(colorAndWeightPredict).collect(Collectors.toList());
        System.out.println("---------示例1：查找颜色为红色并且重量超过100g的苹果------------");
        list.stream().forEach(a -> System.out.println(a.toString()));

        // 示例2：先按照红色排序，再按照重量排序
        Comparator<Apple> comparatorWeight = (a, b) -> a.getWeight().compareTo(b.getWeight());
        Comparator<Apple> comparatorColor = (a, b) -> a.getColor().compareTo(b.getColor());
        Comparator<Apple> colorAndWeightComparator = comparatorColor.thenComparing(comparatorWeight);
        appleList.sort(colorAndWeightComparator);
        System.out.println("---------示例2：先按照红色排序，再按照重量排序------------");
        appleList.forEach(a -> System.out.println(a.toString()));
    }
}
