import java.util.ArrayList;
import java.util.List;

public class Member {
    private String name;
    private String memberId;
    private List<Book> borrowedBooks;

    public Member(String name, String memberId) {
        this.name = name;
        this.memberId = memberId;
        this.borrowedBooks = new ArrayList<>();
    }

    public String getName() {
        return name;
    }

    public String getMemberId() {
        return memberId;
    }

    public void borrowBook(Book book) {
        if (!book.isBorrowed()) {
            borrowedBooks.add(book);
            book.borrow();
            System.out.println("Book borrowed: " + book.getTitle());
        } else {
            System.out.println("Book is already borrowed: " + book.getTitle());
        }
    }

    public void returnBook(Book book) {
        if (borrowedBooks.remove(book)) {
            book.returnBook();
            System.out.println("Book returned: " + book.getTitle());
        } else {
            System.out.println("This book was not borrowed by the member: " + book.getTitle());
        }
    }

    @Override
    public String toString() {
        return "Member{" +
                "name='" + name + '\'' +
                ", memberId='" + memberId + '\'' +
                ", borrowedBooks=" + borrowedBooks +
                '}';
    }
}