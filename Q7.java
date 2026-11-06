// @author Axxxxxxx
import java.util.List;
import java.util.stream.Stream;

class Q7 {
  static class DiscountedBook extends Book {
    public DiscountedBook(Book b, double discount) {
      super(b.getTitle(), b.getGenre(), () -> b.getPrice() * (100 - discount) / 100);
    }
  }

}
