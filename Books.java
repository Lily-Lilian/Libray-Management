public class Books {
    private String title;
    private String author;
    private BookStatus status;

    public enum BookStatus {
        AVAILABLE,
        BORROWED,
        RESERVED
    }

    public Books(String title, String author, BookStatus status) {
        if (title == null || author == null || status == null)
            throw new IllegalArgumentException("Books details can not be null");

        this.title = title;
        this.author = author;
        this.status = status;
    }

    @Override
    public String toString() {
        return "Book: " + title + " by " + author + " (Status: " + status + ")";
    }

    public boolean borrowBook() {
        if (status == BookStatus.AVAILABLE) {
            this.status = BookStatus.BORROWED;
            return true;
        }
        return false;
    }

    public boolean returnBook() {
        if (status == BookStatus.BORROWED) {
            this.status = BookStatus.AVAILABLE;
            return true;
        }
        return false;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public BookStatus getStatus() {
        return status;
    }

    public void setStatus(BookStatus status) {
        this.status = status;
    }

}