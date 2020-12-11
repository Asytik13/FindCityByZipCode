package com.company;

import java.util.List;
import java.util.Map;

interface MapContract {
    Map<String, List<String>> initializeCodeCityMap(String[] csvRow);

    void updateListOfCities(String zipCode, String currentCityName);

    void addNewZipCityPair(List<String> cityNames, String zipCode, String currentCityName);
}

