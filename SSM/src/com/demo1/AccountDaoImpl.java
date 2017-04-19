package com.demo1;

import org.springframework.jdbc.core.support.JdbcDaoSupport;

/**
 * Created by Apple on 2017/4/18.
 * 转账案例DAO(数据库访问对象)层实现类
 *
 * 注入连接池就可以使用J的JdbcDaoSupport的模板
 */
public class AccountDaoImpl  extends JdbcDaoSupport implements AccountDao {


    @Override
    public void outMoney(String out, Double money) {
//预备语句？
        String sql = "update account set money = money - ? where name = ?";
        this.getJdbcTemplate().update(sql,money,out);

    }

    @Override
    public void inMoney(String in, Double money) {
        String sql = "update account set money = money + ? where name = ?";
        this.getJdbcTemplate().update(sql,money,in);
    }
}
