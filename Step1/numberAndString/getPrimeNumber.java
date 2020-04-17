package numberAndString;

public class getPrimeNumber {

	public static void main(String[] args) {
		int g = getNumber(10000000);
		System.out.println(g);
	}

	private static int getNumber(int i) {
		boolean flag=false;
		int count = 2;
		for(int num=3;num<=i;num++) {
			for(int j=2;j<=num/2+1;j++) {
				if(num%j==0) {
					flag=true;
				}
			}
			if(flag==false) {
				count++;
			}else {
				flag=false;
			}
		}
		return count;
		
	}

}
