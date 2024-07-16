package pack.model;

import org.springframework.stereotype.Service;
import pack.controller.JepumBean;

@Service
public class JepumModel {
	public String computePrice(JepumBean bean) {
		String data = "품명:" + bean.getSang() + " " + 
					", 금액:" + (bean.getSu() * bean.getDan());
		return data;
	}
}
