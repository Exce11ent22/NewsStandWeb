package web;

import repository.persistence.RepositoryInDB;

import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;

@WebListener
public class ContextCreator implements ServletContextListener {

  @Override
  public void contextInitialized(ServletContextEvent servletContextEvent) {
    ServletContextListener.super.contextInitialized(servletContextEvent);
    ServletContext servletContext = servletContextEvent.getServletContext();
    servletContext.setAttribute("repository", RepositoryInDB.getInstance());
  }

}
