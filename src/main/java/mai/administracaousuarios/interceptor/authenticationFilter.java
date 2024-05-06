package mai.administracaousuarios.interceptor;


import jakarta.servlet.*;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.stereotype.Component;

import java.io.IOException;

@Component
public class authenticationFilter implements Filter {



    @Override
    public void doFilter(ServletRequest servletRequest,
                         ServletResponse servletResponse,
                         FilterChain filterChain) throws IOException, ServletException {

        HttpServletRequest request = (HttpServletRequest) servletRequest;
        String login;
        String password;

        try{
            login = request.getHeaders("Api_Login").nextElement();
            password = request.getHeaders("Api_Password").nextElement();



        }catch (NullPointerException e){
            System.out.println(e.getMessage());
            ((HttpServletResponse) servletResponse).setStatus(422);
            servletResponse.getOutputStream().write("Missing the api login or password".getBytes());
            return;
        }

        if(login.equals(System.getenv("API_FUNC_LOGIN")) && password.equals(System.getenv("API_FUNC_PASSWORD"))){
            filterChain.doFilter(request, servletResponse);
        }else{
            ((HttpServletResponse) servletResponse).setStatus(401);
            servletResponse.getOutputStream().write("No authorized".getBytes());
        }
    }

}
