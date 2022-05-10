package agenda.BussinessLogic.System;
import java.util.*;
import java.text.*;
import agenda.Exceptions.*;

/**
 * �����
 * �洢������Ϣ���֧�����ӡ���ѯ���޸ġ�ɾ������
 */
public class Agenda {
    private ArrayList <Meeting> table;  // ������
    SimpleDateFormat format;            // ʱ���ʽ����Ϣ
    int id;                             // �»���id

    /**
     * ��ʼ��������Ϊ�գ�idΪ0
     * Ĭ���¼���ʽΪyyyy-MM-dd,HH:mm:ss
     */
    public Agenda() {
        table = new ArrayList <Meeting>();
        format = new SimpleDateFormat();
        format.applyPattern("yyyy-MM-dd,HH:mm:ss");
        id = 0;
    }

    /**
     * ��ȡ��̱��ͷ����Ϣ
     * @return �����ͷ��Ϣ
     */
    static public String getHead() {
        return Meeting.getHead();
    }

    /**
     * ��ȡtable�еĻ�����Ϣ
     * @param table ��Ҫ��ȡ�Ļ����
     * @return �����table�е���Ϣ
     */
    static public String getTableForm(ArrayList <Meeting> table) {
        if (table.size() == 0)
            return "";
        String message = Agenda.getHead();
        for (Meeting temp : table) {
            message += temp.getMessage() + '\n';
        }
        return message;
    }

    /**
     * ���һ���µĻ���
     * @param userTable �û���
     * @param userName ���������û�
     * @param company ����������ͬ�û�
     * @param startString ���鿪ʼ�¼�
     * @param endString ��������¼�
     * @param title ��������
     * @return �»��鹹�ɵĻ�������
     * @throws Exception �쳣����
     */
    public ArrayList <Meeting> addMeeting(UserTable userTable, String userName, String company,
                          String startString, String endString, String title) throws Exception {
        User mainUser = userTable.findUser(userName);
        User companyUser = userTable.findUser(company);

        Date start = new Date();
        start = format.parse(startString);
        Date end = new Date();
        end = format.parse(endString);
        id++;
        
        Meeting newMeeting = new Meeting(start, end, title, mainUser, companyUser, id);
        table.add(newMeeting);

        ArrayList <Meeting> addTable = new ArrayList <Meeting> ();
        addTable.add(newMeeting);
        return addTable;
    }

    /**
     * ��ѯ����ʱ�������Ļ���
     * @param userName ���������û�
     * @param startString ��ѯʱ�䷶Χ����ʼʱ��
     * @param endString ��ѯʱ�䷶Χ�Ľ���ʱ��
     * @return ���ز�ѯ����Ļ�������
     * @throws Exception �쳣����
     */
    public ArrayList <Meeting> query(String userName, String startString, String endString) throws Exception {
        Date start = format.parse(startString);
        long startSeconds = start.getTime();
        Date end = format.parse(endString);
        long endSeconds = end.getTime();
        if (start.after(end))
            throw new CommonError("��ʼʱ����ڽ���ʱ�䡣");
        
        ArrayList <Meeting> queryTable = new ArrayList <Meeting> ();
        for (Meeting aMeeting : table) {
            if (!aMeeting.getCompanyUser().getUserName().equals(userName)
                && !aMeeting.getMainUser().getUserName().equals(userName))
                continue;
            
            long meetingStart = aMeeting.getStartTime().getTime();
            long meetingEnd = aMeeting.getEndTime().getTime();
            if (startSeconds <= meetingStart && meetingEnd <= endSeconds) {
                queryTable.add(aMeeting);
            }
        }
        return queryTable;
    }

    /**
     * ����û��ڸ���ʱ����Ƿ����
     * @param userName ����ѯ���û���
     * @param startString ����ʱ��ε���ʼʱ��
     * @param endString ����ʱ��εĽ���ʱ��
     * @return true-���� false-û��
     * @throws Exception �쳣����
     */
    public boolean checkFree(String userName, String startString, String endString) throws Exception {
        Date start = format.parse(startString);
        long startSeconds = start.getTime();
        Date end = format.parse(endString);
        long endSeconds = end.getTime();
        if (startSeconds > endSeconds)
            throw new CommonError("��ʼʱ����ڽ���ʱ�䡣");
        for (Meeting aMeeting : table) {
            if (!aMeeting.getCompanyUser().getUserName().equals(userName)
                && !aMeeting.getMainUser().getUserName().equals(userName))
                continue;
            
            long meetingStart = aMeeting.getStartTime().getTime();
            long meetingEnd = aMeeting.getEndTime().getTime();
            if (startSeconds <= meetingStart && meetingStart <= endSeconds
                || startSeconds <= meetingEnd && meetingEnd <= endSeconds)
                return false;
        }
        return true;
    }

    /**
     * ������id�Ƿ��������̱���
     * @param id ������id
     * @return true-���� false-������
     */
    public boolean isExist(String id) {
        int number = Integer.parseInt(id);
        for (Meeting aMeeting : table) {
            if (aMeeting.getId() == number)
                return true;
        }
        return false;
    }

    /**
     * �����Ϊid�Ļ����Ƿ����û�userName�����
     * @param userName �������û�
     * @param id �����Ļ���id
     * @return true-�Ǹ��û��Ļ��� false-���Ǹ��û��Ļ���
     */
    public boolean isHisMeeting(String userName, String id) {
        int number = Integer.parseInt(id);
        for (Meeting aMeeting : table) {
            if (aMeeting.getId() == number && (aMeeting.getMainUser().getUserName().equals(userName)))
                return true;
        }
        return false;
    }

    /**
     * ��ȡ������Ϊid�Ļ�����Ϣ
     * @param id ������
     * @return ������Ϊid�Ļ�����Ϣ
     */
    public String getMessage(int id) {
        for (Meeting aMeeting : table) {
            if (aMeeting.getId() == id)
                return aMeeting.getMessage();
        }
        return "";
    }

    /**
     * ����û���������л���
     * @param userName �����������û���
     * @return ������������л��鹹�ɵ�����
     */
    public ArrayList <Meeting> clear(String userName) {
        ArrayList <Meeting> tempTable = new ArrayList <Meeting> (table);
        ArrayList <Meeting> clearTable = new ArrayList <Meeting> ();
        for (Meeting aMeeting : table) {
            if (!aMeeting.getMainUser().getUserName().equals(userName))
                continue;
            clearTable.add(aMeeting);
            tempTable.remove(aMeeting);
        }
        table = tempTable;
        return clearTable;
    }

    /**
     * ɾ���û�userName����ı��Ϊid�Ļ���
     * @param userName �û���
     * @param id ������
     * @return ����ɾ���Ļ��鹹�ɵ�����
     */
    public ArrayList <Meeting> delete(String userName, String id) {
        int number = Integer.parseInt(id);
        ArrayList <Meeting> tempTable = new ArrayList <Meeting> (table);
        ArrayList <Meeting> deleteTable = new ArrayList <Meeting> ();
        for (Meeting aMeeting : table) {
            if (aMeeting.getId() != number ||
                !aMeeting.getMainUser().getUserName().equals(userName))
                continue;
            deleteTable.add(aMeeting);
            tempTable.remove(aMeeting);
        }
        table = tempTable;
        return deleteTable;
    }
}
