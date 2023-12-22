package com.shj.expers.exp2.second;

import lombok.*;

import java.util.ArrayList;
import java.util.List;

/**
 * *2、声明一个 Person 类和派生类 Student，
 * 成员变量包括学号、姓名、入学 时间、身份证号、学分绩点等信息，
 * 成员方法包括开户、存款、取款、查询(余 额、明细)、销户等操作。
 */

@Getter
@NoArgsConstructor
@AllArgsConstructor
public class Person {
    private String name; // 姓名
    private String idCard; // 身份证号
    private double balance; // 财富
    private List<String> accounts; // 账户列表

    public Person(String name, String idCard) {
        this.name = name;
        this.idCard = idCard;
        this.balance = 0.0;
    }

    /**
     * 规定账户号长度必须为6位
     * @param accNum 开户账号
     * @return 开户之后的账户列表
     */
    public List<String> createAccount(String accNum){
        if (accNum.length() != 6){
            System.out.println("开户失败,账号不合法!");
            return this.accounts;
        }
        if (this.accounts == null){
            this.accounts = new ArrayList<>();
        }
        for (String account : accounts) {
            if (account.equals(accNum)){
                System.out.println("账户已存在,开户失败!");
                return this.accounts;
            }
        }
        this.accounts.add(accNum);
        System.out.println("开户成功!");
        return this.accounts;
    }

    /**
     * @param accNum 销户账号
     * @return 销户之后的账户列表
     */
    public List<String> removeAccount(String accNum){
        if (this.accounts == null){
            System.out.println("您尚未开户!");
            return null;
        }
        for (int i = 0; i < accounts.size(); i++) {
            if (accounts.get(i).equals(accNum)){
                this.accounts.remove(accNum);
                System.out.println("销户成功!" + accNum);
                return this.accounts;
            }
        }
        System.out.println("销户失败,账户不存在!");
        return this.accounts;
    }

    // 存款
    public void deposit(double amount) {
        if (amount > 0) {
            balance += amount;
            System.out.println("Deposited " + amount + " dollars. New balance: " + balance);
        }
    }

    // 取款
    public void withdraw(double amount) {
        if (amount > 0 && balance >= amount) {
            balance -= amount;
            System.out.println("Withdrawn " + amount + " dollars. New balance: " + balance);
        } else {
            System.out.println("Insufficient funds.");
        }
    }

    public void showDetails() {
        System.out.println("Name: " + name);
        System.out.println("ID Card: " + idCard);
        System.out.println("Balance: " + balance);
    }


}
