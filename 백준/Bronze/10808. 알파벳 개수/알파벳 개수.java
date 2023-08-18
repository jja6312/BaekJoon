import java.util.*;
import java.io.*;

public class Main{
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static Integer[] arr;
    
        public static void main(String[]args) throws IOException{
            read();
            bw.flush();
            bw.close();
            br.close();
            
        }//main()
    
        public static void read() throws IOException{
            String A = br.readLine();
            arr = new Integer[26];
            for(int i=0; i<26; i++){
                arr[i]=0;
            }
            
            for(int i=0; i<A.length(); i++){
                if(A.charAt(i)=='a') arr[0]+=1;
                if(A.charAt(i)=='b') arr[1]+=1;
                if(A.charAt(i)=='c') arr[2]+=1;
                if(A.charAt(i)=='d') arr[3]+=1;
                if(A.charAt(i)=='e') arr[4]+=1;
                if(A.charAt(i)=='f') arr[5]+=1;
                if(A.charAt(i)=='g') arr[6]+=1;
                if(A.charAt(i)=='h') arr[7]+=1;
                if(A.charAt(i)=='i') arr[8]+=1;
                if(A.charAt(i)=='j') arr[9]+=1;
                if(A.charAt(i)=='k') arr[10]+=1;
                if(A.charAt(i)=='l') arr[11]+=1;
                if(A.charAt(i)=='m') arr[12]+=1;
                if(A.charAt(i)=='n') arr[13]+=1;
                if(A.charAt(i)=='o') arr[14]+=1;
                if(A.charAt(i)=='p') arr[15]+=1;
                if(A.charAt(i)=='q') arr[16]+=1;
                if(A.charAt(i)=='r') arr[17]+=1;
                if(A.charAt(i)=='s') arr[18]+=1;
                if(A.charAt(i)=='t') arr[19]+=1;
                if(A.charAt(i)=='u') arr[20]+=1;
                if(A.charAt(i)=='v') arr[21]+=1;
                if(A.charAt(i)=='w') arr[22]+=1;
                if(A.charAt(i)=='x') arr[23]+=1;
                if(A.charAt(i)=='y') arr[24]+=1;
                if(A.charAt(i)=='z') arr[25]+=1;
            }//for
            StringBuilder sb = new StringBuilder();
            for(int i=0; i<26; i++){
                sb.append(arr[i]+" ");
            }
            bw.write(sb.toString());
        }//read()
}//Main