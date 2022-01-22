package web;

import entity.Item;
import entity.ItemFactory;
import entity.ItemType;
import repository.persistence.RepositoryInDB;
import tools.ItemHtmlFormBuilder;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.text.SimpleDateFormat;

@WebServlet(name = "add", urlPatterns = {"/add"})
public class AddItemsServlet extends HttpServlet {

  @Override
  protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
    String typeString = req.getParameter("type");
    ItemType type = (typeString != null) ? ItemType.getTypeFromTypeNumber(Integer.parseInt(typeString)) : null;
    String form = (type != null) ? ItemHtmlFormBuilder.getForm(type) : null;
    ItemType[] types = ItemType.values();
    req.setAttribute("form", form);
    req.setAttribute("type", type);
    req.setAttribute("types", types);
    getServletContext().getRequestDispatcher("/add.jsp").forward(req, resp);
  }

  @Override
  protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
    String type = req.getParameter("type");
    Item item = ItemFactory.createEmptyItem(ItemType.getTypeFromTypeNumber(Integer.parseInt(type)));
    if (item == null) return;
    item.setTitle(req.getParameter("title"));
    item.setAuthor(req.getParameter("author"));
    item.setPublishingHouse(req.getParameter("publishing_house"));
    item.setNumberFromString(req.getParameter("number"));
    item.setNumberOfPagesFromString(req.getParameter("number_of_pages"));
    item.setReleaseDateFromString(req.getParameter("release_date"), new SimpleDateFormat("yyyy-MM-dd"));
    RepositoryInDB repository = (RepositoryInDB) getServletContext().getAttribute("repository");
    String amount = req.getParameter("amount");
    for (int i = 0; i < Integer.parseInt(amount); i++){
      repository.add(item);
    }
    resp.sendRedirect(getServletContext().getContextPath() + "/add");
  }

}
