package com.oa.service;

import java.util.List;

import com.oa.common.pojo.EasyUIDataGridResult;
import com.oa.common.pojo.OAResult;
import com.oa.pojo.Annualvacation;
import com.oa.pojo.Application;
import com.oa.pojo.Approval;
import com.oa.pojo.User;
import com.oa.vo.ApplicationQueryVo;
import com.oa.vo.SalaryQueryVo;
import com.oa.vo.VacationQueryVo;

public interface PersonalService {
	
	EasyUIDataGridResult getSalaryList(SalaryQueryVo salaryQueryVo,int page, int rows) throws Exception;
	SalaryQueryVo getSalaryById(int id) throws Exception;
	OAResult updateSalary(SalaryQueryVo salaryQueryVo) throws Exception;
	List<SalaryQueryVo> getSalaryList(SalaryQueryVo salaryQueryVo) throws Exception;
	OAResult deleteSalary(String id) throws Exception;
	EasyUIDataGridResult getVacationList(VacationQueryVo vacationQueryVo,int page, int rows) throws Exception;
	VacationQueryVo getVacationById(int id) throws Exception;
	OAResult deleteVacation(String id) throws Exception;
	OAResult updateVacation(VacationQueryVo vacationQueryVo) throws Exception;
	Annualvacation findVacationById(int id) throws Exception;
	EasyUIDataGridResult getApplicationList(int userid,ApplicationQueryVo applicationQueryVo,int page, int rows) throws Exception;
	List<User> getLeaders() throws Exception;
	OAResult insertApplication(int userid,ApplicationQueryVo applicationQueryVo) throws Exception;
	OAResult updateApplication(Application application) throws Exception;
	OAResult validateAppro(Integer userid,Integer id) throws Exception;
	OAResult delApplication(String id) throws Exception;
	EasyUIDataGridResult getApprovalList(int userid,ApplicationQueryVo applicationQueryVo,int page, int rows) throws Exception;
	ApplicationQueryVo getApprovalById(int id) throws Exception;
	OAResult updateApproval(ApplicationQueryVo appVo) throws Exception;
}
