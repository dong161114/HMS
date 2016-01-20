/**  
 * @Title: OperationAction.java
 * @Package com.xzit.hms.action.operation
 * @Description: TODO
 * @author Mr.Black
 * @date 2016年1月20日 上午10:48:33
 * @version V1.0  
 */
package com.xzit.hms.action.inhospitalcost;

import java.util.Map;

import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.Namespace;
import org.apache.struts2.convention.annotation.Result;

import com.xzit.hms.action.BaseAction;
import com.xzit.hms.bean.inhospital.Operation;
import com.xzit.hms.bean.page.PageBean;
import com.xzit.hms.service.operation.OperationService;
import com.xzit.hms.service.operation.impl.OperationServiceImpl;
import com.xzit.hms.service.patient.PatientService;
import com.xzit.hms.service.patient.impl.PatientServiceImpl;

/**
 * @ClassName: OperationAction
 * @Description: TODO
 * @author Mr.Black
 * @date 2016年1月20日 上午10:48:33
 */
@Namespace("/operation")
public class OperationAction extends BaseAction<Operation> {

	private OperationService operationService = new OperationServiceImpl();
	
	private PatientService patientService = new PatientServiceImpl();

	private String queryStr;

	private PageBean<Map<String, Object>> pb;

	private static final long serialVersionUID = 4358476360057846940L;

	@Action(value = "/indexOper", results = {
			@Result(name = "success", location = "/WEB-INF/jsp/inhospital/operation/operation-index.jsp") })
	public String indexOper() {
		return SUCCESS;
	}

	@Action(value = "/queryOper", results = {
			@Result(name = "success", location = "/WEB-INF/jsp/inhospital/operation/operation-query.jsp") })
	public String queryOper() {
		pb = operationService.queryOper(getPagecode(), getPagesize(), queryStr);
		System.out.println(pb.getBeanlist().size());
		return SUCCESS;
	}

	@Action(value = "/addOper", results = {
			@Result(name = "success", location = "/WEB-INF/jsp/inhospital/operation/operation-add.jsp") })
	public String addOper() {
		return SUCCESS;
	}

	@Override
	public Operation getModel() {
		return null;
	}

	public String getQueryStr() {
		return queryStr;
	}

	public void setQueryStr(String queryStr) {
		this.queryStr = queryStr;
	}

	public PageBean<Map<String, Object>> getPb() {
		return pb;
	}

	public void setPb(PageBean<Map<String, Object>> pb) {
		this.pb = pb;
	}

}
