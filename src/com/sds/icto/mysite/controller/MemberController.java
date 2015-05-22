package com.sds.icto.mysite.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.sds.icto.mysite.domain.MemberVo;
import com.sds.icto.mysite.repository.MemberDao;
import com.sds.icto.mysite.service.MemberService;

@Controller
@RequestMapping("/member")
public class MemberController {

	@Autowired
	MemberDao memberDao;

	@RequestMapping(value = "/join", method = RequestMethod.GET)
	public String joinForm() {
		return "member/joinform";
	}

	@RequestMapping(value = "/join", method = RequestMethod.POST)
	public String join(@ModelAttribute MemberVo vo) {
		memberDao.insert(vo);
		return "redirect:/index";
	}

	@RequestMapping(value = "/login", method = RequestMethod.GET)
	public String loginform() {
		return "member/loginform";
	}

	@RequestMapping(value = "/login", method = RequestMethod.POST)
	public String login(@ModelAttribute MemberVo vo, HttpSession session) {
		MemberVo memberVo = null;
		memberVo = memberDao.get(vo);
		if (memberVo == null) {
			return "redirect:member/login?result=fail";
		}

		session.setAttribute("authMember", memberVo);
		return "redirect:/index";
	}
	@RequestMapping(value = "/logout")
	public String logout(HttpSession session){
		session.removeAttribute("authMember");
		session.invalidate();
		return "redirect:/index";
	}
}
