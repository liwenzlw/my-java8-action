package com.daiji.demo.i_分区;

import static java.util.stream.Collectors.partitioningBy;

import com.daiji.demo.metadata.Dish;
import java.util.List;
import java.util.Map;
import org.junit.Test;

/**
 * @author zenglw
 * @date 2018/10/7
 */
public class T {

    @Test
    public void test分区() {
        System.out.println("---------测试分区-----");
        Map<Boolean, List<Dish>> collect = Dish.menu.stream()
            .collect(
                partitioningBy(Dish::isVegetarian)
            );
        System.out.println(collect);
    }
}
