package com.demo2;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import javax.annotation.Resource;

/**
 * Created by Apple on 2017/4/18.
 * 转账案例测试类
 *
 * 声明式事务管理方式二(基于AspectJ和xml)
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:applicationContext2.xml")
public class AccountTest {


    @Resource(name="accountService")
    private AccountService accountService;


    @Test
    public  void demo(){

        accountService.transfer("aaa", "bbb", 100d);

    }


}
