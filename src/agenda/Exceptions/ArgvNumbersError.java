package agenda.Exceptions;

/**
 * ���������Ŀ����
 */
public class ArgvNumbersError extends Exception {
    /**
     * ���캯����������Ŀ��������help�Բ鿴��ȷָ��
     */
    public ArgvNumbersError() {
        super("������Ŀ��������help�Բ鿴��ȷָ�");
    }

    /**
     * ���캯����������Ŀ����Ӧ�� num ������������help�Բ鿴��ȷָ�
     * @param num Ӧ�в�����Ŀ
     */
    public ArgvNumbersError(String num) {
        super("������Ŀ����Ӧ��" + num + "������������help�Բ鿴��ȷָ�");
    }
}
