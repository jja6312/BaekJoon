import java.io.*;
import java.util.*;

class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static int[] arrA = new int[4];
    static int[] arrB = new int[4];


    static class IntArrAndStr{
        int[] intArr;
        String str;

        public IntArrAndStr(int[] intArr, String str){
            this.intArr = intArr;
            this.str = str;
        }
    }

    public static void main(String[] args) throws Exception {
        int t = Integer.parseInt(br.readLine());
        StringTokenizer st;
        for(int i=0; i<t; i++){
            st= new StringTokenizer(br.readLine());
            String A  = st.nextToken();
            String B = st.nextToken();

            Arrays.fill(arrA, 0);
            Arrays.fill(arrB, 0);

            int idx = 3;
            for(int j=A.length()-1; j>=0; j--){

                arrA[idx] = A.charAt(j)-'0';
                idx--;
            }

            idx = 3;
            for(int j=B.length()-1; j>=0; j--){
                arrB[idx] = B.charAt(j)-'0';
                idx--;
            }

            String answer = bfs();
            bw.write(answer+"\n");

        }//for

        bw.flush();
        bw.close();
        br.close();


    }//main

    private static String bfs() {
        //A에서 B가되기위한 최소 개수를 return해야한다.
        Queue<IntArrAndStr> queue = new LinkedList<>();
        boolean[] visited = new boolean[10000];

        queue.add(new IntArrAndStr(arrA,""));
        int intValInit = parseIntegerFromArray(new int[] {arrA[0],arrA[1],arrA[2],arrA[3]});
        int goalInt = parseIntegerFromArray(arrB);
        visited[intValInit] = true;

        while(!queue.isEmpty()){
            IntArrAndStr current = queue.poll();
            int intVal = parseIntegerFromArray(current.intArr);
            int[] intArr = current.intArr;
            String nowStr = current.str;

            if(goalInt == intVal) {
                return nowStr;
            }


            //D
            int mulVal = intVal*2;
            if(mulVal>=10000) mulVal %= 10000;
            int[] mulArr = parseArrayFromInt(mulVal);
            if(!visited[mulVal]) {
                queue.offer(new IntArrAndStr(mulArr, nowStr + "D"));
                visited[mulVal] = true;
            }

            //S
            int subVal = (intVal == 0) ? 9999 : intVal - 1;

            int[] subArr = parseArrayFromInt(subVal);
            if(!visited[subVal]){
                queue.offer(new IntArrAndStr(subArr, nowStr+"S"));
                visited[subVal] = true;
            }



            //L
            int[] LeftRotateArr = new int[]{intArr[1],intArr[2],intArr[3],intArr[0]};
            int leftRotateIntVal = parseIntegerFromArray(LeftRotateArr);
            if(!visited[leftRotateIntVal]) {
                queue.offer(new IntArrAndStr(LeftRotateArr, nowStr + "L"));
                visited[leftRotateIntVal] = true;
            }


            //R
            int[] RightRotateArr = new int[]{intArr[3],intArr[0],intArr[1],intArr[2],};
            int rightRotateIntVal = parseIntegerFromArray(RightRotateArr);
            if(!visited[rightRotateIntVal]) {
                queue.offer(new IntArrAndStr(RightRotateArr, nowStr + "R"));
                visited[rightRotateIntVal] = true;
            }


        }


        return "메롱";
    }

    private static int[] parseArrayFromInt(int val) {
        String str = String.valueOf(val);
        int[] intArr = new int[4];
        int idx = 3;
        for (int i = str.length() - 1; i >= 0; i--) {
            intArr[idx--] = str.charAt(i) - '0';
        }
        return intArr;
    }

    private static int parseIntegerFromArray(int[] arr) {

        int sum=0;
        int mul = 1000;
        for(int i=0; i<4; i++){
            sum += arr[i] * mul;
            mul/=10;
        }
        return sum;
    }


}//Main
