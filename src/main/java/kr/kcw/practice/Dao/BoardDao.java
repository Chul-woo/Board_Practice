package kr.kcw.practice.Dao;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Repository;

import kr.kcw.practice.Util.AbstractDao;
import kr.kcw.practice.VO.Criteria;
import kr.kcw.practice.VO.SearchCriteria;

@Repository
public class BoardDao extends AbstractDao{
	
	@SuppressWarnings("unchecked")
	public List<Map<String, Object>> showList(Map<String, Object> map) throws Exception{
		return (List<Map<String, Object>>) selectList("board.showList",map);
	}
	
	
	@SuppressWarnings("unchecked")
	public Map<String, Object> selectBoard(int bno) throws Exception{
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("bno", bno);
		Map<String, Object> result = (Map<String, Object>) selectOne("board.select", map); 
		System.out.println("³»¿ë: " + result.get("content"));
		System.out.println("Grp_cd: " + result.get("grp_Cd"));
		return  result;
	}
	
	@SuppressWarnings("unchecked")
	public List<Map<String, Object>> selectComment(String grpCd) throws Exception{
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("grpCd", grpCd);
		List<Map<String, Object>> result = selectList("board.selectComment", map); 
		
		return  result;
	}
	
	public void regist(Map<String, Object> map) throws Exception{
		insert("board.insert", map);
	}
	
	public void registComment(Map<String, Object> map) throws Exception{
		insert("board.insertComment", map);
	}
	
	public void update(Map<String, Object> map) throws Exception{
		update("board.update", map);
	}
	
	public void delete(int bno) throws Exception{
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("bno", bno);
		delete("board.delete", map);
	}
	
	public void updateViewCnt(int bno) throws Exception{
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("bno", bno);
		update("board.updateViewCnt", map);
	}
	
	@SuppressWarnings("unchecked")
	public List<Map<String, Object>> listCriteria(Criteria cri) throws Exception{
		return (List<Map<String, Object>>) selectList("board.listCriteria", cri);
	}
	
	public Integer TotalCount() throws Exception{
		return (Integer) selectOne("board.getTotalCount");
	}
	
	@SuppressWarnings("unchecked")
	public List<Map<String, Object>> searchCriteria(SearchCriteria cri) throws Exception{
		return (List<Map<String, Object>>) selectList("board.listSearch", cri);
	}
	
	public Integer searchCount(SearchCriteria cri) throws Exception{
		return (Integer) selectOne("board.searchCount", cri);
	}
	
	
}
