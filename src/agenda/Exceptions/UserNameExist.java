package agenda.Exceptions;

/**
 * �û����Ѵ����쳣��
 */
public class UserNameExist extends Exception {
    /**
     * ���캯�����û������ڣ������������û���
     */
    public UserNameExist() {
        super("�û������ڣ������������û�����");
    }

    /**
     * ���캯�����û��� name ���ڣ������������û���
     * @param name �Ѵ��ڵ��û���
     */
    public UserNameExist(String name) {
        super("�û��� " + name + " ���ڣ������������û�����");
    }
}
