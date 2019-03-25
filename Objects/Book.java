package Objects;
import Control.Library;
public class Book {
	private String title;
	private String author;
	private String ISBN;
	private int totalBook; //Total de llibres a la biblioteca d'un títol determinat
	private int totalLoan; //Total de llibres prestats d'un títol determinat en aquest moment
	private int sumTotalBookLoan; //Suma de llibres a la biblioteca y prestats
	private int sumTotalLoan; //Total de vegades prestades un llibre, incloent els llibres ara prestats
	
	public Book (String title,String author,String ISBN,int totalBook,int totalLoan,int sumTotalBookLoan,int sumTotalLoan) {
		this.title = title;
		this.author = author;
		this.ISBN = ISBN;
		this.totalBook = totalBook;
		this.totalLoan = totalLoan;
		this.sumTotalBookLoan = totalBook + totalLoan;
		this.sumTotalLoan = sumTotalLoan;
	}
	public Book () {
		this.title = title;
		this.author = author;
		this.ISBN = ISBN;
		this.totalBook = totalBook;
		this.totalLoan = totalLoan;
		this.sumTotalBookLoan = totalBook + totalLoan;
		this.sumTotalLoan = sumTotalLoan;
	}
	public Book (Book l) {
		this.author = l.getAuthor();
		this.title = l.getTitle();
		this.ISBN = l.getISBN();
		this.totalBook = l.getTotalBook();
		this.totalLoan = l.getTotalLoan();
		this.sumTotalBookLoan = l.getSumTotalBookLoan();
		this.sumTotalLoan = l.getSumTotalLoan();
	}
	public String getTitle() {
		return title;
	}
	public String getAuthor() {
		return author;
	}
	public String getISBN() {
		return ISBN;
	}
	public int getTotalBook() {
		return totalBook;
	}
	public int getTotalLoan() {
		return totalLoan;
	}
	public int getSumTotalBookLoan() {
		return sumTotalBookLoan;
	}
	public int getSumTotalLoan() {
		return sumTotalLoan;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public void setAuthor(String author) {
		this.author = author;
	}
	public void setISBN(String iSBN) {
		ISBN = iSBN;
	}
	public void setTotalBook(int totalBook) {
		this.totalBook = totalBook;
	}
	public void setTotalLoan(int totalLoan) {
		this.totalLoan = totalLoan;
	}
	public void setSumTotalBookLoan(int sumTotalBookLoan) {
		this.sumTotalBookLoan = sumTotalBookLoan;
	}
	public void setSumTotalLoan(int sumTotalLoan) {
		this.sumTotalLoan = sumTotalLoan;
	}
	public void loanBook() {
		this.totalLoan++;
		this.totalBook--;
		this.sumTotalLoan++;
	}
	public void returnBook() {
		this.totalLoan--;
		this.totalBook++;
	}
	public void showInfo() {
		System.out.println("===== INFO =====");
		System.out.println("= Title: " + this.title + " =");
		System.out.println("= Author: " + this.author + " =");
		System.out.println("= ISBN: " + this.ISBN + " =");
		System.out.println("= Total books in the library: " + this.totalBook + " =");
		System.out.println("= Total books loaned: " + this.totalLoan + " =");
		System.out.println("= Total books in the library and loaned: " + this.sumTotalBookLoan + " =");
		System.out.println("= Book historial of loans: " + this.sumTotalLoan + " =");
	}
	public void showLessInfo() {
		System.out.println("===== LESS INFO =====");
		System.out.println("Title: " + this.title);
		System.out.println("Author: " + this.author);
		System.out.println("ISBN: " + this.ISBN);
	}
}
