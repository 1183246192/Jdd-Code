package yycg.base.service.impl;

import java.util.List;

import javax.annotation.Resource;



import org.springframework.beans.BeanUtils;

import yycg.base.dao.mapper.SysuserMapper;
import yycg.base.dao.mapper.SysuserMapperCustom;
import yycg.base.dao.mapper.UsergysMapper;
import yycg.base.dao.mapper.UserjdMapper;
import yycg.base.dao.mapper.UseryyMapper;
import yycg.base.pojo.po.Sysuser;
import yycg.base.pojo.po.SysuserExample;
import yycg.base.pojo.po.Usergys;
import yycg.base.pojo.po.UsergysExample;
import yycg.base.pojo.po.Userjd;
import yycg.base.pojo.po.UserjdExample;
import yycg.base.pojo.po.Useryy;
import yycg.base.pojo.po.UseryyExample;
import yycg.base.pojo.vo.ActiveUser;
import yycg.base.pojo.vo.SysuserCustom;
import yycg.base.pojo.vo.SysuserQueryVo;
import yycg.base.process.context.Config;
import yycg.base.process.result.ResultUtil;
import yycg.base.service.UserService;
import yycg.util.MD5;
import yycg.util.UUIDBuild;

public class UserServiceImpl implements UserService {

	@Resource
	private SysuserMapper sysuserMapper;

	@Resource
	private UserjdMapper userjdMapper;

	@Resource
	private UseryyMapper useryyMapper;

	@Resource
	private UsergysMapper usergysMapper;

	@Resource
	private SysuserMapperCustom sysuserMapperCustom;

	@Override
	public int findSysuserCount(SysuserQueryVo sysuserQueryVo) throws Exception {
		return sysuserMapperCustom.findSysuserCount(sysuserQueryVo);
	}

	@Override
	public List<SysuserCustom> findSysuserList(SysuserQueryVo sysuserQueryVo)
			throws Exception {
		List<SysuserCustom> list = sysuserMapperCustom
				.findSysuserList(sysuserQueryVo);
		// System.out.println("list的长度："+list.size());
		return list;
	}

	@Override
	public Sysuser findSysuserByUserId(String userId) throws Exception {
		SysuserExample sysuserExample = new SysuserExample();
		SysuserExample.Criteria criteria = sysuserExample.createCriteria();

		criteria.andUseridEqualTo(userId);

		List<Sysuser> list = sysuserMapper.selectByExample(sysuserExample);
		if (list != null && list.size() == 1) {
			return list.get(0);
		}
		return null;
	}

	@Override
	public Userjd findUserjdByMc(String mc) throws Exception {
		UserjdExample userjdExample = new UserjdExample();
		UserjdExample.Criteria criteria = userjdExample.createCriteria();
		criteria.andMcEqualTo(mc);
		List<Userjd> list = userjdMapper.selectByExample(userjdExample);
		if (list != null && list.size() == 1) {
			return list.get(0);
		}
		return null;
	}

	@Override
	public Useryy findUseryyByMc(String mc) throws Exception {
		UseryyExample useryyExample = new UseryyExample();
		UseryyExample.Criteria criteria = useryyExample.createCriteria();
		criteria.andMcEqualTo(mc);
		List<Useryy> list = useryyMapper.selectByExample(useryyExample);
		if (list != null && list.size() == 1) {
			return list.get(0);
		}
		return null;
	}

	@Override
	public Usergys findUsergysByMc(String mc) throws Exception {
		UsergysExample usergysExample = new UsergysExample();
		UsergysExample.Criteria criteria = usergysExample.createCriteria();
		criteria.andMcEqualTo(mc);
		List<Usergys> list = usergysMapper.selectByExample(usergysExample);
		if (list != null && list.size() == 1) {
			return list.get(0);
		}
		return null;
	}

	@Override
	public void insertSysuser(SysuserCustom sysuserCustom) throws Exception {
		// 参数校验
		// 通用的参数合法校验，非空校验，长度校验
		// 根据合法性校验
		// 账号唯一性校验，查询数据库检验sysuser表

		Sysuser sysuser = this.findSysuserByUserId(sysuserCustom.getUserid());
		if (sysuser != null) {
			// 账号重复 抛出异常，可预知的异常
			throw new Exception("账号重复");
		}
		String groupid = sysuserCustom.getGroupid();
		String mc = sysuserCustom.getSysmc();
		String sysid = null;
		if (groupid.equals("1") || groupid.equals("2")) {
			// 监督单位根据单位名称查询信息
			Userjd userjd = this.findUserjdByMc(mc);
			if (userjd == null) {
				// 抛出异常，可预知异常
				throw new Exception("监督单位名称输入错误");
			}
			sysid = userjd.getId();
		} else if (groupid.equals("3")) {
			// 卫生室根据单位名称查询信息
			Useryy useryy = this.findUseryyByMc(mc);
			if (useryy == null) {
				// 抛出异常，可预知异常
				throw new Exception("卫生室单位名称输入错误");
			}
			sysid = useryy.getId();
		} else if (groupid.equals("4")) {
			// 供应商根据单位名称查询信息
			Usergys usergys = this.findUsergysByMc(mc);
			if (usergys == null) {
				// 抛出异常，可预知异常
				throw new Exception("供应商单位名称输入错误");
			}
			sysid = usergys.getId();
		}
		// 设置主键
		// sysuserCustom.setId(UUIDBuild.getUUID());
		sysuserCustom.setSysid(sysid);
		sysuserMapper.insert(sysuserCustom);
	}

	@Override
	public void deleteSysuser(String id) throws Exception {
		Sysuser sysuser = sysuserMapper.selectByPrimaryKey(id);
		if (sysuser == null) {
			// 用户不存在
			ResultUtil.throwExcepion(ResultUtil.createFail(Config.MESSAGE, 212,
					null));
		}
		// 删除用户
		sysuserMapper.deleteByPrimaryKey(id);
	}

	@Override
	public void updateSysuser(String id, SysuserCustom sysuserCustom)
			throws Exception {
		// 非空校验
		// 判断账号是否修改了
		Sysuser sysuser = sysuserMapper.selectByPrimaryKey(id);
		String userid = sysuser.getUserid();
		String userid_page = sysuserCustom.getUserid();
		if (!userid.equals(userid_page)) {
			Sysuser sysuser_1 = this.findSysuserByUserId(userid_page);
			if (sysuser_1 != null) {
				ResultUtil.throwExcepion(ResultUtil.createFail(Config.MESSAGE,
						213, null));
			}
		}
		// 根据页面提交的单位名称查询单位id
		String groupid = sysuserCustom.getGroupid();// 用户类型
		String sysmc = sysuserCustom.getSysmc();// 页面输入的单位名称
		String sysid = null;// 单位id
		if (groupid.equals("1") || groupid.equals("2")) {
			// 监督单位
			// 根据单位名称查询单位信息
			Userjd userjd = this.findUserjdByMc(sysmc);
			if (userjd == null) {
				// 抛出异常，可预知异常
				ResultUtil.throwExcepion(ResultUtil.createFail(Config.MESSAGE,
						217, null));
			}
			sysid = userjd.getId();
		} else if (groupid.equals("3")) {
			// 卫生室
			// 根据单位名称查询单位信息
			Useryy useryy = this.findUseryyByMc(sysmc);
			if (useryy == null) {
				// 抛出异常，可预知异常
				ResultUtil.throwExcepion(ResultUtil.createFail(Config.MESSAGE,
						217, null));
			}
			sysid = useryy.getId();
		} else if (groupid.equals("4")) {
			// 供货商
			// 根据单位名称查询单位信息
			Usergys usergys = this.findUsergysByMc(sysmc);
			if (usergys == null) {
				// 抛出异常，可预知异常
				ResultUtil.throwExcepion(ResultUtil.createFail(Config.MESSAGE,
						217, null));
			}
			sysid = usergys.getId();
		}

		// 密码修改
		// 如果从页面提交的密码值为空说明用户不修改密码，否则 就需要对密码进行加密存储
		String pwd_page = sysuserCustom.getPwd().trim();
		String pwd_md5 = null;
		if (pwd_page != null && !pwd_page.equals("")) {
			// 说明用户修改密码了
			pwd_md5 = new MD5().getMD5ofStr(pwd_page);
		}

		// 设置更新用户信息

		// 调用mapper更新用户
		// 使用updateByPrimaryKey更新，要先查询用户
		sysuser.setUserid(sysuserCustom.getUserid());
		sysuser.setUsername(sysuserCustom.getUsername());
		sysuser.setUserstate(sysuserCustom.getUserstate());
		sysuser.setGroupid(sysuserCustom.getGroupid());
		if (pwd_md5 != null) {
			sysuser.setPwd(pwd_md5);
		}
		sysuser.setSysid(sysuserCustom.getSysid());

		sysuserMapper.updateByPrimaryKey(sysuser);
	}

	@Override
	public SysuserCustom findSysuserById(String id) throws Exception {
		// 从数据库查询用户
		Sysuser sysuser = sysuserMapper.selectByPrimaryKey(id);

		// 根据sysid查询单位名称
		String groupid = sysuser.getGroupid();
		String sysid = sysuser.getSysid();// 单位id
		String sysmc = null;
		if (groupid.equals("1") || groupid.equals("2")) {
			// 监督单位
			// 根据单位id查询单位信息
			Userjd userjd = userjdMapper.selectByPrimaryKey(sysid);
			if (userjd == null) {
				// 抛出异常，可预知异常
				ResultUtil.throwExcepion(ResultUtil.createFail(Config.MESSAGE,
						217, null));
			}
			sysmc = userjd.getMc();
		} else if (groupid.equals("3")) {
			// 卫生室
			// 根据单位id查询单位信息
			Useryy useryy = useryyMapper.selectByPrimaryKey(sysid);
			if (useryy == null) {
				// 抛出异常，可预知异常
				ResultUtil.throwExcepion(ResultUtil.createFail(Config.MESSAGE,
						217, null));
			}
			sysmc = useryy.getMc();
		} else if (groupid.equals("4")) {
			// 供货商
			// 根据单位id查询单位信息
			Usergys usergys = usergysMapper.selectByPrimaryKey(sysid);
			if (usergys == null) {
				// 抛出异常，可预知异常
				ResultUtil.throwExcepion(ResultUtil.createFail(Config.MESSAGE,
						217, null));
			}
			sysmc = usergys.getMc();
		}

		SysuserCustom sysuserCustom = new SysuserCustom();

		// 将sysuser中数据设置到sysuserCustom
		BeanUtils.copyProperties(sysuser, sysuserCustom);

		sysuserCustom.setSysmc(sysmc);// 单位名称

		return sysuserCustom;
	}

	@Override
	public ActiveUser checkUserInfo(String userid, String pwd) throws Exception {
		// 校验用户是否存在
		Sysuser sysuser = this.findSysuserByUserId(userid);
		if (sysuser == null) {
			// 用户不存在
			ResultUtil.throwExcepion(ResultUtil.createFail(Config.MESSAGE, 101,
					null));
		}

		// 校验用户密码是否合法
		String pwd_db = sysuser.getPwd();// md5密文
		String pwd_md5 = new MD5().getMD5ofStr(pwd);

		if (!pwd_db.equalsIgnoreCase(pwd_md5)) {
			// 用户名或密码错误
			ResultUtil.throwExcepion(ResultUtil.createFail(Config.MESSAGE, 114,
					null));
		}

		// 构建用户身份信息
		ActiveUser activeUser = new ActiveUser();
		activeUser.setUserid(userid);
		activeUser.setUsername(sysuser.getUsername());
		activeUser.setGroupid(sysuser.getGroupid());
		activeUser.setSysid(sysuser.getSysid());// 单位id（重要）
		String sysmc = null;// 单位名称
		// 根据sysid查询单位名称
		String groupid = sysuser.getGroupid();
		String sysid = sysuser.getSysid();// 单位id
		if (groupid.equals("1") || groupid.equals("2")) {
			// 监督单位
			// 根据单位id查询单位信息
			Userjd userjd = userjdMapper.selectByPrimaryKey(sysid);
			if (userjd == null) {
				// 抛出异常，可预知异常
				ResultUtil.throwExcepion(ResultUtil.createFail(Config.MESSAGE,
						217, null));
			}
			sysmc = userjd.getMc();
		} else if (groupid.equals("3")) {
			// 卫生室
			// 根据单位id查询单位信息
			Useryy useryy = useryyMapper.selectByPrimaryKey(sysid);
			if (useryy == null) {
				// 抛出异常，可预知异常
				ResultUtil.throwExcepion(ResultUtil.createFail(Config.MESSAGE,
						217, null));
			}
			sysmc = useryy.getMc();
		} else if (groupid.equals("4")) {
			// 供货商
			// 根据单位id查询单位信息
			Usergys usergys = usergysMapper.selectByPrimaryKey(sysid);
			if (usergys == null) {
				// 抛出异常，可预知异常
				ResultUtil.throwExcepion(ResultUtil.createFail(Config.MESSAGE,
						217, null));
			}
			sysmc = usergys.getMc();
		}

		activeUser.setSysmc(sysmc);// 单位名称

		return activeUser;
	}

}
