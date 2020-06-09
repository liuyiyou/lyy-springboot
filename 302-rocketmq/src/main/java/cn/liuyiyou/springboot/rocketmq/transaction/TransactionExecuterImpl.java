package cn.liuyiyou.springboot.rocketmq.transaction;

import org.apache.rocketmq.client.producer.LocalTransactionExecuter;
import org.apache.rocketmq.client.producer.LocalTransactionState;
import org.apache.rocketmq.common.message.Message;

import java.util.concurrent.atomic.AtomicInteger;

/**
 *  执行本地事务
 * @author: liuyiyou.cn
 * @date: 2019/12/19
 * @version: V1.0
 */
public class TransactionExecuterImpl implements LocalTransactionExecuter {
    private AtomicInteger transactionIndex = new AtomicInteger(1);


    @Override
    public LocalTransactionState executeLocalTransactionBranch(final Message msg, final Object arg) {
        int value = transactionIndex.getAndIncrement();
        System.out.println("value == " + value);
        if (value == 0) {
            throw new RuntimeException("Could not find db");
        }
        else if (value == 1) {
            return LocalTransactionState.ROLLBACK_MESSAGE;
        }
        else if (value == 2) {
            return LocalTransactionState.COMMIT_MESSAGE;
        }

        return LocalTransactionState.UNKNOW;
    }
}
