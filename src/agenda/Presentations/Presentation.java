package agenda.Presentations;
import java.util.Scanner;

import agenda.BussinessLogic.Commands.*;
import agenda.BussinessLogic.System.*;

/**
 * 表达层
 * 用于用户UI界面，读取用户输入信息，并与逻辑层做消息传递，打印命令结果
 */
public class Presentation {
    /**
     * scanner
     */
    public static Scanner scan = new Scanner(System.in);

    /**
     * 打印命令执行情况
     * @param name 命令名称
     * @param message 命令执行情况
     */
    public void printMessage(String name, String message) {
        if (!name.equals(""))
            System.out.println(name + "成功。");
        System.out.println(message);
    }

    /**
     * 用户UI界面
     */
    public void userUI() {
        System.out.println("欢迎访问议程管理系统");
        System.out.println("Copyright (c) 2022, 2022, Fang Zhanhong, 19308030.");
        System.out.println("输入help以查看指令");
        
        Command execWorker;
        Parse parseWorker = new Parse();
        Agenda agenda = new Agenda();
        UserTable table = new UserTable();
        
        while (true) {
            System.out.print("\n");
            System.out.print("$ ");

            String []command = scan.nextLine().replaceAll(" {2,}", " ").strip().split(" ");
            try {
                execWorker = parseWorker.parse(command);
                execWorker.check(command, agenda, table);
                String message = execWorker.exec(command, agenda, table);
                printMessage(execWorker.getName(), message);
            } catch (Exception e) {
                String reason = e.getMessage();
                // e.printStackTrace();
                System.out.println(reason);
            }
        }
    }
}
