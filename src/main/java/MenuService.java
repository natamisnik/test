import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;

public class MenuService {
    BufferedReader consoleRead = new BufferedReader(new InputStreamReader(System.in));
    Scanner newscanner = new Scanner(System.in);
    public String StartMenu() throws IOException {

        System.out.println("\n"+
                "**********Menu********\n" +
                "Please select an aсtion\n" +
                "1. See all books by a specific author.\n" +
                "2. See all books published in a specific year.\n" +
                "3. Exit Menu.");
        BufferedReader consoleRead = new BufferedReader(new InputStreamReader(System.in));
        Scanner newscanner = new Scanner(System.in);
        String line = consoleRead.readLine();
        boolean check = true;
        while (check) {
         for (int i = 0; i < line.length(); i++) {
                char symbol = line.charAt(i);
                if (symbol > 51 || symbol < 49) {
                    System.out.println("Please select 1 or 3");
                    String newline = consoleRead.readLine();
                    line = newline;
                }
                else {
                    check = false;;
                    }
         }
        }
        return line;
        }
    public String menuPiont1 () throws IOException {
        System.out.println("You have selected 1. See all books by a specific author\n" +
                "Please enter author lastname");
        String lastname = consoleRead.readLine();
        System.out.println("Please enter author firstname");
        String firstname = consoleRead.readLine();
        System.out.println("We are looking for books from " + firstname + " " + lastname + "...\n");
        String query = "select * from books where lastname like '" + lastname + "' and firstname like '" + firstname + "'order by bookname";
        return query;
    }
    public String menuPiont2 () throws IOException {
        System.out.println("You have selected See all books published in a specific year.\n" +
                "Please enter year");
        String enter = consoleRead.readLine();
        int year = Integer.parseInt(enter);
        System.out.println("We are looking for books published in year " + year + "...\n");
        String query = "select * from books where year=" + year + " order by bookname";
        return query;
    }


    }
