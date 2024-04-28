import java.io.*;
import java.util.*;

public class Main{
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    public static void main(String[] args) throws IOException {
        int n = Integer.parseInt(br.readLine());
        int[] arr = new int[n];
        for(int i=0; i<n; i++){
            arr[i] = Integer.parseInt(br.readLine());
        }

        int sum = calSum(arr);

        Arrays.sort(arr);
        int mid = arr[arr.length/2];
        int frequency = calFreq(arr);
        int maxSubMin = arr[arr.length-1]-arr[0];

        bw.write(sum+"\n");
        bw.write(mid+"\n");
        bw.write(frequency+"\n");
        bw.write(maxSubMin+"\n");
        bw.flush();
        bw.close();
        br.close();

    }

    private static int calFreq(int[] arr) {
        List<Integer> list = new ArrayList<>();
        Map<Integer,Integer> numAndFreq = new HashMap<>();
        int maxCnt = 1;
        for(int x : arr){
            if(numAndFreq.containsKey(x)){//맵에 이미 값이 있으면
                int freq = numAndFreq.get(x)+1;
                if(freq>maxCnt) maxCnt = freq;
                numAndFreq.put(x,freq);
            }else{//값이없으면 냅다집어넣기
                numAndFreq.put(x,1);
            }
        }


        for( Map.Entry<Integer,Integer> entry : numAndFreq.entrySet()){

            if(entry.getValue()==maxCnt) list.add(entry.getKey());
        }

        Collections.sort(list);

        if(list.size()>=2){
            return list.get(1);
        }else{
            return list.get(0);
        }
    }

    private static int calSum(int[] arr) {
        int sum = 0;
        int result = 0;
        for(int x : arr){
            sum+=x;
        }
        result = (int)Math.round((double)sum/arr.length);
        return result;
    }

}//Main
