package com.example.restservice;

public class Quotes {

	private final long id;
	private final String show;
	private final String quote;

	public Quotes(long id, String show, String quote) {
		this.id = id;
		this.show = show;
		this.quote=quote;
	}

	public long getId() {
		return id;
	}

	public String getShow() {
		return show;
	}

	public String getQuote() {
		return quote;
	}

}
