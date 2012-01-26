package com.jasonfc.blogger;

import java.util.List;


public class Items {
	private Author author;
	private Blog blog;
	private String content;
	private String id;
	private String kind;
	private List<String> labels;
	private String published;
	private Replies replies;
	private String selfLink;
	private String title;
	private String updated;
	private String url;

	public Author getAuthor() {
		return this.author;
	}

	public void setAuthor(Author author) {
		this.author = author;
	}

	public Blog getBlog() {
		return this.blog;
	}

	public void setBlog(Blog blog) {
		this.blog = blog;
	}

	public String getContent() {
		return this.content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public String getId() {
		return this.id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getKind() {
		return this.kind;
	}

	public void setKind(String kind) {
		this.kind = kind;
	}

	public List<String> getLabels() {
		return this.labels;
	}

	public void setLabels(List<String> labels) {
		this.labels = labels;
	}

	public String getPublished() {
		return this.published;
	}

	public void setPublished(String published) {
		this.published = published;
	}

	public Replies getReplies() {
		return this.replies;
	}

	public void setReplies(Replies replies) {
		this.replies = replies;
	}

	public String getSelfLink() {
		return this.selfLink;
	}

	public void setSelfLink(String selfLink) {
		this.selfLink = selfLink;
	}

	public String getTitle() {
		return this.title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getUpdated() {
		return this.updated;
	}

	public void setUpdated(String updated) {
		this.updated = updated;
	}

	public String getUrl() {
		return this.url;
	}

	public void setUrl(String url) {
		this.url = url;
	}
}
