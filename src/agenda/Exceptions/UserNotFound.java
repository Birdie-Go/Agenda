package agenda.Exceptions;

/**
 * �û�δ�ҵ��쳣��
 */
public class UserNotFound extends Exception {
    /**
     * ���캯�����û�δ�ҵ�����������ȷ���û���
     */
    public UserNotFound() {
        super("�û�δ�ҵ�����������ȷ���û�����");
    }

    /**
     * ���캯�����û� name δ�ҵ�����������ȷ���û���
     * @param name δ�ҵ����û���
     */
    public UserNotFound(String name) {
        super("�û� " + name + " δ�ҵ�����������ȷ���û�����");
    }
}
