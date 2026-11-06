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

class ClearanceBook extends Book {
  public ClearanceBook(String name, String genre) {
    super(name, genre, () -> 0.5);
  }
}

