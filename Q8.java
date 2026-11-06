// @author Axxxxxxx
import java.util.Comparator;
import java.util.List;
import java.util.stream.Stream;

class Q8 {
  static class ShopComparator<T extends Book> implements Comparator<BookShop<? extends T>> {
    public int compare(BookShop<? extends T> stall1, BookShop<? extends T> stall2) {
      return (int) (stall1.getBooks().stream()
          .map(Book::getPrice)
          .reduce(Double.MAX_VALUE, Math::min)
          - stall2.getBooks().stream()
          .map(Book::getPrice)
          .reduce(Double.MAX_VALUE, Math::min));
    }
  }

}
