package Socket;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Server {
    private static final int PORT = 9000;
    private static final ExecutorService POOL = Executors.newCachedThreadPool();  //缓存线程池（全是临时线程）

    public static void main(String[] args) throws IOException {
        ServerSocket server = new ServerSocket(PORT);
        while (true){
            //阻塞等待，直到新的客户端连接
            Socket client = server.accept(); // 阻塞方法
            POOL.execute(new Task(client)); //线程池执行任务，否则下边代码阻塞无法运行
        }
    }

    private static class Task implements Runnable{   //用线程处理IO流
        private Socket client;
        public Task(Socket client){
            this.client = client;
        }
        @Override
        public void run() {
            try {
                // 输入缓存流（new 输入字节流（Client.get输入字节流））
                BufferedReader in = new BufferedReader(new InputStreamReader(client.getInputStream()));
                PrintWriter out = new PrintWriter(client.getOutputStream(),true); //输出流，自动刷新
                String str;
                int i = 0;
                while ( (str = in.readLine()) != null){  //按行读取客户端发送的数据
                    System.out.println(str);
                    out.println("收到消息了！"+i );
                    i++;
                }
            }catch (IOException e){
                e.printStackTrace();
            }
        }
    }
}
