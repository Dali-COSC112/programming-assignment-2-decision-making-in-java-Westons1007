import java.util.Scanner;

public class SimpleLibrary {

    static String[] titles = new String[100];
    static String[] authors = new String[100];
    static String[] borrower = new String[100];
    static String[] borrowDate = new String[100];
    static boolean[] isBorrowed = new boolean[100];
    static int bookCount = 0;

    // Add Book
    public static void addBook(String title, String author) {
        titles[bookCount] = title;
        authors[bookCount] = author;
        borrower[bookCount] = "";
        borrowDate[bookCount] = "";
        isBorrowed[bookCount] = false;
        bookCount++;

        System.out.println("Added Book: " + title + " by " + author);
    }

    // Borrow Book
    public static void borrowBook(Scanner sc) {
        System.out.print("Enter Book Title: ");
        String name = sc.nextLine();

        for (int i = 0; i < bookCount; i++) {
            if (titles[i].equalsIgnoreCase(name)) {

                if (isBorrowed[i]) {
                    System.out.println("Already borrowed by " + borrower[i]);
                } else {
                    System.out.print("Enter your name: ");
                    borrower[i] = sc.nextLine();
                    System.out.print("Enter date: ");
                    borrowDate[i] = sc.nextLine();
                    isBorrowed[i] = true;

                    System.out.println("Book borrowed successfully!");
                }
                return;
            }
        }

        System.out.println("Book not found.");
    }

    // Return Book
    public static void returnBook(Scanner sc) {
        System.out.print("Enter Book Title to return: ");
        String name = sc.nextLine();

        for (int i = 0; i < bookCount; i++) {
            if (titles[i].equalsIgnoreCase(name)) {

                if (isBorrowed[i]) {
                    isBorrowed[i] = false;
                    borrower[i] = "";
                    borrowDate[i] = "";
                    System.out.println("Book returned successfully!");
                } else {
                    System.out.println("This book was not borrowed.");
                }
                return;
            }
        }

        System.out.println("Book not found.");
    }

    // List All Books
    public static void listBooks() {
        System.out.println("\n--- Book List ---");
        for (int i = 0; i < bookCount; i++) {
            if (isBorrowed[i]) {
                System.out.println(titles[i] + " by " + authors[i] +
                        " (Borrowed by " + borrower[i] + " on " + borrowDate[i] + ")");
            } else {
                System.out.println(titles[i] + " by " + authors[i] + " (Available)");
            }
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // Auto Add Books
        addBook("Diary of a Wimpy Kid", "Jeff Kinney");
        addBook("Twilight", "Stephenie Meyer");

        int choice;

        do {
            System.out.println("\n=== Library Menu ===");
            System.out.println("1. Add Book");
            System.out.println("2. Borrow Book");
            System.out.println("3. Return Book");
            System.out.println("4. List All Books");
            System.out.println("0. Exit");
            System.out.print("Choose: ");
            choice = sc.nextInt();
            sc.nextLine();

            switch (choice) {
                case 1:
                    System.out.print("Enter title: ");
                    String t = sc.nextLine();
                    System.out.print("Enter author: ");
                    String a = sc.nextLine();
                    addBook(t, a);
                    break;

                case 2:
                    borrowBook(sc);
                    break;

                case 3:
                    returnBook(sc);
                    break;

                case 4:
                    listBooks();
                    break;

                case 0:
                    System.out.println("Exiting...");
                    break;

                default:
                    System.out.println("Invalid choice.");
            }

        } while (choice != 0);

        sc.close();
    }
}