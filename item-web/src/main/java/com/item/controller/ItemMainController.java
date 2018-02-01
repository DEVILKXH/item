/**
 * @author kexiaohong
 * @version 1.0 2018年1月30日
 *
 */
package com.item.controller;

import java.util.Date;
import java.util.List;
import java.util.UUID;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.item.base.dto.TemplateInfo;
import com.item.base.dto.TemplateStep;
import com.item.base.entity.Example;
import com.item.constant.Constant;
import com.item.entity.ItemDetail;
import com.item.entity.ItemMain;
import com.item.entity.MainTemplate;
import com.item.entity.SysInfo;
import com.item.entity.Template;
import com.item.entity.Users;
import com.item.inner.base.service.BaseService;
import com.item.inner.dto.Page;
import com.item.service.ItemDetailService;
import com.item.service.ItemMainService;
import com.item.service.MainTemplateService;
import com.item.service.SysInfoService;
import com.item.service.TemplateService;
import com.item.util.UserUtil;
import com.item.utils.ExampleUtil;
import com.item.utils.StringUtil;

@Controller
@RequestMapping(value = "/item/main")
public class ItemMainController extends BaseController<BaseService<ItemMain>, ItemMain>{

	@Autowired
	private ItemMainService itemMainService;
	
	@Autowired
	private UserUtil userUtil;
	
	@Autowired
	private TemplateService templateService;

	@Autowired
	private ItemDetailService itemDetailService;
	
	@Autowired
	private MainTemplateService mainTemplateService;
	
	@Autowired
	private SysInfoService sysInfoService;

	@Autowired
	private ExampleUtil exampleUtil;
	
	@RequestMapping(value = "/index.do")
	private String index(Model model){
		model.addAttribute("page", itemMainService.getMainPage(new ItemMain(), new Page<ItemMain>()));
		return "main/list";
	}
	
	@RequestMapping(value = "getMainPage.do")
	private String getMainPage(String myDoc,ItemMain main, Page<ItemMain> page, Model model,HttpSession session){
		if("self".equals(myDoc)){
			main.setDocCreatorId(userUtil.getUser(session).getId());
		}
		
		model.addAttribute("page", itemMainService.getMainPage(main, page));
		model.addAttribute("model", main);
		return "main/list";
	}
	
	@RequestMapping(value = "getMyDocMainPage.do")
	private String getMyDocMainPage(String myDoc,ItemMain main, Page<ItemMain> page, Model model,HttpSession session){
		Example example = new Example();
		if("approl".equals(myDoc)){
			example.createCriteria().andLike("USER_ID","%" + Constant.PREFIX +  userUtil.getUser(session).getId() + "%").andEqualTo("TEMPLATE_ID", userUtil.getUser(session).getId());
		}else if("approved".equals(myDoc)){
			example.createCriteria().andNotEqualTo("TEMPLATE_ID", userUtil.getUser(session).getId()).andLike("USER_ID","%" + Constant.PREFIX +  userUtil.getUser(session).getId() + "%");
		}
		
		List<MainTemplate> mainTemplates = mainTemplateService.selectByExample(example);
		if(null != mainTemplates && !mainTemplates.isEmpty()){
			model.addAttribute("page", itemMainService.getMyDocMainPage(main, page,mainTemplates));
		}else{
			model.addAttribute("page", new Page<ItemMain>());
		}
		model.addAttribute("model", main);
		return "main/list";
	}
	
	@RequestMapping(value = "/add.do")
	public String add(Model model,String templateId,ItemMain main,HttpSession session){
		if(StringUtil.isNull(templateId)){
			model.addAttribute("message", "模版ID不能为空");
			return Constant.FAIL;
		}
		Template template = templateService.selectByPrimaryKey(templateId);
		if(null == template){
			model.addAttribute("message", "未定义的模版");
			return Constant.FAIL;
		}
		Users user = userUtil.getUser(session);
		TemplateInfo tempInfo = new TemplateInfo();
		List<TemplateStep> steps = JSONArray.parseArray(template.getTemplateInfo(), TemplateStep.class);
		tempInfo.setTn(steps);
		tempInfo.setDocStatus(Constant.EXMIME);
		tempInfo.setHandlerId(user.getId());
		tempInfo.setHandlerName(user.getNickName());
		tempInfo.setStep("0");
		tempInfo.setStepName("起草节点");
		for(TemplateStep step: steps){
			if("1".equals(step.getStep())){
				tempInfo.setNextHandlerId(step.getNode().getHandleId());
				tempInfo.setNextHandlerName(step.getNode().getHandleName());
				tempInfo.setNextStepName(step.getNode().getNodeName());
				break;
			}
		}
		main.setTempInfo(tempInfo);
		main.setDocCreatorId(user.getId());
		main.setDocCreateName(user.getNickName());
		main.setDocCreateTime(new Date());
		main.setDocStatus(Constant.EXMIME);
		model.addAttribute("model", main);
		model.addAttribute("method", "add");
		return "main/edit";
	}
	
	@RequestMapping(value = "/view.do")
	public String view(String id,Model model){
		ItemMain e = itemMainService.selectByPrimaryKey(id);
		if(null == e){
			model.addAttribute("message", "未找到该文档");
			return Constant.FAIL;
		}
		getMainDetail(e);
		model.addAttribute("model", e);
		model.addAttribute("method", "view");
		return "main/view";
	}
	
	@RequestMapping(value = "/edit.do")
	public String edit(String id,Model model){
		ItemMain e = itemMainService.selectByPrimaryKey(id);
		if(null == e){
			model.addAttribute("message", "未找到该文档");
			return Constant.FAIL;
		}
		getMainDetail(e);
		model.addAttribute("model", e);
		model.addAttribute("method", "edit");
		return "main/edit";
	}
	
	public void getMainDetail(ItemMain main){
		//TODO 获取明细
		ItemDetail detail = new ItemDetail();
		detail.setDocMainId(main.getId());
		List<ItemDetail> details = itemDetailService.selectByExample(exampleUtil.getExample(detail));
		main.setFdItems(details);
		
		//TODO 获取模版信息
		MainTemplate mainTemplate = mainTemplateService.selectByPrimaryKey(main.getId());
		TemplateInfo tf = JSONObject.parseObject(mainTemplate.getTemplateInfo(),TemplateInfo.class);
		String _step = tf.getStep();
		int i_step = Integer.parseInt(_step) + 1;
		_step = i_step + "";
		for(TemplateStep step: tf.getTn()){
			if(_step.equals(step.getStep())){
				tf.setNextHandlerId(step.getNode().getHandleId());
				tf.setNextHandlerName(step.getNode().getHandleName());
				tf.setStepName(step.getNode().getNodeName());
				break;
			}
		}
		main.setTempInfo(tf);
	}
	
	@RequestMapping(value = "/addMain.do")
	public String addMain(Model model,ItemMain main,String itemDetailData){
		try{
			TemplateInfo tempInfo = JSONObject.parseObject(main.getTempInfoJSON(), TemplateInfo.class);
			tempInfo.setHandlerId(tempInfo.getNextHandlerId());
			tempInfo.setHandlerName(tempInfo.getNextHandlerName());
			tempInfo.setStepName(tempInfo.getNextStepName());
			String step = tempInfo.getStep();
			String netxStep = Integer.parseInt(step) + 1 + "";
			tempInfo.setStep(netxStep);
			boolean flag = true;
			for(TemplateStep tstep: tempInfo.getTn()){
				if(tstep.getStep().equals(netxStep)){
					flag  = false;
					tempInfo.setNextStepName(tstep.getNode().getNodeName());
					tempInfo.setNextHandlerId(tstep.getNode().getHandleId());
					tempInfo.setNextHandlerName(tstep.getNode().getHandleName());
					break;
				}
			}
			if(flag){
				tempInfo.setDocStatus(Constant.PUBLISH);
				main.setDocStatus(Constant.PUBLISH);
			}
			main.setId(UUID.randomUUID().toString());
			List<ItemDetail> details = JSONArray.parseArray(itemDetailData, ItemDetail.class);
			for(ItemDetail detail: details){
				detail.setId(UUID.randomUUID().toString());
				detail.setDocMainId(main.getId());
				itemDetailService.insertSelective(detail);
			}
			MainTemplate mainTemplate = new MainTemplate();
			mainTemplate.setId(main.getId());
			mainTemplate.setUserId(Constant.PREFIX+ tempInfo.getHandlerId());
			mainTemplate.setTemplateId(tempInfo.getHandlerId());
			mainTemplate.setTemplateInfo(JSONArray.toJSONString(tempInfo));
			mainTemplateService.insertSelective(mainTemplate);
			itemMainService.insertSelective(main);
			
			SysInfo sysInfo = new SysInfo();
			sysInfo.setId(UUID.randomUUID().toString());
			sysInfo.setDocSubject("流程通知");
			sysInfo.setDocContent("请审批"+ main.getDocCreateName() +"提交的"+ main.getDocSubject() +"流程");
			sysInfo.setDocCreatorId(tempInfo.getHandlerId());
			sysInfo.setDocCreatorName(tempInfo.getHandlerName());
			sysInfoService.insertSelective(sysInfo);
			return Constant.SUCCESS;
		}catch (Exception e) {
			model.addAttribute("message", e.getMessage());
			return Constant.FAIL;
		}
	};
	
	
	@RequestMapping(value = "/updateMain.do")
	public String updateMain(Model model,ItemMain main,String itemDetailData){
		try{
			TemplateInfo tempInfo = JSONObject.parseObject(main.getTempInfoJSON(), TemplateInfo.class);
			tempInfo.setHandlerId(tempInfo.getNextHandlerId());
			tempInfo.setHandlerName(tempInfo.getNextHandlerName());
			tempInfo.setStepName(tempInfo.getNextStepName());
			String step = tempInfo.getStep();
			String netxStep = Integer.parseInt(step) + 1 + "";
			tempInfo.setStep(netxStep);
			boolean flag = true;
			for(TemplateStep tstep: tempInfo.getTn()){
				if(tstep.getStep().equals(netxStep)){
					flag  = false;
					tempInfo.setNextStepName(tstep.getNode().getNodeName());
					tempInfo.setNextHandlerId(tstep.getNode().getHandleId());
					tempInfo.setNextHandlerName(tstep.getNode().getHandleName());
					break;
				}
			}
			if(flag){
				tempInfo.setDocStatus(Constant.PUBLISH);
				main.setDocStatus(Constant.PUBLISH);
			}
			ItemDetail deDetail = new ItemDetail();
			deDetail.setDocMainId(main.getId());
			itemDetailService.deleteByExample(exampleUtil.getExample(deDetail));
			List<ItemDetail> details = JSONArray.parseArray(itemDetailData, ItemDetail.class);
			for(ItemDetail detail: details){
				detail.setId(UUID.randomUUID().toString());
				detail.setDocMainId(main.getId());
				itemDetailService.insertSelective(detail);
			}
			MainTemplate mainTemplate = mainTemplateService.selectByPrimaryKey(main.getId());
			mainTemplate.setTemplateInfo(JSONArray.toJSONString(tempInfo));
			mainTemplate.setTemplateId(tempInfo.getHandlerId());
			mainTemplate.setUserId(mainTemplate.getUserId() + Constant.PREFIX + tempInfo.getHandlerId());
			mainTemplateService.updateByPrimaryKeySelective(mainTemplate);
			itemMainService.updateByPrimaryKeySelective(main);
			
			SysInfo sysInfo = new SysInfo();
			sysInfo.setId(UUID.randomUUID().toString());
			sysInfo.setDocSubject("流程通知");
			sysInfo.setDocContent("请审批"+ main.getDocCreateName() +"提交的"+ main.getDocSubject() +"流程");
			sysInfo.setDocCreatorId(tempInfo.getHandlerId());
			sysInfo.setDocCreatorName(tempInfo.getHandlerName());
			sysInfoService.insertSelective(sysInfo);
			
			return Constant.SUCCESS;
		}catch (Exception e) {
			model.addAttribute("message", e.getMessage());
			return Constant.FAIL;
		}
	}
	
	@RequestMapping(value = "/delete.do")
	public String delete(ItemMain record,Model model){
		try{
			ItemDetail deDetail = new ItemDetail();
			deDetail.setDocMainId(record.getId());
			mainTemplateService.deleteByPrimaryKey(record.getId());
			itemDetailService.deleteByExample(exampleUtil.getExample(deDetail));
			itemMainService.deleteByPrimaryKey(record.getId());
			return Constant.SUCCESS;
		}catch (Exception e) {
			model.addAttribute("message", e.getMessage());
			return Constant.FAIL;
		}
	}
}
