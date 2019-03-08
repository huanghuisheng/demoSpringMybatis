package com.sms.portal.webaction;

import com.bdcc.hoffice.common.util.Config;
import com.bdcc.hoffice.security.Constants;
import com.bdcc.waf.controller.web.action.BaseWebAction;
import com.bdcc.waf.controller.web.action.BusinessHelper;
import com.bdcc.waf.web.form.DynaForm;
import com.sms.portal.dto.PortalDefaultRSDTO;
import com.sms.portal.pojo.PortalUser;
import com.sms.portal.service.UserService;
import net.sf.json.JSONObject;
import org.apache.commons.lang.StringUtils;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * @version v1.0
 * Create Date 2017.03.31
 *
 */
public class UserWebAction extends BaseWebAction {

	/**
	 * Des: 医生登录
	 * action:smsmember/doctorLogin.do?method=login
	 * param: loginName=""&passWord=""&loginType=""
	 * return: json{code:1,sessionid:"",userid:"",message:""}
	 * explain: code 1 登录成功  -1 其它失败
	 */
	public ActionForward login(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response) {
		log.info("====================DoctorLoginWebAction login.do=========================");
		PortalDefaultRSDTO loginRsDto = new PortalDefaultRSDTO();
		JSONObject json = null;
		HttpSession session = request.getSession(true);
		try {
			DynaForm dynaForm = (DynaForm) form;
			//String loginName = new String((request.getParameter("loginName")).getBytes("iso-8859-1"),"UTF-8");//(String)dynaForm.getValue("loginName");
			//MD5 传入
			String loginName = request.getParameter("loginName");
			String passWord  = (String)dynaForm.getValue("passWord");
			//1 android 2 ios 3 web
			String loginType = (String)dynaForm.getValue("loginType");
			String deviceType = (String)dynaForm.getValue("deviceType");
			// 0：第一次登陆    1：非
			//String firstLogin = (String)dynaForm.getValue("firstLogin");
			Integer deviceTypes = new Integer(3);
			if(deviceType != null && !"".equals(deviceType.trim())){
				deviceTypes = Integer.parseInt(deviceType);
			}

			log.info("============>"+loginName);
			log.info("============>"+passWord);
			log.info("============>"+loginType);
			log.info("=======deviceTypes=====>"+deviceTypes);
			//log.info("=======firstLogins=====>"+firstLogins);

			if(!StringUtils.isNotBlank(passWord) || !StringUtils.isNotBlank(loginName)){
				loginRsDto.setCode(-1);
				loginRsDto.setMessage("用户名或密码为空!");
				json = JSONObject.fromObject(loginRsDto, Config.jsonConfig2);
				this.view(response, json.toString());
				return null;
			}
			PortalUser user = new PortalUser();
			user.setLogonName(loginName);
			user.setPassword(passWord);

			UserService userService = (UserService) BusinessHelper.getService(request,UserService.class);
			loginRsDto = userService.login(user);
			if( loginRsDto.getCode()==-4){
				loginRsDto.setCode(-4);
				loginRsDto.setMessage("用户名或密码不正确");
				json = JSONObject.fromObject(loginRsDto,Config.jsonConfig2);
				this.view(response, json.toString());
				return null;
			}else if(loginRsDto.getCode()==-2){
				loginRsDto.setCode(-2);
				loginRsDto.setMessage("用户名或密码不正确");
				json = JSONObject.fromObject(loginRsDto,Config.jsonConfig2);
				this.view(response, json.toString());
				return null;
			}
			session.setAttribute(Constants.SESSION_USER_OBJ,user);
			loginRsDto.setCode(1);
			loginRsDto.setMessage("登陆成功!");
			json = JSONObject.fromObject(loginRsDto,Config.jsonConfig2);
			this.view(response, json.toString());
			return null;
		} catch (Exception e) {
			loginRsDto.setCode(-1);
			loginRsDto.setMessage("登录异常!");
			json = JSONObject.fromObject(loginRsDto,Config.jsonConfig2);
			this.view(response, json.toString());
			return null;
		}
	}

	/**
	 * Des: 医生退出登录
	 * action:smsmember/doctorLogin.do?method=loginOut
	 * param:
	 * return: json{code:1,sessionid:"",userid:"",message:""}
	 * explain: code 1 登录成功  -1 其它失败
	 */
	public ActionForward loginOut(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response) {
		log.info("====================DoctorLoginWebAction loginOut.do=========================");
		PortalDefaultRSDTO loginRsDto = null;
		JSONObject json = null;
		HttpSession session = request.getSession(true);
		if(session != null){
			PortalUser user = (PortalUser)session.getAttribute(Constants.SESSION_USER_OBJ);
			if(user != null){
				//调用login business
//				BusinessActionHelper actionHelper = new BusinessActionHelper(request);
//				Event evt = actionHelper.getActionEvent(LoginBusinessAction.class);
//				evt.put(Constants.USER_OBJ,user);
//				evt.setEventName(LoginBusinessAction.LOGOUT);
//				actionHelper.executeCommand();
			}
			//注销session
			session.invalidate();
		}
		loginRsDto = new PortalDefaultRSDTO();
		loginRsDto.setCode(1);
		loginRsDto.setMessage("成功退出登录!");
		json = JSONObject.fromObject(loginRsDto,Config.jsonConfig2);
		this.view(response, json.toString());
		return null;
	}

}
