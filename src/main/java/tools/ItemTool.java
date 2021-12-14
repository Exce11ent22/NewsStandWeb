package tools;

import entity.Item;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ItemTool {

  /**
   * returns items only with unique fields and counts similar in repo
   */
  public static Map<Item, Integer> getCatalog(List<Item> items) {
    Map<Item, Integer> catalog = new HashMap<>();
    for (Item item : items) {
      Item itemToPut = containItem(catalog, item);
      if (itemToPut != null) {
        catalog.put(itemToPut, catalog.get(itemToPut) + 1);
      } else {
        catalog.put(item, 1);
      }
    }
    return catalog;
  }

  /**
   * returns only items with unique fields
   */
  public static List<Item> getDifferentItems(List<Item> items) {
    List<Item> result = new ArrayList<>();
    for (Item item : items) {
      if (!containItem(result, item)) result.add(item);
    }
    return result;
  }

  private static boolean containItem(List<Item> items, Item toCheck) {
    for (Item item : items) {
      if (item.sameTo(toCheck)) return true;
    }
    return false;
  }

  private static Item containItem(Map<Item, Integer> items, Item toCheck) {
    for (Map.Entry<Item, Integer> entry : items.entrySet()) {
      if (entry.getKey().sameTo(toCheck)) return entry.getKey();
    }
    return null;
  }

}
