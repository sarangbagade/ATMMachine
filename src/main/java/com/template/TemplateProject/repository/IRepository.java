package com.template.TemplateProject.repository;

import com.template.TemplateProject.model.Transaction;
import com.template.TemplateProject.model.User;

import java.util.List;

public interface IRepository {

    User getUserByCardNumber(String cardNumber);
    List<Transaction> getUserTransactions(Integer userId, int transCount);
    void setUserBalance(Integer userId, Integer balance);
    void setUserPin(Integer userId, String userPin);
    void logTransaction(Integer userId, Transaction transaction);
    void addUser(User user);
}
