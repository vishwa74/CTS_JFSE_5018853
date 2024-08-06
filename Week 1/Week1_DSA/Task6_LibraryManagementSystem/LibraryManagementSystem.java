import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;

class Book {
    int bookId;
    String title;
    String author;

    public Book(int bookId, String title, String author) {
        this.bookId = bookId;
        this.title = title;
        this.author = author;
    }

    @Override
    public String toString() {
        return "Book ID: " + bookId + ", Title: " + title + ", Author: " + author;
    }
}

class Library {
    public static Book linearSearchByTitle(List<Book> books, String title) {
        for (Book book : books) {
            if (book.title.equalsIgnoreCase(title)) {
                return book;
            }
        }
        return null; // Book not found
    }

    public static Book binarySearchByTitle(List<Book> books, String title) {
        int left = 0;
        int right = books.size() - 1;

        while (left <= right) {
            int mid = left + (right - left) / 2;
            Book midBook = books.get(mid);
            int cmp = midBook.title.compareToIgnoreCase(title);

            if (cmp == 0) {
                return midBook; // Book found
            } else if (cmp < 0) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return null; // Book not found
    }
}

public class LibraryManagementSystem {
    public static void main(String[] args) {
        List<Book> books = new ArrayList<>();
        books.add(new Book(1, "The Great Gatsby", "F. Scott Fitzgerald"));
        books.add(new Book(2, "To Kill a Mockingbird", "Harper Lee"));
        books.add(new Book(3, "1984", "George Orwell"));
        books.add(new Book(4, "Pride and Prejudice", "Jane Austen"));
        books.add(new Book(5, "The Catcher in the Rye", "J.D. Salinger"));

        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter the title of the book you want to search for:");
        String title = scanner.nextLine();

        System.out.println("Choose search method:");
        System.out.println("1. Linear Search");
        System.out.println("2. Binary Search (List must be sorted by title)");

        int choice = scanner.nextInt();
        scanner.nextLine(); // consume newline

        Book foundBook = null;

        switch (choice) {
            case 1:
                foundBook = Library.linearSearchByTitle(books, title);
                break;
            case 2:
                // Ensure the list is sorted by title before performing binary search
                Collections.sort(books, Comparator.comparing(book -> book.title));
                foundBook = Library.binarySearchByTitle(books, title);
                break;
            default:
                System.out.println("Invalid choice. Exiting.");
                System.exit(0);
        }

        if (foundBook != null) {
            System.out.println("Book found: " + foundBook);
        } else {
            System.out.println("Book not found.");
        }

        scanner.close();
    }
}
