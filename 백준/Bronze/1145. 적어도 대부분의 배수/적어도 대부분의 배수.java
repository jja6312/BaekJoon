import java.io.*;
import java.util.*;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));


    public static void main(String[] args) throws IOException {
        StringTokenizer st= new StringTokenizer(br.readLine());
        int[] arr = new int[5];
        for(int i=0; i<5; i++){
            arr[i] = Integer.parseInt(st.nextToken());
        }

        int min = Integer.MAX_VALUE;
        for(int i=0; i<5; i++){
            for(int j=i+1; j<5; j++){
                for(int k=j+1; k<5; k++){
                    int lcm = calLcm(arr[i], arr[j], arr[k]);//세 수의 최소공배수
                    min = Math.min(min,lcm);
                }
            }
        }

        bw.write(min+"");





        bw.flush();
        bw.close();
        br.close();

    }

    private static int calLcm(int one, int two, int three) {

        return calLcm(calLcm(one,two),three);
    }

    private static int calLcm(int one, int two) {
        return one * two / gcd(one,two);
    }

    private static int gcd(int a, int b) {
        if(b==0) return a;
        return gcd(b, a%b);
    }


}
