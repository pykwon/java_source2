package pack.model;

public class SangpumImpl implements SangpumInter {
	
	@Override
	public String[] calcMoney(String sang, int su, int dan) {
		String rs[] = new String[2];
		
		rs[0] = sang;
		rs[1] = Integer.toString(su * dan);
		
		return rs;
	}	
}