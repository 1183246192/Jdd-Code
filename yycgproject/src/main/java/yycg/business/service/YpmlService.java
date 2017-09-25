package yycg.business.service;

import java.util.List;

import yycg.business.pojo.po.Gysypml;
import yycg.business.pojo.po.GysypmlControl;
import yycg.business.pojo.vo.GysypmlCustom;
import yycg.business.pojo.vo.GysypmlQueryVo;

public interface YpmlService {

	// 供货商药品目录查询列表
	/**
	 * 
	 * <p>
	 * Title: findGysypmlList
	 * </p>
	 * <p>
	 * Description:
	 * </p>
	 * 
	 * @param usergysid
	 *            供货商id
	 * @param gysypmlQueryVo
	 *            查询条件
	 * @return
	 * @throws Exception
	 */
	public List<GysypmlCustom> findGysypmlList(String usergysId,
			GysypmlQueryVo gysypmlQueryVo) throws Exception;

	public int findGysypmlCount(String usergysId, GysypmlQueryVo gysypmlQueryVo)
			throws Exception;

	// 供货商添加药品目录查询列表
	public List<GysypmlCustom> findAddGysypmlList(String usergysId,GysypmlQueryVo gysypmlQueryVo) throws Exception;

	public int findAddGysypmlCount(String usergysId,GysypmlQueryVo gysypmlQueryVo) throws Exception;
	//根据供货商的ID和药品信息的ID插入
	public void insertGysypml(String usergysid, String ypxxid) throws Exception;
	
	//根据供货商的ID和药品信息的ID查找Gysypml信息是否存在
	public Gysypml findGysypmlByUsergysidAndYpxxid(String usergysid, String ypxxid) throws Exception;
	
	//根据供货商的ID和药品信息的ID查找GysypmlControl信息是否存在
	public GysypmlControl findGysypmlControlByUsergysidAndYpxxid(String usergysid,String ypxxid) throws Exception;
	
	//根据usergysid查询存在药品Id
	public List<Gysypml> findGysypmlByUsergysid(String usergysid) throws Exception;
}
