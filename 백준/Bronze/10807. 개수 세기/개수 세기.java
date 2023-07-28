import java.util.*;
import java.io.*;
public class Main{
    public static void main(String []args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        
        String A=br.readLine();
        int a = Integer.parseInt(A);
        
        StringTokenizer st = new StringTokenizer(br.readLine()," ");
        String [] arr = new String[a];
        for(int i=0; i<a; i++){
            arr[i]=st.nextToken();
        }
        
        String C = br.readLine();
        
        int count=0;
        for(int i=0; i<arr.length; i++){
            if (C.equals(arr[i])){
             count++;   
            }
        }//for
        
        bw.write(Integer.toString(count));
        bw.flush();
        bw.close();
        br.close();
       
        }
        
    }
