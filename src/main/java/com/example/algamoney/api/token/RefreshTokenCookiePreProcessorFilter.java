package com.example.algamoney.api.token;

import java.io.IOException;
import java.util.Map;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletRequestWrapper;

import org.apache.catalina.util.ParameterMap;
import org.springframework.core.Ordered;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

@Component
@Order(Ordered.HIGHEST_PRECEDENCE)
public class RefreshTokenCookiePreProcessorFilter implements Filter {
	
	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {
		
		HttpServletRequest req = (HttpServletRequest) request ;
		
		if("/oauth/token".equalsIgnoreCase(req.getRequestURI())
				&& "refresh_token".equals(req.getParameter("grant_type"))
				&& req.getCookies() != null) {
			for (Cookie cookie : req.getCookies()) {
				if(cookie.getName().equals("refreshToken")) {
					String refreshToken = cookie.getValue();
					req = new MyServletRequestWrapper(req, refreshToken);
				}
			}
		}
		
		chain.doFilter(req, response);
	}

	@Override
	public void init(FilterConfig filterConfig) throws ServletException {
		
		
	}


	@Override
	public void destroy() {
		
		
	}
	
	/**Como n é possivel alterar um requisição depois de pronta, foi necessário criar uma nova classe (MyServletRequestWrapper)
	 * para sobrescrever um outro objeto (HttpServletRequestWrapper) que contém a requisição, porém recebendo o refreshToken como parametro
	**/
	static class MyServletRequestWrapper extends HttpServletRequestWrapper {
		
		private String refreshToken;
		
		public MyServletRequestWrapper(HttpServletRequest request, String refreshToken) {
			super(request);
			this.refreshToken = refreshToken;
		}
		
		@Override
		//Os valores originais da requisição (request) permanecem e assim adiciona o (refreshToken) recuperado do Cookie
		public Map<String, String[]> getParameterMap() {
			ParameterMap<String, String[]> map = new ParameterMap<>(getRequest().getParameterMap());
			//o refresh_token é o nome que o Oauth2 vai usar pra recuperar o refresh token ( o mesmo refresh token do body da req no postman)
			map.put("refresh_token", new String[] {refreshToken});
			map.setLocked(true);
			return map;
		}
	}
	
	
}
