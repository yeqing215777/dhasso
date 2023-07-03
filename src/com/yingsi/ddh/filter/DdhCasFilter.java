package com.yingsi.ddh.filter;

import java.io.IOException;
import java.util.Map;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;

import org.jasig.cas.client.authentication.AttributePrincipal;


public class DdhCasFilter implements Filter{

	@Override
	public void destroy() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {
		request.setCharacterEncoding("utf-8");
		AttributePrincipal p =  (AttributePrincipal) ((HttpServletRequest) request).getUserPrincipal();

		if (p != null) {
			Map<String, Object> attributes = p.getAttributes();
			System.out.println(attributes);
			String username = (String)attributes.get("username");
			String email = (String)attributes.get("email");
			String first_name = (String)attributes.get("first_name");
			request.setAttribute("username", username);
			request.setAttribute("email", email);
			request.setAttribute("first_name", first_name);
			request.setAttribute("user", "1");
		}else{
			request.setAttribute("user", "0");
			
		}
	    

		 chain.doFilter(request,response);
	}

	@Override
	public void init(FilterConfig arg0) throws ServletException {
		// TODO Auto-generated method stub
		
	}
	
}
