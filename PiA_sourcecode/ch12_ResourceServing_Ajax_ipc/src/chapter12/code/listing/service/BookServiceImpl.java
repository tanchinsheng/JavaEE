package chapter12.code.listing.service;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import javax.portlet.PortletContext;

import chapter12.code.listing.domain.Book;
import chapter12.code.listing.utils.BookDataObject;

public class BookServiceImpl implements BookService {
	private PortletContext context;
	
	public BookServiceImpl(PortletContext context) {
		this.context = context;
	}
	
	public List<Book> getBooks() {
		BookDataObject bookCatalog = (BookDataObject) context.getAttribute("bookCatalog");
		return bookCatalog.getBooks();
	}

	public List<Book> searchBooks(String bookName, String authorName) {
		BookDataObject bookCatalog = (BookDataObject) context.getAttribute("bookCatalog");
		List<Book> matchingBooks = new ArrayList<Book>();
		for(Book book : bookCatalog.getBooks()) {
			if(book.getName().contains(bookName) && book.getAuthor().contains(authorName)) {
				matchingBooks.add(book);
			}
		}
		return matchingBooks;
	}
	
	public void addBook(Book book) {
		BookDataObject bookCatalog = (BookDataObject) context.getAttribute("bookCatalog");
		int currentSequence = bookCatalog.getBooks().size();
		book.setSequence(currentSequence + 1);
		bookCatalog.getBooks().add(book);
	}

	public void removeBook(Long isbnNumber) {
		BookDataObject bookCatalog = (BookDataObject) context.getAttribute("bookCatalog");
		bookCatalog.getBooks().remove(getBook(isbnNumber));
	}
	
	public boolean isUniqueISBN(Long isbnNumber) {
		BookDataObject bookCatalog = (BookDataObject) context.getAttribute("bookCatalog");
		boolean isUnique = true;
		for(Book book : bookCatalog.getBooks()) {
			if(book.getIsbnNumber().equals(isbnNumber)) {
				isUnique = false;
				break;
			}
		}
		return isUnique;
	}

	public Book getBook(Long isbnNumber) {
		BookDataObject bookCatalog = (BookDataObject) context.getAttribute("bookCatalog");
		Book matchingBook = null;
		for(Book book : bookCatalog.getBooks()) {
			if(book.getIsbnNumber().equals(isbnNumber)) {
				matchingBook = book;
				break;
			}
		}
		return matchingBook;
	}
	
	public Book getRecentBook() {
		BookDataObject bookCatalog = (BookDataObject) context.getAttribute("bookCatalog");
		List<Book> books = bookCatalog.getBooks();
		Collections.sort(books);
		return books.get(books.size()-1);
	}
	
	public boolean isRecentBook(long isbnNumber) {
		Book book = getBook(isbnNumber);
		if(book.getSequence() == getLastBookSequence()) {
			return true;
		} else {
			return false;
		}
	}
	
	private int getLastBookSequence() {
		BookDataObject bookCatalog = (BookDataObject) context.getAttribute("bookCatalog");
		List<Book> books = bookCatalog.getBooks();
		Book book = books.get(books.size()-1);
		return book.getSequence();
	}
}