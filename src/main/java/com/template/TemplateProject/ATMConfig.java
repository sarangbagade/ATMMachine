package com.template.TemplateProject;

import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@NoArgsConstructor
//@AllArgsConstructor
public class ATMConfig {

    public String getInvalidInputMsg()
    {
        return "Invalid Input";
    }
    public String getIdealStateTitle()
    {
        return "Welcome to ATM";
    }
    public String getIdealStateDisplayMsg()
    {
        return "Insert Card";
    }
    public String getChooseFunctionalityDisplayMsg()
    {
        return "Choose functionality";
    }
    public String getCashWithdrawalTitle()
    {
        return "Cash Withdrawal";
    }
    public String getCashWithdrawalDisplayMsg()
    {
        return "Enter amount to withdraw cash";
    }
    public String getMiniStatementTitle()
    {
        return "Mini Statement";
    }
    public String getCheckBalanceTitle()
    {
        return "Check Balance";
    }
    public String getModifyPinTitle()
    {
        return "Modify Pin";
    }
    public String getModifyPinMsg1()
    {
        return "Enter New Pin";
    }
    public String getModifyPinMsg2()
    {
        return "Reenter New Pin";
    }
    public String getTransCancelMsg()
    {
        return "Transaction Cancelled";
    }
    public String getDispenseCashTitle()
    {
        return "Dispensing Cash";
    }
    public String getNotCancelDisplayMsg()
    {
        return "Cant cancel transaction";
    }
}
