package service.impl;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.apache.log4j.Logger;
import pojo.Account;
import pojo.Log;
import service.AccountService;

import java.io.IOException;
import java.io.InputStream;
import java.time.LocalDate;

public class AccountServiceImpl implements AccountService {

    @Override
    public int transfer(Account receiver, Account sender) throws IOException {
        InputStream is = Resources.getResourceAsStream("mybatis.xml");
        SqlSessionFactory factory = new SqlSessionFactoryBuilder().build(is);
        SqlSession session = factory.openSession();
        //判断转账方账号密码是否匹配
        Account senderAccount = session.selectOne("com.accountMapper.selectByAccnoPwd",sender);
        if(senderAccount != null){
            if(senderAccount.getBalance() >= sender.getBalance()){
                //判断收款方账号信息是否正确
                Account receiverAccount = session.selectOne("com.accountMapper.selectByAccnoName",receiver);
                if(receiverAccount != null){
                    receiver.setBalance(sender.getBalance());
                    sender.setBalance(sender.getBalance()*(-1));
                    int transferResultSender = session.update("com.accountMapper.updateBalanceByAccno",sender);
                    int transferResultReceiver = session.update("com.accountMapper.updateBalanceByAccno",receiver);
                    if(transferResultSender==1 && transferResultReceiver ==1){
                        Log log = new Log();
                        log.setAccIn(receiverAccount.getAccNo());
                        log.setAccOut(senderAccount.getAccNo());
                        log.setMoney(receiver.getBalance());
                        session.insert("com.logMapper.insLog",log);
                        Logger logger = Logger.getLogger(AccountServiceImpl.class);
                        logger.info("At " + LocalDate.now() + ", " + log.getAccOut() + " sends " + log.getAccIn() + " " +log.getMoney() + " yuan");
                        session.commit();
                        session.close();
                        return TRANSFER_SUCCESS;
                    }else {
                        session.rollback();
                        session.close();
                        return TRANSFER_FAILURE;
                    }
                }else {
                    return ACCOUNT_NAME_NOT_MATCH;
                }
            }else {
                return ACCOUNT_BALANCE_NOT_ENOUGH;
            }
        }else {
            return ACCOUNT_PASSWORD_NOT_MATCH;
        }
    }
}
