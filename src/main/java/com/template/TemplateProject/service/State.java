package com.template.TemplateProject.service;


public interface State {

    default void numberClicked(Integer number)
    {
        System.out.println(BeanFactory.getAtmConfig().getInvalidInputMsg());
    }

    default void cardEnter(String cardNumber)
    {
        System.out.println(BeanFactory.getAtmConfig().getInvalidInputMsg());
    }
    default void enterClicked()
    {
        System.out.println(BeanFactory.getAtmConfig().getInvalidInputMsg());
    }
    default void clearClicked()
    {
        System.out.println(BeanFactory.getAtmConfig().getInvalidInputMsg());
    }
    default void cancelClicked()
    {
        System.out.println(BeanFactory.getAtmConfig().getTransCancelMsg());
        BeanFactory.getUtils().setIdleState();
    }

    default void initializeState()
    {

    }
}
