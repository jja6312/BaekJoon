import java.util.*;
import java.io.*;

public class Main{
    public static void main(String[]args) throws IOException{
    	
    	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int a = Integer.valueOf(br.readLine());
        int b = Integer.valueOf(br.readLine());
        int c = Integer.valueOf(br.readLine());
        
        if(a==60 && b==60 && c==60){
            bw.write("Equilateral");
        }else if(a+b+c==180 && (a==b||a==c||b==c)){
            bw.write("Isosceles");
        }else if(a+b+c==180 && a!=b && b!=c && a!=c){
            bw.write("Scalene");
        }else if(a+b+c!=180){
            bw.write("Error");
        }
        bw.flush();
        bw.close();
        br.close();
        
       
        
    }//main()
}//Main
/*
세 각의 크기가 모두 60이면, Equilateral
세 각의 합이 180이고, 두 각이 같은 경우에는 Isosceles
세 각의 합이 180이고, 같은 각이 없는 경우에는 Scalene
세 각의 합이 180이 아닌 경우에는 Error
*/