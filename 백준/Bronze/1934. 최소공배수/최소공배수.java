import java.util.*;
import java.io.*;

public class Main{
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        //나누었을때 나누어떨어지는 것을 HashMap1,2에 추가하자.
        //서로에게 겹치는 가장 큰 값을 비교하자.
        //HashMap이 적당하겠네.
        int N = Integer.parseInt(br.readLine());
        for(long i=0; i<N; i++){
        	ArrayList<Long> map = new ArrayList<Long>();
        	ArrayList<Long> map2 = new ArrayList<Long>();
        	
            String AA = br.readLine();
            String[] A = AA.split(" ");
            long num1 = Long.parseLong(A[0]);
            long num2 = Long.parseLong(A[1]);
            long div = 1;
            while(div<=num1){
                if(num1%div==0){
                    map.add(div);
                }
                div++;
            }
            div=1;
            while(div<=num2){
                if(num2%div==0){
                   map2.add(div);
                }
                div++;
            }
            long maxDiv=1;
            if(num1<=num2){
                for(int j=0; j<map.size(); j++){
                    if(map2.contains(map.get(j))) {
                    	maxDiv=map.get(j);
                    }//if2
                }//for    
            } else {
            	for(int j=0; j<map2.size(); j++){
                    if(map.contains(map2.get(j))) {
                    	maxDiv=map2.get(j);
                    }//if2
                }//for                }//else
        }//for
        bw.write(num1*num2/maxDiv+"\n");
        
        
        
    }
        bw.flush();
        bw.close();
        br.close();
}
}