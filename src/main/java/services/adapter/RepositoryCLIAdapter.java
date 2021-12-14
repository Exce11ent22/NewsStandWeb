package services.adapter;

import entity.Item;
import entity.ItemFactory;
import entity.ItemType;
import entity.configurator.ItemFromCLIConfigurator;
import repository.Repository;
import services.adapter.RepositoryAdapter;
import tools.ItemTool;

import java.util.*;

public class RepositoryCLIAdapter implements RepositoryAdapter {

  private final Repository<Item, Long> repository;
  private final Scanner scn = new Scanner(System.in);

  public RepositoryCLIAdapter(Repository<Item, Long> repository) {
    this.repository = repository;
  }

  @Override
  public void acceptItems() {
    System.out.println("Select the item you want to add:\n");
    Item item = chooseAndCreateItem();
    if (item == null){
      System.out.println("Error!!!");
      return;
    }
    System.out.println("How much?");
    int choose = Integer.parseInt(scn.nextLine());
    if (choose > 0) {
      for (int i = 0; i < choose; i++) repository.add(item);
    } else {
      System.out.println("Incorrect input!");
    }
  }

  @Override
  public void sellItem() {
    List<Item> items = ItemTool.getDifferentItems(repository.getAll());

    if (items.size() == 0) return;

    System.out.println("Select the item you want to sell:");
    for (int i = 0; i < items.size(); i++) System.out.println((i + 1) + ") " + items.get(i));

    int choose = Integer.parseInt(scn.nextLine()) - 1;
    if (choose >= 0 && choose < items.size()) {
      repository.delete(repository.getAll().get(choose));
    } else {
      System.out.println("Out of range!");
    }
  }

  @Override
  public void viewCatalog() {
    System.out.println("----------Catalog----------");
    Map<Item, Integer> catalog = ItemTool.getCatalog(repository.getAll());
    for (Map.Entry<Item, Integer> entry : catalog.entrySet()) {
      System.out.println(entry.getKey() + "; Amount in repository: " + entry.getValue());
    }
  }

  private Item chooseAndCreateItem() {
    for (ItemType itemType : ItemType.values()) {
      System.out.println(itemType.getTypeNumber() + " -> " + itemType.getItemClass().getSimpleName());
    }
    int choose = Integer.parseInt(scn.nextLine());
    return ItemFactory.create(ItemType.getTypeFromTypeNumber(choose), new ItemFromCLIConfigurator());
  }


}
