import java.io.*;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    public static void main(String[] args) throws IOException {
        int money = 1000-Integer.parseInt(br.readLine());
        int cnt=0;
        int n=0;
        while(money!=0){

            int spaceMoney=0;
            if(money>=500){
                spaceMoney = 500;
            }else if(money>=100){
                spaceMoney = 100;
            }else if(money>=50){
                spaceMoney = 50;
            }else if(money>=10){
                spaceMoney = 10;
            }else if(money>=5){
                spaceMoney = 5;
            }else if(money>=1){
                spaceMoney = 1;
            }
            n = money/spaceMoney;
            cnt+=n;
            money -= n*spaceMoney;
        }
        bw.write(""+cnt);


        bw.flush();
        bw.close();
        br.close();

    }

}
