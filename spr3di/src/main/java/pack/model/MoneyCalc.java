package pack.model;

public class MoneyCalc implements MoneyInter {

	@Override
	public int[] calcMoney(int money) {  // 45678
		/*
		int re[] = new int[5];
		re[0] = money / 10000;
		re[1] = money % 10000 / 1000;
		re[2] = money % 10000 % 1000 / 100;
		re[3] = money % 10000 % 1000 % 100 / 10;
		re[4] = money % 10000 % 1000 % 100 % 10;
		
		return re;
		*/
		
		int re[] = new int[5];
		int divisor = 10000;
		for(int i=0; i < re.length; i++) {
			re[i] = money / divisor;
			money %= divisor;
			divisor /= 10;
		}
		return re;
	}

}
