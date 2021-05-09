package com.example.demo.dto;

import java.util.ArrayList;
import java.util.List;

public class LeaveOutput {

	private int page;
	private int totalPage;
	private long totalItem;
	private List<LeaveDto> listResult = new ArrayList<>();
	
	
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

	public List<LeaveDto> getListResult() {
		return listResult;
	}

	public void setListResult(List<LeaveDto> listResult) {
		this.listResult = listResult;
	}

	public long getTotalItem() {
		return totalItem;
	}

	public void setTotalItem(long totalItem) {
		this.totalItem = totalItem;
	}

	
}
