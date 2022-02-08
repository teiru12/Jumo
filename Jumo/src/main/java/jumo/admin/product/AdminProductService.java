package jumo.admin.product;

import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

public interface AdminProductService {
	@Resource(name="sqlSessionTemplate")
	
	//관리자 상품 리스트
	public List<Map<String, Object>> allList() throws Exception;
	
	//관리자 상품 리스트 검색
	public List<Map<String, Object>> allListKeyWordSearch(Map<String, Object> map) throws Exception;

	//관리자 상품 입력 기능
	public void insertProduct() throws Exception;
	
	//관리자 상품 수정폼
	public Map<String, Object> selectProductId(Map<String, Object> map) throws Exception;
	
	//관리자 상품 수정 기능
	public void updateProduct() throws Exception;
	
	//관리자 상품 삭제 기능
	public void deleteProduct() throws Exception;
}
