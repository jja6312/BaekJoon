import java.util.*;
import java.io.*;

public class Main{
    public static void main(String []args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int a = Integer.valueOf(br.readLine());
        int b = Integer.valueOf(br.readLine());
        ArrayList<Integer> arrList = new ArrayList<Integer>();
        
        boolean checkSwitch = true;
        
        for(int i=a; i<=b; i++){
            checkSwitch = true;
            
            if(i==1) continue;
            if(i==2) arrList.add(i);
            
                    
            for(int j=2; j<i; j++){
                if(i%j==0){
                    checkSwitch=false;
                    break;
                }//if-1
                if(j==i-1 && checkSwitch==true){
                    arrList.add(i);
                }//if-2
            }//for2
        }//for1
        
        if(arrList.size() != 0){
            int sum = 0;
            for(int i=0; i<arrList.size(); i++){
                sum += arrList.get(i);
            }
            bw.write(sum + "\n" + arrList.get(0));
        }else{
            bw.write("-1");
        }
        bw.flush();
        bw.close();
        br.close();

        
        
    }//main()
}//Main