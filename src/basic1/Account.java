package basic1;

import java.util.Scanner;

public class Account {

	int balance = 5000;
	int deficit = -10000;
	public int getBalance() {
		return this.balance; 
	}
	//存钱
	public void deposit(int money) {
		balance += money;
	}
	//取钱
	public void withdraw(int money) throws OverdraftException {
		if(deficit>(balance-money)) {
			throw new OverdraftException("超出透支额度！！！");
		}
		balance -= money; 
	}
	
	public static void main(String[] args) throws OverdraftException {
		// TODO Auto-generated method stub
		System.out.println("请输入数字：\n");
		//Scanner s = new Scanner(System.in);
		Account ac = new Account();
		System.out.println(ac.getBalance());
		//ac.deposit(s.nextInt());
		//System.out.println(ac.getBalance());
		Scanner sc = new Scanner(System.in);
		ac.withdraw(sc.nextInt());
		
	}

}
