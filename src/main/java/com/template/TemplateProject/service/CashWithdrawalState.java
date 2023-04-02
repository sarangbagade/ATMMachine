package com.template.TemplateProject.service;

import com.template.TemplateProject.exceptions.InvalidInputException;


public class CashWithdrawalState implements State{

    @Override
    public void initializeState() {
        BeanFactory.getUtils().setWithdrawAmount(0);
        System.out.println(BeanFactory.getAtmConfig().getCashWithdrawalTitle());
        System.out.println(BeanFactory.getAtmConfig().getCashWithdrawalDisplayMsg());
    }

    public void numberClicked(Integer number)
    {
        BeanFactory.getUtils().setWithdrawAmount(10*BeanFactory.getUtils().getWithdrawAmount()+number);
        printWithdrawAmount();
    }

    public void clearClicked()
    {
        BeanFactory.getUtils().setWithdrawAmount(0);
        printWithdrawAmount();
    }

    public void enterClicked()
    {
        validateWithdrawAmount();
        BeanFactory.getUtils().setState(BeanFactory.getDispenseCashState());
    }

    public void cancelClicked()
    {
        System.out.println(BeanFactory.getAtmConfig().getTransCancelMsg());
        BeanFactory.getUtils().setIdleState();
    }

    private void printWithdrawAmount()
    {
        System.out.println("withdraw amount = " + BeanFactory.getUtils().getWithdrawAmount());
    }

    private void validateWithdrawAmount()
    {
        if(BeanFactory.getUtils().getWithdrawAmount() > BeanFactory.getUtils().getUser().getBalance()) {
            throw new InvalidInputException();
        }
    }
}
