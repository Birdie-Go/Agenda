package agenda.BussinessLogic.Commands;
import agenda.BussinessLogic.System.*;
import agenda.Exceptions.*;
import java.util.*;

/**
 * 会议删除命令
 * 该命令用于删除某一用户的指定会议安排
 */
public class Delete extends Command {
    /**
     * 构造函数
     */
    public Delete() {
        name = "会议删除";
    }

    /**
     * 检查部分
     * 1 参数数目应为4
     * 2 用户名和密码应正确
     * 3 需要删除的会议号应存在且是该用户发起的会议
     * @param argv 命令参数：delete [userName] [password] [meetingId]
     * @param agenda 议程表
     * @param table 用户表
     * @throws Exception 异常基类
     */
    public void check(String[] argv, Agenda agenda, UserTable table) throws Exception {
        argsCheck(argv, 4);
        loginCheck(table, argv[1], argv[2]);
        boolean isExist = agenda.isExist(argv[3]);
        if (!isExist)
            throw new MeetingNotFound(argv[3]);
        boolean isHisMeeting = agenda.isHisMeeting(argv[1], argv[3]);
        if (!isHisMeeting)
            throw new NoPermission();
    }

    /**
     * 删除会议命令执行
     * @param argv 命令参数：delete [userName] [password] [meetingId]
     * @param agenda 议程表
     * @param table 用户表
     * @return 命令执行结果：删除会议数目以及所删除会议的内容
     * @throws Exception 异常基类
     */
    public String exec(String[] argv, Agenda agenda, UserTable table) throws Exception {
        ArrayList <Meeting> deleteTable = agenda.delete(argv[1], argv[3]);
        String message = "已删除" + argv[3] + "号会议\n";
        message += Agenda.getTableForm(deleteTable);
        return message;
    }
}
