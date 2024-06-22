import java.io.*;
import java.util.*;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    public static void main(String[] args) throws IOException {
        StringTokenizer st = new StringTokenizer(br.readLine());
        int L = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        st= new StringTokenizer(br.readLine());
        char[] arr = new char[K];
        for(int i=0; i<K; i++){
            arr[i] = st.nextToken().charAt(0);
        }

        Arrays.sort(arr);

        List<String> result = new ArrayList<>();

        combination(arr,new char[L],0,0,L);

        for(String x: result){
            bw.write(x+"\n");
        }


        bw.flush();
        bw.close();
        br.close();
    }

    private static void combination(char[] arr, char[] chars, int start, int depth, int L) throws IOException {
        if(depth==L){
            if(isValid(chars)){
                for(char x:chars){
                    bw.write(x);
                }
                bw.write("\n");
            }
            return;
        }

        for(int i=start; i<arr.length; i++){
            chars[depth] = arr[i];
            combination(arr,chars,i+1,depth+1,L);
        }


    }

    public static boolean isValid(char[] chars){
        int 자음 = 0;
        int 모음 = 0;

        for(char x:chars){
            if(x=='a' || x=='e' || x=='i' || x=='o' || x=='u') 모음++;
            else 자음++;
        }
        
        return 모음>=1 && 자음>=2;
    }


}
