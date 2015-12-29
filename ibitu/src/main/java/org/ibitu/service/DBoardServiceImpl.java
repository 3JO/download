package org.ibitu.service;

import java.util.List;

import org.ibitu.domain.DBoardVO;
import org.ibitu.domain.SearchCriteria;
import org.ibitu.persistence.DBoardMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class DBoardServiceImpl implements DBoardService {
	
	@Autowired
	private DBoardMapper mapper;
	
	@Override
	public void regist(DBoardVO vo) throws Exception {
		mapper.create(vo);

	}

	@Override
	public DBoardVO read(Integer bno) throws Exception {
		return mapper.read(bno);
	}

	@Override
	public void modify(DBoardVO vo) throws Exception {
		mapper.update(vo);

	}

	@Override
	public void remove(Integer bno) throws Exception {
		mapper.delete(bno);

	}

	@Override
	public List<DBoardVO> listSearchCriteria(SearchCriteria cri) throws Exception {
		return mapper.listSearch(cri);
	}
	
	@Override
	public int listSearchCnt(SearchCriteria cri) throws Exception {
		return mapper.listSearchCnt(cri);
	}

}
