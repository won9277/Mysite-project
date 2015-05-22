package com.sds.icto.mysite.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;


import com.sds.icto.mysite.domain.BoardVo;

import com.sds.icto.mysite.service.BoardService;

@Controller
@RequestMapping("/board")
public class BoardController {

	@Autowired
	BoardService boardService;

	@RequestMapping(value = { "/board_list" })
	public String index(Model model) {
		List<BoardVo> list = boardService.list();

		model.addAttribute("list", list);

		return "board/board_list";
	}
	
	@RequestMapping(value={"/board_write"})
	public String write(){
		return "board/board_write";
	}

	@RequestMapping(value = { "/board_detail/{no}" }, method = RequestMethod.GET)
	public String viewContent(@PathVariable Long no, Model model) {
		model.addAttribute("no", no);
		BoardVo boardVo2 = boardService.BoardContent(no);
		model.addAttribute("boardVo2", boardVo2);
		boardService.boardUpdateViewcnt(boardVo2);

		return "board/board_detail";
	}

	@RequestMapping(value = { "/insert" }, method = RequestMethod.POST)
	public String insert(@ModelAttribute BoardVo vo) {
		boardService.boardInsert(vo);
		return "redirect:/board/board_list";
	}
	
	@RequestMapping(value={"/delete/{no}"}, method=RequestMethod.GET)
	public String deleteForm(@PathVariable Long no, Model model){
		model.addAttribute("no",no);
		return "board/deleteform";
	}
	
	@RequestMapping(value={"/delete"}, method=RequestMethod.POST)
	public String delete(@ModelAttribute BoardVo vo){
		boardService.boardDelete(vo);
		return "redirect:/board/board_list";
	}

	@RequestMapping(value={"/edit/{no}/{authNo}"}, method=RequestMethod.GET)
	public String editForm(@PathVariable Long no, 
			@PathVariable Long authNo, Model model){
		model.addAttribute("no",no);
		model.addAttribute("authNo",authNo);
		BoardVo vo = boardService.BoardContent(no);
		model.addAttribute("vo",vo);
		return "board/edit";
	}
	
	@RequestMapping(value={"/edit"}, method=RequestMethod.POST)
	public String edit(Long no, @ModelAttribute BoardVo vo, Model model){
		model.addAttribute("no", no);
		boardService.boardUpdate(vo);
		BoardVo boardVo2 = boardService.BoardContent(vo.getNo());
		model.addAttribute("boardVo2",boardVo2);
		return "redirect:/board/board_detail/"+no;
	}
	
}
