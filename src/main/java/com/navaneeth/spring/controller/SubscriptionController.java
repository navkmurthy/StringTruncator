package com.navaneeth.spring.controller;

import java.io.BufferedReader;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.navaneeth.spring.service.StringTruncateService;

@Controller
public class SubscriptionController {

	@Autowired
	StringTruncateService stringTruncateService;
	
	static final int maxCharsAllowed =  256;
	
	@RequestMapping(value = "/subscribe", method = RequestMethod.GET)
	public String subscribe(HttpServletRequest request) {

		String orderDetails = getOrderDetails(request);
		String truncatedOrderDetails = truncate(orderDetails);
		log(truncatedOrderDetails);
		return truncatedOrderDetails;

	}

	private String truncate(String orderDetails) {
	
		return stringTruncateService.truncate(orderDetails, maxCharsAllowed);
	}

	private String getOrderDetails(HttpServletRequest request) {
			
		 StringBuffer sb = new StringBuffer();
		  String line = null;
		  try {
		    BufferedReader reader = request.getReader();
		    while ((line = reader.readLine()) != null){
				sb.append(line);
		    }
		  } catch (Exception e) { /*report an error*/
			 //TODO
		  }

		  return sb.toString();
	}

	private void log(String truncatedOrderDetails) {
		// TODO Auto-generated method stub

	}

}
