package com.shj.expers.exp2.second;

public class Test {
    public static void main(String[] args) {
        Student student = new Student("申洪建","130182************","210236","2021-09-01");
        student.setGPA(4.0);
        student.deposit(300); // 存款
        student.withdraw(100.3); // 取款
        student.showDetails();

        student.removeAccount("123456"); // 一开始就开户，账户不存在的情况
        student.createAccount("111"); // 演示长度不合法的情况
        System.out.println(student.createAccount("123456")); // 添加成功的情况
        System.out.println(student.createAccount("123456")); // 账户存在的情况
        System.out.println(student.createAccount("456789")); // 添加成功的情况
        System.out.println(student.removeAccount("123456")); // 删除成功的情况
        student.removeAccount("111111"); // 删除失败的情况
        System.out.println("最终账户列表:" + student.getAccounts());
    }
}
