package com.jasonfc;

import com.google.gson.annotations.SerializedName;
import java.util.List;

public class BlogList {

	private String kind;

	@SerializedName("nextPageToken")
	private String nextPage;

	@SerializedName("prevPageToken")
	private String prevPage;

	private List<Items> items;

	protected String getKind() {
		return kind;
	}

	protected void setKind(String kind) {
		this.kind = kind;
	}

	protected String getNextPage() {
		return nextPage;
	}

	protected void setNextPage(String nextPage) {
		this.nextPage = nextPage;
	}

	protected String getPrevPage() {
		return prevPage;
	}

	protected void setPrevPage(String prevPage) {
		this.prevPage = prevPage;
	}

	protected List<Items> getItems() {
		return this.items;
	}

	protected void setItems(List<Items> items) {
		this.items = items;
	}
}
