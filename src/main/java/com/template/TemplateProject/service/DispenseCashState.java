package com.template.TemplateProject.service;

import com.template.TemplateProject.model.Transaction;
import com.template.TemplateProject.model.TransactionType;


public class DispenseCashState implements State{

    @Override
    public void initializeState()
    {
        if(BeanFactory.getUtils().callEnterPinState(this)){
            return;
        }
        System.out.println(BeanFactory.getAtmConfig().getDispenseCashTitle());
        BeanFactory.getUtils().getUser().setBalance(BeanFactory.getUtils().getUser().getBalance()-BeanFactory.getUtils().getWithdrawAmount());
        System.out.println("Dispensed : Rs" + BeanFactory.getUtils().getWithdrawAmount());
        logTransaction();
        BeanFactory.getUtils().setIdleState();
    }

    private void checkAndCallEnterPinState()
    {

    }

    private void logTransaction()
    {
        Transaction transaction = Transaction.builder().userId(BeanFactory.getUtils().getUser().getUserId())
                .transactionType(TransactionType.WITHDRAW)
                .transactionInfo("Withdrawn : " + BeanFactory.getUtils().getWithdrawAmount())
                .timestamp(System.currentTimeMillis())
                .build();
        BeanFactory.getRepository().logTransaction(BeanFactory.getUtils().getUser().getUserId(), transaction);
    }

    public void cancelClicked()
    {
        System.out.println(BeanFactory.getAtmConfig().getNotCancelDisplayMsg());
    }
}
