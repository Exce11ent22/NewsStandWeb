package web;

import entity.Item;
import repository.persistence.RepositoryInDB;
import tools.ItemTool;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet(name = "sell", urlPatterns = {"/sell"})
public class SellItemServlet extends HttpServlet {

  @Override
  protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
    String id = req.getParameter("id");
    RepositoryInDB repository = (RepositoryInDB) getServletContext().getAttribute("repository");
    if (id != null) {
      repository.delete(repository.find(Long.parseLong(id)));
    }
    List<Item> items = ItemTool.getDifferentItems(repository.getAll());
    req.setAttribute("items", items);
    getServletContext().getRequestDispatcher("/sell.jsp").forward(req, resp);
  }
}
