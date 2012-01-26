package com.jasonfc.blogger;

import com.google.gson.annotations.SerializedName;

import java.util.List;

public class BlogList {

	private String kind;

	@SerializedName("nextPageToken")
	private String nextPage;

	@SerializedName("prevPageToken")
	private String prevPage;

	private List<Items> items;

	public String getKind() {
		return kind;
	}

	public void setKind(String kind) {
		this.kind = kind;
	}

	public String getNextPage() {
		return nextPage;
	}

	public void setNextPage(String nextPage) {
		this.nextPage = nextPage;
	}

	public String getPrevPage() {
		return prevPage;
	}

	public void setPrevPage(String prevPage) {
		this.prevPage = prevPage;
	}

	public List<Items> getItems() {
		return this.items;
	}

	public void setItems(List<Items> items) {
		this.items = items;
	}
}
