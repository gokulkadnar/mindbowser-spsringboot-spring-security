package com.mindbrowser.model;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class ResultMessage {
	
	private int resultType;
	private String resultMsg;
		
	
	public int getResultType() {
		return resultType;
	}

	public void setResultType(int resultType) {
		this.resultType = resultType;
	}

	public String getResultMsg() {
		return resultMsg;
	}

	public void setResultMsg(String resultMsg) {
		this.resultMsg = resultMsg;
	}


	public ResultMessage success(String msg, ResultMessage resultMessageTo) {
		resultMessageTo.resultType = 1;
		resultMessageTo.resultMsg = msg;
		return resultMessageTo;
		
	}
	
	public ResultMessage error(String msg,ResultMessage resultMessageTo) {
		resultMessageTo.resultType = 0;
		resultMessageTo.resultMsg = msg;
		return resultMessageTo;
	}
	


}
