import java.util.*;
import java.io.*;

public class Main{
    public static void main(String[]args)throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;
        String condition;
        
        double sumVolume=0.0;
        double sumVG=0.0;
        
        while((condition = br.readLine())!=null){
            st = new StringTokenizer(condition," ");
            String A = st.nextToken();
            double volume = Double.parseDouble(st.nextToken());
            String gradeString = st.nextToken();
            
            double grade = 0.0;
            if(gradeString.equals("A+")) grade = 4.5;
            else if(gradeString.equals("A0")) grade = 4.0;
            else if(gradeString.equals("B+")) grade = 3.5;
            else if(gradeString.equals("B0")) grade = 3.0;
            else if(gradeString.equals("C+")) grade = 2.5;
            else if(gradeString.equals("C0")) grade = 2.0;
            else if(gradeString.equals("D+")) grade = 1.5;
            else if(gradeString.equals("D0")) grade = 1.0;
            else if(gradeString.equals("F")) grade = 0.0;
            else if(gradeString.equals("P")) volume = 0.0; //학점이 P라면 배정 학점자체를 없애버리자.
            //배점(volume) * 성적(grade)의 합을 필드로 올리자.
            //=> sumVG
            sumVolume += volume;
            sumVG += grade*volume;
            
            //volume들의 합인 sumVolume도 만들어주자.
            //sumVG를 sumVolume으로 나눠줘야 할 것이다.
            
            
        }//while
        double result =sumVG/sumVolume;
        bw.write(""+result);
        bw.flush();
        bw.close();
        br.close();
    }//main()
}//Main class