package Listeners;

import Constants.SharedConstants;
import Service.AllServices;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;
import javax.servlet.http.HttpSession;
import javax.servlet.http.HttpSessionEvent;
import javax.servlet.http.HttpSessionListener;

@WebListener
public class WebAppListener implements ServletContextListener, HttpSessionListener {
    private AllServices allServices;
    public WebAppListener(){
        allServices = new AllServices();
    }
    @Override
    public void contextInitialized(ServletContextEvent servletContextEvent) {
        servletContextEvent.getServletContext().setAttribute(SharedConstants.ATTRIBUTE,allServices);
    }

    @Override
    public void contextDestroyed(ServletContextEvent servletContextEvent) {
        servletContextEvent.getServletContext().removeAttribute(SharedConstants.ATTRIBUTE);
    }

    @Override
    public void sessionCreated(HttpSessionEvent httpSessionEvent) {
        HttpSession session = httpSessionEvent.getSession();
        session.setAttribute(SharedConstants.SESSION_ATTRIBUTE, null);
    }

    @Override
    public void sessionDestroyed(HttpSessionEvent httpSessionEvent) {
        httpSessionEvent.getSession().removeAttribute(SharedConstants.SESSION_ATTRIBUTE);
    }
}
