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

	@SuppressWarnings("unchecked")
	public List<Map<String, Object>> allList() throws Exception{
		return sqlSessionTemplate.selectList("product.allList");
	}
	
	@SuppressWarnings("unchecked")
	public List<Map<String, Object>> allListKeyWordSearch(Map<String, Object> map) throws Exception{
		return sqlSessionTemplate.selectList("product.allListKeyWordSearch",map);
	}
	
	@SuppressWarnings("unchecked")
	public void insertProduct() throws Exception{
		sqlSessionTemplate.insert("product.insertProduct");
	}
	
	@SuppressWarnings("unchecked")
	public Map<String, Object> selectProductId(Map<String, Object> map) throws Exception{
		return sqlSessionTemplate.selectOne("product.selectProductId",map);
	}
	
	@SuppressWarnings("unchecked")
	public void updateProduct() throws Exception{
		sqlSessionTemplate.update("product.updateProduct");
	}
	
	@SuppressWarnings("unchecked")
	public void deleteProduct() throws Exception{
		sqlSessionTemplate.delete("product.deleteProduct");
	}
	
}
