package agenda.Exceptions;

/**
 * �û��ظ��쳣��
 */
public class SameUser extends Exception {
    /**
     * ���캯����������Ҫ���������û������ʧ��
     */
    public SameUser() {
        super("������Ҫ���������û������ʧ�ܡ�");
    }

    /**
     * ���캯�����û� name ������  name ���л��顣������Ҫ���������û������ʧ��
     * @param name �ظ����û���
     */
    public SameUser(String name) {
        super("�û� " + name + " ������ " + name + " ���л��顣������Ҫ���������û������ʧ�ܡ�");
    }
}
