package com.pleshchenko.sbb.web;

public class SearchCriteria {

	String text;

	@Override
	public String toString() {
		return text;
	}

	public String getText() {
		return text;
	}

	public void setText(String text) {
		this.text = text;
	}
}
