/open Valuable.java
/open Book.java
/open BookShop.java

/open Books.jsh

new BookShop<String>();

Classic je = new Classic("Jane Eyre", 8.40);
Classic wh = new Classic("Wuthering Heights", 6.60);

new BookShop<Classic>(List.of(je, wh));
new BookShop<Book>(List.of(je, wh));
new BookShop<Book>(List.of(je, wh)).hasBook("Jane Eyre");
new BookShop<Book>(List.of(je, wh)).hasBook("John Eyre");
new BookShop<Book>(List.of(je, wh)).getBooks();

SciFi ntef = new SciFi("1984", 5.5);
SciFi tb = new SciFi("The Three-Body Problem", 22.4);

List<Book> list = List.of(ntef, je, tb);
new BookShop<>(list).findBooksByGenre("classics");
new BookShop<>(list).findBooksByGenre("sci-fi");
new BookShop<>(list).findBooksByGenre("self-help");
