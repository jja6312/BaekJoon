import java.util.*;
import java.io.*;

public class Main{
    public static void main(String [] args)throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int N = Integer.parseInt(br.readLine());
        Integer[] intArr = new Integer[N];
        Integer []intArr2 = new Integer[N];
        
        String read = br.readLine();
        String [] readArr = read.split(" ");
        for(int i=0; i<N; i++){
            intArr[i]=Integer.parseInt(readArr[i]);
            intArr2[i] = intArr[i];
        }//for

        Arrays.sort(intArr2, Comparator.naturalOrder());
        //intArr2를 복제
        //intArr2를 intArr와 비교해서, 작은것의 개수를 intArr2에 할당하자.
        Map <Integer, Integer> map = new HashMap<Integer, Integer>();
        int countIndex=0;
        for(int i=0; i<intArr2.length; i++) {
        	if(!map.containsKey(intArr2[i])) {
        		map.put(intArr2[i], countIndex++);
        	}
        }
        for(int i=0; i<N;i++) {
        	bw.write(map.get(intArr[i])+" ");
        }
        
        bw.flush();
        bw.close();
        br.close();
        
        
      
        
        
        
    }//main
}//Main