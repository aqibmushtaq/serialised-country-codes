package main;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by aqib on 23/02/14.
 */
public class WriteCountryList {

    public static void main (String[] args) {


        //Read the CSV file
        List<Country> countries = new ArrayList<Country>();
        try {
            BufferedReader in = new BufferedReader(new FileReader("country-list.txt"));
            int count = 0;
            while(in.ready()) {
                String[] items = in.readLine().trim().split(",");
                countries.add(new Country(items[0], items[1], items[2]));
                System.out.printf("Added country: [%s, %s, %s]\n", items[0], items[1], items[2]);
                count++;
            }
            System.out.printf("Added %d countries\n", count);
            in.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
            System.exit(1);
        } catch (IOException e) {
            e.printStackTrace();
            System.exit(1);
        }

        //Write countries list as a serialized file
        try {
            ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream("country-list.ser"));
            out.writeObject(countries);
            out.close();
            System.out.println("Done writing country-list.ser");
        } catch (IOException e) {
            e.printStackTrace();
            System.exit(1);
        }

    }

}
