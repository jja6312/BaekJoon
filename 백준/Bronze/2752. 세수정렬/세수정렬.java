import javax.xml.crypto.dsig.keyinfo.KeyValue;
import java.awt.*;
import java.io.*;
import java.util.*;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));



    public static void main(String[] args) throws IOException {
        StringTokenizer st = new StringTokenizer(br.readLine()," ");
        int[] arr = new int[3];
        for(int i=0; i<3; i++){
            arr[i] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(arr);

        for(int x: arr){
            bw.write(x+" ");
        }

        bw.flush();
        bw.close();
        br.close();

    }




}//Main Class
