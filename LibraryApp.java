import java.util.Scanner;

public class LibraryApp {
    public static void main(String[] args) {
        Library library = new Library();
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("\nLibrary Management System");
            System.out.println("1. Add Book");
            System.out.println("2. Add Member");
            System.out.println("3. Borrow Book");
            System.out.println("4. Return Book");
            System.out.println("5. Display Books");
            System.out.println("6. Exit");
            System.out.print("Choose an option: ");
            int choice = scanner.nextInt();
            scanner.nextLine();  // Consume newline

            switch (choice) {
                case 1:
                    System.out.print("Enter book title: ");
                    String title = scanner.nextLine();
                    System.out.print("Enter book author: ");
                    String author = scanner.nextLine();
                    System.out.print("Enter book ISBN: ");
                    String isbn = scanner.nextLine();
                    library.addBook(new Book(title, author, isbn));
                    break;
                case 2:
                    System.out.print("Enter member name: ");
                    String name = scanner.nextLine();
                    System.out.print("Enter member ID: ");
                    String memberId = scanner.nextLine();
                    library.addMember(new Member(name, memberId));
                    break;
                case 3:
                    System.out.print("Enter member ID: ");
                    memberId = scanner.nextLine();
                    System.out.print("Enter book ISBN: ");
                    isbn = scanner.nextLine();
                    Member member = library.findMemberById(memberId);
                    Book book = library.findBookByIsbn(isbn);
                    if (member != null && book != null) {
                        member.borrowBook(book);
                    } else {
                        System.out.println("Invalid member ID or book ISBN.");
                    }
                    break;
                case 4:
                    System.out.print("Enter member ID: ");
                    memberId = scanner.nextLine();
                    System.out.print("Enter book ISBN: ");
                    isbn = scanner.nextLine();
                    member = library.findMemberById(memberId);
                    book = library.findBookByIsbn(isbn);
                    if (member != null && book != null) {
                        member.returnBook(book);
                    } else {
                        System.out.println("Invalid member ID or book ISBN.");
                    }
                    break;
                case 5:
                    library.displayBooks();
                    break;
                case 6:
                    System.out.println("Exiting...");
                    scanner.close();
                    return;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }
    }
}