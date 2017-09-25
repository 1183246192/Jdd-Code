package com.oa.web.utils;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.oa.mapper.AnnualvacationMapper;
import com.oa.pojo.Annualvacation;
import com.oa.pojo.AnnualvacationExample;
import com.oa.pojo.AnnualvacationExample.Criteria;
import com.oa.pojo.User;
import com.oa.service.PersonalService;
import com.oa.service.SystemConfigService;
import com.oa.service.UserService;


public class InsertVacationExecute {

	@Autowired
	private UserService userService;
	
	@Autowired
	private PersonalService personalService;
	
	@Autowired
	private AnnualvacationMapper vacationMapper;
	
	@Autowired
	private SystemConfigService systemConfigService;
	
	public void execute() throws Exception{
		List<User> list = userService.getAllUsers();
		InsertVacation(list);
	}

	public boolean InsertVacation(List<User> list) throws Exception{
//		id;userid;year;have;used;remain;starttime;stoptime;previousremain;previousstoptime;total
		String start = systemConfigService.findBasicinfoById("2001");//开始的月份 
		String stop = systemConfigService.findBasicinfoById("2001");//结束的月份
		String pre = systemConfigService.findBasicinfoById("2003");//剩余年假结束的月份
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");  
		SimpleDateFormat sdf2 = new SimpleDateFormat("yyyy");  
		Date date1 = new Date();
		String year=sdf2.format(date1);   //当前的年份
		int have = 5 ;
		for (User user : list) {
			Integer userid = user.getId();
			Annualvacation vacation = personalService.findVacationById(userid);
			if (vacation == null ) {
				Annualvacation annualvacation = new Annualvacation();
				annualvacation.setUserid(userid);
				annualvacation.setYear(year+"年");
				annualvacation.setHave(have);
				annualvacation.setUsed(0);
				annualvacation.setRemain(5);
				String formatyear = sdf2.format(date1);
				String formatstarttime = formatyear+"-"+start; //获取的月份
				Date starttime = sdf.parse(formatstarttime);
				annualvacation.setStarttime(starttime);
				String formatstoptime = formatyear+"-"+stop; //获取的月份
				Date stoptime = sdf.parse(formatstoptime);
				annualvacation.setStoptime(stoptime);
				annualvacation.setPreviousremain(0);
				String formatpreviousstoptime = formatyear+"-"+pre; //获取的月份
				Date previousstoptime = sdf.parse(formatpreviousstoptime);
				annualvacation.setPreviousstoptime(previousstoptime);
				annualvacation.setTotal(5);
				vacationMapper.insert(annualvacation);
				continue;			//结束当前循环进入下次循环
			}
			String hiredate1 = user.getHiredate();
		    Date hiredate = sdf.parse(hiredate1);
		    long between = (date1.getTime() - hiredate.getTime())/1000; //秒
		    long years=(between/(24*3600))/365;	//年数
			if (years > 9) {
				have = 10 ;
			}
			Annualvacation annualvacation = new Annualvacation();
			annualvacation.setUserid(userid);
			annualvacation.setYear(year+"年");
			annualvacation.setHave(have);
			annualvacation.setUsed(0);
			annualvacation.setRemain(have);
			String formatyear = sdf2.format(date1);
			String formatstarttime = formatyear+"-"+start; //获取的月份
			Date starttime = sdf.parse(formatstarttime);
			annualvacation.setStarttime(starttime);
			String formatstoptime = formatyear+"-"+stop; //获取的月份
			Date stoptime = sdf.parse(formatstoptime);
			annualvacation.setStoptime(stoptime);
			
			int curyear = Integer.parseInt(year) - 1;
			AnnualvacationExample example = new AnnualvacationExample();
			Criteria criteria = example.createCriteria();
			criteria.andUseridEqualTo(userid);
			criteria.andYearLike("%"+curyear+"%");
			Integer previous = 0 ;
			List<Annualvacation> valist2 = vacationMapper.selectByExample(example);
			if (valist2.size() == 0 || valist2 == null) {
				annualvacation.setPreviousremain(previous);
			}else {
				previous = valist2.get(0).getTotal();		//剩余的total为Previous
				annualvacation.setPreviousremain(previous);
			}
			
			String formatpreviousstoptime = formatyear+"-"+pre; //获取的月份
			Date previousstoptime = sdf.parse(formatpreviousstoptime);
			annualvacation.setPreviousstoptime(previousstoptime);
			annualvacation.setTotal(have+previous);
			vacationMapper.insert(annualvacation);
		}
		return true;
	}
}
