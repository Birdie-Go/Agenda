package agenda.BussinessLogic.System;

/**
 * �û���
 * ����û����û���������
 */
public class User {
    private String userName;    // �û���
    private String password;    // ����

    /**
     * ���캯��
     * @param _userName �û���
     * @param _password ����
     */
    public User(String _userName, String _password) {
        userName = _userName;
        password = _password;
    }

    /**
     * �����û���
     * @param _userName �û���
     */
    public void setUserName(String _userName) {
        userName = _userName;
    }

    /**
     * ��������
     * @param _password ����
     */
    public void setPassword(String _password) {
        password = _password;
    }

    /**
     * ��ȡ�û���
     * @return �û���
     */
    public String getUserName() {
        return userName;
    }

    /**
     * ��ȡ����
     * @return ����
     */
    public String getPassword() {
        return password;
    }
}
