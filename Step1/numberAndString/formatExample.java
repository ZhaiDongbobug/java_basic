package numberAndString;

import java.util.Scanner;

public class formatExample {

	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		System.out.println("请输入地名：");
		String place = s.next();
		System.out.println("请输入公司类型：");
		String companyType = s.next();
		System.out.println("请输入公司名称：");
		String companyName = s.next();
		System.out.println("请输入老板名称：");
		String boss = s.next();
		System.out.println("请输入金额：");
		float money = s.nextFloat();
		System.out.println("请输入产品：");
		String produce = s.next();
		System.out.println("请输入价格计量单位：");
		String unit = s.next();
		System.out.printf("%s最大%s%s倒闭了，"
				+ "王八蛋老板%s吃喝嫖赌，欠下了%.1f个亿，带着他的小姨子跑了!"
				+ "我们没有办法，拿着%s抵工资!原价都是一%s多、两%s多、三%s多的钱包，"
				+ "现在全部只卖二十块，统统只要二十块!%s王八蛋，"
				+ "你不是人!我们辛辛苦苦给你干了大半年，你不发工资，"
				+ "你还我血汗钱，还我血汗钱!",place,companyType,companyName,boss,
				money,produce,unit,unit,unit,boss);
	}

}
