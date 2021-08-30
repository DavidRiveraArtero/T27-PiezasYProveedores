package mainApp.security;

import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;

import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Date;

import static java.util.Collections.emptyList;

public class JwtUtil {

	//METODO PARA CREAR EL JWT Y ENVIARLO AL CLIENTE EN EL HEADER DE LA RESPUESTA 
	static void addAuthentication(HttpServletResponse res, String username) {
		String token = Jwts.builder()
				.setSubject(username)
				//VAMOS A ASIGNAR UN TIEMPO DE EXPIRACION DE 1 MINUT
				.setExpiration(new Date(System.currentTimeMillis() + 60000))
				//HASH CON EL QUE FIRMAREMOS LA CLAVE
				.signWith(SignatureAlgorithm.HS512, "P@tit0")
				.compact();
		
		//AGREGAMOS EL ENCABEZADO AL TOKEN
		res.addHeader("Authorization","Bearer " + token);
		
	}
	
	//METODO PARA VALIDAR EL TOKEN ENVIADO POR EL CLIENTE
	static Authentication getAuthentication(HttpServletRequest request) {
		//OBTENEMOS EL TOKEN QUE VIENE EN EL ENCABEZADO DE LA PETICION
		String token = request.getHeader("Authorization");
		
		// SI HAY TOKEN PRESENTE, ENTONCES LO VALIDAMOS 
		if(token != null) {
			String user = Jwts.parser()
					.setSigningKey("P@tit0")
					.parseClaimsJws(token.replace("Bearer", ""))//ESTE METODO ES EL QUE VALIDA
					.getBody()
					.getSubject();
			
			//RECOREMOS QUE PARA LAS DEMAS PETICIONES QUE NO SEAN / LOGIN
			//NO REQUERIMOS UNA AUTENTICACION POR USERNAME/PASSWORD
			//POR ESTOS MOTIVOS PODEMOS DEVOLVER UN UsernamePasswordAuthenticationToken SIN PASSWORD
			
			return user != null ?
					new UsernamePasswordAuthenticationToken(user, null, emptyList()) :
						null;
		}
		return null;
		
	}
}
