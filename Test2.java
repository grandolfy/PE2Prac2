import java.util.Arrays;
import java.util.List;

class Test2 {
  public static void main(String[] args) {
    CS2030STest we = new CS2030STest();

    we.expectCompile("Testing that BookShop has a bounded type parameter", 
        "new BookShop<String>();",
        false);

    class Classic extends Book {
      public Classic(String n, double p) {
        super(n, "classics", () -> p);
      }
    }

    List<Classic> classics = List.of(new Classic("Jane Eyre", 8.40), 
        new Classic("Wuthering Heights", 6.60));

    we.expect("Create a new BookShop<Classic> with a list of classics",
        new BookShop<Classic>(classics).toString().trim(),
        "- Jane Eyre (S$ 8.40)\n- Wuthering Heights (S$ 6.60)");

    we.expect("Create a new BookShop<Book> with a list of classics",
        new BookShop<Book>(classics).toString().trim(),
        "- Jane Eyre (S$ 8.40)\n- Wuthering Heights (S$ 6.60)");

    we.expect(".. Testing BookShop::hasBook with \"Jane Eyre\"",
        new BookShop<Book>(classics).hasBook("Jane Eyre"),
        true);

    we.expect(".. Testing BookShop::hasBook with \"John Eyre\"",
        new BookShop<Book>(classics).hasBook("John Eyre"),
        false);


    we.expect("Testing BookShop::getBooks",
        new BookShop<Book>(classics).getBooks().toString().trim(),
        "[Jane Eyre (S$ 8.40), Wuthering Heights (S$ 6.60)]");

    class SciFi extends Book {
      public SciFi(String n, double p) {
        super(n, "sci-fi", () -> p);
      }
    }

    List<Book> list2 = List.of(new SciFi("1984", 5.5), 
        new Classic("Jane Eyre", 8.40), 
        new SciFi("The Three-Body Problem", 22.4));

    we.expect("BookShop with two sci-fi, one classic, and zero self-help books.\n" 
        + ".. Testing BookShop::findBooksByGenre with classics",
        new BookShop<>(list2).findBooksByGenre("classics").toString().trim(),
        "[Jane Eyre (S$ 8.40)]");

    we.expect(".. Testing BookShop::findBooksByGenre with sci-fi",
        new BookShop<>(list2).findBooksByGenre("sci-fi").toString().trim(),
        "[1984 (S$ 5.50), The Three-Body Problem (S$ 22.40)]");

    we.expect(".. Testing BookShop::findBooksByGenre with self-help",
        new BookShop<>(list2).findBooksByGenre("self-help").toString().trim(),
        "[]");
  }
}
