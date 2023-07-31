import java.util.*;
import java.io.*;

public class Main{
    public static void main(String []args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        String N = st.nextToken();
        long B = Long.valueOf(st.nextToken());
        long valueMul = 1;
        long [] valueList = new long[N.length()];

        for(int i=0; i<N.length(); i++){
            char key = N.charAt(i); // N의 i번째 요소를 key에 할당
            long valueLong = 0;
            if(key >= '0' && key <= '9') valueLong = key - '0';
            else valueLong = key - 'A' + 10;

            //valueLong에 적절한 값을 곱해 진짜진짜 값을 정하고자함
            valueMul = valueLong;
            for(int m=0; m<N.length()-i-1; m++){
                valueMul *= B; //i번째 키는 키^(N.length-i-1)
            }
            valueList[i] = valueMul;
        }

        long sum = 0;
        for(int i=0; i<N.length(); i++){
            sum += valueList[i];
        }
        bw.write(""+sum);
        bw.flush();
        bw.close();
        br.close();
    }//main()
}//Main
