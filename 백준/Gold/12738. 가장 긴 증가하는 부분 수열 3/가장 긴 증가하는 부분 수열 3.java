import java.io.*;
import java.util.*;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static int n;
    static int[]arr;


    public static void main(String[] args) throws IOException {
        n = Integer.parseInt(br.readLine());
        arr = new int[n];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i=0; i<n; i++){
            arr[i] = Integer.parseInt(st.nextToken());
        }

        List<Integer> lis = new ArrayList<>();
        for(int i=0; i<n; i++){
            int pos = Collections.binarySearch(lis,arr[i]);
            if(pos<0) pos = -pos-1;
            if(pos>=lis.size()) lis.add(arr[i]);
            else lis.set(pos,arr[i]);
        }

        bw.write(lis.size()+"");

        bw.flush();
        bw.close();
        br.close();
    }
}