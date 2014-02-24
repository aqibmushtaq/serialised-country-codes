package main;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by aqib on 23/02/14.
 */
public class ReadCountryFile {

    public static void main (String[] args) {
        try {
            ObjectInput in = new ObjectInputStream(new BufferedInputStream(new FileInputStream("country-list.ser")));
            List<Country> countries = new ArrayList<Country>();
            System.out.printf("in.available(): %d\n", in.available());
            if (in.available() > 0)
                countries = (List<Country>) in.readObject();
            in.close();
            System.out.printf("Country list size %d\n", countries.size());
        } catch (IOException e) {
            e.printStackTrace();
            System.exit(1);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
            System.exit(1);
        }
    }

}
