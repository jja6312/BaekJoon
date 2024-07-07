import java.io.*;
import java.util.*;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static int n;
    static int m;
    static int[] arr;
    static boolean[] visited;
    static List<Integer> list = new ArrayList<>();

    public static void main(String[] args) throws IOException {

        StringTokenizer st= new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        arr = new int[n];
        visited = new boolean[n];

        st = new StringTokenizer(br.readLine());
        for(int i=0; i<n; i++){
            arr[i] = Integer.parseInt(st.nextToken());
        }
        
        Arrays.sort(arr);
        
        backTracking(0,0);

        bw.flush();
        bw.close();
        br.close();
    }

    private static void backTracking(int start, int depth) throws IOException{


        if(depth == m){
            for(int i=0; i<list.size(); i++){
                bw.write(list.get(i)+" ");
                
            }
            bw.write("\n");
            return;
        }

        int last = -1;
        for(int i=start; i<n; i++){
            if(visited[i] || (i>0 && arr[i] == arr[i-1] && !visited[i-1])) continue;

            visited[i] = true;
            list.add(arr[i]);
            backTracking(i+1, depth+1);
            list.remove(list.size()-1);
            visited[i] = false;
        }
    }


}
