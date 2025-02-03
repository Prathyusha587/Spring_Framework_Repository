package com.java.mydiaryapp.business;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.java.mydiaryapp.dao.EntryDaoInterface;
import com.java.mydiaryapp.entities.Entry;

@Component
public class EntryBusinessLayerImpl implements EntryBusinessLayerInterface {
    
	@Autowired
	private EntryDaoInterface entryDaoInterface;
	
	public EntryDaoInterface getEntryDaoInterface() {
		return entryDaoInterface;
	}

	public void setEntryDaoInterface(EntryDaoInterface entryDaoInterface) {
		this.entryDaoInterface = entryDaoInterface;
	}

	public void save(Entry entry) {
	 entryDaoInterface.save(entry);

	}

	
	public void update(Entry entry) {
		entryDaoInterface.update(entry);
	}

	public void delete(Entry entry) {
		entryDaoInterface.delete(entry);
	}

	
	public Entry findById(int id) {
		
		return entryDaoInterface.findById(id);
	}

	public List<Entry> findAllEntries() {
		return entryDaoInterface.findAllEntries();
	}

	
	public List<Entry> findByUserid(int id) {
		// TODO Auto-generated method stub
		return entryDaoInterface.findByUserid(id);
	}

}
