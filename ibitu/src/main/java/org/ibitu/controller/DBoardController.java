package org.ibitu.controller;

import org.ibitu.domain.Criteria;
import org.ibitu.domain.DBoardVO;
import org.ibitu.domain.PageMaker;
import org.ibitu.service.DBoardService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
@RequestMapping("/dboard/*")
public class DBoardController {

	private static final Logger logger = LoggerFactory.getLogger(DBoardController.class);

	@Autowired
	private DBoardService service;

	@RequestMapping(value = "/registPage", method = RequestMethod.GET)
	public void registGET(DBoardVO vo, Model model) throws Exception {
		logger.info("regist get....");
	}

	@RequestMapping(value = "/registPage", method = RequestMethod.POST)
	public String registPOST(DBoardVO vo, RedirectAttributes rttr) throws Exception {
		logger.info("regist post.......");
		logger.info(vo.toString());

		service.regist(vo);

		rttr.addFlashAttribute("msg", "success");
		return "redirect:/dboard/listPage";
	}

	@RequestMapping(value = "/listPage", method = RequestMethod.GET)
	public void listPage(@ModelAttribute("cri") Criteria cri, Model model) throws Exception {
		logger.info("Show all list with Criteria.....");
		logger.info(cri.toString());
		model.addAttribute("list", service.listCriteria(cri));
		PageMaker pageMaker = new PageMaker();
		pageMaker.setCri(cri);
		
		pageMaker.setTotalCnt(service.listCntCriteria(cri));
		
		model.addAttribute("pageMaker", pageMaker);
	}

	@RequestMapping(value = "/readPage", method = RequestMethod.GET)
	public void read(@RequestParam("bno") int bno, @ModelAttribute("cri") Criteria cri, Model model) throws Exception {
		model.addAttribute("dboardVO", service.read(bno));

	}

	@RequestMapping(value = "/removePage", method = RequestMethod.POST)
	public String remove(@RequestParam("bno") int bno, Criteria cri, RedirectAttributes rttr) throws Exception {
		service.remove(bno);
		rttr.addFlashAttribute("page", cri.getPage());
		rttr.addFlashAttribute("perPageNum", cri.getPerPageNum());
		rttr.addFlashAttribute("msg", "SUCCESS");
		return "redirect:/dboard/listPage";

	}
	
	@RequestMapping(value="/modifyPage", method = RequestMethod.GET)
	public void modifyGET(@RequestParam("bno") int bno,@ModelAttribute("cri") Criteria cri, Model model) throws Exception {
		model.addAttribute("dboardVO", service.read(bno));
	}
	
	@RequestMapping(value="/modifyPage", method = RequestMethod.POST)
	public String modifyPOST(DBoardVO vo, Criteria cri, RedirectAttributes rttr) throws Exception {
		logger.info("mod post......");
		service.modify(vo);
		rttr.addFlashAttribute("page", cri.getPage());
		rttr.addFlashAttribute("perPageNum", cri.getPerPageNum());
		rttr.addFlashAttribute("msg", "SUCCESS");
		
		return "redirect:/dboard/listPage";
	}
	

}
