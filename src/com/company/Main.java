package com.company;

public class Main {

    public static void main(String[] args){
        CsvReader reader = new CsvReader();
        UserInputReader input = new UserInputReader();

        CsvMapper map = reader.readFile();
        String providedCode = input.getInput();

        System.out.println(map.getCityByCode(providedCode));
    }
}
