package agenda.BussinessLogic.Commands;
import agenda.BussinessLogic.System.*;

/**
 * �˳���
 * �����˳�����
 */
public class Quit extends Command {
    /**
     * ��鲿�֣��޼��
     * @param argv ���������quit
     * @param agenda ��̱�
     * @param table �û���
     * @throws Exception �쳣����
     */
    public void check(String []argv, Agenda agenda, UserTable table) throws Exception {
    }

    /**
     * ����ִ�в��֣�ֱ���˳�����
     * @param argv ���������quit
     * @param agenda ��̱�
     * @param table �û���
     * @return �մ�
     * @throws Exception �쳣����
     */
    public String exec(String []argv, Agenda agenda, UserTable table) throws Exception {
        System.exit(0);
        return "";
    }
}
