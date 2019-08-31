package com.singapure.app.security;

import java.io.IOException;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.lang3.StringUtils;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.authentication.AbstractAuthenticationProcessingFilter;
import org.springframework.util.ObjectUtils;

import com.singapure.app.dto.AuthenticationToken;


public class TokenAuthenticationFilter extends AbstractAuthenticationProcessingFilter {
	// UsernamePasswordAuthenticationFilter
	// OncePerRequestFilter

	private static final String TOKEN_HEADER = "Authorization";
	private static final String TOKEN_PREFIX = "singapp ";

	public TokenAuthenticationFilter() {
		super("/secured/**");
	}

	@Override
	public Authentication attemptAuthentication(HttpServletRequest request, HttpServletResponse response)
			throws AuthenticationException, IOException, ServletException {
		AuthenticationToken token = validateHeader(request.getHeader(TOKEN_HEADER));
		if (ObjectUtils.isEmpty(token)) {
			throw new BadCredentialsException("401 - UNAUTHORIZED");
		}
		return getAuthenticationManager().authenticate(token);
	}

	@Override
	protected void successfulAuthentication(HttpServletRequest request, HttpServletResponse response, FilterChain chain,
			Authentication authResult) throws IOException, ServletException {
		super.successfulAuthentication(request, response, chain, authResult);
		chain.doFilter(request, response);
	}

	private AuthenticationToken validateHeader(String authenticationHeader) {
		if (StringUtils.isBlank(authenticationHeader) || !authenticationHeader.startsWith(TOKEN_PREFIX)) {
			return null;
		}
		return new AuthenticationToken(authenticationHeader.replace(TOKEN_PREFIX, ""));
	}

}
