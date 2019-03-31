package com.rakuten.controllerImpl;

import java.awt.List;

import com.rakuten.controller.Dashboard;
import com.rakuten.service.UploadCSV;
import com.rakuten.serviceImpl.UploadCSVImpl;

public class DashboardImpl implements Dashboard {
	
	// It must be clarified that i was not able to create the servlet for HttpSession and Class for ModelAndView... due to the time constraint
		
	@Override
	@RequestMapping(value="/dashboardcompany", method = RequestMethod.GET)
	public ModelAndView showDashboard(HttpSession session){
		try{
			
			ModelAndView mav = new ModelAndView("dashboard");
			
			return mav;
		}catch (Exception e){
			
		}
	}
	
	@Override
	@RequestMapping(value="/linkUpload", method = RequestMethod.POST)
	public ModelAndView showDashboard(HttpSession session){
		try{
			
			UploadCSV uploadCSV =new UploadCSVImpl();
			List list=uploadCSV.Coordinator(session.getAttribute("link").toString());
							
			ModelAndView mav = new ModelAndView("dashboard");
			mav.addObject("List",list);
			return mav;
		}catch (Exception e){
			
		}
	}
	
	@Override
	@RequestMapping(value="/storeSearch", method = RequestMethod.POST)
	public ModelAndView showDashboard(HttpSession session){
		try{
			
			UploadCSV uploadCSV =new UploadCSVImpl();
			List list=uploadCSV.loadSearchResults(session.getAttribute("date").toString());
							
			ModelAndView mav = new ModelAndView("dashboard");
			mav.addObject("List",list);
			return mav;
		}catch (Exception e){
			
		}
	}

}
