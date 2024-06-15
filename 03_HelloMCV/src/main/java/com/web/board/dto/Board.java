package com.web.board.dto;

import java.sql.Date;

public class Board {
	private int number;
	private String title;
	private String writer;
	private String con;
	private String ori;
	private String rename;
	private String recon;
	private Date date;
	

	
	public Board() {
		// TODO Auto-generated constructor stub
	}


	public Board(int number, String title, String writer, String con, String ori, String rename, String recon,
			Date date) {
		super();
		this.number = number;
		this.title = title;
		this.writer = writer;
		this.con = con;
		this.ori = ori;
		this.rename = rename;
		this.recon = recon;
		this.date = date;
	}







	public int getNumber() {
		return number;
	}







	public void setNumber(int number) {
		this.number = number;
	}







	public String getTitle() {
		return title;
	}







	public void setTitle(String title) {
		this.title = title;
	}







	public String getWriter() {
		return writer;
	}







	public void setWriter(String writer) {
		this.writer = writer;
	}







	public String getCon() {
		return con;
	}







	public void setCon(String con) {
		this.con = con;
	}







	public String getOri() {
		return ori;
	}







	public void setOri(String ori) {
		this.ori = ori;
	}







	public String getRename() {
		return rename;
	}







	public void setRename(String rename) {
		this.rename = rename;
	}







	public String getRecon() {
		return recon;
	}







	public void setRecon(String recon) {
		this.recon = recon;
	}







	public Date getDate() {
		return date;
	}







	public void setDate(Date date) {
		this.date = date;
	}



	



	
	
	
	
}
