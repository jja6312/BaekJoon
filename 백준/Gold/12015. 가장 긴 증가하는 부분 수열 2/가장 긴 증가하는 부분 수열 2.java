import java.io.*;
import java.util.*;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));


    public static void main(String[] args) throws IOException {

        int n = Integer.parseInt(br.readLine());
        int[] arr = new int[n];
        StringTokenizer st= new StringTokenizer(br.readLine());
        for(int i=0; i<n; i++){
            arr[i] = Integer.parseInt(st.nextToken());
        }
        List<Integer> list = new ArrayList<>();

        for(int x : arr){
            if(list.isEmpty() || list.get(list.size()-1)<x) list.add(x);
            else{
                int idx = Collections.binarySearch(list,x);
                if(idx<0){//바이너리서치로 탐색했을 때 값이 없으면
                    idx = -(idx+1);
                    list.set(idx,x);//idx번째를 x(더작은값)으로대체한다.
                }
            }
        }


        bw.write(list.size()+"");
        bw.flush();
        bw.close();
        br.close();
    }




}
