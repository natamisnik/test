import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Main {
    public static void main(String[] args) throws IOException, SQLException, ClassNotFoundException {

        System.out.println("Insert the path to the file:  ");
//
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String fileName = reader.readLine();

        BufferedReader fileReader = new BufferedReader(new InputStreamReader(new FileInputStream(fileName)));
        Parser parser = new Parser();
        Author a1 = parser.parseJson(fileName);
        fileReader.close();
        DBService newconnection = new DBService();
        Connection connection = newconnection.getDBConnection();

        for (int i = 0; i < a1.getBooks().size(); i++) {
            String query = "Insert into books(firstname,lastname,bookname,year,genre) values ('"+a1.getFirstname() + "','"+ a1.getLastname()+ "',"+a1.getBooks().get(i)+")";
            Statement statement = connection.createStatement();
            statement.execute(query);
        }
        System.out.println("The data from the file has been successfully transferred to the library database");

        while(true){

        MenuService start = new MenuService();
        String line = start.StartMenu();
        int code = Integer.parseInt(line);
        if (code == 1) {
            MenuService point1 = new MenuService();
            String query = point1.menuPiont1();
            Statement statement = connection.createStatement();
            ResultSet resultset = statement.executeQuery(query);
            if(resultset.next()==false){

                System.out.println("******author was not found******\n");

            }

            while (resultset.next()) {
            String bookname = resultset.getString("bookname");
            System.out.println(bookname);
            }

        }
        if (code == 2) {
            MenuService point2 = new MenuService();
            String query = point2.menuPiont2();
            Statement statement = connection.createStatement();
            ResultSet resultset = statement.executeQuery(query);
            if(resultset.next()==false){

                System.out.println("******Year was not found******\n");
            }
            while (resultset.next()) {
                String bookname = resultset.getString("bookname");
                String firstname = resultset.getString("firstname");
                String lastname = resultset.getString("lastname");
                System.out.println(bookname + " author: " + firstname + " " + lastname);
            }
        }
            if (code == 3) {
                break;
            }


        }
//            System.out.println("You have selected 1. See all books by a specific author\n" +
//                    "Please enter author lastname");
//            String lastname = consoleReader.readLine();
//            System.out.println("Please enter author firstname");
//            String firstname = consoleReader.readLine();
//            System.out.println("We are looking forward to books from " + firstname + " " + lastname + "...");
//            String query = "select * from books where lastname like '" + lastname + "' and firstname like '" + firstname + "'order by bookname";
//            Statement statement = connection.createStatement();
//            ResultSet resultset = statement.executeQuery(query);
//            while (resultset.next()) {
//                String bookname = resultset.getString("bookname");
//                System.out.println(bookname);
//            }





//        String query = "Insert into books(firstname,lastname,bookname,year,genre) values ('Sergei','Dovlatov','Craft: A Story in Two Parts',1985,'novel')";
//            Statement statement = connection.createStatement();
//            statement.execute(query);


//        try {
//           Class.forName("com.mysql.jdbc.Driver");
//            Connection connection =DriverManager.getConnection(url,user,password);
//            System.out.println("Connection is successfull to the database" + url);
//            String query = "Insert into books(firstname,lastname,bookname,year,genre) values ('Sergei','Dovlatov','A Foreign Woman',1986,'novel')";
//            Statement statement = connection.createStatement();
//            statement.execute(query);
//        } catch (ClassNotFoundException e) {
//            e.printStackTrace();
//        } catch (SQLException throwables) {
//            throwables.printStackTrace();
//        }

            //Parser parser = new Parser();
            //Author a1 = parser.parse();


            //System.out.println(a1.toString());
            //+ a1.toString());
        }
    }

