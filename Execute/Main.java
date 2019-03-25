package Execute;
import Objects.*;
import Control.*;
import java.util.*;
public class Main {

	public static void main(String[] args) {
		ArrayList<Book> bookList = new ArrayList<Book>();
		ArrayList<Person> staffList = new ArrayList<Person>();
		Person p = new Person("y0955267e", "Djavan Hinrichs", null);
		staffList.add(p);
		Book b1 = new Book("Las memorias de Idhun", "Laura Gallego", "1234", 30, 40, 26, 8);
		Book b2 = new Book("Lord of the Rings", "Tolkien", "12345", 12, 0, 0, 0);
		bookList.add(b1);
		bookList.add(b2);
		Library l1 = new Library(123, "Lib1", "Adress1", bookList, staffList);
		Library l2 = new Library(234, "Lib2", "Adress2", bookList, staffList);
		Menu m = new Menu();
		m.getLbc().getLibraryList().add(l1);
		m.getLbc().getLibraryList().add(l2);
		m.menu();
	}
}
