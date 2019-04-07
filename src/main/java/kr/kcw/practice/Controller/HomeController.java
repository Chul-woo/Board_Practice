package kr.kcw.practice.Controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import kr.kcw.practice.Service.BoardService;
import kr.kcw.practice.VO.Criteria;
import kr.kcw.practice.VO.PageMaker;
import kr.kcw.practice.VO.SearchCriteria;
import kr.kcw.practice.VO.UserVO;

/**
 * Handles requests for the application home page.
 */
@Controller
public class HomeController {
	
	private static final Logger logger = LoggerFactory.getLogger(HomeController.class);
	
	@Autowired
	private BoardService boardService;
	
	
//	@RequestMapping(value="/", method = RequestMethod.GET)
//	public String getList(Model model, Map<String, Object> map) throws Exception {
//		logger.info("---------------------게시판 목록----------------------");
//		
//		List<Map<String, Object>> list = boardService.showList(map);
//		
//		model.addAttribute("list", list);
//		
//		return "/board/list_index";
//	}
	
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String toIndex(Model model, Map<String, Object> map, HttpSession session) throws Exception{
		logger.info("---------------------TO Index----------------------");
		List<Map<String, Object>> list = boardService.showList(map);
		UserVO vo = (UserVO) session.getAttribute("login");
		
		try {
			System.out.println("아이디1: " + vo.getId());
			model.addAttribute("list", list);
			model.addAttribute("login", vo);
			System.out.println("User: " + vo.toString());
		}catch(NullPointerException e) {
			model.addAttribute("list", list);
			model.addAttribute("login", null);
		}
		
		return "/board/index";
	}
	
	@RequestMapping(value="/board", method = RequestMethod.GET)
	public String getList(Model model, Criteria cri, HttpSession session) throws Exception {
		logger.info("---------------------게시판 목록----------------------");
		
		UserVO userVO = (UserVO) session.getAttribute("login");
		List<Map<String, Object>> list = new ArrayList<Map<String, Object>>();
		
		Integer totalNum = 0;
		PageMaker pageMaker = new PageMaker();
		pageMaker.setCri(cri);
		
		try {
			System.out.println("User: " + userVO.toString());	
			totalNum = boardService.totalCount();
			pageMaker.setTotalCount(totalNum);
			
//			List<Map<String, Object>> list = boardService.showList(map);
			
			list = boardService.listCriteria(cri);
		}catch(NullPointerException ne) {
			list = boardService.listCriteria(cri);
			totalNum = boardService.totalCount();
			pageMaker.setTotalCount(totalNum);
			
		}
		
		model.addAttribute("list", list);
		model.addAttribute("login", userVO);
		model.addAttribute("pageMaker", pageMaker);
		
		
		return "/board/list_index";
	}
	
	@RequestMapping(value="/regist", method=RequestMethod.GET)
	public ModelAndView toRegist(HttpSession session) {
		logger.info("---------------------게시판 등록----------------------");
		
		UserVO userVO = (UserVO) session.getAttribute("login");
		
		ModelAndView mv = new ModelAndView("/board/regist");
		
		mv.addObject("login", userVO);
		
		return mv;
	}
	
//	@RequestMapping(value="/read/{bno}", method=RequestMethod.GET)
//	public ModelAndView toRead(@PathVariable int bno) throws Exception {
//		logger.info("---------------------게시판 조회----------------------");
//		ModelAndView mv = new ModelAndView("/board/read");
//		Map<String, Object> board = boardService.select(bno);
//		
//		System.out.println("boardVO: " + board.toString());
//		mv.addObject("board", board);
//		
//		return mv;
//	}

	@RequestMapping(value="/read", method=RequestMethod.GET)
	public String toRead(@RequestParam("bno") int bno, @ModelAttribute("cri") SearchCriteria cri, Model model, HttpSession session) throws Exception {
		logger.info("---------------------게시판 조회----------------------");
		
		Map<String, Object> board = new HashMap<String, Object>();
		List<Map<String, Object>> comment = new ArrayList<Map<String, Object>>();
		UserVO userVO = new UserVO();
		
		try {
			board = boardService.select(bno);
			
			logger.info("그룹코드: " + board.get("grp_cd"));
			
			comment = boardService.selectComment(String.valueOf(board.get("grp_cd")));
			
			logger.info("글쓴이: " + board.get("writer") + ", 내용: " + board.get("content") +", 등록일: " + board.get("regdate"));
			
			userVO = (UserVO)session.getAttribute("login");
//			comment = boardService.selectComment(String.valueOf(board.get("grpCd")));
		}catch(NullPointerException ne) {
			logger.error("게시판 조회 실패: " + String.valueOf(ne));
		}
		
		
		model.addAttribute("cri", cri);
		model.addAttribute("login", userVO);
		model.addAttribute("board", board);	
		model.addAttribute("comment", comment);
		
		return "/board/read";
	}
	
	@RequestMapping(value="/update", method = RequestMethod.GET)
	public String toUpdate(@RequestParam int bno, SearchCriteria cri, Model model, HttpSession session) throws Exception {
		logger.info("---------------------게시판 수정----------------------");
		UserVO userVO = (UserVO) session.getAttribute("login");
		Map<String, Object> board = boardService.select(bno);
		model.addAttribute("cri", cri);
		model.addAttribute("board", board);
		model.addAttribute("login", userVO);
		return "/board/update";
	}
	
}
