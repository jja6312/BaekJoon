import java.util.*;
import java.io.*;

public class Main{
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    
    public static void main(String[]args)throws IOException{
        read();
        bw.flush();
        bw.close();
        br.close();
    }//main
    
    public static void read() throws IOException{
        int N =Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        int [] arrN = new int[N];
        
        for(int i=0; i<N; i++){
           arrN[i] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(arrN);
        //담고,
        //투포인트로 while때리면서 list 추가하자. true라면 추가 시키고, 다음으로넘어가자.;
        
        int cnt=0;
        for(int l=0; l<N; l++){
        	long find = arrN[l];
            int i=0;
            int j=N-1;
            while(i<j){
                int sum = (arrN[i]+arrN[j]);
                
                if(sum==find){
                	if(i==l) {
                		i++;
                		continue;
                	}else if(j==l){
                		j--;
                		continue;
                	}else {
                		cnt++;
                		break;
                	}
                }else if(sum<find){
                    i++;
                }else if(sum>find){
                    j--;
                }
            }//while
            
        }//for
        bw.write(cnt+"");
    }//read
}