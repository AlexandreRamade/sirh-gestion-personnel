package dev.sgp.filtre;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;

import dev.sgp.entite.VisiteWeb;
import dev.sgp.service.VisiteWebService;
import dev.sgp.util.Constantes;

/**
 * Servlet Filter implementation class FrequentationFilter
 */
public class FrequentationFilter implements Filter {

    /**
     * Default constructor. 
     */
    public FrequentationFilter() {
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see Filter#destroy()
	 */
	public void destroy() {
		// TODO Auto-generated method stub
	}

	/**
	 * @see Filter#doFilter(ServletRequest, ServletResponse, FilterChain)
	 */
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
		long before = System.currentTimeMillis();
		VisiteWebService visites = Constantes.VISITE_SERVICE;
		HttpServletRequest req = (HttpServletRequest) request;
		
		// pass the request along the filter chain
		chain.doFilter(request, response);
		
		long after = System.currentTimeMillis();
		visites.sauvegarderVisite(new VisiteWeb(req.getRequestURI(), (int)(after - before)));

	}

	/**
	 * @see Filter#init(FilterConfig)
	 */
	public void init(FilterConfig fConfig) throws ServletException {
		// TODO Auto-generated method stub
	}

}
