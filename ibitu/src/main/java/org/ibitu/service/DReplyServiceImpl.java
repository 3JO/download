package org.ibitu.service;

import java.util.List;

import org.ibitu.domain.DReplyVO;
import org.ibitu.domain.SearchCriteria;
import org.ibitu.persistence.DReplyMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class DReplyServiceImpl implements DReplyService {
	
	@Autowired
	private DReplyMapper mapper;
	
	@Override
	public void addReply(DReplyVO vo) throws Exception {
		mapper.create(vo);

	}

	@Override
	public List<DReplyVO> listReplyPage(Integer bno, SearchCriteria cri) throws Exception {
		return mapper.listPage(bno, cri);
	}
	
	@Override
	public int count(Integer bno) throws Exception {
		return mapper.count(bno);

	}

	@Override
	public void modifyReply(DReplyVO vo) throws Exception {
		mapper.update(vo);

	}

	@Override
	public void removeReply(Integer rno) throws Exception {
		mapper.delete(rno);

	}

}
