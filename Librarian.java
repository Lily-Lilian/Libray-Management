
public class Librarian {
    private Library library;
    private String name;
    private AccessLevel accessLevel;
    private int employeeId;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public AccessLevel getAccessLevel() {
        return accessLevel;
    }

    public void setAccessLevel(AccessLevel accessLevel) {
        this.accessLevel = accessLevel;
    }

    public int getEmployeeId() {
        return employeeId;
    }

    public void setEmployeeId(int employeeId) {
        this.employeeId = employeeId;
    }

    public Librarian(

            String name, AccessLevel accessLevel,
            int employeeId, Library library) {
        this.name = name;
        this.accessLevel = accessLevel;
        this.employeeId = employeeId;
        this.library = library;
    }

    public boolean addBook(Books book) {
        return library.addBook(book);
    }

    public boolean removeBook(Books book) {
        if (accessLevel != AccessLevel.ADMIN)
            System.out.println("Not permitted");
        else
            System.out.println("this book is removed" + book);
        return library.removeBook(book);
    }

    public boolean processBorrowBook(Members member, Books book) {
        if (member.borrowBook(book)) {
            return true;
        }
        return false;
    }

    public boolean processReturnBook(Members member, Books book) {
        if (member.returnBook(book)) {
            return true;
        }
        return false;
    }

    public enum AccessLevel {
        ADMIN,
        SENIOR,
        JUNIOR,
    }
}