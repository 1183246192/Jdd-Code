package com.oa.controller;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import com.oa.common.pojo.EasyUIDataGridResult;
import com.oa.common.pojo.OAResult;
import com.oa.common.utils.ExcelExportSXXSSF;
import com.oa.common.utils.HxlsOptRowsInterface;
import com.oa.common.utils.HxlsRead;
import com.oa.common.utils.UUIDBuild;
import com.oa.pojo.Application;
import com.oa.pojo.Approval;
import com.oa.pojo.Department;
import com.oa.pojo.User;
import com.oa.service.PersonalService;
import com.oa.service.SystemConfigService;
import com.oa.service.UserService;
import com.oa.vo.ActiveUser;
import com.oa.vo.ApplicationQueryVo;
import com.oa.vo.SalaryQueryVo;
import com.oa.vo.VacationQueryVo;
import com.oa.web.utils.Constant;

/**
 * 
 * <p>Title:PersonalController </p>
 * <p>Description: 对应jsp目录下users目录中所有jsp的url请求 </p>
 * <p>Company: </p>
 * @author jdd
 * @date 2017年2月17日 
 *
 */
@Controller
@RequestMapping("/users")
public class PersonalController {

	@Autowired
	private PersonalService personalService;
	
	@Autowired
	private UserService userService;
	
	@Autowired
	private SystemConfigService systemConfigService;
	
	@Autowired
	private HxlsOptRowsInterface salaryImportService;
	
	@RequestMapping("/getDeptName")
	@ResponseBody
	public List<Department> getDeptname() throws Exception{
		List<Department> list = userService.getDeptName();
		return list;
	}
	
	///users/querysalary
	@RequestMapping("/querysalary")
	public String findQuerySalary() throws Exception{
		return "users/querysalary";
	}
	
	@RequestMapping("/querysalary_result")
	@ResponseBody
	public EasyUIDataGridResult getSalaryList(HttpSession session,SalaryQueryVo salaryQueryVo,int page, int rows) throws Exception{
		ActiveUser user = (ActiveUser) session.getAttribute(Constant.USER_SESSION_KEY);
		int userid = user.getUserid();
		EasyUIDataGridResult result = personalService.getSalaryList(salaryQueryVo,page, rows);
		return result;
	}
	
	//users/editsalary?id=2
	@RequestMapping("/editsalary")
	public String editSalary(Model model,HttpServletRequest request) throws Exception{
		String user_id = request.getParameter("id");	
		int id = Integer.parseInt(user_id);
		SalaryQueryVo salaryQueryVo = personalService.getSalaryById(id);
		model.addAttribute("salaryQueryVo", salaryQueryVo);
		return "users/editsalary";
	}
	
	@RequestMapping("/updatesalary")
	@ResponseBody
	public OAResult updateSalary(SalaryQueryVo salaryQueryVo) throws Exception{
		OAResult result = personalService.updateSalary(salaryQueryVo);
		return result;
	}
	
	@RequestMapping("/delete")
	@ResponseBody
	public OAResult deleteSalary(String id) throws Exception{
		OAResult result = personalService.deleteSalary(id);
		return result;
	}
	
	@RequestMapping("/exportsalary")
	@ResponseBody
	public OAResult Exportsalary(SalaryQueryVo salaryQueryVo,HttpServletResponse response) throws Exception{
		
		String filePath = systemConfigService.findBasicinfoById("1001");  //1001:导出文件物理路径
		String fileWebPath = systemConfigService.findBasicinfoById("1002"); //1002:导出文件web下载目录
		String filePrefix = "salary";
		// -1表示关闭自动刷新，手动控制写磁盘的时机，其它数据表示多少数据在内存保存，超过的则写入磁盘
		int flushRows = 100;
		// 定义导出数据的title  
//部门名称  姓名  月份  基本工资  出勤天数  交通补  其他津贴  津贴总金额  养老保险  医疗保险  失业保险  工伤保险  生育保险  住房公积金  总扣费金额  其他应扣  实发工资 
		List<String> fieldNames = new ArrayList<String>();
		fieldNames.add("部门名称");
		fieldNames.add("姓名");
		fieldNames.add("月份");
		fieldNames.add("基本工资");
		fieldNames.add("出勤天数");
		fieldNames.add("交通补");
		fieldNames.add("其他津贴");
		fieldNames.add("津贴总金额");
		fieldNames.add("养老保险");
		fieldNames.add("医疗保险");
		fieldNames.add("失业保险");
		fieldNames.add("工伤保险");
		fieldNames.add("生育保险");
		fieldNames.add("住房公积金");
		fieldNames.add("其他应扣");
		fieldNames.add("总扣费金额");
		fieldNames.add("实发工资");
		// 告诉导出类数据list中对象的属性，让ExcelExportSXXSSF通过反射获取对象的值
		List<String> fieldCodes = new ArrayList<String>();
//		id;userid;month;basicsalary;fsalary;checkingdays;trafficallowance;
//		otherallowance;endowmentinsurance;medicalinsurance;unemploymentinsurance;
//		employmentinjuryinsurance;maternityinsurance;housingfund;othersdeduct;totaldeduct;
		fieldCodes.add("deptName"); 
		fieldCodes.add("name"); 
		fieldCodes.add("month"); 
		fieldCodes.add("basicsalary"); 
		fieldCodes.add("checkingdays"); 
		fieldCodes.add("trafficallowance"); 
		fieldCodes.add("otherallowance"); 
		fieldCodes.add("totalallowance"); 
		fieldCodes.add("endowmentinsurance"); 
		fieldCodes.add("medicalinsurance"); 
		fieldCodes.add("unemploymentinsurance"); 
		fieldCodes.add("employmentinjuryinsurance"); 
		fieldCodes.add("maternityinsurance"); 
		fieldCodes.add("housingfund"); 
		fieldCodes.add("othersdeduct"); 
		fieldCodes.add("totaldeduct"); 
		fieldCodes.add("fsalary"); 
		
		// 开始导出，执行一些workbook及sheet等对象的初始创建
		ExcelExportSXXSSF excelExportSXXSSF = ExcelExportSXXSSF.start(filePath, fileWebPath, filePrefix,
				fieldNames, fieldCodes, flushRows);
		
		// 导出的数据通过service取出
		List<SalaryQueryVo> list = personalService.getSalaryList(salaryQueryVo);
		
		// 执行导出
		excelExportSXXSSF.writeDatasByObject(list);
		
		// 输出文件，返回下载文件的http地址，已经包括虚拟目录
		String webpath = excelExportSXXSSF.exportFile();
		Map<String, String> map = new HashMap<String, String>();
		map.put("webpath", webpath);
		map.put("size", list.size()+"");
		return OAResult.ok(map);
	}
	
	
	@RequestMapping("/importsalary")
	public String importSalary(Model model) throws Exception {

		return "users/importsalary";
	}
	@RequestMapping(value=("/importsalaryinfo"),headers=("content-type=multipart/*"),method=RequestMethod.POST)
//	@RequestMapping("/importsalaryinfo")
	@ResponseBody
	public OAResult importSalaryInfo(MultipartFile salaryimportfile) throws Exception{
		//保存目录
		String webpath = null ;
		//将上传的文件写到磁盘
		String originalFilename  = salaryimportfile.getOriginalFilename();
		String filePath = systemConfigService.findBasicinfoById("1001");  //1001:导出文件物理路径
		String fileWebPath = systemConfigService.findBasicinfoById("1002"); //1002:导出文件web下载目录
		//写入磁盘的文件
		File file = new File(filePath+UUIDBuild.getUUID()+originalFilename.substring(originalFilename.lastIndexOf(".")));
		if(!file.exists()){
			//如果文件目录 不存在则创建
			file.mkdirs();
		}
		//将内存中的文件写磁盘
		salaryimportfile.transferTo(file);
		//上传文件磁盘上路径 
		String absolutePath = file.getAbsolutePath();
		//调用工具类进行药品目录 导入
		HxlsRead xls2csv = null;
		try {
			//第一个参数就是导入的文件
			//第二个参数就是导入文件中哪个sheet
			//第三个参数导入接口的实现类对象
			xls2csv = new HxlsRead(absolutePath,0,salaryImportService);
			xls2csv.process();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		//提示导入成功条数
		long success_num = xls2csv.getOptRows_success();
		//导入失败数量
		long failure_num = xls2csv.getOptRows_failure();
		Map<String, String> map = new HashMap<String, String>();
		map.put("snum", success_num+"");
		map.put("fnum", failure_num+"");
		
		//对导入失败记录处理
		//获取导入失败记录
		List<List<String>> failrows = xls2csv.getFailrows();
		//获取导入记录的title
		List<String> rowtitle = xls2csv.getRowtitle();
		//获取导入失败原因
		List<String> failmsgs = xls2csv.getFailmsgs();
		System.out.println("failrows的数据为："+failrows);
		System.out.println("rowtitle的数据为："+rowtitle);
		System.out.println("failmsgs的数据为："+failmsgs);
		
		ExcelExportSXXSSF excelExportSXXSSF = null ;
		// 告诉导出类数据list中对象的属性，让ExcelExportSXXSSF通过反射获取对象的值   failrows   failmsgs
		if (failmsgs!=null && failmsgs!=null) {
			String filePrefix = "fail";
			int flushRows = 100;
			rowtitle.add("失败原因");
			for (int i = 0; i < failrows.size(); i++) {
				List<String> failrow = failrows.get(i);
				String failmsg = failmsgs.get(i);
				failrow.add(failmsg);
				excelExportSXXSSF = ExcelExportSXXSSF.start(filePath, fileWebPath, filePrefix,
						rowtitle, failrow, flushRows);
				
				excelExportSXXSSF.writeDatasByString(failrow);
//				excelExportSXXSSF.writeDatasByObject(list);
				// 输出文件，返回下载文件的http地址，已经包括虚拟目录
				webpath = excelExportSXXSSF.exportFile();
				map.put("webpath", webpath);
			}
		}
		return OAResult.ok(map);
	}
	
	@RequestMapping("/queryvacation")
	public String findQueryVacation() throws Exception{
		return "users/queryvacation";
	}
	
	@RequestMapping("/queryvacation_result")
	@ResponseBody
	public EasyUIDataGridResult getVacationList(HttpSession session,VacationQueryVo vacationQueryVo,int page, int rows) throws Exception{
		ActiveUser user = (ActiveUser) session.getAttribute(Constant.USER_SESSION_KEY);
		int userid = user.getUserid();
		EasyUIDataGridResult result = personalService.getVacationList(vacationQueryVo,page, rows);
		return result;
	}
	
	@RequestMapping("/editvacation")
	public String editVacation(Model model,HttpServletRequest request) throws Exception{
		String v_id = request.getParameter("id");	
		int id = Integer.parseInt(v_id);
		VacationQueryVo vacationQueryVo = personalService.getVacationById(id);
		model.addAttribute("vacationQueryVo", vacationQueryVo);
		return "users/editvacation";
	}
	
	@RequestMapping("/delvacation")
	@ResponseBody
	public OAResult deleteVacation(String id) throws Exception{
		OAResult result = personalService.deleteSalary(id);
		return result;
	}
	
	@RequestMapping("/updatevacation")
	@ResponseBody
	public OAResult updateVacation(VacationQueryVo vacationQueryVo) throws Exception{
		OAResult result = personalService.updateVacation(vacationQueryVo);
		return result;
	}
	
	@RequestMapping("/addvacation")
	public String findAddVacation() throws Exception{
		return "users/addvacation";
	}
	
	@RequestMapping("/querymyapplication")
	public String findQueryApplication() throws Exception{
		
		return "users/querymyapplication";
	}
	
	@RequestMapping("/queryapplication_result")
	@ResponseBody
	public EasyUIDataGridResult getApplicationList(HttpSession session,ApplicationQueryVo applicationQueryVo,int page, int rows) throws Exception{
		ActiveUser user = (ActiveUser) session.getAttribute(Constant.USER_SESSION_KEY);
		int userid = user.getUserid();
		
		EasyUIDataGridResult result = personalService.getApplicationList(userid,applicationQueryVo,page, rows);
		return result;
	}

	@RequestMapping("/addapplication")
	public String findAddapplication(Model model,HttpSession session) throws Exception{
		ActiveUser user = (ActiveUser) session.getAttribute(Constant.USER_SESSION_KEY);
		String username = user.getUsername();
		Integer did = user.getDid();
		Department department = userService.findDeptByDid(did);
		List<User> leaders = personalService.getLeaders();
		model.addAttribute("ldslist", leaders);
		model.addAttribute("userid", user.getUserid());
		model.addAttribute("username", username);
		model.addAttribute("deptName", department.getName());
		return "users/addapplication";
	}

	@RequestMapping("/editapplication")
	public String editApplication(Model model,HttpServletRequest request) throws Exception{
		String v_id = request.getParameter("id");	
		int id = Integer.parseInt(v_id);
		ApplicationQueryVo appVo = personalService.getApprovalById(id);
		model.addAttribute("applicationQueryVo", appVo);
		return "users/editapplication";
	}

	@RequestMapping("/updatapplication")
	@ResponseBody
	public OAResult updatApplication(Application application) throws Exception{
		OAResult result = personalService.updateApplication(application);
		return result;
	}

	@RequestMapping("/delapplication")
	@ResponseBody
	public OAResult delApplication(String id) throws Exception{
		OAResult result = personalService.delApplication(id);
		return result;
	}
	
	@RequestMapping("/getLeaders")
	@ResponseBody
	public List<User> getLeaders() throws Exception{
		List<User> leaders = personalService.getLeaders();
		return leaders;
	}
	
	@RequestMapping("/insertapplication")
	@ResponseBody
	public OAResult insertApplication(HttpSession session,ApplicationQueryVo applicationQueryVo) throws Exception{
		//id:"34" type:"" reason:"" apptime:"" days:"" leaderList:"1,3,5,7"
		ActiveUser user = (ActiveUser) session.getAttribute(Constant.USER_SESSION_KEY);
		int userid = user.getUserid();
		OAResult result = personalService.insertApplication(userid,applicationQueryVo);
		return result;
	}

	@RequestMapping("/approvalapplication")
	public String findApprovalapplication() throws Exception{
		return "users/approvalapplication";
	}
	
	@RequestMapping("/queryapproval_result")
	@ResponseBody
	public EasyUIDataGridResult getApprovalList(HttpSession session,ApplicationQueryVo applicationQueryVo,int page, int rows) throws Exception{
		ActiveUser user = (ActiveUser) session.getAttribute(Constant.USER_SESSION_KEY);
		int userid = user.getUserid();
		
		EasyUIDataGridResult result = personalService.getApprovalList(userid,applicationQueryVo,page, rows);
		return result;
	}

	@RequestMapping("/editapproval")
	public String editApproval(Model model,HttpServletRequest request) throws Exception{
		String v_id = request.getParameter("id");	
		int id = Integer.parseInt(v_id);
		
		ApplicationQueryVo appVo = personalService.getApprovalById(id);
		model.addAttribute("applicationQueryVo", appVo);
		return "users/editapproval";
	}
	
	@RequestMapping("/validateappro")
	@ResponseBody
	public OAResult validateAppro(HttpSession session,HttpServletRequest request) throws Exception{
		ActiveUser user = (ActiveUser) session.getAttribute(Constant.USER_SESSION_KEY);
		int userid = user.getUserid();
		String v_id = request.getParameter("id");	
		int id = Integer.parseInt(v_id);
		OAResult result = personalService.validateAppro(userid,id);
		return result;
	}

	@RequestMapping("/updateapproval")
	@ResponseBody
	public OAResult updateApproval(ApplicationQueryVo appVo) throws Exception{
		
		OAResult result = personalService.updateApproval(appVo);
		return result;
	}
	
	
}
