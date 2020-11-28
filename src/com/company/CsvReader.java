package com.company;

import java.io.FileReader;
import java.io.IOException;
import au.com.bytecode.opencsv.CSVReader;

public class CsvReader {

    CsvMapper mapper = new CsvMapper();

    public CsvMapper readFile(){
        CSVReader reader = null;
        try {
            //Get the CSVReader instance with specifying the delimiter to be used
            reader = new CSVReader(new FileReader("/Users/olga/Downloads/us-zip-codes.csv"), ';');

            String[] nextLine;

            //Read one line at a time
            while (( nextLine = reader.readNext() ) != null) {
                mapper.addData(nextLine);
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                reader.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return mapper;
    }
}
