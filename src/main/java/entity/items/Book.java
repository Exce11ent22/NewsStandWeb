package entity.items;

import entity.Item;
import entity.ItemFields;

import java.util.Arrays;
import java.util.Calendar;
import java.util.HashSet;

public class Book extends Item {

  public Book() {
    super(new HashSet<>(Arrays.asList(
      ItemFields.TITLE,
      ItemFields.AUTHOR,
      ItemFields.PUBLISHING_HOUSE,
      ItemFields.NUMBER_OF_PAGES
    )));
  }

  @Override
  public String toString() {
    return "Book{" +
      "title='" + title + '\'' +
      ", author='" + author + '\'' +
      ", publishingHouse='" + publishingHouse + '\'' +
      ", numberOfPages=" + numberOfPages +
      '}';
  }

}
