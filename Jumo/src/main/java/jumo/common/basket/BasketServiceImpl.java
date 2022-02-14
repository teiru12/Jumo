package jumo.common.basket;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import jumo.model.BasketBean;

@Service("basketService")
public class BasketServiceImpl implements BasketService {
	
	@Resource(name="basketDAO")
	private BasketDAO basketDAO;

	@Override
	public List<Map<String, Object>> basketList(BasketBean basket) throws Exception {
		Map<String, Object> map = new HashMap<String, Object>();
		
		map.put("EMAIL", basket.getBEMAIL());
						
		return basketDAO.basketList(map);
	}

	@Override
	public void updateBasket(BasketBean basket) throws Exception {
		Map<String, Object> map = new HashMap<String, Object>();
		
		map.put("BNAME", basket.getBNAME());
		map.put("BID", basket.getBID());
		map.put("BPRICE", basket.getBPRICE());
		map.put("BSALE", basket.getBSALE());
		map.put("BEMAIL", basket.getBEMAIL());
		map.put("BCOUNT", basket.getBCOUNT());
						
		basketDAO.updateBasket(map);	
	}

	@Override
	public void deleteBasket(BasketBean basket) throws Exception {
		Map<String, Object> map = new HashMap<String, Object>();
		
		map.put("BNUMBER", basket.getBNUMBER());
						
		basketDAO.updateBasket(map);			
	}
}