package chapter13.code.listing.service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import javax.portlet.PortletContext;

import chapter13.code.listing.domain.Book;
import chapter13.code.listing.utils.BookDataObject;
import chapter13.code.listing.utils.Constants;

public class BookServiceImpl implements BookService {
	private PortletContext context;
	
	public BookServiceImpl(PortletContext context) {
		this.context = context;
	}
	
	public List<Book> getBooks() {
		BookDataObject bookCatalog = (BookDataObject) context.getAttribute("bookCatalog");
		return bookCatalog.getBooks();
	}
	
	public List<Book> searchBooks(String bookName, String authorName, String casePref) {
		BookDataObject bookCatalog = (BookDataObject) context.getAttribute("bookCatalog");
		List<Book> matchingBooks = new ArrayList<Book>();
		for(Book book : bookCatalog.getBooks()) {
			if(casePref.equalsIgnoreCase(Constants.CASE_SENSITIVE)) {
				if(book.getName().contains(bookName) && book.getAuthor().contains(authorName)) {
					matchingBooks.add(book);
				}
			} else {
				if(book.getName().toLowerCase().contains(bookName.toLowerCase()) 
						&& book.getAuthor().toLowerCase().contains(authorName.toLowerCase())) {
					matchingBooks.add(book);
				}
			}
		}
		return matchingBooks;
	}
	public void addBook(Book book) {
		BookDataObject bookCatalog = (BookDataObject) context.getAttribute("bookCatalog");
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
	
	public List<Book> getBooksByCategories(String[] categories) {
		List<String> catList = Arrays.asList(categories);
		BookDataObject bookCatalog = (BookDataObject) context.getAttribute("bookCatalog");
		List<Book> matchingBooks = new ArrayList<Book>();
		for(Book book : bookCatalog.getBooks()) {
			if(catList.contains(book.getCategory())) {
				matchingBooks.add(book);
			}
		}
		return matchingBooks;
	}
}