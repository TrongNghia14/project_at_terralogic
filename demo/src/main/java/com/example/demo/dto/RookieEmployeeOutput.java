package com.example.demo.dto;

import java.util.ArrayList;
import java.util.List;

public class RookieEmployeeOutput {
	private int page;
	private int totalPage;
	private List<RookieEmployeeDto> listResult = new ArrayList<>();

	public int getPage() {
		return page;
	}

	public void setPage(int page) {
		this.page = page;
	}

	public int getTotalPage() {
		return totalPage;
	}

	public void setTotalPage(int totalPage) {
		this.totalPage = totalPage;
	}

	public List<RookieEmployeeDto> getListResult() {
		return listResult;
	}

	public void setListResult(List<RookieEmployeeDto> listResult) {
		this.listResult = listResult;
	}

}
