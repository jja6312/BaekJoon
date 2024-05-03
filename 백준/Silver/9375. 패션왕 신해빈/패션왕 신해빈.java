import javax.xml.crypto.dsig.keyinfo.KeyValue;
import java.io.*;
import java.util.*;


public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));




    public static void main(String[] args) throws IOException {
        int t = Integer.parseInt(br.readLine());
        StringTokenizer st;

        for(int i=0; i<t; i++){
            int n = Integer.parseInt(br.readLine());//의상의 수
            Map<String, Integer> clothTypeMap = new HashMap<>();
            for(int j=0; j<n; j++){
                st = new StringTokenizer(br.readLine()," ");
                String clothSpecific = st.nextToken();
                String clothType = st.nextToken();

                //의상을 하나라도 입을 경우의 수는
                // (type1의 수+1) * (type2의 수+1) * ... - 모두안입는 경우의수

                //즉 타입별로 몇개씩있는지 체크하면 됨.
                if(clothTypeMap.get(clothType)==null){
                    clothTypeMap.put(clothType,1);
                }else{
                    int cnt = clothTypeMap.get(clothType);
                    clothTypeMap.put(clothType, cnt+1);
                }

            }

            int mul = 1;

            for(Map.Entry<String,Integer> entry : clothTypeMap.entrySet()){
                mul *= (entry.getValue()+1);
            }

            int answer = mul - 1;
            bw.write(answer+"\n");
        }


        bw.flush();
        bw.close();
        br.close();


    }

}//Main Class
