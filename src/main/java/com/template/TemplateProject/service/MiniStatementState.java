package com.template.TemplateProject.service;

import com.template.TemplateProject.model.Transaction;

import java.util.List;


public class MiniStatementState implements State{

    @Override
    public void initializeState() {

        if(BeanFactory.getUtils().callEnterPinState(this)){
            return;
        }
        System.out.println(BeanFactory.getAtmConfig().getMiniStatementTitle());
        List<Transaction> transactionList = BeanFactory.getRepository().getUserTransactions(BeanFactory.getUtils().getUser().getUserId(), 5);
        System.out.println("Last 5 transactions :");
        transactionList.forEach(transaction -> {
            System.out.print(transaction.getTransactionType());
            System.out.print(": " + transaction.getTransactionInfo());
        });
        BeanFactory.getUtils().setIdleState();
    }

    public void cancelClicked()
    {
        System.out.println(BeanFactory.getAtmConfig().getNotCancelDisplayMsg());
    }
}
