package com.navaneeth.spring.service.impl;

import org.apache.commons.lang.StringUtils;
import org.springframework.stereotype.Service;

import com.navaneeth.spring.service.StringTruncateService;


@Service
public class StringTruncateServiceImpl implements StringTruncateService{
	String truncatedMessage=" ... (truncated) ... ";
	
	@Override
	public String truncate(String str, int maxCharsAllowed) {		
		
		return StringUtils.abbreviateMiddle(str, truncatedMessage, maxCharsAllowed);
		
	}

}
