import java.awt.*;
import java.io.*;
import java.util.*;
import java.util.List;




public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    public static void main(String[] args) throws IOException {
        String A = br.readLine();
        StringTokenizer st = new StringTokenizer(A, " ");
        int a = Integer.parseInt(st.nextToken());
        int b = Integer.parseInt(st.nextToken());
        int c = Integer.parseInt(st.nextToken());
        
        int [] arr = {a,b,c};
        Arrays.sort(arr);
        bw.write(arr[1]+"");
        


        bw.flush();
        bw.close();
        br.close();
    }//main

}//Main