package br.sp.cacarobos.interception;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import com.fasterxml.jackson.databind.ObjectMapper;

import br.sp.cacarobos.model.Valuer;
import br.sp.cacarobos.util.HttpError;

public class Interception extends HandlerInterceptorAdapter{
	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)throws Exception {
		String url=request.getRequestURI();
		if(url.endsWith("home")
				||url.endsWith("logout")
				||url.endsWith("sigin")
				||url.endsWith("createUser")
				||url.endsWith("registerManager")){
			return true;
		}
		if(request.getSession().getAttribute("managerLoggedIn")!=null){
			if(url.endsWith("")){
				return true;
			}else{
				response.sendRedirect("redirect:mainPageManager");
				return acessDenied("Acesso Negado", response);
			}
		}
		if(request.getSession().getAttribute("valuerLoggedIn")!=null){
			Valuer v=(Valuer)request.getSession().getAttribute("valuerLoggedIn");
			if(url.endsWith("")){
				return valuerRedirect(v);
			}else{
				if(url.endsWith("")){
					return true;
				}
				response.sendRedirect("redirect:manPageValuer");
				return acessDenied("Acesso Negado", response);
			}
		}
		if(request.getSession().getAttribute("userLoggedIn")!=null){
			if(url.endsWith("")){
				return true;
			}else{
				response.sendRedirect("redirect:mainPageUser");
				return acessDenied("Acesso Negado", response);
			}
		}
		return acessDenied("Acesso Negado", response);
	}
	
	private boolean valuerRedirect(Valuer v){
		return v.getActiveAccount()==true?true:false;
	}
	
	private boolean acessDenied(String description, HttpServletResponse response)throws IOException{
		response.setContentType(MediaType.APPLICATION_JSON_UTF8_VALUE);
		response.getWriter().println(new ObjectMapper().writeValueAsString(new HttpError(HttpStatus.FORBIDDEN, description)));
		response.setStatus(HttpStatus.FORBIDDEN.value());
		return false;
	}
}
