package agenda.BussinessLogic.System;
import java.util.*;
import java.text.*;
import agenda.Exceptions.*;

/**
 * 议程类
 * 存储会议信息表格，支持增加、查询、修改、删除会议
 */
public class Agenda {
    private ArrayList <Meeting> table;  // 会议表格
    SimpleDateFormat format;            // 时间格式化信息
    int id;                             // 新会议id

    /**
     * 初始化会议表格为空，id为0
     * 默认事件格式为yyyy-MM-dd,HH:mm:ss
     */
    public Agenda() {
        table = new ArrayList <Meeting>();
        format = new SimpleDateFormat();
        format.applyPattern("yyyy-MM-dd,HH:mm:ss");
        id = 0;
    }

    /**
     * 获取议程表的头部信息
     * @return 会议表头信息
     */
    static public String getHead() {
        return Meeting.getHead();
    }

    /**
     * 获取table中的会议信息
     * @param table 需要获取的会议表
     * @return 会议表table中的信息
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
     * 添加一个新的会议
     * @param userTable 用户表
     * @param userName 发起会议的用户
     * @param company 参与会议的陪同用户
     * @param startString 会议开始事件
     * @param endString 会议结束事件
     * @param title 会议主题
     * @return 新会议构成的会议数组
     * @throws Exception 异常基类
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
     * 查询符合时间条件的会议
     * @param userName 参与会议的用户
     * @param startString 查询时间范围的起始时间
     * @param endString 查询时间范围的结束时间
     * @return 返回查询结果的会议数组
     * @throws Exception 异常基类
     */
    public ArrayList <Meeting> query(String userName, String startString, String endString) throws Exception {
        Date start = format.parse(startString);
        long startSeconds = start.getTime();
        Date end = format.parse(endString);
        long endSeconds = end.getTime();
        if (start.after(end))
            throw new CommonError("起始时间大于结束时间。");
        
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
     * 检查用户在给定时间段是否空闲
     * @param userName 待查询的用户名
     * @param startString 给定时间段的起始时间
     * @param endString 给定时间段的结束时间
     * @return true-空闲 false-没空
     * @throws Exception 异常基类
     */
    public boolean checkFree(String userName, String startString, String endString) throws Exception {
        Date start = format.parse(startString);
        long startSeconds = start.getTime();
        Date end = format.parse(endString);
        long endSeconds = end.getTime();
        if (startSeconds > endSeconds)
            throw new CommonError("起始时间大于结束时间。");
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
     * 检查会议id是否存在在议程表中
     * @param id 待检查的id
     * @return true-存在 false-不存在
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
     * 检查编号为id的会议是否是用户userName发起的
     * @param userName 待检查的用户
     * @param id 待检查的会议id
     * @return true-是该用户的会议 false-不是该用户的会议
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
     * 获取会议编号为id的会议信息
     * @param id 会议编号
     * @return 会议编号为id的会议信息
     */
    public String getMessage(int id) {
        for (Meeting aMeeting : table) {
            if (aMeeting.getId() == id)
                return aMeeting.getMessage();
        }
        return "";
    }

    /**
     * 清除用户发起的所有会议
     * @param userName 待清除会议的用户名
     * @return 返回清除的所有会议构成的数组
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
     * 删除用户userName发起的编号为id的会议
     * @param userName 用户名
     * @param id 会议编号
     * @return 返回删除的会议构成的数组
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
