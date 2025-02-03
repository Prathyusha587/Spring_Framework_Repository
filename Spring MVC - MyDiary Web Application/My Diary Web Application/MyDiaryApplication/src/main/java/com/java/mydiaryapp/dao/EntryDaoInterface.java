package com.java.mydiaryapp.dao;

import java.util.List;

import com.java.mydiaryapp.entities.Entry;


public interface EntryDaoInterface {
	   public void save(Entry entry);
	   public void update(Entry entry);
	   public void delete(Entry entry);
	   public Entry findById(int id);
	   public List<Entry> findAllEntries();
	   public List<Entry> findByUserid(int id);

}
