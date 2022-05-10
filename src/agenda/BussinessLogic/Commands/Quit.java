package agenda.BussinessLogic.Commands;
import agenda.BussinessLogic.System.*;

/**
 * 退出类
 * 用于退出程序
 */
public class Quit extends Command {
    /**
     * 检查部分：无检查
     * @param argv 命令参数：quit
     * @param agenda 议程表
     * @param table 用户表
     * @throws Exception 异常基类
     */
    public void check(String []argv, Agenda agenda, UserTable table) throws Exception {
    }

    /**
     * 命令执行部分：直接退出程序
     * @param argv 命令参数：quit
     * @param agenda 议程表
     * @param table 用户表
     * @return 空串
     * @throws Exception 异常基类
     */
    public String exec(String []argv, Agenda agenda, UserTable table) throws Exception {
        System.exit(0);
        return "";
    }
}
