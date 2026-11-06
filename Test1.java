class Test1 {
  public static void main(String[] args) {
    CS2030STest we = new CS2030STest();

    we.expectCompile("Checking Valuable is not instantiatable", 
                    "new Valuable();",
                    false);

    we.expect("Creating a new Book(\"1984\", \"sci-fi\", () -> 5.5)",
        new Book("1984", "sci-fi", () -> 5.5).toString(),
        "1984 (S$ 5.50)");

    we.expect("Testing Book::getTitle",
        new Book("The Three-Body Problem", "sci-fi", () -> 22.4).getTitle(),
        "The Three-Body Problem");

    we.expect("Testing Book::getGenre",
        new Book("Jane Eyre", "classics", () -> 8.4).getGenre(),
        "classics");

    we.expect("Testing Book::getPrice",
        new Book("The Mountain is You", "self-help", () -> 32.90).getPrice(),
        32.90);

    we.expect("Testing Book::hasTitle",
        new Book("1984", "sci-fi", () -> 5.5).hasTitle("1984"),
        true);

    we.expect("Testing Book::hasTitle",
        new Book("1984", "sci-fi", () -> 5.5).hasTitle("The Three-Body Problem"),
        false);
  }
}
