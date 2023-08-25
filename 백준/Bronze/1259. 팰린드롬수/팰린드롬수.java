import java.util.*;
import java.io.*;

public class Main{
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    public static void main(String[]args) throws IOException{
        read();
        bw.flush();
        bw.close();
        br.close();

    }//main()

    public static void read() throws IOException{
        String A="";
        while(!(A= br.readLine()).equals("0")){
            boolean trueSwitch = true;
            for(int i=0; i<A.length(); i++){
                if(A.charAt(i)==A.charAt(A.length()-1-i)){
                    continue;
                }else{
                    trueSwitch = false;
                }
            }//for
            if(trueSwitch==true){
            	bw.write("yes\n");
            }else{
            	bw.write("no\n");
            }
        }//while
        
    }//read()
}//Main