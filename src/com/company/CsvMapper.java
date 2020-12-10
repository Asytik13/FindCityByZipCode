package com.company;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class CsvMapper implements MapContract{

    Map<String, List<String>> citiesData = new HashMap<>();

    public Map<String, List<String>> initializeCodeCityMap(String[] csvRow){
;
        int zipCodeIndex = 0;
        int currentCityIndex = 2;

        String zipCode = csvRow[zipCodeIndex];
        String currentCityName = csvRow[currentCityIndex];

        List<String> cityNames = new ArrayList<>();

        if ( citiesData.containsKey(zipCode) ) {
            updateListOfCities(zipCode, currentCityName);
        } else {
            addNewZipCityPair(cityNames, zipCode, currentCityName);
        }
        return citiesData;
    }

     public void updateListOfCities(String zipCode, String currentCityName){
        getCitiesFromMap(citiesData, zipCode).add(currentCityName);
    }

    private List<String> getCitiesFromMap(Map<String, List<String>> citiesData, String zipCode){
        return citiesData.entrySet().stream()
                .filter(e -> e.getKey().equals(zipCode))
                .map(Map.Entry::getValue)
                .findAny()
                .orElse(new ArrayList<>());
    }

    public void addNewZipCityPair(List<String> cityNames, String zipCode, String currentCityName){
        cityNames.add(currentCityName);
        citiesData.put(zipCode, cityNames);
    }

    public List<String> getCityByCode(String code){
        return getCitiesFromMap(citiesData, code);
    }
}

