import java.util.ArrayList;
import java.util.List;

public class Members {
    private String name;
    private String ID;
    private List<Books> borrowedBooks;

    public Members(String name, String ID) {
        this.name = name;
        this.ID = ID;
        this.borrowedBooks = new ArrayList<>();
    }

    public boolean borrowBook(Books book) {
        if (book.getStatus() == Books.BookStatus.AVAILABLE) {
            if (borrowedBooks.size() < 3) {
                book.setStatus(Books.BookStatus.BORROWED);
                borrowedBooks.add(book);
                return true;
            }
            return false;
        }
        return false;
    }

    public boolean returnBook(Books book) {
        if (borrowedBooks.contains(book)) {
            if (book.getStatus() == Books.BookStatus.BORROWED) {
                book.setStatus(Books.BookStatus.AVAILABLE);
                borrowedBooks.remove(book);
                return true;
            }
        }
        return false;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getID() {
        return ID;
    }

    public void setID(String iD) {
        ID = iD;
    }

    public List<Books> getBorrowedBooks() {
        return new ArrayList<>(borrowedBooks);
    }

    public void setBorrowedBooks(List<Books> borrowedBooks) {
        this.borrowedBooks = new ArrayList<>(borrowedBooks);
    }
}
