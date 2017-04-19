package com.demo3;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import javax.annotation.Resource;

/**
 * Created by Apple on 2017/4/18.
 * 转账案例测试类
 *
 * 声明式事务管理方式三(基于AspectJ和注解)
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:applicationContext3.xml")
public class AccountTest {


    @Resource(name="accountService")
    private AccountService accountService;


    @Test
    public  void demo(){

        accountService.transfer("aaa", "bbb", 100d);

    }


}
