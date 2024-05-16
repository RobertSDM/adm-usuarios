package mai.administracaousuarios.interceptor;


import jakarta.servlet.*;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import mai.administracaousuarios.model.Usuario;
import mai.administracaousuarios.repositories.UsuarioRepository;
import mai.administracaousuarios.security.TokenService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import java.io.IOException;

@Component
public class AuthFilter extends OncePerRequestFilter {

    TokenService tokenService = new TokenService();

    @Autowired
    UsuarioRepository usuarioRep;

    @Override
    public void doFilterInternal(HttpServletRequest request,
                                 HttpServletResponse response,
                         FilterChain filterChain) throws IOException, ServletException {

        String token = extractToken(request);

        if(token != null) {

            String login = tokenService.verifyToken(token);
            Usuario usuario = usuarioRep.findByLogin(login);

            if(usuario != null) {
                UsernamePasswordAuthenticationToken auth = new UsernamePasswordAuthenticationToken(usuario, null, usuario.getAuthorities());
                SecurityContextHolder.getContext().setAuthentication(auth);
            }


        }

        System.out.println("INDO PRA ROTA");
        filterChain.doFilter(request, response);
    }

    private String extractToken(HttpServletRequest request){
        String auth = request.getHeader("Authorization");
        return auth != null ? auth.replace("Bearer ", "") : null;
    }

}
