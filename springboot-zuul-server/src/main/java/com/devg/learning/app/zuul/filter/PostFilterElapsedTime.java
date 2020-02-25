package com.devg.learning.app.zuul.filter;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import com.netflix.zuul.ZuulFilter;
import com.netflix.zuul.context.RequestContext;
import com.netflix.zuul.exception.ZuulException;

@Component
public class PostFilterElapsedTime extends ZuulFilter{
	
	private static final Logger LOG = LoggerFactory.getLogger(PostFilterElapsedTime.class);

	@Override
	public boolean shouldFilter() {
		return true;
	}

	@Override
	public Object run() throws ZuulException {
		LOG.info("PostFilterElapsedTime");
		RequestContext ctx = RequestContext.getCurrentContext();
		HttpServletRequest request = ctx.getRequest();
		
		Long startTime = (Long)request.getAttribute("startTime");		
		Long totalTitme = System.currentTimeMillis() - startTime;
		
		LOG.info(String.format("Total elapsed time in seconds for request %s: %.2f", request.getRequestURI(), (totalTitme/1000.00)));
		LOG.info(String.format("Total elapsed time in miliseconds for request %s: %d", request.getRequestURI(), totalTitme));
		
		return null;
	}

	@Override
	public String filterType() {
		return "post";
	}

	@Override
	public int filterOrder() {
		return 2;
	}

}
