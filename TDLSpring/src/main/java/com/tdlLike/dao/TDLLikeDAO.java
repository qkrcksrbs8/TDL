package com.tdlLike.dao;

import java.util.List;
import java.util.Map;

import com.tdlLike.domain.*;
import com.tdlLike.domain.likeCommand;
import com.tdlPost.domain.TdlCommand;


public interface TDLLikeDAO {

	//좋아요
	public void insertLike(likeCommand TDLLike);
	
	//좋아요취소
	public void deleteLike(likeCommand TDLLike);
	
	//좋아요 체크유무
	public List<likeCommand> likeCheck(likeCommand TDLLike);
}
