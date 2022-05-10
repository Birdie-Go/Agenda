package agenda.Exceptions;

/**
 * 命令参数数目错误
 */
public class ArgvNumbersError extends Exception {
    /**
     * 构造函数：参数数目错误，输入help以查看正确指令
     */
    public ArgvNumbersError() {
        super("参数数目错误，输入help以查看正确指令。");
    }

    /**
     * 构造函数：参数数目错误，应有 num 个参数。输入help以查看正确指令。
     * @param num 应有参数数目
     */
    public ArgvNumbersError(String num) {
        super("参数数目错误，应有" + num + "个参数。输入help以查看正确指令。");
    }
}
