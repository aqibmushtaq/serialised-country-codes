package main;

import java.io.Serializable;

public class Country implements Comparable<Country>, Serializable {

    private String twoLetterCode;
    private String threeLetterCode;
    private String fullCountry;

    public Country (String country) {
        if (country.length() == 2)
            twoLetterCode = country;
        else if (country.length() == 3)
            threeLetterCode = country;
        else
            fullCountry = country;
    }

    public Country (String two, String three, String full) {
        twoLetterCode = two;
        threeLetterCode = three;
        fullCountry = full;
    }

    @Override
    public int compareTo (Country c) {
        if (c.twoLetterCode != null && twoLetterCode == c.twoLetterCode)
            return 0;
        else if (c.threeLetterCode != null && threeLetterCode == c.threeLetterCode)
            return 0;
        else if (c.fullCountry != null && fullCountry == c.fullCountry)
            return 0;

        return -1;
    }

    @Override
    public boolean equals (Object c) {
        return compareTo((Country)c) == 0;
    }

    @Override
    public String toString () {
        return String.format("%s => %s / %s", fullCountry, twoLetterCode, threeLetterCode);
    }
}
