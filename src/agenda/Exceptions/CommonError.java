package agenda.Exceptions;

/**
 * δ֪����/��ͨ������
 */
public class CommonError extends Exception {
    /**
     * ���캯����δ֪����
     */
    public CommonError() {
        super("δ֪����");
    }

    /**
     * ���캯��
     * @param reason ����ԭ��
     */
    public CommonError(String reason) {
        super(reason);
    }
}
