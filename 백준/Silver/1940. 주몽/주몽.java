import java.util.*;
import java.io.*;

public class Main{
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    public static void main(String[]args) throws IOException{
        read();
        bw.flush();
        bw.close();
        br.close();

    }//main()

    public static void read() throws IOException{
        int N = Integer.parseInt(br.readLine());
        int M = Integer.parseInt(br.readLine());
        int []arrN = new int[N];

        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        for(int i=0; i<N; i++){
            arrN[i]= Integer.parseInt(st.nextToken());
        }
        Arrays.sort(arrN);
        int cnt = 0;
        int i=0;
        int j=N-1;
        while(i<j){
            if((arrN[i]+arrN[j])<M){
                i++;
            }else if((arrN[i]+arrN[j])==M){
                i++;
                j--;
                cnt++;
            }else if(arrN[i]+arrN[j]>M){
            	j--;
            }
        }
        bw.write(cnt+"");
        
    }//read()
}//Main
