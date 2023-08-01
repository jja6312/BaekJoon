import java.util.*;
import java.io.*;

public class Main{
    public static void main(String []args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        ArrayList<Integer> arrList = new ArrayList<Integer>();
        
        int a = Integer.valueOf(br.readLine());
        int x=a;
        if(a==1){ 
            br.close();
        }
        if(a!=1){
        for(int i=2; i<=a; i++){
            while(x%i==0){
                x= x/i;
                arrList.add(i);
            }//while
        }//for
        
        if(arrList.size()!=0){
           for(int i=0; i<arrList.size(); i++){
              bw.write(""+arrList.get(i)+"\n"); 
           } 
        }else{
            bw.write("");
        }
        bw.flush();
        bw.close();
        br.close();
       }
        
        
        
    }//main()
}//Main
