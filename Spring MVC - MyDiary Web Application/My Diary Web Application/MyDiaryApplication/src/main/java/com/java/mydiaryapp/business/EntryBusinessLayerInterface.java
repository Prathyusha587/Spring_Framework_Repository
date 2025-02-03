package com.java.mydiaryapp.business;

import java.util.List;

import com.java.mydiaryapp.entities.Entry;

public interface EntryBusinessLayerInterface {

	   public void save(Entry entry);
	   public void update(Entry entry);
	   public void delete(Entry entry);
	   public Entry findById(int id);
	   public List<Entry> findAllEntries();
	   public List<Entry> findByUserid(int id);
}
