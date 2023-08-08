import java.util.*;
import java.text.*;

public class Main{
    public static void main(String[]args){
        Date d = new Date();
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        System.out.println(sdf.format(d));
    }
}