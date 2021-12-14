package entity;

import lombok.Getter;
import lombok.Setter;
import lombok.SneakyThrows;

import java.text.SimpleDateFormat;
import java.util.*;

public abstract class Item {

  @Getter @Setter
  protected Long id;
  @Getter @Setter
  protected String title, author, publishingHouse;
  @Getter @Setter
  protected Integer number, numberOfPages;
  @Getter @Setter
  protected Calendar releaseDate;
  @Getter
  private final Set<ItemFields> itemFields;

  public Item(Set<ItemFields> itemFields) {
    this.itemFields = itemFields;
  }

  public void setNumberFromString(String number){
    if (number == null) {
      this.number = null;
    } else {
      this.number = Integer.parseInt(number);
    }
  }

  public void setNumberOfPagesFromString(String numberOfPages){
    if (numberOfPages == null) {
      this.numberOfPages = null;
    } else {
      this.numberOfPages = Integer.parseInt(numberOfPages);
    }
  }

  @SneakyThrows
  public void setReleaseDateFromString(String releaseDate, SimpleDateFormat format) {
    if (releaseDate == null){
      this.releaseDate = null;
    } else {
      Date parsed = format.parse(releaseDate);
      this.releaseDate = new GregorianCalendar();
      this.releaseDate.setTime(parsed);
    }
  }

  /**
   * Checks field equality without regard to id
   */
  public boolean sameTo(Item item) {
    return Objects.equals(title, item.title) &&
      Objects.equals(author, item.author) &&
      Objects.equals(publishingHouse, item.publishingHouse) &&
      Objects.equals(number, item.number) &&
      Objects.equals(numberOfPages, item.numberOfPages) &&
      Objects.equals(releaseDate, item.releaseDate);
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) return true;
    if (o == null || getClass() != o.getClass()) return false;
    Item item = (Item) o;
    return Objects.equals(id, item.id) &&
      Objects.equals(title, item.title) &&
      Objects.equals(author, item.author) &&
      Objects.equals(publishingHouse, item.publishingHouse) &&
      Objects.equals(number, item.number) &&
      Objects.equals(numberOfPages, item.numberOfPages) &&
      Objects.equals(releaseDate, item.releaseDate);
  }

  @Override
  public int hashCode() {
    return Objects.hash(id, title, author, publishingHouse, number, numberOfPages, releaseDate);
  }
}
