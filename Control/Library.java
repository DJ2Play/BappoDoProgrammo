package Control;
import java.util.*;
import Objects.Book;
import Objects.Person;
public class Library {
	
	private int id;
	private String name;
	private String adress;
	private int totalBook; // Exemplars a la biblioteca
	private int totalLoan; // Prestats de una biblioteca
	private int sumTotalBookLoan; // Total exemplars y prestats
	private int sumTotalLoan; // Vegades prestades un llibre
	private ArrayList<Book> bookList = new ArrayList<Book>();
	private ArrayList<Person> staffList = new ArrayList<Person>();
	public Library(int id, String name, String adress, ArrayList<Book> bookList, ArrayList<Person> staffList) {
		this.id = id;
		this.name = name;
		this.adress = adress;
		this.bookList = bookList;
		this.staffList = staffList;
	}
	public ArrayList<Book> getBookList() {
		return bookList;
	}
	public void setBookList(ArrayList<Book> bookList) {
		this.bookList = bookList;
	}
	public ArrayList<Person> getStaffList() {
		return staffList;
	}
	public void setStaffList (ArrayList<Person> staffList) {
		this.staffList = staffList;
	}
	public Book createBook() {
		Scanner sc = new Scanner(System.in);
		String ISBN;
		String title = null;
		String author = null;
		int tB = 0;
		ISBN = sc.nextLine().toUpperCase();
		boolean repeated = false;
		for (int i = 0; i < this.bookList.size(); i++) {
			if (this.bookList.get(i).getISBN().equals(ISBN)) {
				repeated = true;
			}
		}
		if (repeated) {
			System.out.println("The ISBN is already in the database");
		} else {
			System.out.println("Introduce the following data:");
			System.out.print("Title: ");
			title = sc.nextLine().toUpperCase();
			System.out.print("Author: ");
			author = sc.nextLine().toUpperCase();
			System.out.print("Total books: ");
			tB = sc.nextInt();
			System.out.println("");		
		}
		
		Book b = new Book(title,author,ISBN,tB,0,tB,0);
		return b; 
	}
	public boolean loanBook() {
		Scanner sc = new Scanner(System.in);
		System.out.println("= Loan a book =");
		System.out.println("Please, enter the ISBN of the book");
		String ISBN = sc.nextLine().toUpperCase();
		int index = 0;
		boolean exists = false;
		for (int i = 0; i < this.bookList.size(); i++) {
			if((this.bookList.get(i).getISBN().equals(ISBN)) && (this.bookList.get(i).getTotalBook() != 0)) {
				exists = true;
				index = i;
			}
		}
		if (exists) {
			this.bookList.get(index).loanBook();
			System.out.println("The book's been successfully loaned");
			return true;
		} else {
			System.out.println("This library does not contain this book");
			return false;
		}
 	}
	public boolean returnBook() {
		Scanner sc = new Scanner(System.in);
		System.out.println("= Return Book =");
		System.out.println("Please, enter the ISBN of the book");
		String ISBN = sc.nextLine().toUpperCase();
		int index = 0;
		boolean returned = false;
		for (int i = 0; i < this.bookList.size(); i++) {
			if ((this.bookList.get(i).getISBN().equals(ISBN)) && equals(this.bookList.get(i).getTotalLoan() != 0)) {
				returned = true;
				index = i;
			}
		}
		if (returned) {
			this.bookList.get(index).returnBook();
			System.out.println("The book's been succesfully returned");
			return true;
		} else {
			System.out.println("All books have already been returned");
			return false;
		}
	}
	public void showBook() {
		Scanner sc = new Scanner(System.in);
		System.out.println("= Show book =");
		System.out.println("Please, enter the title");
		String title = sc.nextLine().toUpperCase();
		int index = 0;
		boolean exists = false;
		for (int i = 0; i < this.bookList.size(); i++) {
			if(this.bookList.get(i).getTitle().equals(title)) {
				exists = true;
				index = i;
			}
		}
		if (exists) {
			this.bookList.get(index).showInfo();
		} else {
			System.out.println("This book does not exist");
		}
	}
	public void locateBook() {
		Scanner sc = new Scanner(System.in);
		System.out.println("= Locate Book =");
		System.out.println("Please, enter the ISBN");
		String ISBN = sc.nextLine().toUpperCase();
		int index = 0;
		boolean exists = false;
		for (int i = 0; i < this.bookList.size(); i++) {
			if(this.bookList.get(i).getISBN().equals(ISBN)) {
				exists = true;
				index = i;
			}
		}
		if (exists && this.bookList.get(index).getTotalBook() > 0) {
			System.out.println("This book is available");
			this.bookList.get(index).showInfo();
		} else {
			System.out.println("This book is not available");
		}
	}
	public void libraryStats() {
		totalBook = 0;
		totalLoan = 0;
		sumTotalBookLoan = 0;
		for (int i = 0; i < bookList.size(); i++) {
			totalBook += this.bookList.get(i).getTotalBook();
			totalLoan += this.bookList.get(i).getTotalLoan();
			sumTotalBookLoan += this.bookList.get(i).getSumTotalBookLoan();
			System.out.println(this.bookList.get(i).getTitle() + ", " + this.bookList.get(i).getAuthor() + " - ISBN: "
					+ this.bookList.get(i).getISBN());
			System.out.println("Total of books loaned: " + this.bookList.get(i).getSumTotalLoan());
			System.out.println("=======================");
		}
		System.out.println("Total books in the library: " + totalBook);
		System.out.println("Total books that've been loaned: " + totalLoan);
		System.out.println("Sum of all the books: " + sumTotalBookLoan);
		System.out.println("==========================================");
		System.out.println("Staff List: ");
		for (int i = 0; i < this.staffList.size(); i++) {
			System.out.println(this.staffList.get(i).getDNI() + ": " + this.staffList.get(i).getName() + ", " + this.staffList.get(i).getEmployment());
		}
	}
	public void addBook(Book b) {
		this.bookList.add(b);
	}
	public void removeBook(int b) {
		this.bookList.remove(b);
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getLibraryName() {
		return name;
	}
	public void setLibraryName(String name) {
		this.name = name;
	}
	public String getAdress() {
		return adress;
	}
	public void setAdress(String adress) {
		this.adress = adress;
	}
	public int getTotalBook() {
		totalBook = 0;
		for (int i = 0; i < this.bookList.size(); i++) {
			totalBook += this.bookList.get(i).getTotalBook();
		}
		return totalBook;
	}
	public void setTotalBook(int totalBook) {
		this.totalBook = totalBook;
	}
	public int getTotalLoan() {
		totalLoan = 0;
		for (int i = 0; i < bookList.size(); i++) {
			totalLoan += this.bookList.get(i).getTotalLoan();
		}
		return totalLoan;
	}
	public void setTotalLoan(int totalLoan) {
		this.totalLoan = totalLoan;
	}
	public int getSumTotalBookLoan() {
		sumTotalBookLoan = 0;
		for (int i = 0; i < this.bookList.size(); i++) {
			sumTotalBookLoan += this.bookList.get(i).getSumTotalBookLoan();
		}
		return sumTotalBookLoan;
	}
	public void setSumTotalBookLoan(int sumTotalBookLoan) {
		this.sumTotalBookLoan = sumTotalBookLoan;
	}
	public int getSumTotalLoan() {
		sumTotalLoan = 0;
		for (int i = 0; i < this.bookList.size(); i++) {
			sumTotalLoan += this.bookList.get(i).getSumTotalLoan();
		}
		return sumTotalLoan;
	}
	public void setSumTotalLoan(int sumTotalLoan) {
		this.sumTotalLoan = sumTotalLoan;
	}
}
