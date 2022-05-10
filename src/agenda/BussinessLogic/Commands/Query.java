package agenda.BussinessLogic.Commands;
import agenda.BussinessLogic.System.*;
import java.util.*;

/**
 * �����ѯ����
 * ���������ڲ�ѯĳһ�û���ĳһʱ����ڵĻ��鰲��
 */
public class Query extends Command {
    /**
     * ���캯��
     */
    public Query() {
        name = "�����ѯ";
    }
    
    /**
     * ��鲿��
     * 1 ������ĿӦΪ5
     * 2 �û�������������ȷ
     * @param argv ���������query [userName] [password] [start] [end]
     * @param agenda ��̱�
     * @param table �û���
     * @throws Exception �쳣����
     */
    public void check(String []argv, Agenda agenda, UserTable table) throws Exception {
        argsCheck(argv, 5);
        loginCheck(table, argv[1], argv[2]);
    }

    /**
     * ����ִ�в���
     * @param argv ���������query [userName] [password] [start] [end]
     * @param agenda ��̱�
     * @param table �û���
     * @return ��ѯ�����Ŀ�Լ���������
     * @throws Exception �쳣����
     */
    public String exec(String []argv, Agenda agenda, UserTable table) throws Exception {
        ArrayList <Meeting> queryTable = agenda.query(argv[1], argv[3], argv[4]);
        String querySize = String.valueOf(queryTable.size());
        String message = querySize + "����ѯ�����\n";
        message += Agenda.getTableForm(queryTable);
        return message;
    }
}
