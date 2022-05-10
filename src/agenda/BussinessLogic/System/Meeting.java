package agenda.BussinessLogic.System;
import java.util.*;
import java.text.*;

/**
 * ������
 * ���ڱ��һ�����飬��������ĸ�����Ϣ
 */
public class Meeting {
    private int meetingId;      // ����id�������Ψһ��ʶ��
    private Date start;         // �������ʼʱ��
    private Date end;           // ����Ľ���ʱ��
    private String title;       // ��������
    private User mainUser;      // ����ķ�����
    private User companyUser;   // �������ͬ��

    /**
     * ���캯��
     * @param _start �������ʼʱ��
     * @param _end ����Ľ���ʱ��
     * @param _title ��������
     * @param _mainUser ����ķ�����
     * @param _companyUser �������ͬ��
     * @param id ����id��Ψһ��ʶ��
     */
    public Meeting(Date _start, Date _end, String _title, User _mainUser, User _companyUser, int id) {
        start = _start;
        end = _end;
        title = _title;
        mainUser = _mainUser;
        companyUser = _companyUser;
        meetingId = id;
    }

    /**
     * ��ȡ����id
     * @return ������
     */
    public int getId() {
        return meetingId;
    }

    /**
     * ��ȡ��������
     * @return ��������
     */
    public String getTitle() {
        return title;
    }

    /**
     * ��ȡ����ķ�����
     * @return ���鷢����
     */
    public User getMainUser() {
        return mainUser;
    }

    /**
     * ��ȡ�������ͬ��
     * @return ������ͬ��
     */
    public User getCompanyUser() {
        return companyUser;
    }

    /**
     * ��ȡ�������ʼʱ��
     * @return ������ʼʱ��
     */
    public Date getStartTime() {
        return start;
    }

    /**
     * ��ȡ�������ʱ��
     * @return �������ʱ��
     */
    public Date getEndTime() {
        return end;
    }

    /**
     * ���û���id
     * @param _meetingId ����id
     */
    public void setId(int _meetingId) {
        meetingId = _meetingId;
    }

    /**
     * ���û�������
     * @param _title ��������
     */
    public void setTitle(String _title) {
        title = _title;
    }

    /**
     * ���û���ķ�����
     * @param _mainUser ���鷢����
     */
    public void setMainUser(User _mainUser) {
        mainUser = _mainUser;
    }

    /**
     * ���û���Ĳ�����
     * @param _companyUser ����Ĳ�����
     */
    public void setCompanyUser(User _companyUser) {
        companyUser = _companyUser;
    }

    /**
     * ���û�����ʼʱ��
     * @param _start ������ʼʱ��
     */
    public void setStartTime(Date _start) {
        start = _start;
    }

    /**
     * ���û���Ľ���ʱ��
     * @param _end �������ʱ��
     */
    public void setEndTime(Date _end) {
        end = _end;
    }

    /**
     * ��ȡ����ı�ͷ��Ϣ
     * @return �����ͷ��Ϣ
     */
    static public String getHead() {
        String message = String.format("%5s%10s%22s%24s%14s%14s\n", 
                                       "������", "��ʼʱ��", "����ʱ��", "��������",
                                       "���鷢����", "������ͬ");
        return message;
    }

    /**
     * ��ȡһ�������������Ϣ
     * @return ������Ϣ
     */
    public String getMessage() {
        SimpleDateFormat aFormat = new SimpleDateFormat("yyyy-MM-dd,hh:mm:ss");
        String startTime = aFormat.format(start);
        String endTime = aFormat.format(end);
        String message = String.format("%5d%25s%25s%20s%20s%20s", 
                                       meetingId, startTime, endTime, title,
                                       mainUser.getUserName(), companyUser.getUserName());
        return message;
    }
}
