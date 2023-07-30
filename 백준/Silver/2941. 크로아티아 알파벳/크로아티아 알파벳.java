import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[]args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        String A = br.readLine();

        int check=0;
        int count=0;
        while(true){
            int index = A.indexOf("c=", check);
            if (index == -1) {
                break;
            } else {
                check = index + 2;
                count++;
            }
        }

        int check2=0;
        while(true){
            int index = A.indexOf("c-", check2);
            if (index == -1) {
                break;
            } else {
                check2 = index + 2;
                count++;
            }
        }

        int check3=0;
        int count2=0;
        while(true){
            int index = A.indexOf("dz=", check3);
            if (index == -1) {
                break;
            } else {
                check3 = index + 3;
                count2++;
            }
        }

        int check4=0;
        while(true){
            int index = A.indexOf("d-", check4);
            if (index == -1) {
                break;
            } else {
                check4 = index + 2;
                count++;
            }
        }

        int check5=0;
        while(true){
            int index = A.indexOf("lj", check5);
            if (index == -1) {
                break;
            } else {
                check5 = index + 2;
                count++;
            }
        }

        int check6=0;
        while(true){
            int index = A.indexOf("nj", check6);
            if (index == -1) {
                break;
            } else {
                check6 = index + 2;
                count++;
            }
        }

        int check7=0;
        while(true){
            int index = A.indexOf("s=", check7);
            if (index == -1) {
                break;
            } else {
                check7 = index + 2;
                count++;
            }
        }

        int check8=0;
        int count3=0;
        while(true){
            int index = A.indexOf("z=", check8);
            if (index == -1) {
                break;
            } else {
                check8 = index + 2;
                count3++;
            }
        }

        int result = A.length() - count - count2*2 - (count3 - count2);
        bw.write(""+result);
        bw.flush();
        bw.close();
        br.close();
    }
}
