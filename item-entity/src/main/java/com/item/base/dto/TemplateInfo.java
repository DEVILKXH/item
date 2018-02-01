/**
 * @author kexiaohong
 * @version 1.0 2018年1月29日
 *
 */
package com.item.base.dto;

import java.util.List;

public class TemplateInfo {
	
	private String docStatus;
	
	private String handlerId;
	
	private String handlerName;

	private String nextHandlerId;
	
	private String nextHandlerName;

	private String step;

	private String stepName;
	

	private String nextStepName;
	
	private List<TemplateStep> tn;

	public String getDocStatus() {
		return docStatus;
	}

	public void setDocStatus(String docStatus) {
		this.docStatus = docStatus;
	}

	public String getHandlerId() {
		return handlerId;
	}

	public void setHandlerId(String handlerId) {
		this.handlerId = handlerId;
	}

	public String getHandlerName() {
		return handlerName;
	}

	public void setHandlerName(String handlerName) {
		this.handlerName = handlerName;
	}

	public List<TemplateStep> getTn() {
		return tn;
	}

	public void setTn(List<TemplateStep> tn) {
		this.tn = tn;
	}

	public String getStep() {
		return step;
	}

	public void setStep(String step) {
		this.step = step;
	}

	public String getNextHandlerId() {
		return nextHandlerId;
	}

	public void setNextHandlerId(String nextHandlerId) {
		this.nextHandlerId = nextHandlerId;
	}

	public String getNextHandlerName() {
		return nextHandlerName;
	}

	public void setNextHandlerName(String nextHandlerName) {
		this.nextHandlerName = nextHandlerName;
	}

	public String getStepName() {
		return stepName;
	}

	public void setStepName(String stepName) {
		this.stepName = stepName;
	}

	public String getNextStepName() {
		return nextStepName;
	}

	public void setNextStepName(String nextStepName) {
		this.nextStepName = nextStepName;
	}
	
}
