package basic1;

import java.util.Scanner;

public class CheckingAccount extends Account{

	private double overdraftProtection;
	
	public CheckingAccount(double balance) {
		// TODO Auto-generated constructor stub
		super(balance);
	}
	public CheckingAccount(double balance,
			double overdraftProtection) {
		super(balance);
		this.overdraftProtection = overdraftProtection;
	}
	public void withdraw(double amt) throws OverDraftException {
		if(amt >balance + overdraftProtection) {
			double deficit = amt - (this.balance+overdraftProtection);
			throw new OverDraftException("透支金额超标：",deficit);
		}
		this.balance -= amt;
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		CheckingAccount ca = new CheckingAccount(1000,1000);
		ca.deposit(1000);
		System.out.println(ca.getBalance());
		Scanner sc = new Scanner(System.in);
		try {
			ca.withdraw(sc.nextInt());
		}catch(OverDraftException e) {
			System.err.println("透支金额为" + e.getDeficit());
			e.printStackTrace();
		}
	}

}
