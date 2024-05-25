import java.io.*;
import java.util.*;


class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));


    public static void main(String[] args) throws Exception {
        int t = Integer.parseInt(br.readLine());
        for(int i=0; i<t; i++){
            TreeMap<Integer,Integer> treeMap = new TreeMap<>();
            int n = Integer.parseInt(br.readLine());
            for(int j=0; j<n; j++){
                StringTokenizer st =new StringTokenizer(br.readLine());
                String order = st.nextToken();
                int num = Integer.parseInt(st.nextToken());
                if(order.equals("I")){
                    treeMap.put(num, treeMap.getOrDefault(num,0)+1);
                }else if(order.equals("D")){
                    if(treeMap.isEmpty()) continue;//키가 없으면 삭제x

                    if(num == -1){
                        //최솟값 삭제
                        int minKey = treeMap.firstKey();
                        treeMap.put(minKey,treeMap.get(minKey)-1);//최소 키의 값을 -1
                        if(treeMap.get(minKey)<=0){//값이 0이하가되면 삭제
                            treeMap.remove(minKey);
                        }

                    }else if(num==1){
                        //최대값 삭제
                        int lastKey = treeMap.lastKey();
                        treeMap.put(lastKey,treeMap.get(lastKey)-1);//최대 키의 값을 -1
                        if(treeMap.get(lastKey)<=0) {//값이 0이하가되면 삭제
                            treeMap.remove(lastKey);
                        }
                    }

                }
            }//for
            //for문이 끝나면, 비어있으면 EMPTY 출력
            if(treeMap.isEmpty()){
                bw.write("EMPTY\n");
            }else{//비어있지 않으면
                bw.write(treeMap.lastKey()+" "+treeMap.firstKey()+"\n");
            }
        }

        bw.flush();
        bw.close();
        br.close();
    }




}