import java.io.*;
import java.util.*;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));


    public static void main(String[] args) throws IOException {
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        if(n==1){
            System.out.println("1");
            return;
        }

        int l = Integer.parseInt(st.nextToken());
        st = new StringTokenizer(br.readLine());
        int[] arr  = new int[n];
        for(int i=0; i<n; i++){
            arr[i] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(arr);

        int cnt=0;

        int tmp = arr[0];
        int stack = 1;
        int sub = 0;
        for(int i=1; i<n; i++){
            sub += arr[i]-tmp;
            if(sub<=l-1){
                stack = 1;
            }else{
                sub = 0;
                cnt+=stack;//
                stack = 1;
            }
            tmp = arr[i];
        }
        cnt+=stack;


        bw.write(cnt+"");
        bw.flush();
        bw.close();
        br.close();
    }




}
