package Socket;

import java.net.Socket;
import java.io.*;
import java.util.Scanner;

public class Client {
    private static final String HOST = "127.0.0.1";
    private static final int PORT = 9000;

    public static void main(String[] args) throws IOException {
        Socket client = new Socket(HOST, PORT);
        // 输入缓存流（new 输入字节流（Client.get输入字节流））
        BufferedReader in = new BufferedReader(new InputStreamReader(client.getInputStream()));
        PrintWriter out = new PrintWriter(client.getOutputStream(),true); //输出流，自动刷新
        Scanner sc = new Scanner(System.in);

        new Thread(new Runnable() {
            @Override
            public void run() {
                while (sc.hasNextLine()){
                    String line = sc.nextLine();
                    out.println(line);
                }
            }
        }).start();

        String str;
        while ((str = in.readLine()) != null){
            System.out.println(str);
        }
    }
}
