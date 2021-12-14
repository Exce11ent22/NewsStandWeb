package entity.configurator;

import entity.Item;
import entity.ItemFields;

import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.Scanner;
import java.util.Set;

public class ItemFromCLIConfigurator implements ItemConfigurator{

  private static final Scanner scn = new Scanner(System.in);

  @Override
  public void configure(Item item) {
    Set<ItemFields> itemFields = item.getItemFields();
    if (itemFields.contains(ItemFields.TITLE)) item.setTitle(getTitle());
    if (itemFields.contains(ItemFields.AUTHOR)) item.setAuthor(getAuthor());
    if (itemFields.contains(ItemFields.PUBLISHING_HOUSE)) item.setPublishingHouse(getPublishingHouse());
    if (itemFields.contains(ItemFields.NUMBER)) item.setNumber(getNumber());
    if (itemFields.contains(ItemFields.NUMBER_OF_PAGES)) item.setNumberOfPages(getNumberOfPages());
    if (itemFields.contains(ItemFields.RELEASE_DATE)) item.setReleaseDate(getReleaseDate());
  }

  public static String getTitle() {
    System.out.print("Title: ");
    return scn.nextLine();
  }

  public static String getAuthor() {
    System.out.print("Author: ");
    return scn.nextLine();
  }

  public static String getPublishingHouse() {
    System.out.print("Publishing house: ");
    return scn.nextLine();
  }

  public static Integer getNumber() {
    System.out.print("Number: ");
    return Integer.parseInt(scn.nextLine());
  }

  public static Integer getNumberOfPages() {
    System.out.print("Number of pages: ");
    return Integer.parseInt(scn.nextLine());
  }

  public static Calendar getReleaseDate() {
    System.out.print("Release Year: ");
    int year = Integer.parseInt(scn.nextLine());

    System.out.print("Release Month: ");
    int month = Integer.parseInt(scn.nextLine());

    System.out.print("Release Day: ");
    int day = Integer.parseInt(scn.nextLine());

    return new GregorianCalendar(year, month - 1, day);
  }

}
