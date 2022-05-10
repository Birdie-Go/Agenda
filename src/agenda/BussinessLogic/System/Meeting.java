package agenda.BussinessLogic.System;
import java.util.*;
import java.text.*;

/**
 * 会议类
 * 用于表达一个会议，包括会议的各种信息
 */
public class Meeting {
    private int meetingId;      // 会议id，会议的唯一标识符
    private Date start;         // 会议的起始时间
    private Date end;           // 会议的结束时间
    private String title;       // 会议主题
    private User mainUser;      // 会议的发起者
    private User companyUser;   // 会议的陪同人

    /**
     * 构造函数
     * @param _start 会议的起始时间
     * @param _end 会议的结束时间
     * @param _title 会议主题
     * @param _mainUser 会议的发起者
     * @param _companyUser 会议的陪同人
     * @param id 会议id，唯一标识符
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
     * 获取会议id
     * @return 会议编号
     */
    public int getId() {
        return meetingId;
    }

    /**
     * 获取会议主题
     * @return 会议主题
     */
    public String getTitle() {
        return title;
    }

    /**
     * 获取会议的发起人
     * @return 会议发起人
     */
    public User getMainUser() {
        return mainUser;
    }

    /**
     * 获取会议的陪同人
     * @return 会议陪同人
     */
    public User getCompanyUser() {
        return companyUser;
    }

    /**
     * 获取会议的起始时间
     * @return 会议起始时间
     */
    public Date getStartTime() {
        return start;
    }

    /**
     * 获取会议结束时间
     * @return 会议结束时间
     */
    public Date getEndTime() {
        return end;
    }

    /**
     * 设置会议id
     * @param _meetingId 会议id
     */
    public void setId(int _meetingId) {
        meetingId = _meetingId;
    }

    /**
     * 设置会议主题
     * @param _title 会议主题
     */
    public void setTitle(String _title) {
        title = _title;
    }

    /**
     * 设置会议的发起人
     * @param _mainUser 会议发起人
     */
    public void setMainUser(User _mainUser) {
        mainUser = _mainUser;
    }

    /**
     * 设置会议的参与者
     * @param _companyUser 会议的参与者
     */
    public void setCompanyUser(User _companyUser) {
        companyUser = _companyUser;
    }

    /**
     * 设置会议起始时间
     * @param _start 会议起始时间
     */
    public void setStartTime(Date _start) {
        start = _start;
    }

    /**
     * 设置会议的结束时间
     * @param _end 会议结束时间
     */
    public void setEndTime(Date _end) {
        end = _end;
    }

    /**
     * 获取会议的表头信息
     * @return 会议表头信息
     */
    static public String getHead() {
        String message = String.format("%5s%10s%22s%24s%14s%14s\n", 
                                       "会议编号", "起始时间", "结束时间", "会议名称",
                                       "会议发起人", "会议陪同");
        return message;
    }

    /**
     * 获取一个会议的所有信息
     * @return 会议信息
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
