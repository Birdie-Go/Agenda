package agenda.BussinessLogic.Commands;
import java.util.ArrayList;

import agenda.BussinessLogic.System.*;
import agenda.Exceptions.*;

/**
 * 添加会议命令
 * 该命令用于添加一个新的会议安排
 */
public class Add extends Command {
    /**
     * 构造函数
     */
    public Add() {
        name = "会议添加";
    }

    /**
     * 检查部分
     * 1 参数数目应为7
     * 2 用户密码必须正确
     * 3 用户名必须存在
     * 4 两个与会者不能为同一用户
     * 5 用户开户时间不能与已有会议冲突
     * @param argv 命令参数：add [userName] [password] [other] [start] [end] [title]
     * @param agenda 议程表
     * @param table 用户表
     * @throws Exception 异常基类
     */
    public void check(String []argv, Agenda agenda, UserTable table) throws Exception {
        argsCheck(argv, 7);
        loginCheck(table, argv[1], argv[2]);
        
        boolean isExist = table.checkExist(argv[3]);
        if (!isExist)
            throw new UserNotFound(argv[3]);
        if (argv[1].equals(argv[3]))
            throw new SameUser(argv[1]);
        
        boolean isFree = agenda.checkFree(argv[1], argv[4], argv[5]);
        if (!isFree)
            throw new UserTimeConflict(argv[1]);
        isFree = agenda.checkFree(argv[3], argv[4], argv[5]);
        if (!isFree)
            throw new UserTimeConflict(argv[3]);
    }

    /**
     * 执行添加会议命令
     * @param argv 命令参数：add [userName] [password] [other] [start] [end] [title]
     * @param agenda 议程表
     * @param table 用户表
     * @return 执行结果：添加会议的信息
     * @throws Exception 异常基类
     */
    public String exec(String []argv, Agenda agenda, UserTable table) throws Exception {
        ArrayList <Meeting> addMeeting = agenda.addMeeting(table, argv[1], argv[3], argv[4], argv[5], argv[6]);
        String message = Agenda.getTableForm(addMeeting);
        return message;
    }
}
