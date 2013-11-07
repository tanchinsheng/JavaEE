package com.st.loggingwebexample;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@WebServlet("/LoggingDemo")
public class LoggingDemo extends HttpServlet {

    private static final Logger logger = LoggerFactory.getLogger(LoggingDemo.class);

    @Override
    protected void doGet(final HttpServletRequest request,
            final HttpServletResponse response) throws ServletException, IOException {
        processRequest(request, response);
    }

    @Override
    protected void doPost(final HttpServletRequest request,
            final HttpServletResponse response) throws ServletException, IOException {
        processRequest(request, response);
    }

    protected void processRequest(final HttpServletRequest request, final HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
        try {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet TestServlet</title>");
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet LoggingDemo at " + request.getContextPath() + "</h1>");
            out.println("</body>");
            out.println("</html>");
            logger.info("This is  demo for the Logging concept");
            logger.debug("Just some sample messages");
        } finally {
            out.close();
        }
    }
}
