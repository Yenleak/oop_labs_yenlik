public abstract  class LibraryItem {
    private String title;
    private String author;
    private int publicationYear;

    public LibraryItem(String title, String author, int publicationYear) {
        this.title = title;
        this.author = author;
        this.publicationYear = publicationYear;
}

    public String getTitle() { return title; }
    public void setTitle(String title) { this.title = title; }

    public String getAuthor() { return author; }
    public void setAuthor(String author) { this.author = author; }

    public int getPublicationYear() { return publicationYear; }
    public void setPublicationYear(int publicationYear) { this.publicationYear = publicationYear; }

    public abstract String getItemType();

    @Override
    public String toString() {
        return String.format("Название: '%s', Автор: %s, Год: %d", title, author, publicationYear);
    }
}

class Book extends LibraryItem {
    private int numberOfPages;

    public Book(String title, String author, int year, int pages) {
        super(title, author, year);
        this.numberOfPages = pages;
    }

    public int getNumberOfPages() {
        return numberOfPages;
    }

    public void setNumberOfPages(int numberOfPages) {
        this.numberOfPages = numberOfPages;
    }

    @Override
    public String getItemType() {
        return "Книга";
    }

    @Override
    public String toString() {
        return super.toString() + ", Страниц: " + numberOfPages + " [" + getItemType() + "]";
    }
}

class myBook{
    public static void main(String[] args) {
        Book myBook = new Book("Десять негритят", "Агата Кристи", 1939, 288);
        
        System.out.println(myBook.toString());
    }
}
