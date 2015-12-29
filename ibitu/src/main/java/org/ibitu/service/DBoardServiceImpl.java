package org.ibitu.service;

import java.util.List;

import org.ibitu.domain.Criteria;
import org.ibitu.domain.DBoardVO;
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
	public List<DBoardVO> listCriteria(Criteria cri) throws Exception {
		return mapper.listCriteria(cri);
	}
	
	@Override
	public int listCntCriteria(Criteria cri) throws Exception {
		return mapper.cntPaging(cri);
	}

}
