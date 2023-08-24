package co.yedam;

import java.io.Serializable;
import java.util.*;

public class Board implements Serializable{
	private int brdNo;
	private String brdTitle;
	private String brdContent;
	private String brdWriter;
	private Date brdDate;
	
	
	
	public Board( String brdTitle, String brdContent, String brdWriter, Date brdDate) {
//		this.brdNo = brdNo;
		//게시글 번호는 따로 설정해줌
		this.brdTitle = brdTitle;
		this.brdContent = brdContent;
		this.brdWriter = brdWriter;
		this.brdDate = brdDate;
	}
	public int getBrdNo() {
		return brdNo;
	}
	public void setBrdNo(int brdNo) {
		this.brdNo = brdNo;
	}
	public String getBrdTitle() {
		return brdTitle;
	}
	public void setBrdTitle(String brdTitle) {
		this.brdTitle = brdTitle;
	}
	public String getBrdContent() {
		return brdContent;
	}
	public void setBrdContent(String brdContent) {
		this.brdContent = brdContent;
	}
	public String getBrdWriter() {
		return brdWriter;
	}
	public void setBrdWriter(String brdWriter) {
		this.brdWriter = brdWriter;
	}
	public Date getBrdDate() {
		return brdDate;
	}
	public void setBrdDate(Date brdDate) {
		this.brdDate = brdDate;
	}
	
	
}
