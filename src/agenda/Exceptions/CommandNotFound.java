package agenda.Exceptions;

/**
 * ����δ�ҵ��쳣��
 */
public class CommandNotFound extends Exception {
    /**
     * ���캯��������δ�ҵ�: ����help�Բ鿴��ȷ����
     */
    public CommandNotFound() {
        super("����δ�ҵ�: ����help�Բ鿴��ȷ���");
    }
}
