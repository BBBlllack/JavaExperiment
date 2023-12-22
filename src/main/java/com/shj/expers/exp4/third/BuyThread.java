package com.shj.expers.exp4.third;

public class BuyThread extends Thread {
    private WaitedCustomer tempObject;

    public BuyThread(WaitedCustomer tempObject) {
        this.tempObject = tempObject;
    }

    public void run() {
        if (getName().equals("赵")) {
            tempObject.buyticket(20, 2);
        }
        if (getName().equals("钱")) {
            tempObject.buyticket(20, 1);
        }
        if (getName().equals("孙")) {
            tempObject.buyticket(10, 1);
        }
        if (getName().equals("李")) {
            tempObject.buyticket(10, 2);
        }
        if (getName().equals("周")) {
            tempObject.buyticket(5, 1);
        }
    }
}
