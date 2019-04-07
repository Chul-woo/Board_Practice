package kr.kcw.practice.Controller;

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

import kr.kcw.practice.Service.UserService;
import kr.kcw.practice.VO.UserVO;

@Controller
public class UserController {

	private static final Logger logger = LoggerFactory.getLogger(UserController.class);
	
	@Autowired
	private UserService userService;
	
	@RequestMapping(value="/login", method=RequestMethod.GET)
	public String toLogin() throws Exception{
		logger.info("---------------로그인 화면--------------------");
		return "/login/login";
	}
	
	@RequestMapping(value="/register/step1", method=RequestMethod.GET)
	public String toStep1() throws Exception{
		logger.info("---------------회원가입 화면1--------------------");
		return "/register/step1";
	}
	
	@RequestMapping(value="/register/step2", method=RequestMethod.GET)
	public String toStep2() throws Exception{
		logger.info("---------------회원가입 화면2--------------------");
		return "/register/step2";
	}
	
	@RequestMapping(value="/loginProcess", method=RequestMethod.POST)
	public @ResponseBody Map<String, Object> loginProcess(HttpSession session, @RequestBody Map<String, Object> map) throws Exception {
		logger.info("---------------로그인 클릭--------------------");
		System.out.println("아이디: " + String.valueOf(map.get("id")) + ", 비밀번호: " + String.valueOf(map.get("password")));
		
		Map<String, Object> result = new HashMap<String, Object>();
		
		UserVO userVO = userService.logining(String.valueOf(map.get("id")));
		
		if(session.getAttribute("login") != null) {
			session.removeAttribute("login");
		}
		
		try {
			Map<String, Object> user = userService.login(map);
			if(String.valueOf(user.get("id")) != null) {
				session.setAttribute("login", userVO);
				result.put("result", "success");
			}else {
				result.put("result", "fail");
			}
		}catch(NullPointerException e) {
			result.put("result", "fail");
		}
			
		return result;
	}
	
	@RequestMapping(value="/logout")
	public String toLogout(HttpSession session) throws Exception{
		logger.info("---------------로그아웃--------------------");
		session.invalidate();
		return "redirect:/";
	}
	
	@RequestMapping(value="/register/insert", method = RequestMethod.POST)
	public @ResponseBody Map<String, Object> userRegist(@RequestBody Map<String, Object> map) throws Exception{
		logger.info("---------------회원가입 완료--------------------");
		Map<String, Object> result = new HashMap<String, Object>();
		map.put("agree", "Y");
		try {
			userService.insert(map);
		}catch(Exception e) {
			result.put("result", "fail");
			
			return result;
		}
		
		
		result.put("result", "success");
		
		return result;
	}
	
	@RequestMapping(value = "/checkId", method=RequestMethod.POST)
	public @ResponseBody Map<String, Object> checkId(@RequestBody Map<String, Object> maps) throws Exception{
		logger.info("---------------중복확인--------------------");
		Map<String, Object> result = new HashMap<String, Object>();
		Integer i = null;
		try {
			i = userService.checkId(maps);
			System.out.println("i: " + i);
			if(i != null) {
				result.put("result", "success");
				result.put("check", "N");
				return result;
			}
		}catch(NullPointerException e) {
			result.put("result", "success");
			result.put("check", "Y");
		}
		
		return result;
	}
	
}
