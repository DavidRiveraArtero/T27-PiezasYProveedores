package mainApp.security;

import com.fasterxml.jackson.databind.ObjectMapper;

import org.springframework.boot.autoconfigure.security.SecurityProperties.User;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.authentication.AbstractAuthenticationProcessingFilter;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.InputStream;
import java.util.Collections;

public class LoginFilter extends AbstractAuthenticationProcessingFilter{
	
	  public LoginFilter(String url, AuthenticationManager authManager) {
	        super(new AntPathRequestMatcher(url));
	        setAuthenticationManager(authManager);
	    }

	    @Override
	    public Authentication attemptAuthentication(
	            HttpServletRequest req, HttpServletResponse res)
	            throws AuthenticationException, IOException, ServletException {

	        // OBTENEMOS EL BODY DE LA PETICION QUE ASUMIMOS VIENE EN FORMATO JSON
	        InputStream body = req.getInputStream();

	        //ASUMIMOS QUE EL VODI TENDRE EL SIGUIENTE JSON {"username":"david", "password":"1234"}
	        //REALIZAMOS UN MAPEO A NUESTRA CLASE USER PARA TENER AHI LOS DATOS
	        User user = new ObjectMapper().readValue(body, User.class);

	        // FINALMENTE AUTENTICAMOS
	        // SPRING COMPARARA EL USER/PASSWORD RECIBIDOS
	        //CONTRA EL QUE DEFINIMOS NE LA CLASE SECURITYCONFIG
	        
	        return getAuthenticationManager().authenticate(
	                new UsernamePasswordAuthenticationToken(
	                        user.getName(),
	                        user.getPassword(),
	                        Collections.emptyList()
	                )
	        );
	    }

	    @Override
	    protected void successfulAuthentication(
	            HttpServletRequest req,
	            HttpServletResponse res, FilterChain chain,
	            Authentication auth) throws IOException, ServletException {

	        // SI LA AUTENTIFICACION FUE EXITOSA, AGREGAMOS EL TOKEN EN LA RESPUESTA
	        JwtUtil.addAuthentication(res, auth.getName());
	    }
}
