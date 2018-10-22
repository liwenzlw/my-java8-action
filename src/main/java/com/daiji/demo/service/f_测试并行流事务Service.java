package com.daiji.demo.service;

import com.daiji.demo.mapper.f_测试并行流事务Mapper;
import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

/**
 * @author zenglw
 * @date 2018/10/6
 */
@Service
public class f_测试并行流事务Service {

    @Autowired
    private f_测试并行流事务Mapper mapper;

    public static ArrayList<Integer> arrayList = new ArrayList<>(8);

    static {
        //1. 构造数据
        arrayList.add(null);
        arrayList.add(null);
        arrayList.add(null);
        arrayList.add(null);
        arrayList.add(null);
        arrayList.add(null);
        arrayList.add(null);
        arrayList.add(null);
    }

    public List<String> findAll() {
        return mapper.findAll();
    }

    @Transactional(propagation = Propagation.REQUIRES_NEW, rollbackFor = Exception.class)
    public void insertSuccessWithStream() {

        System.out.println("-------示例：验证串行流使用的是同一个事务--------");
        //2. 写表
        arrayList.stream().forEach(a -> mapper.insert(Thread.currentThread().getName()));
    }

    @Transactional(propagation = Propagation.REQUIRES_NEW, rollbackFor = Exception.class)
    public void insertSuccessWithParallelStream() {

        System.out.println("-------示例：验证并行流使用的是不同事务--------");
        //2. 写表
        arrayList.parallelStream().forEach(a -> mapper.insert(Thread.currentThread().getName()));
    }

}
