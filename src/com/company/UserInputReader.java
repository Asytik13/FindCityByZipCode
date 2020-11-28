package com.company;

import java.util.Scanner;

public class UserInputReader {

    public String getInput(){
        Scanner in = new Scanner(System.in);
        while(true){
            System.out.print("Please provide zip code: ");
            String code = in.nextLine();

            boolean isValid = VerifyInput(code);

            if (isValid) {
                return code;
            }
            else{
                getInput();
            }
        }
    }

  public boolean VerifyInput(String s){
       if(s.length() > 5 || s.length() == 0){
           System.out.println("Your code is too long");
           return false;
       }
       try{
          Long.parseLong(s);
           return true;
       }
       catch(NumberFormatException e){
           System.out.println("Your code is not valid");
       }
       return false;
    }

}
