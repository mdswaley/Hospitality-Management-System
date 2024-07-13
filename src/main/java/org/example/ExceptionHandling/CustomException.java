package org.example.ExceptionHandling;

import java.util.ArrayList;

public class CustomException {
    public static void main(String[] args) {
        try{
            int num = 17;
            validate(num);
            validateNum(num);
            System.out.println("Student validate now you can access our website.");
        }catch (AgeTooYoung e){
            System.out.println("AgeTooYoung caught : "+e.getMessage());
        }catch (OddNumException e){
            System.out.println("OddNumException caught : "+e.getMessage());
        }

    }
    public static void validate(int age) throws AgeTooYoung{
        if (age < 15){
            throw new AgeTooYoung("Student is too young must be greater than 15 to access our website.");
        }
    }
    public static void validateNum(int num) throws OddNumException{
        if (num % 2 == 1){
            throw new OddNumException("Number is odd");
        }
    }
}

class AgeTooYoung extends Exception{
    public AgeTooYoung(String msg){
        super(msg);
    }
}
class OddNumException extends Exception{
    public OddNumException(String msg){
        super(msg);
    }
}
