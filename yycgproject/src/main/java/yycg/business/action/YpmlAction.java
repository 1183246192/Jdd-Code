package yycg.business.action;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import yycg.base.pojo.po.Dictinfo;
import yycg.base.pojo.vo.ActiveUser;
import yycg.base.pojo.vo.PageQuery;
import yycg.base.process.context.Config;
import yycg.base.process.result.DataGridResultInfo;
import yycg.base.process.result.ExceptionResultInfo;
import yycg.base.process.result.ResultInfo;
import yycg.base.process.result.ResultUtil;
import yycg.base.process.result.SubmitResultInfo;
import yycg.base.service.SystemConfigService;
import yycg.base.service.UserService;
import yycg.business.dao.mapper.GysypmlMapper;
import yycg.business.pojo.po.Gysypml;
import yycg.business.pojo.po.GysypmlExample;
import yycg.business.pojo.vo.GysypmlCustom;
import yycg.business.pojo.vo.GysypmlQueryVo;
import yycg.business.pojo.vo.YpxxCustom;
import yycg.business.service.YpmlService;

/**
 * 
 * <p>
 * Title: YpmlAction
 * </p>
 * <p>
 * Description:供货商药品目录
 * </p>
 * <p>
 * Company: www.itcast.com
 * </p>
 */
@Controller
@RequestMapping("/ypml")
public class YpmlAction {

	@Autowired
	private SystemConfigService systemConfigService;

	@Autowired
	private YpmlService ypmlService;

	@Autowired
	private GysypmlMapper gysypmlMapper;

	// 查询页面
	@RequestMapping("/querygysypml")
	public String querygysypml(Model model) throws Exception {
		// 药品类别
		List<Dictinfo> yplblist = systemConfigService.findDictinfoByType("001");
		model.addAttribute("yplblist", yplblist);

		return "/business/ypml/querygysypml";
	}

	// 查询列表结果集,json
	@RequestMapping("/querygysypml_result")
	public @ResponseBody DataGridResultInfo querygysypml_result(HttpSession session,
			GysypmlQueryVo gysypmlQueryVo,// 查询条件
			int page, int rows) throws Exception {

		// 当前用户
		ActiveUser activeUser = (ActiveUser) session.getAttribute(Config.ACTIVEUSER_KEY);
		// 用户所属的单位
		String usergysid = activeUser.getSysid();// 单位id

		// 列表的总数
		int total = ypmlService.findGysypmlCount(usergysid, gysypmlQueryVo);

		// 分页参数
		PageQuery pageQuery = new PageQuery();
		pageQuery.setPageParams(total, rows, page);
		gysypmlQueryVo.setPageQuery(pageQuery);// 设置分页参数

		// 分页查询列表
		List<GysypmlCustom> list = ypmlService.findGysypmlList(usergysid, gysypmlQueryVo);

		DataGridResultInfo dataGridResultInfo = new DataGridResultInfo();
		dataGridResultInfo.setTotal(total);
		dataGridResultInfo.setRows(list);

		return dataGridResultInfo;
	}

	// 查询页面
	@RequestMapping("/queryaddgysypml")
	public String queryaddgysypml(Model model) throws Exception {
		// 药品类别
		List<Dictinfo> yplblist = systemConfigService.findDictinfoByType("001");
		model.addAttribute("yplblist", yplblist);

		return "/business/ypml/queryaddgysypml";
	}

	// 查询列表结果集,json
	@RequestMapping("/queryaddgysypml_result")
	public @ResponseBody DataGridResultInfo queryaddgysypml_result(HttpSession session,
			GysypmlQueryVo gysypmlQueryVo,// 查询条件
			int page, int rows) throws Exception {

		// 当前用户
		ActiveUser activeUser = (ActiveUser) session.getAttribute(Config.ACTIVEUSER_KEY);
		// 用户所属的单位
		String usergysid = activeUser.getSysid();// 单位id

		// 列表的总数
		int total = ypmlService.findAddGysypmlCount(usergysid, gysypmlQueryVo);

		// 分页参数
		PageQuery pageQuery = new PageQuery();
		pageQuery.setPageParams(total, rows, page);
		gysypmlQueryVo.setPageQuery(pageQuery);// 设置分页参数

		// 分页查询列表
		List<GysypmlCustom> list = ypmlService.findAddGysypmlList(usergysid, gysypmlQueryVo);

		DataGridResultInfo dataGridResultInfo = new DataGridResultInfo();
		dataGridResultInfo.setTotal(total);
		dataGridResultInfo.setRows(list);

		return dataGridResultInfo;
	}

	@RequestMapping("/addgysypmlsubmit")
	public @ResponseBody SubmitResultInfo addgysypmlsubmit(HttpSession session, int[] indexs,
			GysypmlQueryVo gysypmlQueryVo) throws Exception {
		ActiveUser activeUser = (ActiveUser) session.getAttribute(Config.ACTIVEUSER_KEY);
		// System.out.println(indexs);
		String usergysid = activeUser.getSysid();
		List<YpxxCustom> list = gysypmlQueryVo.getYpxxCustoms();
		// 处理数据的总数
		int count = indexs.length;
		// 处理成功的数量
		int count_success = 0;
		// 处理失败的数量
		int count_error = 0;
		// 处理失败的原因
		List<ResultInfo> msgs_error = new ArrayList<ResultInfo>();
		for (int i = 0; i < count; i++) {
			ResultInfo resultInfo = null;
			// 根据选中行的序号获取要处理的业务数据(单个)
			YpxxCustom ypxxCustom = list.get(indexs[i]);
			String ypxxid = ypxxCustom.getId();
			try {
				ypmlService.insertGysypml(usergysid, ypxxid);
			} catch (Exception e) {
				e.printStackTrace();
				if (e instanceof ExceptionResultInfo) {
					resultInfo = ((ExceptionResultInfo) e).getResultInfo();
				} else {
					// 构造未知错误异常
					resultInfo = ResultUtil.createFail(Config.MESSAGE, 900, null);
				}
			}
			if (resultInfo == null) {
				// 说明成功
				count_success++;
			} else {
				count_error++;
				// 记录失败原因
				msgs_error.add(resultInfo);
			}
		}
		// 改成返回详细信息
		return ResultUtil.createSubmitResult(
				ResultUtil.createSuccess(Config.MESSAGE, 907, new Object[] { count_success,
						count_error }), msgs_error);

	}

	@RequestMapping("/deletegysypmlsubmit")
	public @ResponseBody SubmitResultInfo deletegysypmlsubmit(HttpSession session, int[] indexs,
			GysypmlQueryVo gysypmlQueryVo) throws Exception {
		ActiveUser activeUser = (ActiveUser) session.getAttribute(Config.ACTIVEUSER_KEY);
		// System.out.println(indexs);
		String usergysid = activeUser.getSysid();
		// 查询药品信息
		List<Gysypml> list_Gysypml = ypmlService.findGysypmlByUsergysid(usergysid);
		List<GysypmlCustom> list_GysypmlCustom = gysypmlQueryVo.getGysypmlCustoms();
		int count = indexs.length;
		int count_success = 0;
		int count_error = 0;
		ResultInfo resultInfo = null;
		// 处理失败的原因
		List<ResultInfo> msgs_error = new ArrayList<ResultInfo>();
		for (int i = 0; i < count; i++) {
			GysypmlCustom gysypmlCustom = list_GysypmlCustom.get(indexs[i]);
			String ypxxid = gysypmlCustom.getYpxxid();
			if (ypxxid != null) {
				for (int j = 0; j < list_Gysypml.size(); j++) {
					Gysypml gysypml = list_Gysypml.get(j);
					if (ypxxid.equals(gysypml.getYpxxid())) {
						GysypmlExample gysypmlExample = new GysypmlExample();
						GysypmlExample.Criteria criteria = gysypmlExample.createCriteria();
						criteria.andYpxxidEqualTo(ypxxid);
						try {
							gysypmlMapper.deleteByExample(gysypmlExample);
							count_success++;
						} catch (Exception e) {
							e.printStackTrace();
							count_error++;
							if (e instanceof ExceptionResultInfo) {
								resultInfo = ((ExceptionResultInfo) e).getResultInfo();
							} else {
								// 构造未知错误异常
								resultInfo = ResultUtil.createFail(Config.MESSAGE, 900, null);
								msgs_error.add(resultInfo);
							}
						}
					}
				}
			} else {
				return ResultUtil.createSubmitResult(ResultUtil.createFail(Config.MESSAGE, 900,
						null));
			}
		}
		// 改成返回详细信息
		return ResultUtil.createSubmitResult(
				ResultUtil.createSuccess(Config.MESSAGE, 907, new Object[] { count_success,
						count_error }), msgs_error);
	}
}
