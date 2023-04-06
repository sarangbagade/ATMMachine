package com.template.TemplateProject.service;

import net.jcip.annotations.ThreadSafe;

@ThreadSafe
public class ATMService {

    public synchronized void numberClicked(Integer number)
    {
        BeanFactory.getUtils().getState().numberClicked(number);
    }

    public synchronized void cardEnter(String cardNumber)
    {
        BeanFactory.getUtils().getState().cardEnter(cardNumber);
    }
    public synchronized void enterClicked()
    {
        BeanFactory.getUtils().getState().enterClicked();
    }
    public synchronized void clearClicked()
    {
        BeanFactory.getUtils().getState().clearClicked();
    }
    public synchronized void cancelClicked()
    {
        BeanFactory.getUtils().getState().cancelClicked();
    }

    public synchronized void initialize() {
        BeanFactory.getUtils().setState(BeanFactory.getIdleState());
    }
}
