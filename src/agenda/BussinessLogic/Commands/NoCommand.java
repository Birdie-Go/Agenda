package agenda.BussinessLogic.Commands;
import agenda.BussinessLogic.System.*;

/**
 * ������Ĵ�����ֱ�ӻ��У�
 */
public class NoCommand extends Command {
    /**
     * ���캯��
     */
    public NoCommand() {
        name = "";
    }

    /**
     * ��鲿�֣��޼��
     * @param argv ������
     * @param agenda ��̱�
     * @param table �û���
     * @throws Exception �쳣����
     */
    public void check(String []argv, Agenda agenda, UserTable table) throws Exception {
    }

    /**
     * ����ִ�У��������
     * @param argv ������
     * @param agenda ��̱�
     * @param table �û���
     * @return ����һ���մ�
     * @throws Exception �쳣����
     */
    public String exec(String []argv, Agenda agenda, UserTable table) throws Exception {
        return "";
    }
}
