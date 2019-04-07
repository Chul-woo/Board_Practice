package kr.kcw.practice.Controller;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import kr.kcw.practice.Service.BoardService;
import kr.kcw.practice.VO.SearchCriteria;
import kr.kcw.practice.VO.UserVO;

@Controller
public class BoardController {

	private static final Logger logger = LoggerFactory.getLogger(BoardController.class);
	
	@Autowired
	private BoardService boardService;
	
//	@RequestMapping(value="/board", method = RequestMethod.GET)
//	public String getList(Model model, Map<String, Object> map) throws Exception {
//		logger.info("---------------------게시판 목록----------------------");
//		
//		List<Map<String, Object>> list = boardService.showList(map);
//		
//		model.addAttribute("list", list);
//		
//		return "/board/index";
//	}
//	
//	@RequestMapping(value="/regist", method=RequestMethod.GET)
//	public ModelAndView toRegist() {
//		ModelAndView mv = new ModelAndView("/board/regist");
//		return mv;
//	}
	
	@RequestMapping(value="/board/regist", method=RequestMethod.POST)
	public @ResponseBody Map<String, Object> boardRegist(@RequestBody Map<String, Object> map) throws Exception{
		logger.info("---------------------게시판 등록----------------------");
		String writer = String.valueOf(map.get("writer"));
		String title = String.valueOf(map.get("title"));
		
		System.out.println("writer: " + writer +", date: " + title);
		
		map.put("grpCd", writer+"_"+title);
		map.put("contentCd", "01");
		boardService.regist(map);
		Map<String, Object> params = new HashMap<String,Object>();
		params.put("result", "success");
		return params;
	}
	
	@RequestMapping(value = "/board/comment", method = RequestMethod.POST)
	public @ResponseBody Map<String, Object> commentRegist(@RequestBody Map<String, Object> maps, HttpSession session) throws Exception{
		logger.info("---------------------댓글 등록----------------------");
		UserVO userVO = new UserVO();
		userVO = (UserVO)session.getAttribute("login");
		
		maps.put("writer", userVO.getId());
		maps.put("contentCd", "02");
		boardService.regist(maps);
		Map<String, Object> params = new HashMap<String,Object>();
		params.put("result", "success");
		return params;
	}
	
	@RequestMapping(value="/board/update", method=RequestMethod.POST)
	public String boardUpdate(@RequestBody Map<String, Object> map, SearchCriteria cri, RedirectAttributes rb) throws Exception{
		logger.info("---------------------게시판 수정----------------------");
		
		rb.addAttribute("page", cri.getPage());
		rb.addAttribute("perPageNum", cri.getPerPageNum());
		
		boardService.update(map);
		
		rb.addFlashAttribute("msg", "modSuccess");
		
		return "redirect:/board";
	}
	
//	@RequestMapping(value="/board/delete/{bno}", method = RequestMethod.DELETE)
//	public String boardDelete(@RequestParam int bno) throws Exception{
//		logger.info("---------------------게시판 삭제----------------------");
//		boardService.delete(bno);
//		return "redirect:/";
//	}
	
	@RequestMapping(value="/board/delete", method = RequestMethod.POST)
	public String boardDelete(@RequestBody Map<String, Object> maps, SearchCriteria cri, RedirectAttributes rb) throws Exception{
		logger.info("---------------------게시판 삭제----------------------");
		int bno = Integer.parseInt(String.valueOf(maps.get("bno")));
		boardService.delete(bno);
		rb.addAttribute("page", cri.getPage());
		rb.addAttribute("perPageNum", cri.getPerPageNum());
		rb.addAttribute("searchType", cri.getSearchType());
		rb.addAttribute("keyword", cri.getKeyword());
		rb.addFlashAttribute("msg", "delSuccess");
		
		return "redirect:/board";
	}
	
}
