package repository;

import java.util.List;

public interface Repository<T, ID> {

  List<T> getAll();

  void add(T item);

  void delete(T item);

  T find(ID id);

}
