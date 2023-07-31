import java.util.*;
import java.io.*;

public class Main{
    public static void main(String []args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;
        Integer [][] arr100 = new Integer[100][100];
        for(int i=0; i<100; i++){
            for(int j=0; j<100; j++){
                arr100[i][j]=0;
            }
        }
        
        int n = Integer.valueOf(br.readLine());
        for(int i=0; i<n; i++){
            st = new StringTokenizer(br.readLine(), " ");
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            for(int j=x; j<x+10; j++){
                for(int l=y; l<y+10; l++){
                    arr100[j][l]=1;
                }//for3
            }//for2
        }//for1
        
        int sum=0;
        for(int i=0; i<100; i++){
            for(int j=0; j<100; j++){
                sum+=arr100[i][j];
            }
        }
        bw.write(""+sum);
        bw.flush();
        bw.close();
        br.close();
        
        
    }//main
}//Main