package com.company;

import java.io.*;
import java.util.*;

public class CountryManager {
    List<Country> countryList = new ArrayList<>();

    public void addCountry(Country country){
        countryList.add(country);
    }

    public void writeAllCountries(){
        for (int i = 0; i <countryList.size();i++){
            System.out.println(countryList.get(i));
        }
    }
    public void writeCountriesInFormat(){
        writeCountriesInFormat(null,null, false,false);
    }

    public void writeCountriesInFormat(List<Country> contriesList,List<Country> contriesList2, Boolean sort, Boolean saveToFile){
        String textSaveToFile="";
        if (contriesList==null){
            contriesList = countryList;
        }
        if(sort){

            contriesList.sort(Comparator.comparingDouble(Country::getFullVat).reversed());
            //contriesList.reverse(contriesList);
            //contriesList.sort((o1, o2) -> Double.compare(o1.getFullVat(), o2.getFullVat()));
        }
        for (int i = 0 ; i < contriesList.size();i++){
            System.out.println(contriesList.get(i).getState()+" ("+contriesList.get(i).shortState + "): " + contriesList.get(i).fullVat + " %");
            textSaveToFile+=contriesList.get(i).getState()+" ("+contriesList.get(i).shortState + "): " + contriesList.get(i).fullVat + " %\n";
        }
        if(contriesList2 != null){
            System.out.println("====================");
            System.out.print("Sazba VAT 20 % nebo nižší nebo používají speciální sazbu: ");
            textSaveToFile+="====================\n" + "Sazba VAT 20 % nebo nižší nebo používají speciální sazbu: ";
            for (int i = 0 ; i < contriesList2.size();i++){
                System.out.print(contriesList2.get(i).shortState+", ");
                textSaveToFile+=contriesList2.get(i).shortState+", ";
            }
        }
        if(saveToFile){
            printoutSaveToFile(textSaveToFile+="\n");
        }
    }

    public List<Country> getCountryListWithVatMoreLike(int vat){
        List<Country> vatIsHigherThan = new ArrayList<>();
        for (int i = 0; i< countryList.size();i++){
            if(countryList.get(i).fullVat > vat && !countryList.get(i).specialVat){
                vatIsHigherThan.add(countryList.get(i));
            }
        }
        return vatIsHigherThan;
    }

    public List<Country> getCountryListWithVatLessLikeIncluding(int vat){
        List<Country> vatIsLessThan = new ArrayList<>();
        for (int i = 0; i< countryList.size();i++){
            if(countryList.get(i).fullVat <= vat || countryList.get(i).specialVat){
                vatIsLessThan.add(countryList.get(i));
            }
        }
        return vatIsLessThan;
    }

    public void printoutSaveToFile(String message) {
        //PrintWriter out = null;

        try {
            PrintWriter out = new PrintWriter(new FileWriter("vat-over-20.txt", true), true);
            out.write(message);
            out.close();
        } catch (IOException e) {
            e.printStackTrace();
            System.out.println("Unable to write to file.");
        }

    }



    public void readFromFile(String filename, String delimiter){
        try {
            Scanner scanner = new Scanner(new BufferedReader(new FileReader(filename)));
            int counter = 0;
            while (scanner.hasNextLine()) {
                String inputLine = scanner.nextLine();
                String[] parts = inputLine.split(delimiter);
                counter++;
                // System.out.println(Arrays.toString(parts));
                // puts values from file into variables
                try {
                    String shortState = String.valueOf(parts[0]);
                    String state = String.valueOf(parts[1]);
                    double fullVat = Double.parseDouble(parts[2].replace(",","."));
                    double reducedVat = Double.parseDouble(parts[3].replace(",","."));
                    boolean specialVat = Boolean.parseBoolean(parts[4].replace(",","."));

                    addCountry(new Country(shortState,state,fullVat,reducedVat,specialVat));

                    /*String name = String.valueOf(parts[0]); //String notes = parts[1];
                    String notes = String.valueOf(parts[1]);
                    //int frequencyOfWatering = wateringFormater(String.valueOf(parts[2]));
                    int frequencyOfWatering = Integer.parseInt(parts[2]);
                    LocalDate watering = dateFormater(String.valueOf(parts[3]));
                    LocalDate planted = dateFormater(String.valueOf(parts[4]));
                    // add to list
                    addPlant(new Plants(name, notes, planted, watering, frequencyOfWatering));*/

                } catch (java.lang.RuntimeException e) {
                    //System.out.println("From file " + filename + " cannot read line " + counter);
                }

            }

        } catch (FileNotFoundException e) {
            e.printStackTrace();
            System.out.println("The file was not loaded!");
        }
    }
}
