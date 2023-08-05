import java.util.*;
import java.io.*;

public class Main{
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        String A = br.readLine();
        String[] arrA = A.split(" ");
        int N = Integer.parseInt(arrA[0]);
        int M = Integer.parseInt(arrA[1]);
        
        Map<String, Integer> map = new HashMap<String, Integer>();
        Map<String, Integer> map2 = new HashMap<String, Integer>();
        
        String B = br.readLine();
        String[] arrB = B.split(" ");
        
        String C = br.readLine();
        String[] arrC = C.split(" ");
        
        
        for(int i=0; i<N; i++){
            map.put(arrB[i], 1);   
        }
        
        for(int i=0; i<M; i++){
            map2.put(arrC[i], 1);   
        }
        
        for(int i=0; i<M; i++){
            if(map.containsKey(arrC[i])){
                map.remove(arrC[i]);
            }
        }
        for(int i=0; i<N; i++){
            if(map2.containsKey(arrB[i])){
                map2.remove(arrB[i]);
            }
        }
        
        bw.write(map.size()+map2.size()+"");
        bw.flush();
        bw.close();
        br.close();
        
        
    }
}