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
        String A = br.readLine();
        /*소문자, 대문자, 숫자, 공백*/
        while(A!=null){
            int lower = 0;
            int upper = 0;
            int num = 0;
            int space = 0;
            for(int i=0; i<A.length(); i++){
                int aaa = (int)'a';
                int zzz = (int)'z';
                int AAA = (int)'A';
                int ZZZ = (int)'Z';
                if(A.charAt(i)==' '){
                    space++;
                }else if( ((int)A.charAt(i)>=AAA) && ((int)A.charAt(i)<=ZZZ) ){
                    upper++;
                }else if( ((int)A.charAt(i)>=aaa) && ((int)A.charAt(i)<=zzz) ){
                    lower++;
                }else{
                    num++;
                }
            }
            bw.write(lower+" "+upper+" "+num+" "+space+"\n");
            A = br.readLine();
        }//while
    }//read()
}//Main