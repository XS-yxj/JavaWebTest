package com.demo1;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import javax.annotation.Resource;

/**
 * Created by Apple on 2017/4/18.
 * 转账案例测试类
 *
 * 声明式事务管理方式一（原始方式）(不推荐)
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:applicationContext1.xml")
public class AccountTest {

//  注入增强的代理类
//    @Resource(name="accountService")
    @Resource(name="accountServiceProxy")
    private AccountService accountService;


    @Test
    public  void demo(){

        accountService.transfer("aaa", "bbb", 100d);

    }


}
