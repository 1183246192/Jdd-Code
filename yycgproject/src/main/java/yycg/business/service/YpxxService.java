package yycg.business.service;

import java.util.List;

import yycg.business.pojo.vo.YpxxCustom;
import yycg.business.pojo.vo.YpxxQueryVo;

public interface YpxxService {
	// 药品目录 查询
	List<YpxxCustom> findYpxxList(YpxxQueryVo ypxxQueryVo) throws Exception;
	//查询总数
	int findSysuserCount(YpxxQueryVo ypxxQueryVo) throws Exception;
	
	//导出目录
	public List<YpxxCustom> exportList(YpxxQueryVo ypxxQueryVo) throws Exception;

}
