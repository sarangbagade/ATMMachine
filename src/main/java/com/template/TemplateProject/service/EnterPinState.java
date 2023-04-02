package com.template.TemplateProject.service;

import com.template.TemplateProject.exceptions.InvalidInputException;
import lombok.Getter;
import lombok.Setter;

@Getter
public class EnterPinState implements State{

    @Setter
    private State nextState;
    private Boolean authorised;
    private StringBuilder enteredPin;

    public EnterPinState()
    {
        this.nextState = null;
        this.authorised = false;
    }

    public void initializeState()
    {
        System.out.println("Enter Pin");
        this.authorised = false;
        this.enteredPin = new StringBuilder();
    }

    public void numberClicked(Integer number)
    {
        enteredPin.append(number);
        System.out.println("entered pin : " + this.enteredPin);
    }

    public void enterClicked()
    {
        try {
            validatePin();
        } catch (RuntimeException exception) {
            System.out.println("pin is not valid");
            return;
        }
        this.authorised = true;
        BeanFactory.getUtils().setState(this.nextState);
    }

    private void validatePin()
    {
        if(!enteredPin.toString().equals(BeanFactory.getUtils().getUser().getPin())) {
            throw new InvalidInputException();
        }
    }
    public void clearClicked()
    {
        System.out.println(BeanFactory.getAtmConfig().getInvalidInputMsg());
    }
    public void cancelClicked()
    {
        System.out.println(BeanFactory.getAtmConfig().getTransCancelMsg());
        BeanFactory.getUtils().setIdleState();
    }

}
