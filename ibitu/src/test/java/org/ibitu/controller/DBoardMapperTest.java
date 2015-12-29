package org.ibitu.controller;

import java.util.List;

import javax.sql.DataSource;

import org.ibitu.domain.Criteria;
import org.ibitu.domain.DBoardVO;
import org.ibitu.persistence.DBoardMapper;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.web.util.UriComponents;
import org.springframework.web.util.UriComponentsBuilder;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "file:src/main/webapp/WEB-INF/spring/**/*.xml" })
public class DBoardMapperTest {

	@Autowired
	private DBoardMapper mapper;

	protected static final Logger logger = LoggerFactory.getLogger(DataSource.class);

	@Test
	public void CreateTest() throws Exception {

		DBoardVO vo = new DBoardVO();
		for (int i = 0; i < 100; i++) {

			vo.setTitle("페이징도 테스트하 " + i);
			vo.setContent("페이징 테스트입니다다다다다 " + i);
			vo.setWriter("tester" + i);

			mapper.create(vo);
		}

	}

	@Test
	public void ReadTest() throws Exception {
		logger.info("RRRRRRRRRRRRRRRRRRRRRRRRR");
		logger.info(mapper.read(60).toString());

	}

	@Test
	public void UpdateTest() throws Exception {

		DBoardVO vo = new DBoardVO();
		vo.setBno(65);
		vo.setTitle("자료실 수정테스트.");
		vo.setContent("내용이 수정되었습니다.");

		mapper.update(vo);

	}

	@Test
	public void DeleteTest() throws Exception {

		mapper.delete(65);

	}

	@Test
	public void listCriteriaTest() throws Exception {
		Criteria cri = new Criteria();
		cri.setPage(2);
		cri.setPerPageNum(20);

		List<DBoardVO> list = mapper.listCriteria(cri);

		for (DBoardVO vo : list) {
			logger.info(vo.getBno() + ":" + vo.getTitle());
		}
	}

	@Test
	public void testURI() throws Exception {
		UriComponents uriComponents = UriComponentsBuilder.newInstance().path("/dboard/read").queryParam("bno", 12)
				.queryParam("perPageNum", 20).build();
		
		logger.info("/dboard/read?bno=12&perPageNum=20");
		logger.info(uriComponents.toString());

	}

}
