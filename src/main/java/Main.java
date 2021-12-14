import command.*;
import entity.Item;
import repository.Repository;
import repository.persistence.BasicConnectionPool;
import repository.persistence.RepositoryInDB;
import services.adapter.RepositoryCLIAdapter;
import services.adapter.RepositoryAdapter;
import ui.CLI;
import ui.UI;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Main {

  public static void main(String[] args){
    Repository<Item, Long> itemRepository = RepositoryInDB.getInstance();
    RepositoryAdapter adapter = new RepositoryCLIAdapter(itemRepository);

    List<Command> commands = new ArrayList<>(
      Arrays.asList(
        new AcceptItemsCommand(adapter),
        new SellItemCommand(adapter),
        new ViewCatalogCommand(adapter),
        new ShutdownCommand(BasicConnectionPool.getInstance())
      )
    );

    UI ui = new CLI(commands);
    ui.run();
  }
}
