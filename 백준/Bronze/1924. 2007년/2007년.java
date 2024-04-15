import java.awt.*;
import java.io.*;
import java.util.*;
import java.util.List;




public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));


    public static void main(String[] args) throws IOException {
        String[][] arr = new String [13][32];

        String [] day = {"MON", "TUE", "WED", "THU", "FRI", "SAT", "SUN"};

        int idx = 0;
        for(int i=1; i<=12; i++){
            for(int j=1; j<=31; j++){
                if(i==2 && j==29) break;
                else if((i==4 || i==6 || i==9 || i==11) && j==31) break;

                arr[i][j] = day[idx];
                idx++;
                idx %= 7;
            }
        }

        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        bw.write(arr[n][m]);



        bw.flush();
        bw.close();
        br.close();
    }//main



}//Main