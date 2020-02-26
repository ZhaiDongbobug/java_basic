package basic1;

import java.util.Scanner;

public class Account {

	protected double balance = 5000;//#是protected的意思
	public Account(double balance) {
		this.balance = balance;
	}
	public double getBalance() {
		return balance; 
	}
	//存钱
	public void deposit(double amt) {
		if(amt > 0) {
			this.balance += amt;
		}else {
			System.out.println("输入错误！请重新输入！");
		}
	}
	//取钱
	public void withdraw(double amt) throws OverDraftException{
		if(this.balance < amt)
			throw new OverDraftException("余额不足",amt - this.balance);
		this.balance -= amt;
	}

}
