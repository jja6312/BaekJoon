import java.io.*;
import java.util.*;

class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    public static void main(String[] args) throws Exception {

        int t = Integer.parseInt(br.readLine());

        for(int i=0; i<t; i++){
            String command = br.readLine();
            int commandLen = command.length();
            char[] commands = new char[commandLen];
            for(int j=0; j<commandLen; j++){
                commands[j] = command.charAt(j); // 명령어 배열 초기화
            }

            int n = Integer.parseInt(br.readLine());
            String Nums = br.readLine();
            String cutNums = trimNums(Nums);
            StringTokenizer st = new StringTokenizer(cutNums,",");
            Deque<Integer> numList = new ArrayDeque<>();
            while(st.hasMoreTokens()){
                numList.add(Integer.parseInt(st.nextToken()));// 숫자배열 추가
            }

            boolean isReverse = false;

            boolean isError = false;
            for(int j=0; j<commandLen; j++){
                if(commands[j] == 'R') isReverse = !isReverse;
                else if(commands[j]=='D'){
                    if(numList.isEmpty()){
                        bw.write("error\n");
                        isError = true;
                        break;
                    }
                    if(isReverse){//만약 거꾸로 지워야한다면
                        numList.pollLast(); //리스트에서 마지막문자열 제거
                    }else{//순차적으로 지워야한다면
                        numList.pollFirst();
                    }
                }
            }//for-2
            //명령어가 끝난 시점에서 출력
            if(!isError && !isReverse) {//거꾸로가아니면
                bw.write("[");
                while(!numList.isEmpty()){
                    bw.write(numList.pollFirst()+"");
                    if(!numList.isEmpty())bw.write(",");
                }

                bw.write("]\n");
            }else if(!isError && isReverse){
                bw.write("[");
                while(!numList.isEmpty()){
                    bw.write(numList.pollLast()+"");
                    if(!numList.isEmpty())bw.write(",");
                }
                bw.write("]\n");
            }

        }//for-1
        bw.flush();
        bw.close();
        br.close();


    }//main

    private static boolean isValidNum(int num, int numListSize) {
        return num>=0 && num<numListSize;
    }

    private static String trimNums(String nums) {

        String ans = nums.substring(1,nums.length()-1);

        return ans;
    }
}//Main
