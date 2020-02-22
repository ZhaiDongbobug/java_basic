package basic1;

import java.util.Scanner;

public class Account {

	int balance = 5000;
	int deficit = -10000;
	public int getBalance() {
		return this.balance; 
	}
	//存钱
	public boolean deposit(int money) {
		if(money > 0) {
			balance += money;
		}else {
			System.out.println("输入金额有误！请重新输入：");
			return false;
		}
		return true;
	}
	//取钱
	public void withdraw(int money) throws OverdraftException {
		if(deficit>(balance-money)) {
			throw new OverdraftException("超出透支额度！！！");
		}else {
			balance -= money;
			System.out.println("取钱成功！");
		}
	}
	public static void service(Account ac) throws OverdraftException {
		System.out.println("请选择你的业务！");
		System.out.println("1.查询当前余额");
		System.out.println("2.存钱");
		System.out.println("3.取钱");
		System.out.println("请输入数字：");
		
		int money = 0;
		Scanner sc = new Scanner(System.in);
		int i = sc.nextInt();
		switch(i)
		{
		case 1:
			int balanceTempt = ac.getBalance();
			System.out.println("当前余额为："+ balanceTempt);
			break;
		case 2:
			System.out.println("请输入您要存储的金额");
			money = sc.nextInt();
			boolean dep = ac.deposit(money);
			if(dep==true) {
				System.out.println("存款成功！");
			}
			break;
		case 3:
			System.out.println("请输入要取出的金额：");
			money = sc.nextInt();
			ac.withdraw(money);
			break;	
		}
	}
	public static void main(String[] args) throws OverdraftException {
		// TODO Auto-generated method stub
		
		Account ac = new Account();
		service(ac);
		
	}

}
