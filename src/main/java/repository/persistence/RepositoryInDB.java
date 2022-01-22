package repository.persistence;

import entity.ItemFactory;
import entity.ItemType;
import entity.Item;
import repository.Repository;

import java.sql.*;
import java.util.*;
import java.util.Date;

public class RepositoryInDB implements Repository<Item, Long> {

  private final ConnectionManager connectionManager = new ConnectionManager();
  private static RepositoryInDB instance;

  public static RepositoryInDB getInstance(){
    if (instance != null) return instance;
    instance = new RepositoryInDB();
    return instance;
  }

  @Override
  public List<Item> getAll() {
    try {
      Connection connection = connectionManager.getConnection();
      Statement statement = connection.createStatement();
      ResultSet resultSet = statement.executeQuery("SELECT * FROM items");
      return extractor.extract(resultSet);
    } catch (SQLException e) {
      e.printStackTrace();
    }
    return Collections.emptyList();
  }

  @Override
  public void add(Item item) {
    try (Connection connection = connectionManager.getConnection();
         PreparedStatement ps = connection.prepareStatement(
                 "insert into ITEMS(title, author, publishing_house, number, number_of_pages, release_date, item_type) " +
                         "values ( ? , ? , ? , ? , ? , ? , ? )"
         )) {
      ps.setObject(1, item.getTitle(), Types.VARCHAR);
      ps.setObject(2, item.getAuthor(), Types.VARCHAR);
      ps.setObject(3, item.getPublishingHouse(), Types.VARCHAR);
      ps.setObject(4, item.getNumber(), Types.INTEGER);
      ps.setObject(5, item.getNumberOfPages(), Types.INTEGER);
      if(item.getReleaseDate() == null){
        ps.setNull(6, Types.DATE);
      } else {
        ps.setDate(6, new java.sql.Date(item.getReleaseDate().getTimeInMillis()));
      }
      ps.setObject(7, Objects.requireNonNull(ItemType.getTypeFromClass(item.getClass())).getTypeNumber(), Types.INTEGER);
      ps.execute();
      
    } catch (SQLException e) {
      e.printStackTrace();
    }
  }

  @Override
  public void delete(Item item) {
    Long id = item.getId();
    if (id == null) return;
    try (Connection connection = connectionManager.getConnection();
         Statement statement = connection.createStatement()) {
      statement.execute(String.format("DELETE ITEMS " +
        "WHERE ID = %s;", id));
    } catch (SQLException e) {
      e.printStackTrace();
    }
  }

  @Override
  public Item find(Long id) {
    final List<Item> items = executeSelect(String.format("SELECT * FROM ITEMS WHERE ID = %d", id), extractor);
    return items.size() > 0 ? items.get(0) : null;
  }

  private <T> List<T> executeSelect(String query, Extractor<T> extractor) {
    try (
      Connection connection = connectionManager.getConnection();
      Statement statement = connection.createStatement()
    ) {
      ResultSet resultSet = statement.executeQuery(query);
      return extractor.extract(resultSet);
    } catch (SQLException e) {
      System.out.println("Unable to get data: " + e.getMessage());
    }
    return Collections.emptyList();
  }

  private final Extractor<Item> extractor = rs -> {
    List<Item> items = new ArrayList<>();
    while (rs.next()) {
      Item item = ItemFactory.createEmptyItem(ItemType.getTypeFromTypeNumber(rs.getInt("item_type")));
      if (item == null) continue;
      item.setId(rs.getLong("id"));
      item.setTitle(rs.getString("title"));
      item.setAuthor(rs.getString("author"));
      item.setPublishingHouse(rs.getString("publishing_house"));
      item.setNumber(rs.getInt("number"));
      item.setNumberOfPages(rs.getInt("number_of_pages"));
      item.setReleaseDate(toCalendar(rs.getDate("release_date")));

      items.add(item);
    }
    return items;
  };

  private static Calendar toCalendar(Date date) {
    if (date == null) return null;
    Calendar cal = Calendar.getInstance();
    cal.setTime(date);
    return cal;
  }
}
