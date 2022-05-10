package agenda.BussinessLogic.Commands;
import agenda.BussinessLogic.System.*;
import java.util.*;

/**
 * 会议查询命令
 * 该命令用于查询某一用户在某一时间段内的会议安排
 */
public class Query extends Command {
    /**
     * 构造函数
     */
    public Query() {
        name = "会议查询";
    }
    
    /**
     * 检查部分
     * 1 参数数目应为5
     * 2 用户名和密码需正确
     * @param argv 命令参数：query [userName] [password] [start] [end]
     * @param agenda 议程表
     * @param table 用户表
     * @throws Exception 异常基类
     */
    public void check(String []argv, Agenda agenda, UserTable table) throws Exception {
        argsCheck(argv, 5);
        loginCheck(table, argv[1], argv[2]);
    }

    /**
     * 命令执行部分
     * @param argv 命令参数：query [userName] [password] [start] [end]
     * @param agenda 议程表
     * @param table 用户表
     * @return 查询结果数目以及会议内容
     * @throws Exception 异常基类
     */
    public String exec(String []argv, Agenda agenda, UserTable table) throws Exception {
        ArrayList <Meeting> queryTable = agenda.query(argv[1], argv[3], argv[4]);
        String querySize = String.valueOf(queryTable.size());
        String message = querySize + "条查询结果：\n";
        message += Agenda.getTableForm(queryTable);
        return message;
    }
}
