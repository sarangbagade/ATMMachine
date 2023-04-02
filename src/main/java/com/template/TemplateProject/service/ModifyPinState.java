package com.template.TemplateProject.service;

import com.template.TemplateProject.model.Transaction;
import com.template.TemplateProject.model.TransactionType;


public class ModifyPinState implements State{

    private StringBuilder newPin1;
    private StringBuilder newPin2;
    private Boolean veryfyPin;
    @Override
    public void initializeState() {

        if(BeanFactory.getUtils().callEnterPinState(this)){
            return;
        }
        newPin1 = new StringBuilder();
        newPin2 = new StringBuilder();
        veryfyPin = false;
        System.out.println(BeanFactory.getAtmConfig().getModifyPinTitle());
        System.out.println(BeanFactory.getAtmConfig().getModifyPinMsg1());
    }

    public void numberClicked(Integer number)
    {
        if(!veryfyPin) {
            newPin1.append(number);
            try {
                validatePin();
            } catch (RuntimeException exception) {
                System.out.println(exception.getMessage());
                newPin1 = new StringBuilder();
                return;
            }
        } else {
            newPin2.append(number);
            try {
                validatePin();
            } catch (RuntimeException exception) {
                System.out.println(exception.getMessage());
                newPin1 = new StringBuilder();
                return;
            }
        }
    }
    private void validatePin()
    {

    }
    public void enterClicked()
    {
        if(!veryfyPin) {
            System.out.println(BeanFactory.getAtmConfig().getModifyPinMsg2());
        } else if(!newPin1.equals(newPin2)) {
            System.out.println("new pin verification failed");
            System.out.println(BeanFactory.getAtmConfig().getModifyPinMsg1());
            newPin1 = new StringBuilder();
            newPin2 = new StringBuilder();
        } else {
            BeanFactory.getRepository().setUserPin(BeanFactory.getUtils().getUser().getUserId(), newPin2.toString());
            logTransaction();
            BeanFactory.getUtils().setIdleState();
        }
    }

    private void logTransaction()
    {
        Transaction transaction = Transaction.builder().userId(BeanFactory.getUtils().getUser().getUserId())
                .transactionType(TransactionType.PIN_CHANGE)
                .transactionInfo("Pin changed")
                .timestamp(System.currentTimeMillis())
                .build();
        BeanFactory.getRepository().logTransaction(BeanFactory.getUtils().getUser().getUserId(), transaction);
    }

    public void clearClicked()
    {
        if(!veryfyPin) {
            newPin1 = new StringBuilder();
            System.out.println(BeanFactory.getAtmConfig().getModifyPinMsg1());
        } else {
            newPin2 = new StringBuilder();
            System.out.println(BeanFactory.getAtmConfig().getModifyPinMsg2());
        }
    }
}
