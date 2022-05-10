package agenda.BussinessLogic.Commands;
import agenda.BussinessLogic.System.*;
import agenda.Exceptions.*;

/**
 * 用户注册
 * 该命令用于注册一个新用户
 */
public class Register extends Command {
    /**
     * 构造函数
     */
    public Register() {
        name = "用户注册";
    }

    /**
     * 检查部分
     * 1 参数数目应为3
     * 2 用户名必须不同于已注册用户
     * @param argv 命令参数：register [userName] [password]
     * @param agenda 议程表
     * @param table 用户表
     * @throws Exception 异常基类
     */
    public void check(String []argv, Agenda agenda, UserTable table) throws Exception {
        argsCheck(argv, 3);
        boolean isExist = table.checkExist(argv[1]);
        if (isExist)
            throw new UserNameExist(argv[1]);
    }

    /**
     * 执行用户注册命令
     * @param argv 命令参数：register [userName] [password]
     * @param agenda 议程表
     * @param table 用户表
     * @return 注册用户信息
     * @throws Exception 异常基类
     */
    public String exec(String []argv, Agenda agenda, UserTable table) throws Exception {
        table.addUser(argv[1], argv[2]);
        String message = "注册用户：" + argv[1] + '\n';
        return message;
    }
}
