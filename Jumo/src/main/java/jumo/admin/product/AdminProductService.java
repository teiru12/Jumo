package jumo.admin.product;

import java.util.List;
import java.util.Map;

import jumo.model.ProductBean;
 
public interface AdminProductService {
	//관리자 상품 리스트
	public List<Map<String, Object>> allListPaging(int START, int END) throws Exception;
	
	// 판매량을 조건으로 정렬하기 위해 상품 리스트 조건 검색
	public List<Map<String, Object>> allListPSELLDescPaging(int START, int END) throws Exception;
    
	//관리자 상품 리스트 검색
	public List<Map<String, Object>> allListKeyWordSearch(String KEYWORD, String ISNUMBER) throws Exception;
	
	//관리자 상품 입력 기능
	public void insertProduct(ProductBean product) throws Exception;
	
	//상품 PID최대값 구하기
	public int selectPIDMax() throws Exception;
	   
	//관리자 상품 수정폼
	public Map<String, Object> selectProductId(ProductBean product) throws Exception;
	   
	//관리자 상품 수정 기능
	public void updateProduct(ProductBean product) throws Exception;
	   
	//관리자 상품 삭제 기능
	public void deleteProduct(ProductBean product) throws Exception;
}