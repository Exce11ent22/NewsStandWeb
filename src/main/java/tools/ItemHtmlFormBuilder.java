package tools;

import entity.Item;
import entity.ItemFactory;
import entity.ItemFields;
import entity.ItemType;

import java.util.Set;

public class ItemHtmlFormBuilder {

  public static String getForm(ItemType type){
    Item item = ItemFactory.createEmptyItem(type);
    Set<ItemFields> itemFields = item.getItemFields();
    StringBuilder stringBuilder = new StringBuilder();
    if (itemFields.contains(ItemFields.TITLE))
      stringBuilder.append("<input type=\"text\" name=\"title\" placeholder=\"Title\" required><br>");
    if (itemFields.contains(ItemFields.AUTHOR))
      stringBuilder.append("<input type=\"text\" name=\"author\" placeholder=\"Author\" required><br>");
    if (itemFields.contains(ItemFields.PUBLISHING_HOUSE))
      stringBuilder.append("<input type=\"text\" name=\"publishing_house\" placeholder=\"Publishing House\" required><br>");
    if (itemFields.contains(ItemFields.NUMBER))
      stringBuilder.append("<input type=\"number\" name=\"number\" placeholder=\"Number\" required><br>");
    if (itemFields.contains(ItemFields.NUMBER_OF_PAGES))
      stringBuilder.append("<input type=\"number\" name=\"number_of_pages\" placeholder=\"Number of pages\" required><br>");
    if (itemFields.contains(ItemFields.RELEASE_DATE))
      stringBuilder.append("<input type=\"date\" name=\"release_date\" placeholder=\"Release date\" required><br>");
    stringBuilder.append("<input type=\"hidden\" name=\"type\" value=").append(type.getTypeNumber()).append(">");
    return stringBuilder.toString();
  }

}
