import java.util.*;
import java.io.*;

public class Main{
    public static void main(String[]args) throws IOException{
    	
    	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int N = Integer.parseInt(br.readLine());
        int[][]result = new int[N][];
        for(int i=0; i<N; i++){
            String A = br.readLine();
            String[] aArr = A.split(" ");
            int[] intArr = new int[2];
            intArr[0]=Integer.parseInt(aArr[0]);
            intArr[1]=Integer.parseInt(aArr[1]);
            
            result[i] = intArr;
        }
        
        Arrays.sort(result, new Comparator<int[]>(){
           @Override
            public int compare(int[] i1, int[]i2){
                if (i1[1]==i2[1]){
                    return i1[0]-i2[0];
                }
                return i1[1]-i2[1];
            }
        });
        
        for(int i=0; i<N; i++){
            bw.write((result[i])[0]+" "+(result[i])[1]+"\n");
        }
        bw.flush();
        bw.close();
        br.close();
        
    }//main()
}//Main