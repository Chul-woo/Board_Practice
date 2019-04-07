package kr.kcw.practice.Service;

import java.util.Map;

import kr.kcw.practice.VO.UserVO;

public interface UserService {

	public Map<String, Object> login(Map<String, Object> params) throws Exception;
	
	public void insert(Map<String, Object> params) throws Exception;
	
	public int checkId(Map<String, Object> params) throws Exception;
	
	public UserVO logining(String id) throws Exception;
	
}
