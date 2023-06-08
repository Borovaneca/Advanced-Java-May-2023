package Advance.IteratorsAndComparators.Lab.Book;

import java.util.Iterator;

public class Library implements Iterable<Book> {

    private class LibIterator implements Iterator<Book> {

        int index = 0;

        @Override
        public boolean hasNext() {
           return index < book.length;
        }

        @Override
        public Book next() {
            return book[index++];
        }
    }
    private Book[] book;

    public Library(Book... books) {
        this.book = books;
    }

    @Override
    public Iterator<Book> iterator() {
        return new LibIterator();
    }
}
