import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@WebFilter("/user/*")
public class FiltroLogin implements Filter {

    FilterConfig fc;

    public void destroy() {
    }

    public void doFilter(ServletRequest req, ServletResponse resp, FilterChain chain) throws ServletException, IOException {
        Cookie[] cookies = ((HttpServletRequest)req).getCookies();
        ServletContext servletContext = fc.getServletContext();
        List<String> tokens = (ArrayList<String>) servletContext.getAttribute("tokens");

        for(var c:cookies){
            if(c.getName().equals("authentication")){
                for(var t:tokens){
                    if(t.equals(c.getName())){
                        chain.doFilter(req, resp);
                    }
                }
            }
        }
        ((HttpServletResponse)resp).sendRedirect("http://localhost:8080/AulaExercicio_war_exploded/login.html");

    }

    public void init(FilterConfig config) throws ServletException {
        this.fc = config;
    }

}
