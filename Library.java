import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Library {
    private List<Books> bookCollection;
    private List<Members> memberCollections;
    private String libraryName;

    public Library(String libraryName) {
        this.bookCollection = new ArrayList<>();
        this.memberCollections = new ArrayList<>();
        this.libraryName = libraryName;
    }

    public boolean addBook(Books newBook) {
        // Check if the book already exists
        boolean bookExists = bookCollection.stream()
                .anyMatch(book -> book.getTitle().equals(newBook.getTitle())
                        && book.getAuthor().equals(newBook.getAuthor()));
        if (!bookExists) {
            bookCollection.add(newBook);
            return true;
        }
        return false;
    }

    public boolean removeBook(Books book) {
        return bookCollection.remove(book);
    }

    // Book Search Method
    public List<Books> findBookByTitle(String title) {
        System.out.println("finding a book by a title: " + title);
        List<Books> findBooks = bookCollection.stream()
                .filter(book -> book.getTitle().toLowerCase().contains(title.toLowerCase()))
                .collect(Collectors.toList());
        if (findBooks.isEmpty())
            System.out.println("no book found for this title: ");
        else {
            System.out.println("book found: ");
            findBooks.forEach(book -> System.out
                    .println(book.getTitle() + " by " + book.getAuthor() + " and it is " + book.getStatus()));
        }
        return findBooks;

    }

    public List<Books> findBookByAuthor(String author) {
        System.out.println("finding a book by an Author");
        List<Books> findBooks = bookCollection.stream()
                .filter(book -> book.getAuthor().toLowerCase().contains(author.toLowerCase()))
                .collect(Collectors.toList());
        if (findBooks.isEmpty())
            System.out.println("no book found for this Author");
        else {
            System.out.println("Book found: ");
            findBooks.forEach(book -> System.out
                    .println(book.getTitle() + " by " + book.getAuthor() + " and it is " + book.getStatus()));
        }
        return findBooks;
    }

    public List<Books> findAvailableBooks(Books status) {
        return bookCollection.stream().filter(book -> book.getStatus() == Books.BookStatus.AVAILABLE)
                .collect(Collectors.toList());
    }

    public boolean registerMember(Members newMember) {
        // Check if the book already exists
        boolean memberExists = memberCollections.stream()
                .anyMatch(member -> member.getName().equals(newMember.getName())
                        && member.getID().equals(newMember.getID()));
        if (!memberExists) {
            memberCollections.add(newMember);
            return true;
        }
        return false;
    }

    public boolean removeMember(Members member) {
        return memberCollections.remove(member);
    }

    public boolean borrowBook(Books book, Members member) {
        if (book.getStatus() == Books.BookStatus.AVAILABLE && member.getBorrowedBooks().size() < 3) {
            book.setStatus(Books.BookStatus.BORROWED);
            member.borrowBook(book);
            return true;
        }
        return false;
    }

    public boolean returnBook(Books book, Members member) {
        if (member.getBorrowedBooks().contains(book)) {
            book.setStatus(Books.BookStatus.AVAILABLE);
            member.returnBook(book);
            return true;
        }
        return false;
    }

    // Reporting and statistics
    public int getTotalBookCount() {
        return bookCollection.size();
    }

    public int getAvailableBooks() {
        return (int) bookCollection.stream()
                .filter(book -> book.getStatus() == Books.BookStatus.AVAILABLE)
                .count();
    }

    public List<Books> getAllBooks() {
        System.out.println("this is the book collection: " + bookCollection);
        return new ArrayList<>(bookCollection);
    }

    public List<Members> getAllMembers() {
        return new ArrayList<>(memberCollections);
    }

}
