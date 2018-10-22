package com.daiji.demo.f_串流和并行流;

import com.daiji.demo.service.f_测试并行流事务Service;
import java.util.ArrayList;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.annotation.Transactional;

/**
 * @author zenglw
 * @date 2018/10/6
 */
@SpringBootTest
@RunWith(SpringRunner.class)
public class T {

    @Autowired
    private f_测试并行流事务Service service;

    @Test
    public void test并行流和串行流原理() {
        // 1. 构造数据
        ArrayList<T> arrayList = new ArrayList<>();
        arrayList.add(new T());
        arrayList.add(new T());
        arrayList.add(new T());
        arrayList.add(new T());
        arrayList.add(new T());
        arrayList.add(new T());
        arrayList.add(new T());
        arrayList.add(new T());

        System.out.println("示例1：串行执行");
        long before = System.currentTimeMillis();
        arrayList.stream().forEach(T::doSome);
        System.out.println("串行执行时间" + (System.currentTimeMillis() - before));

        System.out.println("示例2：并行执行");
        before = System.currentTimeMillis();
        arrayList.parallelStream().forEach(T::doSome);
        System.out.println("并行执行时间" + (System.currentTimeMillis() - before));
    }

    @Test
    @Transactional
    public void test串行流事务控制() {
        // 示例：验证并行流使用的是同一个事务
        service.insertSuccessWithStream();
        service.findAll().forEach(a -> System.out.println(a));
    }

    @Test
    @Transactional
    public void test并行流事务控制() {
        // 示例：验证并行流使用的是不同事务
        service.insertSuccessWithParallelStream();
        service.findAll().forEach(System.out::println);
    }


    public void doSome() {
        try {
            Thread.sleep(2000L);
            System.out.println(Thread.currentThread().getName());
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

}
