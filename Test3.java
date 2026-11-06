import java.util.Arrays;
import java.util.List;

class Test3 {
  public static void main(String[] args) {
    CS2030STest we = new CS2030STest();

    class Classic extends Book {
      public Classic(String n, double p) {
        super(n, "classics", () -> p);
      }
    }

    class SciFi extends Book {
      public SciFi(String n, double p) {
        super(n, "sci-fi", () -> p);
      }
    }

    Classic janeEyre = new Classic("Jane Eyre", 8.40);
    Classic wutheringHeights = new Classic("Wuthering Heights", 6.60);
    SciFi threeBody = new SciFi("The Three-Body Problem", 22.4);

    BookShop<Book> bs1 = new BookShop<>(List.of(janeEyre, threeBody));
    BookShop<Classic> bs2 = new BookShop<>(List.of(wutheringHeights));
    BookShop<Classic> bsempty = new BookShop<>();

    we.expect("Q4: Merging two BookShop of different types",
        () -> Q4.mergeShops(bs1, bs2).toString().trim(),
        "- Jane Eyre (S$ 8.40)\n" +
        "- The Three-Body Problem (S$ 22.40)\n" +
        "- Wuthering Heights (S$ 6.60)");

    we.expect("Q4: Merging with an empty BookShop",
        () -> Q4.mergeShops(bs1, bsempty).toString().trim(),
        "- Jane Eyre (S$ 8.40)\n" +
        "- The Three-Body Problem (S$ 22.40)");

    we.expectCompile("Q4: Merging two BookShops of different types into BookShop<Book>",
        """
        class A extends Book { public A(String n, double p) { super(n, "a", () -> p); } }
        class B extends Book { public B(String n, double p) { super(n, "b", () -> p); } }
        BookShop<A> bs1 = new BookShop<>();
        BookShop<B> bs2 = new BookShop<>();
        BookShop<Book> bs = Q4.mergeShops(bs1, bs2);""", 
        true);

    we.expectCompile("Q4: Merging two BookShops of incompatible types should compile with error",
        """
        class A extends Book { public A(String n, double p) { super(n, "a", () -> p); } }
        class B extends Book { public B(String n, double p) { super(n, "b", () -> p); } }
        BookShop<A> bs1 = new BookShop<>();
        BookShop<B> bs2 = new BookShop<>();
        BookShop<A> bs = Q4.mergeShops(bs1, bs2);""", 
        false);

    Classic janeEyre2 = new Classic("Jane Eyre", 7.00);
    BookShop<Book> bs3 = new BookShop<>(List.of(janeEyre2, threeBody));

    class ClearanceBook extends Book {
      public ClearanceBook(String name, String genre) {
        super(name, genre, () -> 0.5);
      }
    }

    ClearanceBook jv = new ClearanceBook("Effective Java", "education");
    ClearanceBook je = new ClearanceBook("Jane Eyre", "romance");
    BookShop<ClearanceBook> bs4 = new BookShop<>(List.of(jv, je));

    we.expect("Q5: Testing Q5::findUniqueGenres",
        () -> Q5.findUniqueGenres(List.of(bs1, bs2, bs3, bs4)).toString().trim(),
        "[classics, education, romance, sci-fi]");

    we.expect("Q5: Testing Q5::findUniqueGenres with only one genre",
        () -> Q5.findUniqueGenres(List.of(bs2)).toString().trim(),
        "[classics]");

    we.expect("Q6: Testing Q6::consolidateShopsbyGenre",
        () -> Q6.consolidateShopsbyGenre(List.of(bs1, bs2, bs3, bs4)).toString().trim(),
        "[\n- Jane Eyre (S$ 8.40)"
        + "\n- Wuthering Heights (S$ 6.60)"
        + "\n- Jane Eyre (S$ 7.00)"
        + "\n, "
        + "\n- Effective Java (S$ 0.50)"
        + "\n, "
        + "\n- Jane Eyre (S$ 0.50)"
        + "\n, "
        + "\n- The Three-Body Problem (S$ 22.40)"
        + "\n- The Three-Body Problem (S$ 22.40)"
        + "\n]");

    we.expect("Q7: Testing Q7::discountRemainingStock method with k = 2",
        () -> Q7.discountRemainingStock(List.of(bs1, bs2, bs3, bs4), 2).toString().trim(),
        "[\n"
        + "- Wuthering Heights (S$ 3.30)\n"
        + "]");

    we.expect("Q7: Testing Q7::discountRemainingStock method with k = 3",
        () -> Q7.discountRemainingStock(List.of(bs3, bs4), 3).toString().trim(),
        "["
        + "\n- Jane Eyre (S$ 3.50)"
        + "\n- The Three-Body Problem (S$ 11.20)"
        + "\n, "
        + "\n- Effective Java (S$ 0.25)"
        + "\n- Jane Eyre (S$ 0.25)"
        + "\n]");

    we.expect("Q8: Testing Q8::searchForBook method",
        () -> Q8.searchForBook(List.of(bs1, bs2, bs3, bs4), "Jane Eyre").toString().trim(),
        "["
        + "\n- Jane Eyre (S$ 0.50)"
        + "\n, "
        + "\n- Jane Eyre (S$ 7.00)"
        + "\n, "
        + "\n- Jane Eyre (S$ 8.40)"
        + "\n]");
  }
}
