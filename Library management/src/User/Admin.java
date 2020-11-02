package User;
import operation.*;
import java.util.Scanner;


public class Admin extends User {
    public Admin(String name) {
        super(name);
        doOperation = new IOperation[]{
                new ExitOperation(),
                new FindOperation(),
                new AddOperation(),
                new DelOperation(),
                new DisplayOperation()
        };
    }


    public int menu() {
        System.out.println("欢迎管理员 " + this.name + "回家");
        System.out.println("1.查找图书！");
        System.out.println("2.新增图书！");
        System.out.println("3.删除图书！");
        System.out.println("4.显示图书！");
        System.out.println("0.退出系统！");
        Scanner scanner = new Scanner(System.in);
        int choice = scanner.nextInt();
        return choice;

    }
}
