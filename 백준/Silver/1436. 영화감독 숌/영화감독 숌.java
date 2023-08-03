import java.util.*;
import java.io.*;

public class Main{
    public static void main(String[]args) throws IOException{
    	
    	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int N = Integer.valueOf(br.readLine());
        
        
        
        ArrayList<Integer> arrList = new ArrayList<Integer>();
        //arrList로 666이들어있으면 추가하다보니까, 6666 이런데선 두 번 추가하더라... 그래서 중복없애기용으로 set,hashset사용
      
        int i=666;
        while(true) {
        	
            String iString = ""+i;
            
            for(int j=0; j<iString.length()-2; j++){
                if((int)(iString.charAt(j)-'0')==6 &&
                 (int)(iString.charAt(j)-'0')==(int)(iString.charAt(j+1)-'0') &&
                 (int)(iString.charAt(j+1)-'0')==(int)(iString.charAt(j+2)-'0')){
                	if(!arrList.contains(i)) {
                		arrList.add(i);
                	}
                }//if
            }
            i++;
           
            if(arrList.size()>N) break;
        }
        
        Collections.sort(arrList);
        
        bw.write(""+arrList.get(N-1));
        bw.flush();
        bw.close();
        br.close();
       
        
        /*
        666
        1666
        2666
        .
        .
        9666
        10666
        
        11666
        .
        16661
        16662
        ...
        16668
        16669
        .
        16666
        17666
        18666
        19666
        
        20666
        26661
        26662
        */
        
        
    }//main()
}//Main