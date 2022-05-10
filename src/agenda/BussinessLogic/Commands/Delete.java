package agenda.BussinessLogic.Commands;
import agenda.BussinessLogic.System.*;
import agenda.Exceptions.*;
import java.util.*;

/**
 * ����ɾ������
 * ����������ɾ��ĳһ�û���ָ�����鰲��
 */
public class Delete extends Command {
    /**
     * ���캯��
     */
    public Delete() {
        name = "����ɾ��";
    }

    /**
     * ��鲿��
     * 1 ������ĿӦΪ4
     * 2 �û���������Ӧ��ȷ
     * 3 ��Ҫɾ���Ļ����Ӧ�������Ǹ��û�����Ļ���
     * @param argv ���������delete [userName] [password] [meetingId]
     * @param agenda ��̱�
     * @param table �û���
     * @throws Exception �쳣����
     */
    public void check(String[] argv, Agenda agenda, UserTable table) throws Exception {
        argsCheck(argv, 4);
        loginCheck(table, argv[1], argv[2]);
        boolean isExist = agenda.isExist(argv[3]);
        if (!isExist)
            throw new MeetingNotFound(argv[3]);
        boolean isHisMeeting = agenda.isHisMeeting(argv[1], argv[3]);
        if (!isHisMeeting)
            throw new NoPermission();
    }

    /**
     * ɾ����������ִ��
     * @param argv ���������delete [userName] [password] [meetingId]
     * @param agenda ��̱�
     * @param table �û���
     * @return ����ִ�н����ɾ��������Ŀ�Լ���ɾ�����������
     * @throws Exception �쳣����
     */
    public String exec(String[] argv, Agenda agenda, UserTable table) throws Exception {
        ArrayList <Meeting> deleteTable = agenda.delete(argv[1], argv[3]);
        String message = "��ɾ��" + argv[3] + "�Ż���\n";
        message += Agenda.getTableForm(deleteTable);
        return message;
    }
}
