package agenda.Presentations;
import java.util.Scanner;

import agenda.BussinessLogic.Commands.*;
import agenda.BussinessLogic.System.*;

/**
 * ����
 * �����û�UI���棬��ȡ�û�������Ϣ�������߼�������Ϣ���ݣ���ӡ������
 */
public class Presentation {
    /**
     * scanner
     */
    public static Scanner scan = new Scanner(System.in);

    /**
     * ��ӡ����ִ�����
     * @param name ��������
     * @param message ����ִ�����
     */
    public void printMessage(String name, String message) {
        if (!name.equals(""))
            System.out.println(name + "�ɹ���");
        System.out.println(message);
    }

    /**
     * �û�UI����
     */
    public void userUI() {
        System.out.println("��ӭ������̹���ϵͳ");
        System.out.println("Copyright (c) 2022, 2022, Fang Zhanhong, 19308030.");
        System.out.println("����help�Բ鿴ָ��");
        
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
