package kr.kcw.practice.Service;

import java.util.List;
import java.util.Map;

import kr.kcw.practice.VO.SearchCriteria;

public interface PagingSearchService {

	public List<Map<String, Object>> listSearch(SearchCriteria cri) throws Exception;
	
	public Integer searchCount(SearchCriteria cri) throws Exception;
	
}
