package org.ibitu.controller;

import java.util.ArrayList;
import java.util.List;

import org.ibitu.domain.SampleVO;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/sample")
public class SampleController {
	
	@RequestMapping("/hello")
	public String sayHello(){
		return "Hello World";
	}
	
	@RequestMapping("/sendList")
	public ResponseEntity<List<SampleVO>> sendListNot(){
		List<SampleVO> list = new ArrayList<>();
		for (int i = 0; i< 10;i++) {
			
			SampleVO vo = new SampleVO();
			vo.setBno(160);
			vo.setReplyer("tester99");
			vo.setReplytext("sample reply text" + i);
			list.add(vo);
			
		}
		return new ResponseEntity<>(list, HttpStatus.NOT_FOUND);
	}
	
}
