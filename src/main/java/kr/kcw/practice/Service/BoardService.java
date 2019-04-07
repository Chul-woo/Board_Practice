package kr.kcw.practice.Service;

import java.util.List;
import java.util.Map;

import kr.kcw.practice.VO.Criteria;


public interface BoardService {

	public List<Map<String, Object>> showList(Map<String, Object> map) throws Exception;
	
	public Map<String, Object> select(int bno) throws Exception;
	
	public List<Map<String, Object>> selectComment(String grpCd) throws Exception;
	
	public void regist(Map<String, Object> map) throws Exception;
	
	public void registComment(Map<String, Object> map) throws Exception;
	
	public void update(Map<String, Object> map) throws Exception;
	
	public void delete(int bno) throws Exception;
	
	public List<Map<String, Object>> listCriteria(Criteria cri) throws Exception;
	
	public Integer totalCount() throws Exception;
	
}
