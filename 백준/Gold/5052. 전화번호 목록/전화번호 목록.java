
import java.io.*;
import java.util.Arrays;

public class Main {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    public static void main(String[] args) throws IOException {
        int t = Integer.parseInt(br.readLine());
        for(int i=0; i<t; i++){
            int n = Integer.parseInt(br.readLine());
            String[] arr = new String[n];
            for(int j=0; j<n; j++){
                arr[j] = br.readLine();
            }

            Arrays.sort(arr);

            boolean endSwitch = false;
            for(int j=0; j<n-1; j++){
                String before = arr[j];
                String after = arr[j+1];

                int len = before.length() < after.length() ? before.length() : after.length();
                boolean isTrue = true;
                for(int l = 0 ; l <len; l++){
                    if(before.charAt(l) != after.charAt(l)) {
                        isTrue = false;
                    }
                }
                if(isTrue){
                    bw.write("NO\n");
                    endSwitch = true;
                }

                if(endSwitch) break;

            }
            if(!endSwitch){
                bw.write("YES\n");
            }
        }

        bw.flush();
        bw.close();
        br.close();
    }
}











