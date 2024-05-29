import java.io.*;
import java.util.*;

class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static boolean[] isEated;
    static String A;
    static int n;


    public static void main(String[] args) throws Exception {
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());
        isEated = new boolean[n];
        A = br.readLine();
        for(int i=0; i<n; i++){
            if(A.charAt(i)== 'P') isEated[i] = true;// 사람은 true
        }
        int answer=0;
        for(int i=0; i<n; i++){
            //범위의 가장 왼쪽부터 안 먹은 햄버거를 찾는다.
            if(A.charAt(i)== 'P'){//사람이면
                boolean eatHamber = findHamber(i,k);//햄버거를 찾고
                if(eatHamber) answer++;
            }

        }

        bw.write(answer+"");
        bw.flush();
        bw.close();
        br.close();


    }//main

    private static boolean findHamber(int idx, int k) {
        int startIdx = idx-k;
        if(startIdx<0) startIdx = 0;
        
        while(startIdx<=idx+k && startIdx<n){//유효한 범위라면
            //start부터 찾아나간다.
            //만약 안먹은게 있으면,
            if(!isEated[startIdx]){
                isEated[startIdx] = true;
                return true;
            }
            startIdx++;
        }

        return false;

    }


}//Main
