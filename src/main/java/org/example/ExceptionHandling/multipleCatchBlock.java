package org.example.ExceptionHandling;

public class multipleCatchBlock {
    public static void main(String[] args) {
        int[] num = {10,20,30};

        try{
//            int res = num[3]/5;
            int res2 = num[2]/0;
//            System.out.println(res);
            System.out.println(res2);
//            Unchecked Exception
        }catch (ArrayIndexOutOfBoundsException e){
            System.out.println("ArrayIndexOutOfBoundsException is caught : "+e.getMessage());
            //e.getMessage():-means what exception is occurred(ArrayIndexOutOfBoundsException) that related message show.
        }catch (ArithmeticException e){
            System.out.println("ArithmeticException is caught : "+e.getMessage());
        }catch (Exception e){
            System.out.println("Exception is caught : "+e.getMessage());
        }finally {
            System.out.println("Execute finally.");
        }


    }
}
