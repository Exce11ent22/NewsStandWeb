package web;

import entity.Item;
import repository.Repository;
import repository.persistence.RepositoryInDB;
import tools.ItemTool;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Map;

@WebServlet(name = "catalog", urlPatterns = {"/"})
public class CatalogServlet extends HttpServlet {

  @Override
  public void init() throws ServletException {
    super.init();
  }

  @Override
  protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
    RepositoryInDB repository = (RepositoryInDB) getServletContext().getAttribute("repository");
    Map<Item, Integer> items = ItemTool.getCatalog(repository.getAll());
    req.setAttribute("items", items.entrySet());
    getServletContext().getRequestDispatcher("/catalog.jsp").forward(req, resp);
  }
}
