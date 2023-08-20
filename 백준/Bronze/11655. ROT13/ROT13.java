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
        String A =  br.readLine();
        int aaa = (int)'a';
        int zzz = (int)'z';
        int AAA = (int)'A';
        int ZZZ = (int)'Z';
        StringBuilder sb = new StringBuilder();
        for(int i=0; i<A.length(); i++){
            
            if( ((int)A.charAt(i)>=aaa) && ((int)A.charAt(i)<=zzz) ){
                char result = (char)(((int)A.charAt(i)-'a' + 13)%26+(int)'a');
                sb.append(result);
            }else if ( ((int)A.charAt(i)>=AAA) && ((int)A.charAt(i)<=ZZZ) ){
                char result = (char)(((int)A.charAt(i)-'A' + 13)%26+(int)'A');
                sb.append(result);
            }else if(A.charAt(i)==' '){
                sb.append(' ');
            }else{
                sb.append(A.charAt(i));
            }
        }//for
        bw.write(sb.toString());

    }//read()
}//Main