package agenda.BussinessLogic.Commands;
import java.util.ArrayList;

import agenda.BussinessLogic.System.*;
import agenda.Exceptions.*;

/**
 * ��ӻ�������
 * �������������һ���µĻ��鰲��
 */
public class Add extends Command {
    /**
     * ���캯��
     */
    public Add() {
        name = "�������";
    }

    /**
     * ��鲿��
     * 1 ������ĿӦΪ7
     * 2 �û����������ȷ
     * 3 �û����������
     * 4 ��������߲���Ϊͬһ�û�
     * 5 �û�����ʱ�䲻�������л����ͻ
     * @param argv ���������add [userName] [password] [other] [start] [end] [title]
     * @param agenda ��̱�
     * @param table �û���
     * @throws Exception �쳣����
     */
    public void check(String []argv, Agenda agenda, UserTable table) throws Exception {
        argsCheck(argv, 7);
        loginCheck(table, argv[1], argv[2]);
        
        boolean isExist = table.checkExist(argv[3]);
        if (!isExist)
            throw new UserNotFound(argv[3]);
        if (argv[1].equals(argv[3]))
            throw new SameUser(argv[1]);
        
        boolean isFree = agenda.checkFree(argv[1], argv[4], argv[5]);
        if (!isFree)
            throw new UserTimeConflict(argv[1]);
        isFree = agenda.checkFree(argv[3], argv[4], argv[5]);
        if (!isFree)
            throw new UserTimeConflict(argv[3]);
    }

    /**
     * ִ����ӻ�������
     * @param argv ���������add [userName] [password] [other] [start] [end] [title]
     * @param agenda ��̱�
     * @param table �û���
     * @return ִ�н������ӻ������Ϣ
     * @throws Exception �쳣����
     */
    public String exec(String []argv, Agenda agenda, UserTable table) throws Exception {
        ArrayList <Meeting> addMeeting = agenda.addMeeting(table, argv[1], argv[3], argv[4], argv[5], argv[6]);
        String message = Agenda.getTableForm(addMeeting);
        return message;
    }
}
