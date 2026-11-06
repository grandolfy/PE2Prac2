/open Valuable.java
/open Book.java
/open BookShop.java
/open Q4.java
/open Q5.java
/open Q6.java
/open Q7.java
/open Q8.java

/open Books.jsh

Classic je = new Classic("Jane Eyre", 8.40);
Classic wh = new Classic("Wuthering Heights", 6.60);
SciFi tb = new SciFi("The Three-Body Problem", 22.4);

BookShop<Book> bs1 = new BookShop<>(List.of(je, tb));
BookShop<Classic> bs2 = new BookShop<>(List.of(wh));
Q4.mergeShops(bs1, bs2);

BookShop<Book> bsempty = new BookShop<>();
Q4.mergeShops(bs1, bsempty);

BookShop<Book> bs = Q4.mergeShops(new BookShop<Classic>(), new BookShop<Book>())
BookShop<Classic> bs = Q4.mergeShops(new BookShop<Classic>(), new BookShop<Book>())

Classic je2 = new Classic("Jane Eyre", 7.00);
BookShop<Book> bs3 = new BookShop<>(List.of(je2, tb));

ClearanceBook jv = new ClearanceBook("Effective Java", "education");
ClearanceBook je3 = new ClearanceBook("Jane Eyre", "romance");
BookShop<ClearanceBook> bs4 = new BookShop<>(List.of(jv, je3));

Q5.findUniqueGenres(List.of(bs1, bs2, bs3, bs4));

Q5.findUniqueGenres(List.of(bs2));
                                                      
Q6.consolidateShopsbyGenre(List.of(bs1, bs2, bs3, bs4));

Q7.discountRemainingStock(List.of(bs1, bs2, bs3, bs4), 2);

Q7.discountRemainingStock(List.of(bs3, bs4), 3);

Q8.searchForBook(List.of(bs1, bs2, bs3, bs4), "Jane Eyre");

Q8.searchForBook(List.of(bs3, Q4.mergeShops(bs1, bs4)), "Jane Eyre");
