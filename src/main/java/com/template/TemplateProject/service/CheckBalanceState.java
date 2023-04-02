package com.template.TemplateProject.service;

import com.template.TemplateProject.model.Transaction;
import com.template.TemplateProject.model.TransactionType;


public class CheckBalanceState implements State{

    @Override
    public void initializeState() {

        if(BeanFactory.getUtils().callEnterPinState(this)){
            return;
        }
        System.out.println(BeanFactory.getAtmConfig().getCheckBalanceTitle());
        System.out.println("Balance : " + BeanFactory.getUtils().getUser().getBalance());
        logTransaction();
        BeanFactory.getUtils().setIdleState();
    }

    private void logTransaction()
    {
        Transaction transaction = Transaction.builder().userId(BeanFactory.getUtils().getUser().getUserId())
                .transactionType(TransactionType.CHECK_BALANCE)
                .transactionInfo("Balance : " + BeanFactory.getUtils().getUser().getBalance())
                .timestamp(System.currentTimeMillis())
                .build();
        BeanFactory.getRepository().logTransaction(BeanFactory.getUtils().getUser().getUserId(), transaction);
    }
}
