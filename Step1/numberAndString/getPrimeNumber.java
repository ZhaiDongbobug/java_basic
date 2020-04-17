package numberAndString;

public class getPrimeNumber {

	public static void main(String[] args) {
		int max = 10000*1000;
		int count=0;
		for(int i=0;i<=max;i++) {
			if(isPrime(i)) {
				count++;
			}
		}
		System.out.println(count);
		System.out.println("一千万以内的质数一共有："+count);
	}

	private static boolean isPrime(int i) {
		for(int j=2;j<=Math.sqrt(i);j++) {
			if(i%j==0) {
				return false;
			}
		}
		return true;
	}

}
