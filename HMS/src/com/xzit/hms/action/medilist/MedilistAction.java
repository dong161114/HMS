package com.xzit.hms.action.medilist;

import java.util.Map;

import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.Result;

import com.xzit.hms.action.BaseAction;
import com.xzit.hms.bean.medicine.MediList;
import com.xzit.hms.bean.page.PageBean;
import com.xzit.hms.service.medilist.medilistService;
import com.xzit.hms.service.medilist.impl.medilistServiceImpl;
/**
 * 
 * @ClassName: MedilistAction
 * @Description: TODO 药单信息
 * @author QinChong
 * @date 2016年1月21日 下午1:39:47
 */
@SuppressWarnings("serial")
public class MedilistAction extends BaseAction<MediList>{

	private medilistService medilistservice=new medilistServiceImpl();
	
	private MediList medilist=new MediList();
	
	private PageBean<Map<String, Object>> pb;
	/**
	 * queryStr
	 */
	private String queryStr;
	/**
	 * 
	 * @Title: indexMedilist
	 * @Description: TODO indexMedilist
	 * @param @return   
	 * @return String 
	 * @throws
	 */
	@Action(value = "/indexMedilist", results = { @Result(name = "success", location = "/WEB-INF/jsp/medilist/medilist-index.jsp") })
	public String indexMedilist() {
		return SUCCESS;
	}
	/**
	 * 
	 * @Title: queryMedilist
	 * @Description: TODO queryMedilist
	 * @param @return   
	 * @return String 
	 * @throws
	 */
	@Action(value = "/queryMedilist", results = { @Result(name = "success", location = "/WEB-INF/jsp/medilist/medilist-query.jsp") })
	public String queryMedilist() {
		System.out.println(queryStr);
		pb = medilistservice.queryMedilist(getPagecode(), getPagesize(), queryStr);
		return SUCCESS;
	}
	/**
	 * 
	 * @Title: deleteMedilist
	 * @Description: TODO deleteMedilist
	 * @param @return   
	 * @return String 
	 * @throws
	 */
	@Action(value = "/deleteMedilist", results = { @Result(name = "success", location = "queryMedilist.action", type = "redirect") })
	public String deleteMedilist() {
		medilistservice.delete(medilist);
		return SUCCESS;
	}

	public MediList getMedilist() {
		return medilist;
	}
	public void setMedilist(MediList medilist) {
		this.medilist = medilist;
	}
	public PageBean<Map<String, Object>> getPb() {
		return pb;
	}
	public void setPb(PageBean<Map<String, Object>> pb) {
		this.pb = pb;
	}
	public String getQueryStr() {
		return queryStr;
	}
	public void setQueryStr(String queryStr) {
		this.queryStr = queryStr;
	}
	/**
	 * getModel
	 */
	@Override
	public MediList getModel() {
		return null;
	}

}
