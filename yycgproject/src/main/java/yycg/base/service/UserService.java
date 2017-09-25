package yycg.base.service;

import java.util.List;

import yycg.base.pojo.po.Sysuser;
import yycg.base.pojo.po.Usergys;
import yycg.base.pojo.po.Userjd;
import yycg.base.pojo.po.Useryy;
import yycg.base.pojo.vo.ActiveUser;
import yycg.base.pojo.vo.SysuserCustom;
import yycg.base.pojo.vo.SysuserQueryVo;

public interface UserService {
	// 根据用户id查询用户信息
	public List<SysuserCustom> findSysuserList(SysuserQueryVo sysuserQueryVo)
			throws Exception;

	// 查询总数
	public int findSysuserCount(SysuserQueryVo sysuserQueryVo) throws Exception;
	
	//根据UserId查找用户
	Sysuser findSysuserByUserId(String userId) throws Exception;

	//添加用户
	public void insertSysuser(SysuserCustom sysuserCustom) throws Exception ;
	
	// 删除用户
	public void deleteSysuser(String id) throws Exception;
	
	//修改用户
	public void updateSysuser(String id,SysuserCustom sysuserCustom) throws Exception;
	
	//根据单位名称查询监督单位信息
	public Userjd findUserjdByMc(String sysmc) throws Exception;

	//根据单位名称查询监督单位信息
	public Useryy findUseryyByMc(String sysmc) throws Exception;
	
	//根据单位名称查询监督单位信息
	public Usergys findUsergysByMc(String sysmc) throws Exception;
	
	//根据Id查找
	public SysuserCustom findSysuserById(String id) throws Exception;
	
	//校验用户的身份信息
	public ActiveUser checkUserInfo(String userid, String pwd) throws Exception;
	

	
}
