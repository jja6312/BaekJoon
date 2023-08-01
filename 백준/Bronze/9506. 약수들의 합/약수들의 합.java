import java.util.*;
import java.io.*;

public class Main{
    public static void main(String []args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        ArrayList <Integer>arrList = new ArrayList <Integer>();
        String line;
        int n=0;
        while(!(line=br.readLine()).equals("-1")){
            n = Integer.valueOf(line);
            int sum=0;
            arrList.clear();
            for(int i=1; i<n; i++){ 
                if(n%i==0){
                    arrList.add(i);
                    sum+=i;    
                }
            }
            if(sum==n){
                bw.write(""+n+" = ");
                for(int i=0; i<arrList.size(); i++){
                    if(i!=arrList.size()-1){
                        bw.write(""+arrList.get(i)+" + ");    
                    }else{
                        bw.write(""+arrList.get(i)+"\n");
                    }
                }
                
            }else{
                bw.write(""+n+" is NOT perfect.\n");
            }
            
            
        }
        bw.flush();
        bw.close();
        br.close();
    }
}