package Objects;
import Control.Library;
import Control.LibraryCompany;
import java.util.*;
public class Menu {
	private LibraryCompany lbc = new LibraryCompany();
	
	public void menu() {
		Scanner sc = new Scanner(System.in);
		int opc = 0;
		while(opc != 3) {
			mainMenu();
			opc = sc.nextInt();
			System.out.println();
			switch(opc) {
				case 1:
					opc = 0;
					if(pswMenu()) {
						while(opc != 5) {
						adminMenu();
						opc = sc.nextInt();
						System.out.println();
						switch(opc) {
							case 1:
								lbc.addLibrary();
								break;
							case 2:
								lbc.add_deleteBook();
								break;
							case 3:
								lbc.libraryStats();
								break;
							case 4:
								lbc.LibraryCompanyStats();
								break;
							case 5:
								break;
							default:
								System.out.println("Enter a valid option! Please try again");
								break;
							}
						}
					}
					break;
				case 2:
					opc = 0;
					while(opc != 5) {
						userMenu();
						opc = sc.nextInt();
						System.out.println();
						switch(opc) {
							case 1:
								lbc.searchBook();
								break;
							case 2:
								lbc.searchLibrary();
								break;
							case 3:
								lbc.bookBook();
								break;
							case 4:
								lbc.returnBook_Library();
							case 5:
								break;
							default:
								System.out.println("Enter a valid option! Please try again");
								break;
						}
					}
				case 3:
					break;
				default:
					System.out.println("Enter a valid option! Please try again");
					break;
			}
		}
	}
	public boolean pswMenu() {
		Scanner sc = new Scanner(System.in);
		System.out.print("Enter your username: ");
		String username = sc.nextLine();
		System.out.print("Enter your password: ");
		String psw = sc.nextLine();
		if (username.equals("admin") && psw.equals("12345678")) {
			return true;
		} else {
			return false;
		}
	}
	public void userMenu() {
		System.out.println("================");
		System.out.println(" User Menu ");
		System.out.println("================");
		System.out.println(" 1) Search book ");
		System.out.println(" 2) Search library");
		System.out.println(" 3) Loan book ");
		System.out.println(" 4) Return book ");
		System.out.println(" 5) Exit ");
		System.out.println("================");
		System.out.println("Enter your option:");
	}
	public void mainMenu() {
		System.out.println("===============");
		System.out.println(" 1) Staff Menu");
		System.out.println(" 2) User Menu");
		System.out.println(" 3) Exit");
		System.out.println("===============");
		System.out.println("Enter your option:");
	}
	public void adminMenu() {
		System.out.println("===============");
		System.out.println(" Staff Menu");
		System.out.println("===============");
		System.out.println(" 1) Add library");
		System.out.println(" 2) Add or delete book to/from library");
		System.out.println(" 3) View statistics from a library");
		System.out.println(" 4) View statistics from the net");
		System.out.println(" 5) Exit");
		System.out.println("===============");
		System.out.println("Enter your option:");
	}
	public LibraryCompany getLbc() {
		return lbc;
	}
	public void setLbc(LibraryCompany lbc) {
		this.lbc = lbc;
	}
}
