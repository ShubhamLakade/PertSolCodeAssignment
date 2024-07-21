package com.pertsol.service;

import java.time.LocalDate;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.pertsol.dao.CommentsRepository;
import com.pertsol.exception.CustomException;
import com.pertsol.model.Comments;

@Service
public class CommentsServiceImpl {

	@Autowired
	private CommentsRepository commentsRepository;
	
	//Get all comments
	public List<Comments> getAllComments() throws CustomException
	{
		List<Comments> commentList = commentsRepository.findAll();
		
		if(commentList!=null && commentList.size()>0)
		{
			return commentList;
		}
		else
		{
			throw new CustomException("Comments not found or does not exist");
		}
	}
	
	//Get comments by username
	public List<Comments> getCommentsByUserName(String userName) throws CustomException
	{
		List<Comments> commentsByUserNameList = commentsRepository.findByName(userName);
		
		if(commentsByUserNameList==null || commentsByUserNameList.isEmpty())
		{
			throw new CustomException("Comments does not found for username: "+userName);
		}
		
		return commentsByUserNameList;
	}
	
	//Get comments by date
	public List<Comments> getCommentsByDate(LocalDate date) throws CustomException
	{
		List<Comments> commentsByDateList = commentsRepository.findByDate(date);
		if(commentsByDateList==null || commentsByDateList.isEmpty())
		{
			throw new CustomException("Comments does not found for date: "+date);
		}
		return commentsByDateList;
	}
}
