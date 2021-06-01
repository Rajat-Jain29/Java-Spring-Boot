package com.example.demo.config;

import java.io.IOException;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.web.authentication.WebAuthenticationDetailsSource;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import com.example.demo.service.JwtUserDetailService;

@Component
public class JwtRequestFilter extends OncePerRequestFilter {

	@Autowired
	private JwtUserDetailService jwtUserDetailsService;

	@Autowired
	private JwtTokenUtil jwtTokenUtil;

	@Override
	protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain chain)
			throws ServletException, IOException {

	//	final String requestTokenHeade = request.getHeader("Authorization");
		// System.out.println(requestTokenHeader);
//		final String requestTokenHeader = request.getHeader("Cookie");

//		System.out.println( request.getCookies().toString());
//		for(Cookie cookie : cok) {
//			System.out.println(cookie);
//		}
//		String[] arrOfStr = rawCookie.split("=");
//        for (String a : arrOfStr)
//            System.out.println(a);

//		for(Cookie rawCookieNameAndValue :rawCookie)
//		{
//		  Cookie rawCookieNameAndValuePair = rawCookieNameAndValue;
//		  System.out.println(rawCookieNameAndValue);
//		}

		String rawCookie = request.getHeader("Cookie");
		String[] rawCookieParams = rawCookie.split(";");
		String[] rawCookieNameAndValuePair = new String[1000];
		for (String rawCookieNameAndValue : rawCookieParams) {
			rawCookieNameAndValuePair = rawCookieNameAndValue.split("=");
		}
		StringBuffer sb = new StringBuffer();
		for (int i = 0; i < rawCookieNameAndValuePair.length; i++) {
			sb.append(rawCookieNameAndValuePair[i]);
		}
		String requestTokenHeader = sb.toString();

		String username = null;
		String jwtToken = null;
		
		if (requestTokenHeader != null && requestTokenHeader.startsWith(" someSessionId")) {
			jwtToken = requestTokenHeader.substring(14);
			try {
				username = jwtTokenUtil.getUsernameFromToken(jwtToken);
			} catch (IllegalArgumentException e) {
				System.out.println("Unable to get JWT Token");
			} catch (Exception e) {
				System.out.println("JWT Token has expired");
			}
		}


		// Once we get the token validate it.
		if (username != null && SecurityContextHolder.getContext().getAuthentication() == null) {

			UserDetails userDetails = this.jwtUserDetailsService.loadUserByUsername(username);

			// if token is valid configure Spring Security to manually set
			// authentication
			if (jwtTokenUtil.validateToken(jwtToken, userDetails)) {

				UsernamePasswordAuthenticationToken usernamePasswordAuthenticationToken = new UsernamePasswordAuthenticationToken(
						userDetails, null, userDetails.getAuthorities());
				usernamePasswordAuthenticationToken
						.setDetails(new WebAuthenticationDetailsSource().buildDetails(request));
				// After setting the Authentication in the context, we specify
				// that the current user is authenticated. So it passes the
				// Spring Security Configurations successfully.
				SecurityContextHolder.getContext().setAuthentication(usernamePasswordAuthenticationToken);
			}
		}

//		Cookie sessionCookie = new Cookie("someSessionId", jwtToken);
//		sessionCookie.setMaxAge(150);
//		sessionCookie.setHttpOnly(true);
//		response.addCookie(sessionCookie);

		chain.doFilter(request, response);

	}

}
