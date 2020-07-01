import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;
import javax.servlet.http.HttpSessionAttributeListener;
import javax.servlet.http.HttpSessionEvent;
import javax.servlet.http.HttpSessionListener;
import javax.servlet.http.HttpSessionBindingEvent;
import java.util.ArrayList;
import java.util.List;

@WebListener()
public class InicializaListaUsuarios implements ServletContextListener {

    // Public constructor is required by servlet spec
    public InicializaListaUsuarios() {
    }

    public void contextInitialized(ServletContextEvent sce) {
        var u1 = new Usuario(1, "Tarcisio", "eu1@gmail.com", "12345");
        var u2 = new Usuario(2, "João", "eu2@gmail.com", "45667");
        var u3 = new Usuario(3, "Pedro", "eu3@gmail.com", "asd123");
        var u4 = new Usuario(4, "José", "eu4@gmail.com", "123asd");
        var u5 = new Usuario(5, "Buda", "eu5@gmail.com", "qsdawd");

        List<Usuario> usuariosList = new ArrayList<>();
        usuariosList.add(u1);
        usuariosList.add(u2);
        usuariosList.add(u3);
        usuariosList.add(u4);
        usuariosList.add(u5);

        List<String> tokenList = new ArrayList<>();

        ServletContext servletContext = sce.getServletContext();
        servletContext.setAttribute("usuarios", usuariosList);
        servletContext.setAttribute("tokens", tokenList);
    }

    public void contextDestroyed(ServletContextEvent sce) {
    }

}
