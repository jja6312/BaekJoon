import java.io.*;
import java.util.*;


public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));


    public static void main(String[] args) throws IOException {

        int n = Integer.parseInt(br.readLine());
        String A = br.readLine();
        StringTokenizer st = new StringTokenizer(A, " ");

        int m = 0;
        int [] arr = new int[n];
        for(int i=0; i<n; i++){
            int score = Integer.parseInt(st.nextToken());
            arr[i] = score;
            m = Math.max(m,score);
        }

        double [] miracleArr = new double[n];

        double sum=0;
        for(int i=0; i<n; i++){
            miracleArr[i] = miracleCal(m,arr[i]);
            sum+=miracleArr[i];
        }
        double answer = ((int)(sum*100/n))/100.0;
        bw.write(""+answer);
        bw.flush();
        bw.close();
        br.close();

    }//main()

    public static double miracleCal(int m, int score){
        double answer =100.0*score/m;
        return answer;
    }



}//Main Class

