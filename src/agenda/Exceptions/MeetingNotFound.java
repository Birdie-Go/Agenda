package agenda.Exceptions;

/**
 * ����δ�ҵ��쳣��
 */
public class MeetingNotFound extends Exception {
    /**
     * ���캯��������δ�ҵ�����������ȷ�Ļ����
     */
    public MeetingNotFound() {
        super("����δ�ҵ�����������ȷ�Ļ���š�");
    }

    /**
     * ���캯�������� name δ�ҵ�����������ȷ�Ļ����
     * @param name δ�ҵ��Ļ����
     */
    public MeetingNotFound(String name) {
        super("���� " + name + " δ�ҵ�����������ȷ�Ļ���š�");
    }
}
