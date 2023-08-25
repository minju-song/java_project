package co.yedam.board.vo;

import java.io.Serializable;
import java.text.SimpleDateFormat;
import java.util.*;

//board객체 정의
public class Board implements Serializable {
	private int brdNo;
	private String brdTitle;
	private String brdContent;
	private String brdWriter;
	private Date writeDate;
	private Date updateDate;
	
	public Board() {
		
	}
	
	public Board(String brdTitle, String brdContent, String brdWriter) {
		super();
		this.brdTitle = brdTitle;
		this.brdContent = brdContent;
		this.brdWriter = brdWriter;
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

	public Date getWriteDate() {
		return writeDate;
	}

	public void setWriteDate(Date writeDate) {
		this.writeDate = writeDate;
	}

	public Date getUpdateDate() {
		return updateDate;
	}

	public void setUpdateDate(Date updateDate) {
		this.updateDate = updateDate;
	}

	@Override
	public String toString() {
		return  
//				brdNo+")" + 
				" [제목] " + brdTitle + "\t [작성자] "+ brdWriter;
//				+ "\t <작성 일자> " + writeDate + "\t <수정 일자> " + updateDate;
	}
	
	public String listInfo() {
		return  
//				brdNo+")" + 
				" [제목] " + brdTitle + "\t [작성자] "+ brdWriter;
	}
	
	public String showInfo() {
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy/MM/dd HH:mm");
		String wd = sdf.format(writeDate);
		if(updateDate == null) {			
			return 
//					"["+ brdNo+"]\n"
					 "[제목] " + brdTitle + "\t\t [작성자] "+ brdWriter+
					"\n[내용] "+brdContent+"\t\t <작성 일자> " + wd;
		}
		else {
			String ud = sdf.format(updateDate);
			return  
//					"["+ brdNo+"]\n"
					"[제목] " + brdTitle + "\t\t  [작성자] "+ brdWriter+
					"\n[내용] "+brdContent+"\t<작성 일자> " + wd + "\t <수정 일자> " + ud;
		}
	}
	
	
}