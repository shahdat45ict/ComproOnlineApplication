package mum.compro.countrylist;

import java.text.Collator;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Locale;
 
public class CountryList {
    //public static void main(String[] args) {
    public static List<String> getAllCountry() {
        //
        // A collection to store our country object
        //
        List<Country> countries = new ArrayList<Country>();
        List<String> countryList = new ArrayList<String>();
        //
        // Get ISO countries, create Country object and
        // store in the collection.
        //
        String[] isoCountries = Locale.getISOCountries();
        for (String country : isoCountries) {
            Locale locale = new Locale("en", country);
            String iso = locale.getISO3Country();
            String code = locale.getCountry();
            String name = locale.getDisplayCountry();
 
            if (!"".equals(iso) && !"".equals(code)
                    && !"".equals(name)) {
                countries.add(new Country(iso, code, name));
            }
        }
 
        //
        // Sort the country by their name and then display the content
        // of countries collection object.
        //
        Collections.sort(countries, new CountryComparator());
 
        for (Country country : countries) {
        //    System.out.println(country);
        	countryList.add(country.getName());
        }
        
        return countryList;
    }
 
    /**
     * Country pojo class.
     */
    static class Country {
        private String iso;
        private String code;
        private String name;
 
        Country(String iso, String code, String name) {
            this.iso = iso;
            this.code = code;
            this.name = name;
        }
        
        public String getCode(){
        	return this.code;
        }
        
        public String getName(){
        	return this.name;
        }
        
        public String toString() {
            return iso + " - " + code + " - " + name.toUpperCase();
        }
    }
 
    /**
     * CountryComparator class.
     */
    static class CountryComparator implements Comparator<Country> {
        private Comparator comparator;
 
        CountryComparator() {
            comparator = Collator.getInstance();
        }
 
        @SuppressWarnings("unchecked")
        public int compare(Country c1, Country c2) {
            return comparator.compare(c1.name, c2.name);
        }
    }
}