package kr.kcw.practice.Dao;

import java.util.Map;

import org.springframework.stereotype.Repository;

import kr.kcw.practice.Util.AbstractDao;
import kr.kcw.practice.VO.UserVO;

@Repository
public class UserDao extends AbstractDao{
	
	@SuppressWarnings("unchecked")
	public Map<String, Object> login(Map<String, Object> maps) throws Exception{
		return (Map<String, Object>) selectOne("user.login", maps);
	}

	public void insert(Map<String, Object> maps) throws Exception{
		insert("user.insert", maps);
	}
	
	public int checkId(Map<String, Object> params) throws Exception{
		return (Integer) selectOne("user.checkId", params);
	}
	
	public UserVO logining(Map<String, Object> maps) throws Exception{
		return (UserVO) selectOne("user.logining", maps);
	}
	
}
