package agenda.BussinessLogic.Commands;
import agenda.BussinessLogic.System.*;
import java.util.*;

/**
 * �����������
 * ���������ڲ�ѯĳһ�û���ĳһʱ����ڵĻ��鰲��
 */
public class Clear extends Command {
    /**
     * ���캯��
     */
    public Clear() {
        name = "�������";
    }

    /**
     * ��鲿��
     * 1 ���������ĿӦΪ3
     * 2 ��¼����Ӧ��ȷ
     * @param argv ���������clear [userName] [password]
     * @param agenda ��̱�
     * @param table �û�����
     * @throws Exception �쳣����
     */
    public void check(String[] argv, Agenda agenda, UserTable table) throws Exception {
        argsCheck(argv, 3);
        loginCheck(table, argv[1], argv[2]);
    }

    /**
     * ִ�������������
     * @param argv ���������clear [userName] [password]
     * @param agenda ��̱�
     * @param table �û���
     * @return ����ִ������������������������ͻ��������
     * @throws Exception �쳣����
     */
    public String exec(String[] argv, Agenda agenda, UserTable table) throws Exception {
        ArrayList <Meeting> clearTable = agenda.clear(argv[1]);
        String clearSize = String.valueOf(clearTable.size());
        String message = "������û� " + argv[1] + " �����" + clearSize + "�����飺\n";
        message += Agenda.getTableForm(clearTable);
        return message;
    }
}
