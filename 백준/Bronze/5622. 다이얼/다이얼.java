import java.util.Scanner;

public class Main{
    public static void main(String [] args){
        Scanner s = new Scanner(System.in);
        String F = s.nextLine();
        char [] arr = new char[F.length()];
        Integer []arrInt = new Integer[F.length()];
        int sum=0;
        
        for(int i=0; i<F.length(); i++){
            arr[i]= F.charAt(i);
            int castASCII = (int)arr[i];
            if(castASCII>=65&&castASCII<=67) arrInt[i]=3;
            else if(castASCII>=68&&castASCII<=70) arrInt[i]=4;
            else if(castASCII>=71&&castASCII<=73) arrInt[i]=5;
            else if(castASCII>=74&&castASCII<=76) arrInt[i]=6;
            else if(castASCII>=77&&castASCII<=79) arrInt[i]=7;
            else if(castASCII>=80&&castASCII<=83) arrInt[i]=8;
            else if(castASCII>=84&&castASCII<=86) arrInt[i]=9;
            else if(castASCII>=87&&castASCII<=90) arrInt[i]=10;
            
        }
        
        
        for(int i=0; i<arrInt.length; i++){
            sum+=arrInt[i];
        }
        System.out.println(sum);
        
    }
}