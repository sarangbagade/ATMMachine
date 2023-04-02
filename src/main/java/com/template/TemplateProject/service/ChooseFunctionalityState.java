package com.template.TemplateProject.service;

public class ChooseFunctionalityState implements State{

    @Override
    public void initializeState() {
        System.out.println("1. Cash Withdrawal");
        System.out.println("2. Modify Pin");
        System.out.println("3. Mini Statement");
        System.out.println("4. Check Balance");
    }

    public void numberClicked(Integer number)
    {
        try{
            validateInput(number);
        } catch (RuntimeException exception) {
            System.out.println(exception.getMessage());
            return;
        }
        BeanFactory.getUtils().setState(getFunctionality(number));
    }

    private void validateInput(Integer number)
    {

    }

    private State getFunctionality(Integer input)
    {
        switch (input) {
            case 1:
                return BeanFactory.getCashWithdrawalState();
            case 2:
                return BeanFactory.getModifyPinState();
            case 3:
                return BeanFactory.getMiniStatementState();
            case 4:
                return BeanFactory.getCheckBalanceState();
            default:
                return null;
        }
    }
}
