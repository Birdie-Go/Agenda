package agenda.BussinessLogic.Commands;
import agenda.BussinessLogic.System.*;
import java.util.*;

/**
 * 会议清除命令
 * 该命令用于查询某一用户在某一时间段内的会议安排
 */
public class Clear extends Command {
    /**
     * 构造函数
     */
    public Clear() {
        name = "会议清除";
    }

    /**
     * 检查部分
     * 1 命令参数数目应为3
     * 2 登录密码应正确
     * @param argv 命令参数：clear [userName] [password]
     * @param agenda 议程表
     * @param table 用户名表
     * @throws Exception 异常基类
     */
    public void check(String[] argv, Agenda agenda, UserTable table) throws Exception {
        argsCheck(argv, 3);
        loginCheck(table, argv[1], argv[2]);
    }

    /**
     * 执行清除会议命令
     * @param argv 命令参数：clear [userName] [password]
     * @param agenda 议程表
     * @param table 用户表
     * @return 命令执行情况：包括清除会议的数量和会议的内容
     * @throws Exception 异常基类
     */
    public String exec(String[] argv, Agenda agenda, UserTable table) throws Exception {
        ArrayList <Meeting> clearTable = agenda.clear(argv[1]);
        String clearSize = String.valueOf(clearTable.size());
        String message = "已清除用户 " + argv[1] + " 发起的" + clearSize + "个会议：\n";
        message += Agenda.getTableForm(clearTable);
        return message;
    }
}
