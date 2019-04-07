package kr.kcw.practice.ServiceImpl;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kr.kcw.practice.Dao.BoardDao;
import kr.kcw.practice.Service.BoardService;
import kr.kcw.practice.VO.Criteria;

@Service
public class BoardServiceImpl implements BoardService{

	@Autowired
	private BoardDao boardDao;
	
	@Override
	public List<Map<String, Object>> showList(Map<String, Object> map) throws Exception {
		// TODO Auto-generated method stub
		return boardDao.showList(map);
	}
	
	@Override
	public Map<String, Object> select(int bno) throws Exception {
		// TODO Auto-generated method stub
		boardDao.updateViewCnt(bno);
		return boardDao.selectBoard(bno);
	}
	
	public List<Map<String, Object>> selectComment(String grpCd) throws Exception{
		return boardDao.selectComment(grpCd);
	}

	@Override
	public void regist(Map<String, Object> map) throws Exception {
		// TODO Auto-generated method stub
		boardDao.regist(map);
	}
	
	@Override
	public void registComment(Map<String, Object> map) throws Exception {
		// TODO Auto-generated method stub
		boardDao.registComment(map);
	}

	@Override
	public void update(Map<String, Object> map) throws Exception {
		// TODO Auto-generated method stub
		boardDao.update(map);
	}

	@Override
	public void delete(int bno) throws Exception {
		// TODO Auto-generated method stub
		boardDao.delete(bno);		
	}

	@Override
	public List<Map<String, Object>> listCriteria(Criteria cri) throws Exception {
		return boardDao.listCriteria(cri);
	}

	@Override
	public Integer totalCount() throws Exception {
		// TODO Auto-generated method stub
		return boardDao.TotalCount();
	}

}
