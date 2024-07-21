package com.pertsol.dao;

import java.time.LocalDate;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.pertsol.model.Comments;

@Repository
public interface CommentsRepository extends JpaRepository<Comments,Integer> 
{
	public List<Comments> findAll();
	public List<Comments> findByName(String userName);
	public List<Comments> findByDate(LocalDate date);
}