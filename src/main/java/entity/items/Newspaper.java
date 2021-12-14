package entity.items;

import entity.Item;
import entity.ItemFields;

import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Calendar;
import java.util.HashSet;

public class Newspaper extends Item {

  public Newspaper() {
    super(new HashSet<>(Arrays.asList(
      ItemFields.TITLE,
      ItemFields.NUMBER,
      ItemFields.RELEASE_DATE
    )));
  }

  @Override
  public String toString() {
    SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
    return "Newspaper{" +
      "title='" + title + '\'' +
      ", number=" + number +
      ", releaseDate=" + format.format(releaseDate.getTime()) +
      '}';
  }
}
