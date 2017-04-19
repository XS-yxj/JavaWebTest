package com.demo2;

/**
 * Created by Apple on 2017/4/18.
 * 转账案例的业务层接口
 */
public interface AccountService {

    public void transfer(String out, String in, Double money);

}
