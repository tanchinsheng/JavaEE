package com.st.loggingwebexample;

import java.io.IOException;
import java.net.InetAddress;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import org.slf4j.MDC;

@WebFilter(filterName = "LogFilter", urlPatterns = {"/*"})
public class LoggingFilter implements Filter {

    @Override
    public void init(final FilterConfig filterConfig) throws ServletException {
    }

    @Override
    public void destroy() {
    }

    @Override
    public void doFilter(final ServletRequest request, final ServletResponse response,
            final FilterChain chain) throws IOException, ServletException {
        try {
            final HttpServletRequest httpRequest = (HttpServletRequest) request;
            final String ipAddress = getClientIpAddr(httpRequest);

            MDC.put("appName", httpRequest.getContextPath().substring(1));
            MDC.put("hostName", InetAddress.getByName(ipAddress).getCanonicalHostName());
            MDC.put("userName", "cstan"); // Replace your own logic
            MDC.put("ipAddress", ipAddress);
            MDC.put("sessionID", httpRequest.getSession().getId());
            MDC.put("url", httpRequest.getRequestURL().toString());
            chain.doFilter(request, response);
        } finally {
            MDC.remove("appName");
            MDC.remove("hostName");
            MDC.remove("userName");
            MDC.remove("ipAddress");
            MDC.remove("sessionID");
            MDC.remove("url");
        }
    }

    private String getClientIpAddr(final HttpServletRequest request) {

        String ipAddr = request.getHeader("X-Forwarded-For");
        if (checkIpAddr(ipAddr)) {
            ipAddr = request.getHeader("Proxy-Client-IP");
        }
        if (checkIpAddr(ipAddr)) {
            ipAddr = request.getHeader("WL-Proxy-Client-IP");
        }
        if (checkIpAddr(ipAddr)) {
            ipAddr = request.getHeader("HTTP_CLIENT_IP");
        }
        if (checkIpAddr(ipAddr)) {
            ipAddr = request.getHeader("HTTP_X_FORWARDED_FOR");
        }
        if (checkIpAddr(ipAddr)) {
            ipAddr = request.getRemoteAddr();
        }
        return ipAddr;
    }

    private boolean checkIpAddr(final String ipAddress) {

        boolean isNotIpAddr = false;

        if (ipAddress == null || ipAddress.length() == 0 || "unknown".equalsIgnoreCase(ipAddress)) {
            isNotIpAddr = true;
        }
        return isNotIpAddr;
    }
}
