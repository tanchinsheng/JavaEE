package com.st.loggingwebexample;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebInitParam;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.apache.log4j.PropertyConfigurator;

@WebServlet(name = "LoggingInit",
urlPatterns = { "/*" }, loadOnStartup = 1,
initParams = {
@WebInitParam(name = "log4j-conf-file", value = "WEB-INF/classes/log4j.xml") })
public class LoggingInit extends HttpServlet {

    @Override
    public final void init() throws ServletException {
        super.init();
        final String prefix = getServletContext().getRealPath("/");
        final String file = getInitParameter("log4j-conf-file");
        if (file != null) {
            PropertyConfigurator.configureAndWatch(prefix + file);
            System.out.println("Log4J Logging started: " + prefix + file);
        } else {
            System.out.println("Log4J Is not configured for your Application:" + prefix + file);
        }

    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {    
    }
}
