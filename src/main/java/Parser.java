import com.google.gson.Gson;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileReader;
import java.io.InputStreamReader;

public class Parser {

    public Author parse() {

        Gson gson = new Gson();

        try (FileReader reader = new FileReader("LTolstoy.json")) {
            Author a1 = gson.fromJson(reader, Author.class);
            return a1;


        } catch (Exception e) {
            System.out.println("Parsing error " + e.toString());
        }

        return null;
    }

    public Author parseJson(String file) {

        Gson gson = new Gson();

        try (BufferedReader reader = new BufferedReader(new InputStreamReader(new FileInputStream(file)))) {
            Author a1 = gson.fromJson(reader, Author.class);

            return a1;


        } catch (Exception e) {
            System.out.println("Parsing error " + e.toString());
        }

        return null;
    }

}
