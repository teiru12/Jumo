package jumo.event;

import javax.annotation.Resource;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.stereotype.Repository;

@Repository("eventDAO")
public class EventDAO {

	@Resource(name="sqlSessionTemplate")
	SqlSessionTemplate sqlSessionTemplate;
	
	
}