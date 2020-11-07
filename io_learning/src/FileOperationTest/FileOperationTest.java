package FileOperationTest;
import java.io.*;
import java.util.Scanner;

/**
 * 文件读取方式 1：字符流读取
 */
class FileReader_1{
    public static void main(String[] args) throws IOException {
        //文件读取为字节流
        FileInputStream fis = new FileInputStream(new File("E:\\Project1\\io_learning\\test.txt"));
        //InputStreamReader(fis)输入的字节字符转换流，把读取的字节流转换为 BufferedReader 字符缓冲流，
        //OutputStreamWriter(fis)输出的字节字符转换流
        BufferedReader br = new BufferedReader(new InputStreamReader(fis,"UTF-8"));
//        //字符流按行读取
//        String line ;
//        while ((line = br.readLine()) != null){
//            System.out.println(line);
//        }

//        //字符流按字符数组读取
//        char[] chars = new char[1024];
//        int len;
//        //br.read(目的数组)
//        while ( (len = br.read(chars)) != -1){
//            String str = new String(chars,0,len);
//            System.out.println(str);
//        }
    }
}


/**
 * 文件读取方式 2：按字节流读取
 */
class FileReader_2{
    public static void main(String[] args) throws IOException {
        //文件读取为字节流,不存在就报错
        FileInputStream fis = new FileInputStream(new File("E:\\Project1\\io_learning\\test3.txt"));
        byte[] bytes = new byte[1024];
        int len;
        while ( (len = fis.read(bytes)) != -1){
            String str = new String(bytes,0,len);
            System.out.println(str);
        }
    }
}

/**
 * 文件写操作
 */
class FileWriter_1 {
    public static void main(String[] args) throws IOException {
        //文件读取为字节流，如不存在，就新建
        FileOutputStream fis = new FileOutputStream(new File("E:\\Project1\\io_learning\\test1.txt"));
        // OutputStreamWriter(fis)输出的字节字符转换流,把读取的字节流转换为 BufferedWriter 字符缓冲流，
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(fis,"UTF-8"));
        //使用缓冲流输出的时候，如果不进行flush刷新缓冲区，就不会真实的输出的目的设备。
        bw.write("1.大量减少零点九零卡\n"); //write写数据到系统内存缓冲区
        bw.write("2.d邓肯帕克的菩萨的卡上");
        bw.flush(); //缓冲区刷新，发送数据到目的设备
    }
}

/**
 *
 */
class copyfile {
    //作业：复制本地文件到另一个地方（字节缓冲流）
    public static void main(String[] args) throws IOException {
        FileInputStream fis1 = null;
        FileOutputStream fis2 = null;
        BufferedOutputStream bos = null;

        try {
            //原文件读取为字节流
            fis1 = new FileInputStream(new File("E:\\Project1\\io_learning\\test.JPG"));
            //文件输出地址，如不存在，就新建
            fis2 = new FileOutputStream(new File("E:\\Project1\\io_learning\\test1.JPG"));
            //字节缓冲流复制
            bos = new BufferedOutputStream(fis2);
            //原文件按字节复制到目的文件
            byte[] bytes = new byte[1024];
            int len;
            while ( (len = fis1.read(bytes)) != -1) {
                bos.write(bytes);
                bos.flush();
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }finally {//若B依赖A，则先释放B
            bos.close();
            fis2.close();
            fis1.close();
        }
    }
}