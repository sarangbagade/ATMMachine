package com.template.TemplateProject.service;

import com.template.TemplateProject.ATMConfig;
import com.template.TemplateProject.repository.IRepository;
import com.template.TemplateProject.repository.InMemoryRepo;
import net.jcip.annotations.GuardedBy;

public class BeanFactory {

    private static final Object lockObject = new Object();
    @GuardedBy("lockObject")
    private static IdleState idleState;
    private static DispenseCashState dispenseCashState;
    private static EnterPinState enterPinState;
    private static CashWithdrawalState cashWithdrawalState;
    private static CheckBalanceState checkBalanceState;
    private static MiniStatementState miniStatementState;
    private static ModifyPinState modifyPinState;
    private static ChooseFunctionalityState chooseFunctionalityState;
    private static IRepository repository;
    private static ATMConfig atmConfig;
    private static ATMUtils utils;
    private static ATMService atmService;

    public static IdleState getIdleState()
    {
        if(idleState == null) {
            synchronized (lockObject) {
                if(idleState == null) {
                    idleState = new IdleState();
                }
            }
        }
        return idleState;
    }
    public static DispenseCashState getDispenseCashState()
    {
        if(dispenseCashState == null) {
            dispenseCashState = new DispenseCashState();
        }
        return dispenseCashState;
    }
    public static EnterPinState getEnterPinState()
    {
        if(enterPinState == null) {
            enterPinState = new EnterPinState();
        }
        return enterPinState;
    }
    public static CashWithdrawalState getCashWithdrawalState()
    {
        if(cashWithdrawalState == null) {
            cashWithdrawalState = new CashWithdrawalState();
        }
        return cashWithdrawalState;
    }
    public static CheckBalanceState getCheckBalanceState()
    {
        if(checkBalanceState == null) {
            checkBalanceState = new CheckBalanceState();
        }
        return checkBalanceState;
    }
    public static MiniStatementState getMiniStatementState()
    {
        if(miniStatementState == null) {
            miniStatementState = new MiniStatementState();
        }
        return miniStatementState;
    }
    public static ModifyPinState getModifyPinState()
    {
        if(modifyPinState == null) {
            modifyPinState = new ModifyPinState();
        }
        return modifyPinState;
    }
    public static ChooseFunctionalityState getChooseFunctionalityState()
    {
        if(chooseFunctionalityState == null) {
            chooseFunctionalityState = new ChooseFunctionalityState();
        }
        return chooseFunctionalityState;
    }
    public static IRepository getRepository()
    {
        if(repository == null) {
            repository = new InMemoryRepo();
        }
        return repository;
    }
    public static ATMConfig getAtmConfig()
    {
        if(atmConfig == null) {
            atmConfig = new ATMConfig();
        }
        return atmConfig;
    }
    public static ATMUtils getUtils()
    {
        if(utils == null) {
            utils = new ATMUtils();
        }
        return utils;
    }
    public static ATMService getAtmService()
    {
        if(atmService == null) {
            atmService = new ATMService();
        }
        return atmService;
    }
}
