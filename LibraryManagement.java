public class LibraryManagement {
    public static void main(String[] a) {
        Library library = new Library("New libray in Town");
        Librarian librarian = new Librarian("Lily", Librarian.AccessLevel.JUNIOR, 12, library);
        Members member1 = new Members("Anna", "Is1212");
        Members member2 = new Members("Ada", "IB1452");
        Books book1 = new Books("RISE TO SEEK HIM", "MEYERS", Books.BookStatus.AVAILABLE);
        Books book2 = new Books("HUMILITY", "MAHANEY", Books.BookStatus.BORROWED);
        Books book3 = new Books("12 RULES OF LIFE", "CHRISTOPHER", Books.BookStatus.AVAILABLE);
        Books book4 = new Books("12 RULES OF LIFE", "CHRISTOPHER", Books.BookStatus.AVAILABLE);

        System.out.println("display all books");
        library.getAllBooks();
        librarian.addBook(book1);
        librarian.addBook(book2);
        librarian.addBook(book3);

        System.out.println("search a book by title");
        library.findBookByTitle("RISE TO SEEK HIM");
        System.out.println("removed a book");
        librarian.removeBook(book4);
        System.out.println("All books after removal");
        library.getAllBooks();
        System.out.println("Borrowed a book: ");
        librarian.processBorrowBook(member1, book4);
    }
}
