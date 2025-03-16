class Book {
    private String title;
    private String author;
    private int year;

    public Book(String title, String author, int year) {
        this.title = title;
        this.author = author;
        this.year = year;
    }

    public String getTitle() { return title; }
    public String getAuthor() { return author; }
    public int getYear() { return year; }

    public void displayInfo() {
        System.out.println("Book: " + title + " by " + author + " (" + year + ")");
    }
}

class PrintedBook extends Book {
    private int pages;

    public PrintedBook(String title, String author, int year, int pages) {
        super(title, author, year);
        this.pages = pages;
    }

    @Override
    public void displayInfo() {
        System.out.println("Printed Book: " + getTitle() + " by " + getAuthor() + " (" + getYear() + "), Pages: " + pages);
    }
}

class EBook extends Book {
    private double fileSize;

    public EBook(String title, String author, int year, double fileSize) {
        super(title, author, year);
        this.fileSize = fileSize;
    }

    @Override
    public void displayInfo() {
        System.out.println("E-Book: " + getTitle() + " by " + getAuthor() + " (" + getYear() + "), File Size: " + fileSize + "MB");
    }
}

class AudioBook extends Book {
    private double duration;

    public AudioBook(String title, String author, int year, double duration) {
        super(title, author, year);
        this.duration = duration;
    }

    @Override
    public void displayInfo() {
        System.out.println("Audio Book: " + getTitle() + " by " + getAuthor() + " (" + getYear() + "), Duration: " + duration + " hours");
    }
}

public class Ex7 {
    public static void main(String[] args) {
        Book b1 = new PrintedBook("The Alchemist", "Paulo Coelho", 1988, 208);
        Book b2 = new EBook("Atomic Habits", "James Clear", 2018, 2.5);
        Book b3 = new AudioBook("Becoming", "Michelle Obama", 2018, 19.2);

        Book[] books = {b1, b2, b3};

        for (Book book : books) {
            book.displayInfo();
        }
    }
}
