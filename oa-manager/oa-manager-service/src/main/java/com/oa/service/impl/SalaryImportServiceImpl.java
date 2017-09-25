package com.oa.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.oa.common.utils.ExceptionResultInfo;
import com.oa.common.utils.HxlsOptRowsInterface;
import com.oa.common.utils.ResultInfo;
import com.oa.mapper.SalaryMapper;
import com.oa.mapper.custom.UserMapperCustom;
import com.oa.pojo.Salary;
import com.oa.pojo.User;

@Service
public class SalaryImportServiceImpl implements HxlsOptRowsInterface {

	@Autowired
	private SalaryMapper salaryMapper;
	@Autowired
	private UserMapperCustom userMapperCustom;
	
	@Override
	public String optRows(int sheetIndex, int curRow, List<String> rowlist) throws Exception {
		
		try {
	//		String deptName = rowlist.get(0);
			String name = rowlist.get(1);
			String month = rowlist.get(2);
			String basicsalary = rowlist.get(3);
			String checkingdays = rowlist.get(4);
			String trafficallowance = rowlist.get(5);
			String otherallowance = rowlist.get(6);
			String totalallowance = rowlist.get(7);
			String endowmentinsurance = rowlist.get(8);
			String medicalinsurance = rowlist.get(9);
			String unemploymentinsurance = rowlist.get(10);
			String employmentinjuryinsurance = rowlist.get(11);
			String maternityinsurance = rowlist.get(12);
			String housingfund = rowlist.get(13);
			String othersdeduct = rowlist.get(14);
			String totaldeduct = rowlist.get(15);
			String fsalary = rowlist.get(16);
			float basicsalary1 = 0;
			int checkingdays1 = 0;
			float trafficallowance1 = 0;
			float otherallowance1 = 0;
			float totalallowance1 = 0;
			float endowmentinsurance1 = 0;
			float medicalinsurance1 = 0;
			float unemploymentinsurance1 = 0;
			float employmentinjuryinsurance1 = 0;
			float maternityinsurance1 = 0;
			float housingfund1 = 0;
			float othersdeduct1 = 0;
			float totaldeduct1 = 0;
			float fsalary1 = 0;
			try {
				basicsalary1 = Float.parseFloat(basicsalary==null ? "0" : basicsalary);
				checkingdays1 = Integer.parseInt(checkingdays==null ? "0" : checkingdays);
				trafficallowance1 = Float.parseFloat(trafficallowance==null ? "0" : trafficallowance);
				otherallowance1 = Float.parseFloat(otherallowance==null ? "0" : otherallowance);
//				totalallowance1 = Float.parseFloat(totalallowance==null ? "0" : totalallowance);
				totalallowance1 = trafficallowance1+otherallowance1;
				endowmentinsurance1 = Float.parseFloat(endowmentinsurance==null ? "0" : endowmentinsurance);
				medicalinsurance1 = Float.parseFloat(medicalinsurance==null ? "0" : medicalinsurance);
				unemploymentinsurance1 = Float.parseFloat(unemploymentinsurance==null ? "0" : unemploymentinsurance);
				employmentinjuryinsurance1 = Float.parseFloat(employmentinjuryinsurance==null ? "0" : employmentinjuryinsurance);
				maternityinsurance1 = Float.parseFloat(maternityinsurance==null ? "0" : maternityinsurance);
				housingfund1 = Float.parseFloat(housingfund==null ? "0" : housingfund);
				othersdeduct1 = Float.parseFloat(othersdeduct==null ? "0" : othersdeduct);
//				totaldeduct1 = Float.parseFloat(totaldeduct==null ? "0" : totaldeduct);
				totaldeduct1 = endowmentinsurance1+medicalinsurance1+unemploymentinsurance1+employmentinjuryinsurance1+
						maternityinsurance1+housingfund1+othersdeduct1;
//				fsalary1 = Float.parseFloat(fsalary==null ? "0" : fsalary);
				fsalary1 = basicsalary1 + totalallowance1 - totaldeduct1;
			} catch (Exception e) {
				ResultInfo resultInfo = new ResultInfo(500,"请注意excel中的字符不能转成数字",null);
				throw new ExceptionResultInfo(resultInfo);
			}
			Salary salary = new Salary();
			List<User> list = userMapperCustom.findUseridByName(name);
			Integer id = list.get(0).getId();
			salary.setUserid(id);
			salary.setMonth(month);
			salary.setBasicsalary(basicsalary1);
			salary.setCheckingdays(checkingdays1);
			salary.setTrafficallowance(trafficallowance1);
			salary.setOtherallowance(otherallowance1);
			salary.setTotalallowance(totalallowance1);
			salary.setEndowmentinsurance(endowmentinsurance1);
			salary.setMedicalinsurance(medicalinsurance1);
			salary.setUnemploymentinsurance(unemploymentinsurance1);
			salary.setEmploymentinjuryinsurance(employmentinjuryinsurance1);
			salary.setMaternityinsurance(maternityinsurance1);
			salary.setHousingfund(housingfund1);
			salary.setOthersdeduct(othersdeduct1);
			salary.setTotaldeduct(totaldeduct1);
			salary.setFsalary(fsalary1);
			//插入记录
			salaryMapper.insert(salary);
		} catch (Exception e) {
			e.printStackTrace();
			return "导入失败！";
		}
		
		return "success";
	}

}
