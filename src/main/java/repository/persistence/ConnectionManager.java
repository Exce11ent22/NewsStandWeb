package repository.persistence;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.SQLException;

public class ConnectionManager {

  private DataSource dataSource;

  public ConnectionManager() {
    try {
      Context initContext = new InitialContext();
      Context envContext = (Context) initContext.lookup("java:comp/env");
      dataSource = (DataSource) envContext.lookup("jdbc/h2items");
    } catch (NamingException e) {
      e.printStackTrace();
    }
  }

  public Connection getConnection() throws SQLException {
    return dataSource.getConnection();
  }

}
