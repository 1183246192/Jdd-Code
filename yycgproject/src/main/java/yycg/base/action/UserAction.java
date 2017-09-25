package yycg.base.action;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import yycg.base.pojo.vo.PageQuery;
import yycg.base.pojo.vo.SysuserCustom;
import yycg.base.pojo.vo.SysuserQueryVo;
import yycg.base.process.result.DataGridResultInfo;
import yycg.base.process.result.ResultInfo;
import yycg.base.process.result.SubmitResultInfo;
import yycg.base.service.UserService;

@Controller
@RequestMapping("/user")
public class UserAction {

	@Resource
	private UserService userService;

	@RequestMapping("/queryuser")
	public String queryuser() throws Exception {
		return "/base/user/queryuser";
	}

	@RequestMapping("/queryuser_result")
	public @ResponseBody DataGridResultInfo queryuser_result(
			SysuserQueryVo sysuserQueryVo, 
			int page,// 页码
			int rows// 每页显示个数
	) throws Exception {

		// 非空校验
		sysuserQueryVo = sysuserQueryVo != null ? sysuserQueryVo
				: new SysuserQueryVo();
		// 查询列表的总数
		int total = userService.findSysuserCount(sysuserQueryVo);

		PageQuery pageQuery = new PageQuery();
		pageQuery.setPageParams(total, rows, page);

		sysuserQueryVo.setPageQuery(pageQuery);

		// 分页查询，向sysuserQueryVo中传入pageQuery
		List<SysuserCustom> list = userService.findSysuserList(sysuserQueryVo);

		DataGridResultInfo dataGridResultInfo = new DataGridResultInfo();
		// 填充 total
		dataGridResultInfo.setTotal(total);
		// 填充 rows
		dataGridResultInfo.setRows(list);

		return dataGridResultInfo;

	}
	
	//添加用户页面
	@RequestMapping("/addsysuser")
	public String addsysuser(Model model)throws Exception{
		return "/base/user/addsysuser";
	}

	//页面提交
	@RequestMapping("/addsysusersubmit")
	public @ResponseBody SubmitResultInfo addsysusersubmit(SysuserQueryVo sysuserQueryVo)throws Exception{
		
		ResultInfo resultInfo = new ResultInfo();
		resultInfo.setType(ResultInfo.TYPE_RESULT_SUCCESS);
		resultInfo.setMessage("操作成功！");
		
		userService.insertSysuser(sysuserQueryVo.getSysuserCustom());
		SubmitResultInfo submitResultInfo = new SubmitResultInfo(resultInfo);
		
		return submitResultInfo;
	}
	
	
	
}
