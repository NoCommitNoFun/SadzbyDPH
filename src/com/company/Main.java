package com.company;

public class Main {

    public static final String INPUT_FILENAME = "C:\\Users\\an079167\\IdeaProjects\\FistProject_Sazby_DPH\\tax.csv";
    public static final String DELIMITER = "\t";
    public static void main(String[] args) {

        CountryManager country = new CountryManager();
        //1. Načti ze souboru všechna data do vhodné datové struktury (vytvoř třídu pro uložení dat).
        country.readFromFile(INPUT_FILENAME,DELIMITER);
        //2. Vypiš seznam všech států a u každého uveď základní sazbu daně z přidané hodnoty ve formátu podle vzoru:
        System.out.println("\n2. Vypiš seznam všech států a u každého uveď základní sazbu daně z přidané hodnoty ve formátu podle vzoru:");
        country.writeCountriesInFormat();
        //3. Vypište ve stejném formátu pouze státy, které mají základní sazbu daně z přidané hodnoty vyšší než 20 % a přitom nepoužívají speciální sazbu daně.
        System.out.println("\n3. Vypište ve stejném formátu pouze státy, které mají základní sazbu daně z přidané hodnoty vyšší než 20 % a přitom nepoužívají speciální sazbu daně.");
        country.writeCountriesInFormat(country.getCountryListWithVatMoreLike(20),null,false,false);
        //4. Výpis z bodu 3. seřaď podle výše základní sazby DPH/VAT sestupně (nejprve státy s nejvyšší sazbou).
        System.out.println("\n4. Výpis z bodu 3. seřaď podle výše základní sazby DPH/VAT sestupně (nejprve státy s nejvyšší sazbou).");
        country.writeCountriesInFormat(country.getCountryListWithVatMoreLike(20),null,true,false);
        //5. Pod výpis z bodu 3. doplň řádek s rovnítky pro oddělení a poté seznam zkratek států, které ve výpisu nefigurují. Opět dodrž formát podle vzoru (místo tří teček budou další státy):
        System.out.println("\n5. Pod výpis z bodu 3. doplň řádek s rovnítky pro oddělení a poté seznam zkratek států, které ve výpisu nefigurují. Opět dodrž formát podle vzoru (místo tří teček budou další státy):");
        country.writeCountriesInFormat(country.getCountryListWithVatMoreLike(20),country.getCountryListWithVatLessLikeIncluding(20),true,false);
        //6. Výsledný výpis zapiš také do souboru s názvem vat-over-20.txt. Výstupní soubor ulož do stejné složky, ve které byl vstupní soubor. (Výpis na obrazovku zůstává.)
        System.out.println("\n6. Výsledný výpis zapiš také do souboru s názvem vat-over-20.txt. Výstupní soubor ulož do stejné složky, ve které byl vstupní soubor. (Výpis na obrazovku zůstává.)");
        country.writeCountriesInFormat(country.getCountryListWithVatMoreLike(20),country.getCountryListWithVatLessLikeIncluding(20),true,true);



    }
}
