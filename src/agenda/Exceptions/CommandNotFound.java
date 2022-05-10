package agenda.Exceptions;

/**
 * 命令未找到异常类
 */
public class CommandNotFound extends Exception {
    /**
     * 构造函数：命令未找到: 输入help以查看正确命令
     */
    public CommandNotFound() {
        super("命令未找到: 输入help以查看正确命令。");
    }
}
