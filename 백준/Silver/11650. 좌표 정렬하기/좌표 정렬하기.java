import java.util.*;
import java.io.*;

public class Main{
    public static void main(String[]args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        
        int N = Integer.parseInt(br.readLine());
        
        int[] [] result = new int[N][];
        for(int i=0; i<N; i++){
            String next = br.readLine();
            String abc[] = next.split(" ");
            int XY[] = new int[2];
            XY[0]=Integer.parseInt(abc[0]);
            XY[1]=Integer.parseInt(abc[1]);
            result[i]=XY;
        }
        
        // Sort the array
        Arrays.sort(result, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                if (o1[0] == o2[0]) {
                    // If the first elements are equal, compare the second elements
                    return o1[1] - o2[1];
                }
                return o1[0]-o2[0];
            }
        });
        for(int i=0; i<N; i++) {
        	for(int j=0; j<2; j++) {
        		bw.write((result[i])[j]+" ");
        	}
        	bw.write("\n");
        }
        bw.flush();
        bw.close();
        br.close();
    }//main
}//Main