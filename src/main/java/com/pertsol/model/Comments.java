package com.pertsol.model;

import java.time.LocalDate;

import static com.pertsol.constants.CommentsConstants.*;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name=COMMENTS)
public class Comments 
{
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	
	@Column(name=ID)
	private int commentId;
	
	@Column(name=BY)
	private String name;
	
	@Column(name=TEXT)
	private String comment;
	
	@Column(name=DATEOFCOMMENT)
	private LocalDate date;

	public int getCommentId() {
		return commentId;
	}

	public void setCommentId(int commentId) {
		this.commentId = commentId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getComment() {
		return comment;
	}

	public void setComment(String comment) {
		this.comment = comment;
	}

	public LocalDate getDate() {
		return date;
	}

	public void setDate(LocalDate date) {
		this.date = date;
	}

}
