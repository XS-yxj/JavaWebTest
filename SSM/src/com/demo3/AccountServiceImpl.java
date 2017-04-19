package com.demo3;

import org.springframework.transaction.annotation.Transactional;

/**
 * Created by Apple on 2017/4/18.
 * 转账案例的业务层实现类
 * out转入账号，in转出账号，money流动金额
 *
 *
* @Transactional中的的属性
*   propagation	:事务的传播行为
*   isolation		:事务的隔离级别
*   readOnly		:只读
*   rollbackFor	:发生哪些异常回滚
*   noRollbackFor	:发生哪些异常不回滚
*   rollbackForClassName 根据异常类名回滚
 */
@Transactional
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
