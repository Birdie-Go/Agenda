package agenda.BussinessLogic.Commands;
import agenda.BussinessLogic.System.*;

/**
 * 无命令的处理（如直接换行）
 */
public class NoCommand extends Command {
    /**
     * 构造函数
     */
    public NoCommand() {
        name = "";
    }

    /**
     * 检查部分：无检查
     * @param argv 无命令
     * @param agenda 议程表
     * @param table 用户表
     * @throws Exception 异常基类
     */
    public void check(String []argv, Agenda agenda, UserTable table) throws Exception {
    }

    /**
     * 命令执行：无需操作
     * @param argv 无命令
     * @param agenda 议程表
     * @param table 用户表
     * @return 返回一个空串
     * @throws Exception 异常基类
     */
    public String exec(String []argv, Agenda agenda, UserTable table) throws Exception {
        return "";
    }
}
