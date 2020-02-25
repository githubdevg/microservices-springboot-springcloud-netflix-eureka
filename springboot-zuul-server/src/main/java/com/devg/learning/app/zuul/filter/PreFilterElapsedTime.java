package com.devg.learning.app.zuul.filter;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import com.netflix.zuul.ZuulFilter;
import com.netflix.zuul.context.RequestContext;
import com.netflix.zuul.exception.ZuulException;

@Component
public class PreFilterElapsedTime extends ZuulFilter {
	
	private static final Logger LOG = LoggerFactory.getLogger(PreFilterElapsedTime.class);

	@Override
	public boolean shouldFilter() {
		return true;
	}

	@Override
	public Object run() throws ZuulException {
		Long startTime = System.currentTimeMillis();		
		RequestContext ctx = RequestContext.getCurrentContext();
		HttpServletRequest request = ctx.getRequest();
		LOG.info(String.format("%s request routing to %s", request.getMethod(), request.getRequestURI()));
		request.setAttribute("startTime", startTime);		
		return null;
	}

	@Override
	public String filterType() {
		return "pre";
	}

	@Override
	public int filterOrder() {
		return 1;
	}

}
