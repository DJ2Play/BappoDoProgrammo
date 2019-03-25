package Control;
import java.util.*;
import Objects.*;
import Control.*;
import Execute.*;
public class LibraryCompany {
	private ArrayList<Person> staffList;
	private ArrayList<Book> bookList = new ArrayList<Book>();
	private ArrayList<Library> libraryList;
	public LibraryCompany() {
		libraryList = new ArrayList<Library>();
	}
	
	public ArrayList<Library> getLibraryList() {
		return libraryList;
	}

	public void setLibraryList(ArrayList<Library> libraryList) {
		this.libraryList = libraryList;
	}
	public void addLibrary() { // crear una biblioteca dins la xarxa
		Scanner sc = new Scanner(System.in);
		System.out.println("= Create Library =");
		System.out.println("Please, enter the Library ID");
		int ID = sc.nextInt();
		String name = null;
		String adress = null;
		for (int i = 0; i < this.libraryList.size(); i++) {
			if (this.libraryList.get(i).getId() == ID) {
				System.out.println("This library already exists on the database");
				break;
			} else {
				System.out.println("Enter the name of the library");
				name = sc.nextLine().toUpperCase();
				System.out.println("Enter the adress of the library");
				adress = sc.nextLine().toUpperCase();
				staffList = new ArrayList<Person>();
				Library lib = new Library(ID,name,adress,bookList,staffList);
				break;
			}
		}
		int input = 0;
		while(input != 2) {
			System.out.println("1) Add new staff");
			System.out.println("2) Exit");
			System.out.println("================");
			input = sc.nextInt();

			switch (input) {
			case 1:
				System.out.print("Enter the DNI: ");
				String dni = sc.nextLine().toUpperCase();
				System.out.print("Enter the name: ");
				String stName = sc.nextLine().toUpperCase();
				System.out.print("Enter the employment: ");
				String employment = sc.nextLine().toUpperCase();
				Person prs = new Person(dni,stName,employment);
				staffList.add(prs);
				break;
			case 2:
				break;
			default:
				System.out.println("That option is not available!");
				break;
			}
		}
		Library bbt = new Library(ID,name,adress,bookList,staffList);
		libraryList.add(bbt);
	}
	public void add_deleteBook() {
		Scanner sc = new Scanner(System.in);
		int index = 0;
		boolean exists = false;
		int totalBook;
		int opc = 0;
		String ISBN = null;
		String title = null;
		String author = null;
		System.out.print("Enter the library's ID:");
		int ID = sc.nextInt();
		while(opc != 3) {
			System.out.println("1) Add Book");
			System.out.println("2) Delete Book");
			System.out.println("3) Exit");
			opc = sc.nextInt();
			switch(opc) {
				case 1:
					for (int i = 0; i < this.libraryList.size(); i++) { // comprovar que existeix la biblioteca
						if (this.libraryList.get(i).getId() == ID) {
							exists = true;
							index = i;
						} else {
							System.out.println("The library with ID " + ID + " does not exist");
							break;
						}
					}
					System.out.print("Enter the ISBN of the book:");
					ISBN = sc.nextLine().toUpperCase();
					for (int j = 0; j < this.libraryList.size(); j++) { // comprovar si existeix ja el llibre (segons ISBN)
						if(this.libraryList.get(index).getBookList().get(j).getISBN().equals(ISBN));
						exists = false;
					}
					if (exists) { // si existeix la biblioteca...crear llibre
						System.out.println("Enter the title of the book:");
						title = sc.nextLine().toUpperCase();
						System.out.println("Enter the author of this book:");
						author = sc.nextLine().toUpperCase();
						System.out.println("Enter how many books do we have:");
						totalBook = sc.nextInt();
						Book b = new Book(title,author,ISBN,totalBook,0,totalBook,0);
						this.libraryList.get(index).addBook(b);
					} else {
						System.out.println("This book already exists in this library");
					}
					break;
				case 2:
					for (int i = 0; i < this.libraryList.size(); i++) {
						if (this.libraryList.get(i).getId() == ID) {
							System.out.print("Enter the ISBN of the book you want to delete: ");
							ISBN = sc.nextLine();
							for (int j = 0; j < this.libraryList.get(j).getBookList().size(); j++) { // comprovar que el llibre existeix dins la biblioteca
								if (this.libraryList.get(j).getBookList().get(j).getISBN().equals(ISBN)) {
									this.libraryList.get(j).removeBook(j);
									exists = true;
									break;
								}
							}
						} else {
							System.out.println("This library with ID " + ID + " does not exist");
							break;
						}
					if (!exists) {
						System.out.println("The book with ISBN " + ISBN + " does not exist in this library");
						break;
					}
				}
					break;
				case 3:
					break;
				default:
					System.out.println("Enter a valid option! Please try again.");
			}
		} 
	}
	public void libraryStats() {
		Scanner sc = new Scanner(System.in);
		System.out.print("Enter the library's ID: ");
		boolean exists = false;
		int index = 0;
		int id = sc.nextInt();
		for (int i = 0; i < this.libraryList.size(); i++) {
			if (this.libraryList.get(i).getId() == id) {
				exists = true;
				index = i;
			}
		}
		if (exists) {
			this.libraryList.get(index).libraryStats();
		} else {
			System.out.println("This library does not exist");
		}
	}
	public void LibraryCompanyStats() {
		for (int i = 0; i < this.libraryList.size(); i++) {
			System.out.println(this.libraryList.get(i).getLibraryName());
			System.out.println("Total books that are now loaned: " + this.libraryList.get(i).getTotalLoan());
			System.out.println("Sum of all books in all libraries: " + this.libraryList.get(i).getSumTotalBookLoan());
			System.out.println("Total history of loaned books: "+this.libraryList.get(i).getSumTotalLoan());
			System.out.println("Staff: "+this.libraryList.get(i).getStaffList().size()+" employees.");
			System.out.println("===============================================");
		}
	}
	public void searchBook() {
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter an ISBN:");
		int index = 0;
		int index2 = 0;
		String ISBN = sc.nextLine().toUpperCase();
		ArrayList<Integer> aux = new ArrayList<Integer>();
		for (int i = 0; i < this.libraryList.size(); i++) {
			for (int j = 0; j < this.libraryList.get(i).getBookList().size(); j++) {
				if (this.libraryList.get(i).getBookList().get(j).getISBN().equals(ISBN)) {
					aux.add(i);
					index = i;
					index2 = j;
				}
			}
		}
		if(aux.size() > 0) {
			this.libraryList.get(index).getBookList().get(index2).showLessInfo();
			System.out.println(" Books are located in ");
			for (int i = 0; i < aux.size(); i++) {
				System.out.println(this.libraryList.get(i).getLibraryName());
			}
		}
	}
	public void searchLibrary() {
		int index = 0;
		int index2 = 0;
		boolean exists = false;
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter an ISBN:");
		String ISBN = sc.nextLine().toUpperCase();
		System.out.println("Enter the ID of the library:");
		int ID = sc.nextInt();
		for (int i = 0; i < this.libraryList.size(); i++) {
			for (int j = 0; j < this.libraryList.get(i).getBookList().size(); j++) {
				if (this.libraryList.get(i).getId() == ID && this.libraryList.get(i).getBookList().get(j).getISBN().equals(ISBN)) {
					exists = true;
					index = i;
					index2 = j;
				}
			}
		}
		if (exists) {
			this.libraryList.get(index).getBookList().get(index2).showInfo();
		}
	}
	public void bookBook() {
		Scanner sc = new Scanner(System.in);
		int total = 0;
		int totalAfter = 0;
		System.out.println("Enter the ID from the library where are you looking for:");
		int ID = sc.nextInt();
		System.out.println("Enter the ISBN from the book you want to book:");
		String ISBN = sc.nextLine().toUpperCase();
		for (int i = 0; i < this.libraryList.size(); i++) {
			for (int j = 0; j < this.libraryList.get(i).getBookList().size(); j++) {
				if (this.libraryList.get(i).getId() == ID && this.libraryList.get(i).getBookList().get(j).getISBN().equals(ISBN)) {
					if (this.libraryList.get(i).getBookList().get(j).getTotalBook() > 0) {
						total = this.libraryList.get(i).getBookList().get(j).getTotalBook();
						this.libraryList.get(i).getBookList().get(j).loanBook();
						totalAfter = this.libraryList.get(i).getBookList().get(j).getTotalBook();
						if (totalAfter == total) {
							System.out.println("The ISBN from the book has not been successfully found. Please come back later!");
							break;
						}
						System.err.println("The book has been successfully loaned.");
						System.out.println("Please return it back in a period of 15 days.");
						System.out.println("If you want to return it in a period of more than 15 days, please contact to our staff.");
						System.out.println("Thanks! And read safe");
						break;
					} else {
						System.out.println("There are no books of this ISBN. Please come back later!");
						break;
					}
				}
			}
		}
	}
		public void returnBook_Library() {
			Scanner sc = new Scanner(System.in);
			int total = 0;
			int totalAfter = 0;
			System.out.println("= Return Book =");
			System.out.println("Please, enter the ID of the library:");
			int ID = sc.nextInt();
			System.out.println("Please, enter the ISBN of the book:");
			String ISBN = sc.nextLine().toUpperCase();
			for (int i = 0; i < this.libraryList.size(); i++) {
				for (int j = 0; j < this.libraryList.get(i).getBookList().size(); j++) {
					if (this.libraryList.get(i).getId() == ID && this.libraryList.get(i).getBookList().get(j).getISBN().equals(ISBN)) {
						if(this.libraryList.get(i).getBookList().get(j).getSumTotalLoan() > 0) {
						total = this.libraryList.get(i).getBookList().get(j).getTotalBook();
						this.libraryList.get(i).getBookList().get(j).returnBook();
						totalAfter = this.libraryList.get(i).getBookList().get(j).getTotalBook();
						if (totalAfter == total) {
							System.out.println("This book has not been successfully found. Please come back later!");
							break;
						}
						System.err.println("The book has been successfully returned.");
						System.out.println("Thanks! And read safe");
						break;
						} else {
							System.out.println("There's no book to return with this ISBN");
						}
					}	
				}
			}
			
	}
}