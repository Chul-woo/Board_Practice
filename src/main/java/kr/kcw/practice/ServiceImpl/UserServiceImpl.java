package kr.kcw.practice.ServiceImpl;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kr.kcw.practice.Dao.UserDao;
import kr.kcw.practice.Service.UserService;
import kr.kcw.practice.VO.UserVO;

@Service
public class UserServiceImpl implements UserService{

	@Autowired
	private UserDao userDao;
	
	@Override
	public Map<String, Object> login(Map<String, Object> params) throws Exception {
		// TODO Auto-generated method stub
		return userDao.login(params);
	}

	@Override
	public void insert(Map<String, Object> params) throws Exception {
		userDao.insert(params);
	}

	@Override
	public int checkId(Map<String, Object> params) throws Exception {
		// TODO Auto-generated method stub
		return userDao.checkId(params);
	}

	@Override
	public UserVO logining(String id) throws Exception {
		Map<String, Object> maps = new HashMap<String, Object>();
		maps.put("id", id);
		return userDao.logining(maps);
	}

}
