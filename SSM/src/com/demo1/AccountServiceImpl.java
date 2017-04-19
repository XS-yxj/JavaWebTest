package com.demo1;

import org.springframework.transaction.TransactionStatus;
import org.springframework.transaction.support.TransactionCallbackWithoutResult;
import org.springframework.transaction.support.TransactionTemplate;

/**
 * Created by Apple on 2017/4/18.
 * 转账案例的业务层实现类
 * out转入账号，in转出账号，money流动金额
 */
public class AccountServiceImpl implements AccountService {
//    注入转账的DAO类
    private AccountDao accountDao;

    public void setAccountDao(AccountDao accountDao) {
        this.accountDao = accountDao;
    }



    @Override
    public void transfer(String out, String in, Double money) {


                accountDao.outMoney(out,money);
//            异常测试
                int i = 1/0;
                accountDao.inMoney(in,money);





    }
}
