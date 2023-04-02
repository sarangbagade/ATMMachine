package com.template.TemplateProject.service;

import com.template.TemplateProject.model.User;
import lombok.Data;


@Data
public class ATMUtils {

    private State state;
    protected User user;
    protected Integer withdrawAmount;

    public void setState(State state)
    {
        this.state = state;
        state.initializeState();
    }

    protected void setIdleState()
    {
        this.user = null;
        this.withdrawAmount = 0;
        setState(BeanFactory.getIdleState());
    }

    protected Boolean callEnterPinState(State nextState)
    {
        EnterPinState enterPinState = BeanFactory.getEnterPinState();
        if(!enterPinState.getAuthorised()) {
            enterPinState.setNextState(nextState);
            setState(enterPinState);
            return true;
        }
        return false;
    }
}
