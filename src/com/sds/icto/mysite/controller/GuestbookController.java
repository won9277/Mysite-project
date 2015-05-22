package com.sds.icto.mysite.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.sds.icto.mysite.repository.GuestbookDao;
import com.sds.icto.mysite.domain.GuestbookVo;

@Controller
@RequestMapping("/guestbook")
public class GuestbookController {


	@Autowired
	GuestbookDao guestbookDao;

	@RequestMapping(value={"/list"})
	public String index(Model model) {
		List<GuestbookVo> list = guestbookDao.fetchList();
		
		model.addAttribute("list", list);
				
		return "/guestbook/list";
	}

	@RequestMapping(value = "/insert", method = RequestMethod.POST)
	public String insert(@ModelAttribute GuestbookVo vo) {
		
		guestbookDao.insert(vo);
		return "redirect:/guestbook/list";
	}
	
	@RequestMapping(value={"/delete/{no}"}, method=RequestMethod.GET)
	public String deleteForm(@PathVariable Long no, Model model){
		model.addAttribute("no",no);
		return "/guestbook/deleteform";
	}
	
	@RequestMapping(value={"/delete"}, method=RequestMethod.POST)
	public String delete(@RequestParam("no") Long no,
			@RequestParam("pwd") String pwd){
		
		GuestbookVo vo = new GuestbookVo();
		vo.setNo(no);
		vo.setPwd(pwd);
		
		guestbookDao.delete(vo);
		
		return "redirect:/guestbook/list";
	}
	
	
}
