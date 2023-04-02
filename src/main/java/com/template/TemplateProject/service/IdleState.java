package com.template.TemplateProject.service;

public class IdleState implements State{

    public void cardEnter(String cardNumber)
    {
        try {
            validateCardNumber(cardNumber);
        } catch (RuntimeException exception) {
            System.out.println(exception.getMessage());
            return;
        }
        BeanFactory.getUtils().setUser(BeanFactory.getRepository().getUserByCardNumber(cardNumber));
        BeanFactory.getUtils().setState(BeanFactory.getChooseFunctionalityState());
    }

    public void cancelClicked()
    {
        System.out.println(BeanFactory.getAtmConfig().getInvalidInputMsg());
    }

    @Override
    public void initializeState() {
        System.out.println(BeanFactory.getAtmConfig().getIdealStateTitle());
        System.out.println(BeanFactory.getAtmConfig().getIdealStateDisplayMsg());
    }

    private void validateCardNumber(String cardNumber)
    {

    }
}
