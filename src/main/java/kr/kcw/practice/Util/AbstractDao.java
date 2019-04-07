package kr.kcw.practice.Util;

import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

public class AbstractDao {

	private static final Logger logger = LoggerFactory.getLogger(AbstractDao.class);
	
	@Autowired
    private SqlSessionTemplate sqlSession;
    
	private void queryId(String a) {
		logger.info(a);
	}
	
    public Object insert(String queryId, Object params){
    	queryId(queryId);
        return sqlSession.insert(queryId, params);
    }
      
    public Object update(String queryId, Object params){
    	queryId(queryId);
        return sqlSession.update(queryId, params);
    }
      
    public Object delete(String queryId, Object params){
    	queryId(queryId);
        return sqlSession.delete(queryId, params);
    }
      
    public Object selectOne(String queryId){
    	queryId(queryId);
        return sqlSession.selectOne(queryId);
    }
      
    public Object selectOne(String queryId, Object params){
    	queryId(queryId);
        return sqlSession.selectOne(queryId, params);
    }
      
    @SuppressWarnings("rawtypes")
    public List selectList(String queryId){
    	queryId(queryId);
        return sqlSession.selectList(queryId);
    }
      
    @SuppressWarnings("rawtypes")
    public List selectList(String queryId, Object params){
    	queryId(queryId);
        return sqlSession.selectList(queryId,params);
    }
    
	
}
