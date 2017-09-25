package yycg.business.dao.mapper;

import java.util.List;

import yycg.business.pojo.vo.YpxxCustom;
import yycg.business.pojo.vo.YpxxQueryVo;

public interface YpxxMapperCustom {
	//药品目录 查询
	public List<YpxxCustom> findYpxxList(YpxxQueryVo ypxxQueryVo) throws Exception;
	//查询总数
	public int findYpxxCount(YpxxQueryVo ypxxQueryVo) throws Exception;
	
	//导出目录
	public List<YpxxCustom> exportList(YpxxQueryVo ypxxQueryVo) throws Exception;

}
