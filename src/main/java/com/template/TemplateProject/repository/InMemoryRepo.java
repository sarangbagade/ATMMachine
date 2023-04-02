package com.template.TemplateProject.repository;

import com.template.TemplateProject.model.Transaction;
import com.template.TemplateProject.model.User;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Repository
public class InMemoryRepo implements IRepository{

    private Map<String, User> userMap;
    private Map<Integer, List<Transaction>> userTransactions;

    public InMemoryRepo()
    {
        this.userMap = new HashMap<>();
        this.userTransactions = new HashMap<>();
    }

    @Override
    public User getUserByCardNumber(String cardNumber) {
        return userMap.get(cardNumber);
    }

    public List<Transaction> getUserTransactions(Integer userId, int transCount)
    {
        List<Transaction> list = userTransactions.getOrDefault(userId, new ArrayList<>());
        return list.subList(0, Math.min(list.size(), transCount));
    }

    @Override
    public void setUserBalance(Integer userId, Integer balance) {
        userMap.get(userId).setBalance(balance);
    }

    @Override
    public void setUserPin(Integer userId, String userPin) {
        userMap.get(userId).setPin(userPin);
    }

    @Override
    public void logTransaction(Integer userId, Transaction transaction) {
        List<Transaction> transactionList = userTransactions.getOrDefault(userId, new ArrayList<>());
        transactionList.add(transaction);
        userTransactions.put(userId, transactionList);
    }

    @Override
    public void addUser(User user) {
        userMap.put(user.getCardNumber(), user);
    }
}
