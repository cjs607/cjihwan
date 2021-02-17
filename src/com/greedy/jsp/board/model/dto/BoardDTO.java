package com.greedy.jsp.board.model.dto;

import java.sql.Date;

import com.greedy.jsp.member.model.dto.MemberDTO;

public class BoardDTO implements java.io.Serializable {
	
	private int no;
	private int type;
	private int categoryCode;
	private CategoryDTO category;
	private String title;
	private String body;
	private int writerMemberNo;
	private MemberDTO writer;
	private int count;
	private java.sql.Date createdDate;
	private java.sql.Date modifedDate;
	private String status;
	
	public BoardDTO() {}

	public BoardDTO(int no, int type, int categoryCode, CategoryDTO category, String title, String body,
			int writerMemberNo, MemberDTO writer, int count, Date createdDate, Date modifedDate, String status) {
		super();
		this.no = no;
		this.type = type;
		this.categoryCode = categoryCode;
		this.category = category;
		this.title = title;
		this.body = body;
		this.writerMemberNo = writerMemberNo;
		this.writer = writer;
		this.count = count;
		this.createdDate = createdDate;
		this.modifedDate = modifedDate;
		this.status = status;
	}

	public int getNo() {
		return no;
	}

	public void setNo(int no) {
		this.no = no;
	}

	public int getType() {
		return type;
	}

	public void setType(int type) {
		this.type = type;
	}

	public int getCategoryCode() {
		return categoryCode;
	}

	public void setCategoryCode(int categoryCode) {
		this.categoryCode = categoryCode;
	}

	public CategoryDTO getCategory() {
		return category;
	}

	public void setCategory(CategoryDTO category) {
		this.category = category;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getBody() {
		return body;
	}

	public void setBody(String body) {
		this.body = body;
	}

	public int getWriterMemberNo() {
		return writerMemberNo;
	}

	public void setWriterMemberNo(int writerMemberNo) {
		this.writerMemberNo = writerMemberNo;
	}

	public MemberDTO getWriter() {
		return writer;
	}

	public void setWriter(MemberDTO writer) {
		this.writer = writer;
	}

	public int getCount() {
		return count;
	}

	public void setCount(int count) {
		this.count = count;
	}

	public java.sql.Date getCreatedDate() {
		return createdDate;
	}

	public void setCreatedDate(java.sql.Date createdDate) {
		this.createdDate = createdDate;
	}

	public java.sql.Date getModifedDate() {
		return modifedDate;
	}

	public void setModifedDate(java.sql.Date modifedDate) {
		this.modifedDate = modifedDate;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	@Override
	public String toString() {
		return "BoardDTO [no=" + no + ", type=" + type + ", categoryCode=" + categoryCode + ", category=" + category
				+ ", title=" + title + ", body=" + body + ", writerMemberNo=" + writerMemberNo + ", writer=" + writer
				+ ", count=" + count + ", createdDate=" + createdDate + ", modifedDate=" + modifedDate + ", status="
				+ status + "]";
	}
	
	
}
