package agenda.BussinessLogic.Commands;
import agenda.BussinessLogic.System.*;
import agenda.Exceptions.*;

/**
 * �û�ע��
 * ����������ע��һ�����û�
 */
public class Register extends Command {
    /**
     * ���캯��
     */
    public Register() {
        name = "�û�ע��";
    }

    /**
     * ��鲿��
     * 1 ������ĿӦΪ3
     * 2 �û������벻ͬ����ע���û�
     * @param argv ���������register [userName] [password]
     * @param agenda ��̱�
     * @param table �û���
     * @throws Exception �쳣����
     */
    public void check(String []argv, Agenda agenda, UserTable table) throws Exception {
        argsCheck(argv, 3);
        boolean isExist = table.checkExist(argv[1]);
        if (isExist)
            throw new UserNameExist(argv[1]);
    }

    /**
     * ִ���û�ע������
     * @param argv ���������register [userName] [password]
     * @param agenda ��̱�
     * @param table �û���
     * @return ע���û���Ϣ
     * @throws Exception �쳣����
     */
    public String exec(String []argv, Agenda agenda, UserTable table) throws Exception {
        table.addUser(argv[1], argv[2]);
        String message = "ע���û���" + argv[1] + '\n';
        return message;
    }
}
