package agenda.Exceptions;

/**
 * �û�ʱ���ͻ�쳣��
 */
public class UserTimeConflict extends Exception {
    /**
     * ���캯�����û�ʱ���ͻ��������ѡ��ʱ��
     */
    public UserTimeConflict() {
        super("�û�ʱ���ͻ��������ѡ��ʱ�䡣");
    }

    /**
     * ���캯�����û� name ʱ���ͻ��������ѡ��ʱ��
     * @param name ��ͻ���û���
     */
    public UserTimeConflict(String name) {
        super("�û� " + name + " ʱ���ͻ��������ѡ��ʱ�䡣");
    }
}
