package clearkode.util;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

public class WebContextListener implements ServletContextListener {
    @Override
    public void contextInitialized(ServletContextEvent sce) {
        // Eğer bu property false set edilmez ise Long, Integer vb. değişkenlere null değerler 0 olarak bind edilmektedir.
        System.setProperty("org.apache.el.parser.COERCE_TO_ZERO", "false");
    }

    @Override
    public void contextDestroyed(ServletContextEvent sce) {
    }
}
