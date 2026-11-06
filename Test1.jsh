/open Valuable.java
/open Book.java

new Book("1984", "sci-fi", () -> 5.5);
new Book("The Three-Body Problem", "sci-fi", () -> 22.4).getTitle();
new Book("Jane Eyre", "classics", () -> 8.40).getGenre();
new Book("The Mountain is You", "self-help", () -> 32.9).getPrice();
new Book("1984", "sci-fi", () -> 5.5).hasTitle("1984");
new Book("1984", "sci-fi", () -> 5.5).hasTitle("The Three-Body Problem");
