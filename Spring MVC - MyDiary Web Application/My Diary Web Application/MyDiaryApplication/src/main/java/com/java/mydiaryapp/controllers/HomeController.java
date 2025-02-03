package com.java.mydiaryapp.controllers;

import java.sql.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.java.mydiaryapp.business.EntryBusinessLayerInterface;
import com.java.mydiaryapp.business.UserBusinessLayerInterface;
import com.java.mydiaryapp.entities.Entry;
import com.java.mydiaryapp.entities.User;

@Controller
public class HomeController {
	@Autowired
	private UserBusinessLayerInterface userBusinessLayerInterface;
	
	@Autowired
	private EntryBusinessLayerInterface entryBusinessLayerInterface;
	
	@Autowired
	HttpSession session;
	
	public EntryBusinessLayerInterface getEntryBusinessLayerInterface() {
		return entryBusinessLayerInterface;
	}

	public void setEntryBusinessLayerInterface(EntryBusinessLayerInterface entryBusinessLayerInterface) {
		this.entryBusinessLayerInterface = entryBusinessLayerInterface;
	}

	public UserBusinessLayerInterface getUserBusinessLayerInterface() {
		return userBusinessLayerInterface;
	}

	public void setUserBusinessLayerInterface(UserBusinessLayerInterface userBusinessLayerInterface) {
		this.userBusinessLayerInterface = userBusinessLayerInterface;
	}

	@RequestMapping("home")
	public ModelAndView homepage() {
		ModelAndView model = new ModelAndView("loginpage");
		return model;
	}

	@RequestMapping("register")
	public ModelAndView registrationpage() {
		ModelAndView model = new ModelAndView("registrationpage");
		return model;
	}

	@RequestMapping(value = "saveuser", method = RequestMethod.POST)
	public ModelAndView saveuser(@ModelAttribute("user") User user) {
		ModelAndView model = new ModelAndView("registersuccess");

		userBusinessLayerInterface.save(user);
		return model;
	}

	

	// method to check a user details against existing users in database
	@RequestMapping(value = "/authenticate", method = RequestMethod.POST)
	public ModelAndView authenticateuser(@ModelAttribute("user") User user) {

		ModelAndView model = new ModelAndView("loginpage");

		User user1 = userBusinessLayerInterface.findByUsername(user.getUsername());

		if (user1 != null && user.getPassword().equals(user1.getPassword())) {
			model.setViewName("userhomepage");
			model.addObject("user", user1);
			
			
			session.setAttribute("user", user1);
			
			List<Entry> entries = null;
			try {
			entries = entryBusinessLayerInterface.findByUserid(user1.getId());
			} catch(Exception e) {
				e.printStackTrace();
			}
			
			model.addObject("entrieslist", entries);

		}

		return model;
	}
	
	@RequestMapping("addentry")
	public ModelAndView addentry() {
		
		ModelAndView model = new ModelAndView("addentryform");
		
		return model;

	}

	@RequestMapping(value = "/saveentry", method = RequestMethod.POST)
	public ModelAndView saveentry(HttpServletRequest request) {
	    ModelAndView model = new ModelAndView("userhomepage");
	    
	    // Extract form parameters
	    String dateStr = request.getParameter("entrydate");
	    String description = request.getParameter("description");
	    User user1 = (User) session.getAttribute("user");

	    if (dateStr == null || description == null || user1 == null) {
	        System.out.println("Error: One or more required parameters are missing.");
	        model.addObject("errorMessage", "Invalid request data.");
	        return model;
	    }

	    // Create new entry object and manually set values
	    Entry entry = new Entry();
	    entry.setEntrydate(java.sql.Date.valueOf(dateStr));  // Ensure proper conversion
	    entry.setDescription(description.trim());
	    entry.setUserid(user1.getId());

	    // Save to database
	    entryBusinessLayerInterface.save(entry);

	    // Fetch updated entries list
	    List<Entry> entries = entryBusinessLayerInterface.findByUserid(user1.getId());
	    model.addObject("entrieslist", entries);

	    return model;
	}
	
	@RequestMapping("viewentry")
	public ModelAndView viewentry(@RequestParam("id") int id)
	{
		ModelAndView model=new ModelAndView("displayentry");
		
		Entry entry = entryBusinessLayerInterface.findById(id);
		
		model.addObject("entry", entry);
		
		return model;
	}
	
	@RequestMapping("userhome")
	public ModelAndView userhomepage()
	{
		
		ModelAndView model = new ModelAndView("userhomepage");
		User user1=(User)session.getAttribute("user");
		
		List<Entry> entries=null;
		
		try {
			entries=entryBusinessLayerInterface.findByUserid(user1.getId());
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		model.addObject("entrieslist", entries);
		
		return model;
	}
	
	@RequestMapping("updateentry")
	public ModelAndView updateentry(@RequestParam("id") int id)
	{
		ModelAndView model=new ModelAndView("displayupdateentry");
		
		Entry entry = entryBusinessLayerInterface.findById(id);
		
		model.addObject("entry", entry);
		
		User user1=(User)session.getAttribute("user");
		
		if(user1==null)
			model.setViewName("loginpage");
		
		return model;
	}
	
	@RequestMapping(value = "processentryupdate", method = RequestMethod.POST)
	public ModelAndView processentryupdate(
	    @RequestParam("id") int id,
	    @RequestParam("description") String description,
	    @RequestParam("entrydate") String entryDateStr) {
	    
	    ModelAndView model = new ModelAndView("userhomepage");
	    
	    User user1 = (User) session.getAttribute("user");
	    if (user1 == null) {
	        model.setViewName("loginpage");
	        return model;
	    }

	    Entry entry = new Entry();
	    entry.setId(id);
	    entry.setDescription(description.trim());
	    entry.setEntrydate(Date.valueOf(entryDateStr));
	    entry.setUserid(user1.getId());

	    try {
	        entryBusinessLayerInterface.update(entry);
	    } catch (Exception e) {
	        e.printStackTrace();
	        model.addObject("errorMessage", "Update failed.");
	        return model;
	    }

	    List<Entry> entries = entryBusinessLayerInterface.findByUserid(user1.getId());
	    model.addObject("entrieslist", entries);

	    return model;
	}
	
	@RequestMapping("deleteentry")
	public ModelAndView deleteentry(@RequestParam("id") int id)
	{
		ModelAndView model=new ModelAndView("userhomepage");
		
         User user1=(User)session.getAttribute("user");
		
		
		Entry entry = entryBusinessLayerInterface.findById(id);
		
		if(user1==null)
			model.setViewName("loginpage");
		else
			entryBusinessLayerInterface.delete(entry);
		
		
        List<Entry> entries=null;
		
		try {
			entries=entryBusinessLayerInterface.findByUserid(user1.getId());
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		model.addObject("entrieslist", entries);
		
		
		
		
		return model;
	}
	@RequestMapping("signout")
	public ModelAndView signout()
	{
		
		ModelAndView model = new ModelAndView("loginpage");
		
		session.invalidate();
		
		
		return model;
	}
	
}
