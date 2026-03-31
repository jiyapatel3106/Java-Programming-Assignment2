// Program 4: 
// Sort Book objects using Comparable and
// Comparator interfaces.

import java.util.*;

public class Program4 implements Comparable<Program4> {
    int id;
    String title;
    double price;

    public Program4(int id, String title, double price) {
        this.id = id;
        this.title = title;
        this.price = price;
    }

    // Comparable: sort by id
    @Override
    public int compareTo(Program4 other) {
        return Integer.compare(this.id, other.id);
    }

    @Override
    public String toString() {
        return id + " - " + title + " - " + price;
    }

    public static void main(String[] args) {
        List<Program4> books = new ArrayList<>();
        books.add(new Program4(3, "Java", 450));
        books.add(new Program4(1, "Data Structures", 600));
        books.add(new Program4(2, "Algorithms", 500));
        System.out.println("Original List:");
        for (Program4 b : books)
            System.out.println(b);
        // Sort using Comparable (by id)
        Collections.sort(books);
        System.out.println("\nSorted by ID (Comparable):");
        for (Program4 b : books)
            System.out.println(b);
        // Sort using Comparator (by title)
        Collections.sort(books, (b1, b2) -> b1.title.compareTo(b2.title));
        System.out.println("\nSorted by Title (Comparator):");
        for (Program4 b : books)
            System.out.println(b);
        // Sort using Comparator (by price)
        Collections.sort(books, (b1, b2) -> Double.compare(b1.price, b2.price));
        System.out.println("\nSorted by Price (Comparator):");
        for (Program4 b : books)
            System.out.println(b);
    }
}