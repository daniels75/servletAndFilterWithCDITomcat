package org.daniels.examples.cdi.servlet;

import java.io.IOException;

import javax.inject.Inject;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;

import org.daniels.examples.cdi.bean.SimpleService;

@WebFilter(filterName = "SimpleFilter", urlPatterns = "/*")
public class SimpleFilter implements Filter{

	@Inject
	private SimpleService service;
	
	@Override
	public void destroy() {
	}

	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {
		System.out.println(">>> Start SimpleFilter");
		
		
        if (service != null) {
        	System.out.println(">>> Start SimpleFilter: " + service.createMessage("Message from SimpleFilter"));
        } else {
        	System.out.println(">>> Start SimpleFilter - !!! service has not been created !!!");
        }
		
		chain.doFilter(request, response);
	}

	@Override
	public void init(FilterConfig arg0) throws ServletException {
		
	}

}
