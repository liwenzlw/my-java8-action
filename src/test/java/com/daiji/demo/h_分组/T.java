package com.daiji.demo.h_分组;

import static java.util.stream.Collectors.groupingBy;

import com.daiji.demo.metadata.Dish;
import com.daiji.demo.metadata.Dish.Type;
import java.util.List;
import java.util.Map;
import org.junit.Test;

/**
 * @author zenglw
 * @date 2018/10/7
 */
public class T {

    @Test
    public void test分组() {
        System.out.println("---------示例 1：按照食物类型分组");
        Map<Type, List<Dish>> collect = Dish.menu.stream().collect(groupingBy(Dish::getType));
        System.out.println(collect.toString());
    }

    @Test
    public void test多次分组() {
        System.out.println("---------示例 2：按照食物类型分组,内部再按照卡路里分组");
        Map<Type, Map<CaloricLevel, List<Dish>>> collect = Dish.menu.stream()
            .collect(
            groupingBy(Dish::getType,
                groupingBy(dish -> {
                    if (dish.getCalories() <= 400)
                        return CaloricLevel.DIET;
                    else if (dish.getCalories() <= 700)
                        return CaloricLevel.NORMAL;
                    else
                        return CaloricLevel.FAT;
                })
            )
        );
        System.out.println(collect.toString());
    }

    enum CaloricLevel { DIET, NORMAL, FAT };
}
