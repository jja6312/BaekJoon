import java.util.Scanner;
public class Main{
    public static void main(String[]args){
        Scanner s = new Scanner(System.in);
        String N = s.nextLine();
        String [] arr = N.split(" ");
        String A = arr[0];
        String B = arr[1];

        char[] a = new char[3];
        char[] b = new char[3];
        for(int i=0; i<3; i++){
           a[2-i] = A.charAt(i);
           b[2-i] = B.charAt(i);
        }
        
        String aString="";
        String bString="";
        //-------------------------
        for(int i=0; i<3; i++){
            aString += Character.toString(a[i]);
            bString += Character.toString(b[i]);
        }
        
        int aInt = Integer.valueOf(aString);
        int bInt = Integer.valueOf(bString);
        
        if(aInt>bInt) System.out.println(aInt);
        else if(bInt>aInt) System.out.println(bInt);;

    }
}