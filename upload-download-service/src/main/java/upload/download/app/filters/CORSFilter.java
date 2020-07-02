package upload.download.app.filters;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletResponse;

import org.springframework.context.annotation.Configuration;

@Configuration
//@EnableWebFlux
public class CORSFilter implements Filter {

	/*
	 * @Override public void addCorsMappings(CorsRegistry registry) { registry
	 * 
	 * .addMapping("/**") .allowedOrigins("*") .allowedMethods("GET",
	 * "POST","DELETE", "PUT") .allowedHeaders("Authorization")
	 * .allowCredentials(true);
	 * 
	 * }
	 */

	@Override
	public void doFilter(ServletRequest req, ServletResponse res, FilterChain chain)
			throws IOException, ServletException {
		HttpServletResponse

		response = (HttpServletResponse) res;

		response.setHeader("Access-Control-Allow-Origin", "*");
		response.setHeader("Access-Control-Allow-Credentials", "true");
		response.setHeader("Access-Control-Allow-Methods", "POST, GET, PUT, OPTIONS, DELETE");
		response.setHeader("Access-Control-Max-Age", "3600");
		response.setHeader("Access-Control-Allow-Headers",
				"X-Requested-With, Content-Type, Authorization, Origin, Accept, Access-Control-Request-Method, Access-Control-Request-Headers");
		response.setHeader("Access-Control-Expose-Headers", "*");

		
		chain.doFilter(req, res);
	}

}
