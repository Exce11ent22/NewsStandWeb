package command;

import services.adapter.RepositoryAdapter;

public class AcceptItemsCommand implements Command {

  private final RepositoryAdapter adapter;

  public AcceptItemsCommand(RepositoryAdapter adapter) {
    this.adapter = adapter;
  }

  @Override
  public void execute() {
    adapter.acceptItems();
  }

  @Override
  public String toString() {
    return "Accept items";
  }
}
