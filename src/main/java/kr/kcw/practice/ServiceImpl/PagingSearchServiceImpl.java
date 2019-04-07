package kr.kcw.practice.ServiceImpl;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kr.kcw.practice.Dao.BoardDao;
import kr.kcw.practice.Service.PagingSearchService;
import kr.kcw.practice.VO.SearchCriteria;

@Service
public class PagingSearchServiceImpl implements PagingSearchService{

	@Autowired
	private BoardDao boardDao;
	
	@Override
	public List<Map<String, Object>> listSearch(SearchCriteria cri) throws Exception {
		// TODO Auto-generated method stub
		return boardDao.searchCriteria(cri);
	}

	@Override
	public Integer searchCount(SearchCriteria cri) throws Exception {
		// TODO Auto-generated method stub
		return boardDao.searchCount(cri);
	}

}
