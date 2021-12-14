package entity.items;

import entity.Item;
import entity.ItemFields;

import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Calendar;
import java.util.HashSet;

public class Magazine extends Item {

  public Magazine() {
    super(new HashSet<>(Arrays.asList(
      ItemFields.TITLE,
      ItemFields.NUMBER,
      ItemFields.NUMBER_OF_PAGES,
      ItemFields.RELEASE_DATE
    )));
  }

  @Override
  public String toString() {
    SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
    return "Magazine{" +
      "title='" + title + '\'' +
      ", number=" + number +
      ", numberOfPages=" + numberOfPages +
      ", releaseDate=" + format.format(releaseDate.getTime()) +
      '}';
  }
}
