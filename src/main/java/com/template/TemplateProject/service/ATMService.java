package com.template.TemplateProject.service;

public class ATMService {

    public void numberClicked(Integer number)
    {
        BeanFactory.getUtils().getState().numberClicked(number);
    }

    public void cardEnter(String cardNumber)
    {
        BeanFactory.getUtils().getState().cardEnter(cardNumber);
    }
    public void enterClicked()
    {
        BeanFactory.getUtils().getState().enterClicked();
    }
    public void clearClicked()
    {
        BeanFactory.getUtils().getState().clearClicked();
    }
    public void cancelClicked()
    {
        BeanFactory.getUtils().getState().cancelClicked();
    }

    public void initialize() {
        BeanFactory.getUtils().setState(BeanFactory.getIdleState());
    }
}
