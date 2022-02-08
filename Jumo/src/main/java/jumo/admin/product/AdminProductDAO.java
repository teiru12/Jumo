package jumo.admin.product;

import java.util.Map;

import javax.annotation.Resource;

import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.stereotype.Repository;

@Repository("adminProductDAO")
public class AdminProductDAO {
	
	@Resource(name="sqlSessionTemplate")
	private SqlSessionTemplate sqlSessionTemplate;

	public List<Map<String, Object>> allList() throws Exception{
		return sqlSessionTemplate.selectList("product.allList");
	}
	
	public List<Map<String, Object>> allListKeyWordSearch(Map<String, Object> map) throws Exception{
		return sqlSessionTemplate.selectList("product.allListKeyWordSearch",map);
	}
	
	public void insertProduct(Map<String, Object> map) throws Exception{
		sqlSessionTemplate.insert("product.insertProduct");
	}
	
	public Map<String, Object> selectProductId(Map<String, Object> map) throws Exception{
		return sqlSessionTemplate.selectOne("product.selectProductId",map);
	}
	
	public void updateProduct(Map<String, Object> map) throws Exception{
		sqlSessionTemplate.update("product.updateProduct");
	}
	
	public void deleteProduct(Map<String, Object> map) throws Exception{
		sqlSessionTemplate.delete("product.deleteProduct");
	}	
}