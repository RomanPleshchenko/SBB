package com.pleshchenko.sbb.web;
//
//import com.fasterxml.jackson.annotation.JsonView;
//import com.mkyong.web.jsonview.Views;

import com.fasterxml.jackson.annotation.JsonView;

import java.util.List;

public class AjaxResponseBody {

	@JsonView(Views.Public.class)
	String msg;
	@JsonView(Views.Public.class)
	String code;


	public String getMsg() {
		return msg;
	}

	public void setMsg(String msg) {
		this.msg = msg;
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	@Override
	public String toString() {
		return "AjaxResponseResult [msg=" + msg + ", code=" + code + "]";
	}

}
