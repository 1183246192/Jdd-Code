package com.oa.service.impl;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.oa.common.pojo.EasyUIDataGridResult;
import com.oa.common.pojo.OAResult;
import com.oa.mapper.AnnualvacationMapper;
import com.oa.mapper.ApplicationMapper;
import com.oa.mapper.ApprovalMapper;
import com.oa.mapper.SalaryMapper;
import com.oa.mapper.UserMapper;
import com.oa.mapper.custom.ApplicationMapperCustom;
import com.oa.mapper.custom.UserMapperCustom;
import com.oa.pojo.Annualvacation;
import com.oa.pojo.AnnualvacationExample;
import com.oa.pojo.Application;
import com.oa.pojo.ApplicationExample;
import com.oa.pojo.Approval;
import com.oa.pojo.ApprovalExample;
import com.oa.pojo.Department;
import com.oa.pojo.Salary;
import com.oa.pojo.SalaryExample;
import com.oa.pojo.SalaryExample.Criteria;
import com.oa.pojo.User;
import com.oa.pojo.UserExample;
import com.oa.service.PersonalService;
import com.oa.vo.ApplicationQueryVo;
import com.oa.vo.SalaryQueryVo;
import com.oa.vo.VacationQueryVo;

@Service
public class PersonalServiceImpl implements PersonalService {

	@Autowired
	private SalaryMapper salaryMapper;

	@Autowired
	private UserMapperCustom userMapperCustom;
	
	@Autowired
	private AnnualvacationMapper vacationMapper;
	
	@Autowired
	private ApplicationMapper applicationMapper;
	
	@Autowired
	private UserMapper userMapper;
	
	@Autowired
	private ApprovalMapper approvalMapper;
	
	@Autowired
	private ApplicationMapperCustom appMapperCustom;
	
	@Override
	public EasyUIDataGridResult getSalaryList(SalaryQueryVo QueryVo,int page, int rows) throws Exception {
		PageHelper.startPage(page, rows);
		SalaryExample example = new SalaryExample();
		Criteria criteria = example.createCriteria();
		if (QueryVo.getMonth() != null && StringUtils.isNotBlank(QueryVo.getMonth())) {
			criteria.andMonthLike("%"+QueryVo.getMonth()+"_");
		}
		String name = QueryVo.getName();
		if (name != null && StringUtils.isNotBlank(name)) {
			List<User> users = userMapperCustom.findUseridByName(name);
			List<Integer> list = new ArrayList<Integer>();
			for (User user : users) {
				Integer id = user.getId();
				list.add(id);
			}
			criteria.andUseridIn(list);
		}
		if (QueryVo.getDeptName() != null && StringUtils.isNotBlank(QueryVo.getDeptName())) {
			Integer did = Integer.parseInt(QueryVo.getDeptName());
			List<User> users = userMapperCustom.findUseridByDeptid(did);
			List<Integer> list = new ArrayList<Integer>();
			for (User user : users) {
				Integer id = user.getId();
				list.add(id);
			}
			criteria.andUseridIn(list);
		}
		List<SalaryQueryVo> salaryList = new ArrayList<SalaryQueryVo>();
		List<Salary> list = salaryMapper.selectByExample(example);
//		BeanUtils.copyProperties(source, target);
		for (Salary salary : list) {
			SalaryQueryVo salaryQueryVo = new SalaryQueryVo();
			Integer userid = salary.getUserid();
			User user = userMapperCustom.findUserById(userid);
			Department department = userMapperCustom.findDeptNameById(userid);
			String username = user.getUsername();
			String deptName = department.getName();
			BeanUtils.copyProperties(salary, salaryQueryVo);
			salaryQueryVo.setName(username);
			salaryQueryVo.setDeptName(deptName);
			salaryQueryVo.setDid(user.getDid());
			salaryList.add(salaryQueryVo);
		}
		PageInfo<Salary> pageInfo = new PageInfo<>(list);
		long total = pageInfo.getTotal();
//		int pages = pageInfo.getPages();
//		int pageSize = pageInfo.getPageSize();
		EasyUIDataGridResult result = new EasyUIDataGridResult();
		result.setTotal(total);
		result.setRows(salaryList);
		return result;
	}

	@Override
	public List<SalaryQueryVo> getSalaryList(SalaryQueryVo salaryQueryVo) throws Exception {
		SalaryExample example = new SalaryExample();
		Criteria criteria = example.createCriteria();
		if (salaryQueryVo.getMonth() != null && StringUtils.isNotBlank(salaryQueryVo.getMonth())) {
			criteria.andMonthLike("%"+salaryQueryVo.getMonth()+"%");
		}
		String name = salaryQueryVo.getName();
		if (name != null && StringUtils.isNotBlank(name)) {
			List<User> users = userMapperCustom.findUseridByName(name);
			List<Integer> list = new ArrayList<Integer>();
			for (User user : users) {
				Integer id = user.getId();
				list.add(id);
			}
			criteria.andUseridIn(list);
		}
		if (salaryQueryVo.getDeptName() != null && StringUtils.isNotBlank(salaryQueryVo.getDeptName())) {
			Integer did = Integer.parseInt(salaryQueryVo.getDeptName());
			List<User> users = userMapperCustom.findUseridByDeptid(did);
			List<Integer> list = new ArrayList<Integer>();
			for (User user : users) {
				Integer id = user.getId();
				list.add(id);
			}
			criteria.andUseridIn(list);
		}
		List<SalaryQueryVo> salaryList = new ArrayList<SalaryQueryVo>();
		List<Salary> list = salaryMapper.selectByExample(example);
		for (Salary salary : list) {
			SalaryQueryVo queryVo = new SalaryQueryVo();
			Integer userid = salary.getUserid();
			User user = userMapperCustom.findUserById(userid);
			Department department = userMapperCustom.findDeptNameById(userid);
			String username = user.getUsername();
			String deptName = department.getName();
			BeanUtils.copyProperties(salary, queryVo);
			queryVo.setName(username);
			queryVo.setDeptName(deptName);
			queryVo.setDid(user.getDid());
			salaryList.add(queryVo);
		}
		
		return salaryList;
	}
	
	@Override
	public SalaryQueryVo getSalaryById(int id) throws Exception {
		SalaryQueryVo salaryQueryVo = new SalaryQueryVo();
		Salary salary = salaryMapper.selectByPrimaryKey(id);
		Integer userid = salary.getUserid();
		User user = userMapperCustom.findUserById(userid);
		String username = user.getUsername();
		Department department = userMapperCustom.findDeptNameById(userid);
		String deptName = department.getName();
		BeanUtils.copyProperties(salary, salaryQueryVo);
		salaryQueryVo.setName(username);
		salaryQueryVo.setDeptName(deptName);
		return salaryQueryVo;
	}

	@Override
	public OAResult updateSalary(SalaryQueryVo salaryQueryVo) throws Exception {
		Salary salary = new Salary();
		BeanUtils.copyProperties(salaryQueryVo, salary);
		salaryMapper.updateByPrimaryKeySelective(salary);
//		return OAResult.ok();
		return OAResult.build(200, "修改工资信息成功!");
	}

	@Override
	public OAResult deleteSalary(String id) throws Exception {
		String[] ids = id.split(",");
		for (String sid : ids) {
			int s_id = Integer.parseInt(sid);
			salaryMapper.deleteByPrimaryKey(s_id);
		}
		
		return OAResult.ok();
	}

	@Override
	public EasyUIDataGridResult getVacationList(VacationQueryVo vacationQueryVo, int page, int rows)
			throws Exception {
		PageHelper.startPage(page, rows);
		AnnualvacationExample example = new AnnualvacationExample();
		com.oa.pojo.AnnualvacationExample.Criteria criteria = example.createCriteria();
		String username = vacationQueryVo.getName();
		if (username != null && StringUtils.isNotBlank(username)) {
			List<User> users = userMapperCustom.findUseridByName(username);
			List<Integer> list = new ArrayList<Integer>();
			for (User user : users) {
				Integer id = user.getId();
				list.add(id);
			}
			criteria.andUseridIn(list);
		}
		String deptname = vacationQueryVo.getDeptName();
		if (deptname != null && StringUtils.isNotBlank(deptname)) {
			Integer did = Integer.parseInt(deptname);
			List<User> users = userMapperCustom.findUseridByDeptid(did);
			List<Integer> list = new ArrayList<Integer>();
			for (User user : users) {
				Integer id = user.getId();
				list.add(id);
			}
			criteria.andUseridIn(list);
		}
		String year = vacationQueryVo.getYear();
		if (year != null && StringUtils.isNotBlank(year)) {
			criteria.andYearLike("%"+year+"%");
		}
		List<Annualvacation> list = vacationMapper.selectByExample(example);
		
		List<VacationQueryVo> vacationVoList = new ArrayList<VacationQueryVo>();
		for (Annualvacation annualvacation : list) {
			VacationQueryVo vacation = new VacationQueryVo();
			Integer userid = annualvacation.getUserid();
			User user = userMapperCustom.findUserById(userid);
			Department department = userMapperCustom.findDeptNameById(userid);
			BeanUtils.copyProperties(annualvacation, vacation);
			vacation.setName(user.getUsername());
			vacation.setDeptName(department.getName());
//			statime stotime pretime new SimpleDateFormat("yyyy-MM-dd").format(annualvacation.getPreviousstoptime());
			vacation.setStatime(new SimpleDateFormat("yyyy-MM-dd").format(annualvacation.getStarttime()));
			vacation.setStotime(new SimpleDateFormat("yyyy-MM-dd").format(annualvacation.getStoptime()));
			vacation.setPretime(new SimpleDateFormat("yyyy-MM-dd").format(annualvacation.getPreviousstoptime()));
			vacationVoList.add(vacation);
		}
		
		PageInfo<Annualvacation> pageInfo = new PageInfo<Annualvacation>(list);
		long total = pageInfo.getTotal();
//		int pages = pageInfo.getPages();
//		int pageSize = pageInfo.getPageSize();
		EasyUIDataGridResult result = new EasyUIDataGridResult();
		result.setTotal(total);
		result.setRows(vacationVoList);
		return result;
	}

	@Override
	public VacationQueryVo getVacationById(int id) throws Exception {
		VacationQueryVo vacationQueryVo = new VacationQueryVo();
		Annualvacation vacation = vacationMapper.selectByPrimaryKey(id);
		Integer userid = vacation.getUserid();
		User user = userMapperCustom.findUserById(userid);
		String username = user.getUsername();
		Department department = userMapperCustom.findDeptNameById(userid);
		String deptName = department.getName();
		BeanUtils.copyProperties(vacation, vacationQueryVo);
		vacationQueryVo.setDeptName(deptName);
		vacationQueryVo.setName(username);
		vacationQueryVo.setStatime(new SimpleDateFormat("yyyy-MM-dd").format(vacation.getStarttime()));
		vacationQueryVo.setStotime(new SimpleDateFormat("yyyy-MM-dd").format(vacation.getStoptime()));
		vacationQueryVo.setPretime(new SimpleDateFormat("yyyy-MM-dd").format(vacation.getPreviousstoptime()));
		return vacationQueryVo;
	}

	@Override
	public OAResult deleteVacation(String id) throws Exception {
		String[] ids = id.split(",");
		for (String sid : ids) {
			int v_id = Integer.parseInt(sid);
			vacationMapper.deleteByPrimaryKey(v_id);
		}
		return OAResult.ok();
	}

	@Override
	public OAResult updateVacation(VacationQueryVo vacationQueryVo) throws Exception {
		Annualvacation vacation = new Annualvacation();
		String statime = vacationQueryVo.getStatime();
		String stotime = vacationQueryVo.getStotime();
		String pretime = vacationQueryVo.getPretime();
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");  
	    Date start = sdf.parse(statime);  
	    Date stop = sdf.parse(stotime);  
	    Date previous = sdf.parse(pretime);  
		BeanUtils.copyProperties(vacationQueryVo, vacation);
		vacation.setStarttime(start);
		vacation.setStoptime(stop);
		vacation.setPreviousstoptime(previous);
		vacationMapper.updateByPrimaryKeySelective(vacation);
		return OAResult.build(200, "更新年假成功！");
	}

	@Override
	public Annualvacation findVacationById(int id) throws Exception {
		AnnualvacationExample example = new AnnualvacationExample();
		com.oa.pojo.AnnualvacationExample.Criteria criteria = example.createCriteria();
		criteria.andUseridEqualTo(id);
		List<Annualvacation> list = vacationMapper.selectByExample(example);
		if (list != null && list.size() > 0) {
			return list.get(0);
		}
		return null;
	}

	@Override
	public EasyUIDataGridResult getApplicationList(int user_id,ApplicationQueryVo applicationQueryVo, int page,
			int rows) throws Exception {
		PageHelper.startPage(page, rows);
		ApplicationExample example = new ApplicationExample();
		com.oa.pojo.ApplicationExample.Criteria criteria = example.createCriteria();
		String username = applicationQueryVo.getName();
		if (username != null && StringUtils.isNotBlank(username)) {
			List<User> users = userMapperCustom.findUseridByName(username);
			List<Integer> list = new ArrayList<Integer>();
			for (User user : users) {
				Integer id = user.getId();
				list.add(id);
			}
			criteria.andUseridIn(list);
		}
		String deptname = applicationQueryVo.getDeptName();
		if (deptname != null && StringUtils.isNotBlank(deptname)) {
			Integer did = Integer.parseInt(deptname);
			List<User> users = userMapperCustom.findUseridByDeptid(did);
			List<Integer> list = new ArrayList<Integer>();
			for (User user : users) {
				Integer id = user.getId();
				list.add(id);
			}
			criteria.andUseridIn(list);
		}
		List<Application> list = new ArrayList<Application>();
		//判断用户类型
		User u = userMapper.selectByPrimaryKey(user_id);
//		userMapperCustom.findUserById(user_id);
		if (!(u.getUsername().equals("admin"))) {
//			if (u.getIsleader() == 1) {
//				list = appMapperCustom.findApplicationByleaderid(user_id);
//				
//			}else {
//			}
			criteria.andUseridEqualTo(user_id);
			list = applicationMapper.selectByExample(example);
			
		}else {
			list = applicationMapper.selectByExample(example);
		}
		List<ApplicationQueryVo> applicationVoList = new ArrayList<ApplicationQueryVo>();
		for (Application application : list) {
			ApplicationQueryVo appQueryVo = new ApplicationQueryVo();
			Integer status = application.getStatus();
			Integer userid = application.getUserid();
			User user = userMapperCustom.findUserById(userid);
			Department department = userMapperCustom.findDeptNameById(userid);
			BeanUtils.copyProperties(application, appQueryVo);
			if (status == 1) {//1:待审批 2:审批中 3:审批不通过 4:审批通过
				appQueryVo.setSchedule("已提交未审核");
			}else if(status == 2){
				Integer id = application.getId();
				ApprovalExample appro = new ApprovalExample();
				com.oa.pojo.ApprovalExample.Criteria cra = appro.createCriteria();
				cra.andAppidEqualTo(id);
				cra.andStatusNotEqualTo(1);
				List<Approval> listappro = approvalMapper.selectByExample(appro);
				Integer leaderid = listappro.get(0).getLeaderid();
				String leadername = userMapperCustom.findUserById(leaderid).getUsername();
				appQueryVo.setSchedule(leadername+"已审批");
				appQueryVo.setOpinion(listappro.get(0).getOpinion());
			}else if (status == 3) {
				Integer id = application.getId();
				ApprovalExample appro = new ApprovalExample();
				com.oa.pojo.ApprovalExample.Criteria cra = appro.createCriteria();
				cra.andAppidEqualTo(id);
				cra.andStatusEqualTo(3);//1: 待审批  2:批准 3：不批准
				List<Approval> listappro = approvalMapper.selectByExample(appro);
				Integer leaderid = listappro.get(0).getLeaderid();
				String leadername = userMapperCustom.findUserById(leaderid).getUsername();
				appQueryVo.setSchedule(leadername+"审批不通过");
				appQueryVo.setOpinion(listappro.get(0).getOpinion());
			}else if (status == 4) {
				Integer id = application.getId();
				ApprovalExample appro = new ApprovalExample();
				com.oa.pojo.ApprovalExample.Criteria cra = appro.createCriteria();
				cra.andAppidEqualTo(id);
				cra.andStatusEqualTo(2);//1: 待审批  2:批准 3：不批准
				List<Approval> listappro = approvalMapper.selectByExample(appro);
				Integer leaderid = listappro.get(0).getLeaderid();
				String leadername = userMapperCustom.findUserById(leaderid).getUsername();
				appQueryVo.setSchedule(leadername+"已审批通过");
				appQueryVo.setOpinion(listappro.get(0).getOpinion());
			}
			appQueryVo.setName(user.getUsername());
			appQueryVo.setDeptName(department.getName());
			appQueryVo.setApptime(new SimpleDateFormat("yyyy-MM-dd").format(application.getApplytime()));
			applicationVoList.add(appQueryVo);
		}
		
		PageInfo<Application> pageInfo = new PageInfo<>(list);
		long total = pageInfo.getTotal();
//		int pages = pageInfo.getPages();
//		int pageSize = pageInfo.getPageSize();
		EasyUIDataGridResult result = new EasyUIDataGridResult();
		result.setTotal(total);
		result.setRows(applicationVoList);
		return result;
	}

	@Override
	public List<User> getLeaders() throws Exception {
		UserExample example = new UserExample();
		com.oa.pojo.UserExample.Criteria criteria = example.createCriteria();
		criteria.andIsleaderEqualTo(1);
		List<User> list = userMapper.selectByExample(example);
		return list;
	}

	@Override
	public OAResult insertApplication(int user_id,ApplicationQueryVo applicationQueryVo) throws Exception {
		//id:"34" type:"" reason:"" apptime:"" days:"" leaderList:"1,3,5,7"
		//status: 1:审核中 2:审批不通过 3:审批通过
		String apptime = applicationQueryVo.getApptime();
		Integer id = applicationQueryVo.getId();
		Integer type = applicationQueryVo.getType();//1：年假 2：公假（产假、婚假、丧假）  3：事假  4：病假  5：其他
		String reason = applicationQueryVo.getReason();
		Integer days = applicationQueryVo.getDays();
//		String leader_List = applicationQueryVo.getLeaderlist();
		String leaderList = user_id + "," + applicationQueryVo.getLeaderlist();
		int num = 1;
		Application record = new Application();
		record.setApplytime(new SimpleDateFormat("yyyy-MM-dd").parse(apptime));
		record.setDays(days);
		record.setReason(reason);
		record.setStatus(1);
		record.setType(type);
		record.setUserid(id);
		record.setNum(num);
		record.setLeaderlist(leaderList);
//		applicationMapper.insertSelective(record);
		appMapperCustom.insertappAndGetId(record);
		String[] ldids = leaderList.split(",");
		if (ldids != null && ldids.length > 0) {
			for (int i = 1; i < ldids.length; i++) {
				String lid_ = ldids[i];
				if (lid_ != null) {
					int lid = Integer.parseInt(lid_);
					Approval approval = new Approval();
					approval.setLeaderid(lid);
					approval.setUserid(id);
					approval.setAppid(record.getId());
					if (i == 1) {
						approval.setStatus(1);//审批状态  1:待审批  2:批准 3：不批准
					}
					approvalMapper.insertSelective(approval);
				}
			}
		}
		return OAResult.build(200, "提交休假申请成功！");
	}

	@Override
	public EasyUIDataGridResult getApprovalList(int leaderid, ApplicationQueryVo applicationQueryVo,
			int page, int rows) throws Exception {
		PageHelper.startPage(page, rows);
		
		ApplicationExample example = new ApplicationExample();
		com.oa.pojo.ApplicationExample.Criteria criteria = example.createCriteria();
		String username = applicationQueryVo.getName();
		if (username != null && StringUtils.isNotBlank(username)) {
			List<User> users = userMapperCustom.findUseridByName(username);
			if (users != null && users.size() > 0) {
				List<Integer> list = new ArrayList<Integer>();
				for (User user : users) {
					Integer id = user.getId();
					list.add(id);
				}
				criteria.andUseridIn(list);
			}
			criteria.andUseridEqualTo(0);//给一个没有的值
		}
		Integer spStatus = applicationQueryVo.getSpStatus();
		if (spStatus != null && spStatus != 0) {
			criteria.andStatusEqualTo(spStatus);
		}
		List<Application> list = new ArrayList<Application>();
		//判断用户类型
		User u = userMapper.selectByPrimaryKey(leaderid);
		if (!(u.getUsername().equals("admin"))) {
			ApprovalExample appro = new ApprovalExample();
			com.oa.pojo.ApprovalExample.Criteria cra = appro.createCriteria();
			cra.andLeaderidEqualTo(leaderid);
			List<Approval> list2 = approvalMapper.selectByExample(appro);
			List<Integer> appidlist = new ArrayList<Integer>();
			for (Approval approval : list2) {
				Integer appid = approval.getAppid();
				appidlist.add(appid);
			}
			criteria.andIdIn(appidlist);
			list = applicationMapper.selectByExample(example);
		}else {
			list = applicationMapper.selectByExample(example);
		}
		List<ApplicationQueryVo> applicationVoList = new ArrayList<ApplicationQueryVo>();
		for (Application application : list) {
			ApplicationQueryVo appQueryVo = new ApplicationQueryVo();
			Integer status = application.getStatus();
			Integer userid = application.getUserid();
			User user = userMapperCustom.findUserById(userid);
			Department department = userMapperCustom.findDeptNameById(userid);
			BeanUtils.copyProperties(application, appQueryVo);
			if (status == 1) {//1:待审批 2:审批中 3:审批不通过 4:审批通过
				appQueryVo.setSchedule("已提交未审核");
			}else if(status == 2){
				Integer id = application.getId();
				ApprovalExample appro = new ApprovalExample();
				com.oa.pojo.ApprovalExample.Criteria cra = appro.createCriteria();
				cra.andAppidEqualTo(id);
				cra.andStatusNotEqualTo(1);
				List<Approval> listappro = approvalMapper.selectByExample(appro);
				Integer leader_id = listappro.get(0).getLeaderid();
				String leadername = userMapperCustom.findUserById(leader_id).getUsername();
				appQueryVo.setSchedule(leadername+"已审批");
				appQueryVo.setOpinion(listappro.get(0).getOpinion());
			}else if (status == 3) {
				Integer id = application.getId();
				ApprovalExample appro = new ApprovalExample();
				com.oa.pojo.ApprovalExample.Criteria cra = appro.createCriteria();
				cra.andAppidEqualTo(id);
				cra.andStatusEqualTo(3);//1: 待审批  2:批准 3：不批准
				List<Approval> listappro = approvalMapper.selectByExample(appro);
				Integer leader_id = listappro.get(0).getLeaderid();
				String leadername = userMapperCustom.findUserById(leader_id).getUsername();
				appQueryVo.setSchedule(leadername+"审批不通过");
				appQueryVo.setOpinion(listappro.get(0).getOpinion());
			}else if (status == 4) {
				Integer id = application.getId();
				ApprovalExample appro = new ApprovalExample();
				com.oa.pojo.ApprovalExample.Criteria cra = appro.createCriteria();
				cra.andAppidEqualTo(id);
				cra.andStatusEqualTo(2);//1: 待审批  2:批准 3：不批准
				List<Approval> listappro = approvalMapper.selectByExample(appro);
				Integer leader_id = listappro.get(0).getLeaderid();
				String leadername = userMapperCustom.findUserById(leader_id).getUsername();
				appQueryVo.setSchedule(leadername+"已审批通过");
				appQueryVo.setOpinion(listappro.get(0).getOpinion());
			}else if (status == 5) {
				continue;
			}
			appQueryVo.setName(user.getUsername());
			appQueryVo.setDeptName(department.getName());
			appQueryVo.setApptime(new SimpleDateFormat("yyyy-MM-dd").format(application.getApplytime()));
			applicationVoList.add(appQueryVo);
		}
		
		PageInfo<Application> pageInfo = new PageInfo<>(list);
		long total = pageInfo.getTotal();
//		int pages = pageInfo.getPages();
//		int pageSize = pageInfo.getPageSize();
		EasyUIDataGridResult result = new EasyUIDataGridResult();
		result.setTotal(total);
		result.setRows(applicationVoList);
		return result;
	}

	@Override
	public ApplicationQueryVo getApprovalById(int id) throws Exception {
		ApplicationQueryVo appVo = new ApplicationQueryVo();
		Application application = applicationMapper.selectByPrimaryKey(id);
//		ApprovalExample example = new ApprovalExample();
//		com.oa.pojo.ApprovalExample.Criteria criteria = example.createCriteria();
//		criteria.andAppidEqualTo(id);
//		approvalMapper.selectByExample(example);
		BeanUtils.copyProperties(application, appVo);
		Integer userid = application.getUserid();
		User user = userMapperCustom.findUserById(userid);
		Department department = userMapperCustom.findDeptNameById(userid);
		appVo.setDeptName(department.getName());
		appVo.setName(user.getUsername());
		appVo.setApptime(new SimpleDateFormat("yyyy-MM-dd").format(application.getApplytime()));
		return appVo;
	}

	@Override
	public OAResult updateApplication(Application application) throws Exception {
		applicationMapper.updateByPrimaryKeySelective(application);
		return OAResult.build(200, "更新申请信息成功！");
	}

	@Override
	public OAResult delApplication(String id) throws Exception {
		String[] ids = id.split(",");
		for (String sid : ids) {
			int v_id = Integer.parseInt(sid);
			Application record = new Application();
			record.setStatus(5);					//1:待审批 2:审批中 3:审批不通过 4:审批通过 5:已撤销
			ApplicationExample example = new ApplicationExample();
			com.oa.pojo.ApplicationExample.Criteria criteria = example.createCriteria();
			criteria.andIdEqualTo(v_id);
			applicationMapper.updateByExampleSelective(record, example);
		}
		return OAResult.ok();
	}

	@Override
	public OAResult updateApproval(ApplicationQueryVo appVo) throws Exception {
		Integer appid = appVo.getId();
		Application application = applicationMapper.selectByPrimaryKey(appid);
		Integer num = application.getNum();
		String leaderlist = application.getLeaderlist();
		String[] leaders = leaderlist.split(",");
		String leaderid = leaders[num];
		int leader_id = Integer.parseInt(leaderid);
		Approval approval = new Approval();
		approval.setAppid(appid);
		approval.setLeaderid(leader_id);
		approval.setOpinion(appVo.getSp_opinion());
		int sp_result = Integer.parseInt(appVo.getSp_result());
		approval.setStatus(sp_result);
		ApprovalExample example = new ApprovalExample();
		com.oa.pojo.ApprovalExample.Criteria criteria = example.createCriteria();
		criteria.andAppidEqualTo(appid);
		criteria.andLeaderidEqualTo(leader_id);
		approvalMapper.updateByExampleSelective(approval, example);//更新审批信息
		Application app = new Application();
		app.setId(appid);
		app.setNum(num+1);
		if (sp_result == 2 && leaders.length - num > 1) {
			app.setStatus(2);
		}else if(sp_result == 3){
			app.setStatus(3);
		}else if (sp_result == 2 && leaders.length - num == 1) {
			app.setStatus(4);
		}
		applicationMapper.updateByPrimaryKeySelective(app);//更新num
		String next_id = leaders[num+1];
		Approval appro = new Approval();
		appro.setAppid(appid);
		appro.setLeaderid(Integer.parseInt(next_id));
		appro.setStatus(1);
		ApprovalExample ex = new ApprovalExample();
		com.oa.pojo.ApprovalExample.Criteria criteria2 = ex.createCriteria();
		criteria2.andAppidEqualTo(appid);
		criteria2.andLeaderidEqualTo(Integer.parseInt(next_id));
		approvalMapper.updateByExampleSelective(appro, ex);
		return OAResult.ok();
	}

	@Override
	public OAResult validateAppro(Integer userid, Integer id) throws Exception {
		ApprovalExample example = new ApprovalExample();
		com.oa.pojo.ApprovalExample.Criteria criteria = example.createCriteria();
		criteria.andAppidEqualTo(id);
		criteria.andLeaderidEqualTo(userid);
		List<Approval> list = approvalMapper.selectByExample(example);
		Approval approval = list.get(0);
		Integer status = approval.getStatus();
		if (status != 1) {
			return OAResult.build(500, "此记录已经被审核！");
		}
		return OAResult.ok();
	}
	
	

}
