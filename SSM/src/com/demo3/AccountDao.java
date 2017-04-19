package com.demo3;

/**
 * Created by Apple on 2017/4/18.
 * 转账案例DAO(数据库访问对象)层接口
 */
public interface AccountDao {

    public void outMoney(String out, Double money);

    public void inMoney(String in, Double money);
}
