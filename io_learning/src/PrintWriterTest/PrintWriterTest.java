package PrintWriterTest;

import java.io.PrintWriter;
import java.io.StringWriter;
import java.util.Scanner;

public class PrintWriterTest {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    if(sc.nextInt() == 0){
                        throw new RuntimeException(" i == 0");
                    }
                    System.out.println();
                } catch (RuntimeException e) {
                    System.out.println(e.getMessage());
                    StringWriter sw = new StringWriter();
                    //输出流包裹字节流
                    PrintWriter pw = new PrintWriter(sw);
                    e.printStackTrace(pw);
                    String StackTrace = sw.toString();
                    System.out.println(StackTrace);
                }
            }
        }).start();
    }
}
