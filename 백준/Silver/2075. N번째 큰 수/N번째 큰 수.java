import java.io.*;
import java.util.*;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));


    public static void main(String[] args) throws IOException {
        int n = Integer.parseInt(br.readLine());
        StringTokenizer st;
        List<Integer>list = new ArrayList<>();
        for(int i=0; i<n; i++){
            st = new StringTokenizer(br.readLine());
            for(int j=0; j<n; j++){
                list.add(Integer.parseInt(st.nextToken()));
            }
        }
        Collections.sort(list);


        bw.write(list.get(list.size()-1-(n-1))+"");



        bw.flush();
        bw.close();
        br.close();
    }





}
