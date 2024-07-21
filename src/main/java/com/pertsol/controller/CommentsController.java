package com.pertsol.controller;

import java.time.LocalDate;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.pertsol.exception.CustomException;
import com.pertsol.model.Comments;
import com.pertsol.service.CommentsServiceImpl;

@RestController
@RequestMapping("/api/v2/comments")
public class CommentsController {

	@Autowired
	private CommentsServiceImpl commentsServiceImpl;
	
	@GetMapping
	public ResponseEntity<List<Comments>> getAllComments() throws CustomException
	{
		return ResponseEntity.ok(commentsServiceImpl.getAllComments());
	}

	@GetMapping("/search")
	public ResponseEntity<List<Comments>> searchComments(@RequestParam(required = false) String userName,
			@RequestParam(required = false) LocalDate date) throws CustomException {
		
		if (userName != null && !"".equals(userName)) 
		{
			return ResponseEntity.ok(commentsServiceImpl.getCommentsByUserName(userName));
		} 
		else if (date != null) 
		{
			return ResponseEntity.ok(commentsServiceImpl.getCommentsByDate(date));
		}

		return ResponseEntity.status(HttpStatus.BAD_REQUEST).build(); 
	}
}
