package agenda.BussinessLogic.System;
import java.util.*;

/**
 * �û�����
 * ���ڴ洢���е��û����ṩ���ӡ�ɾ�����޸ġ������û�
 */
public class UserTable {
    private ArrayList <User> table; // �û�������

    /**
     * ���캯��
     * ��ʼ���ձ�
     */
    public UserTable() {
        table = new ArrayList <User>();
    }

    /**
     * �����û��������û�
     * @param userName �û���
     * @return ���û�
     */
    public User findUser(String userName) {
        for (User user : table) {
            if (user.getUserName().equals(userName))
                return user;
        }
        return null;
    }

    /**
     * �����û�userName�Ƿ����
     * @param userName �������û���
     * @return true-���� false-������
     */
    public boolean checkExist(String userName) {
        for (User user : table) {
            if (user.getUserName().equals(userName))
                return true;
        }
        return false;
    }

    /**
     * ����û�
     * @param newUser �û���
     * @param password ����
     */
    public void addUser(String newUser, String password) {
        User aUser = new User(newUser, password);
        table.add(aUser);
    }

    /**
     * ����û����������Ƿ���ȷ
     * @param userName �û���
     * @param password ����
     * @return true-��ȷ false-����ȷ
     */
    public boolean checkPassword(String userName, String password) {
        for (User user : table) {
            if (user.getUserName().equals(userName)) {
                if (user.getPassword().equals(password))
                    return true;
            }
        }
        return false;
    }
}