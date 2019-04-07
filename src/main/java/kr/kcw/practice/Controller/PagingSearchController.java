package kr.kcw.practice.Controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import kr.kcw.practice.Service.PagingSearchService;
import kr.kcw.practice.VO.PageMaker;
import kr.kcw.practice.VO.SearchCriteria;

@Controller
@RequestMapping("/board/search")
public class PagingSearchController {

	private static final Logger logger = LoggerFactory.getLogger(PagingSearchController.class);
	
	@Autowired
	private PagingSearchService searchService;
	
	@RequestMapping(value = "/list", method = RequestMethod.GET)
	public String list(Model model, SearchCriteria searchCriteria) throws Exception{
		
		logger.info("---------------------검색 리스트--------------------");
		
		PageMaker pageMaker = new PageMaker();
		pageMaker.setCri(searchCriteria);
		Integer totalNum = searchService.searchCount(searchCriteria);
		pageMaker.setTotalCount(totalNum);
		
		model.addAttribute("list", searchService.listSearch(searchCriteria));
		model.addAttribute("pageMaker", pageMaker);
		
		return "/board/search_index";
	}
	
}
