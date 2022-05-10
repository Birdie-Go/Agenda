package agenda.Exceptions;

/**
 * 未知错误/普通错误类
 */
public class CommonError extends Exception {
    /**
     * 构造函数：未知错误
     */
    public CommonError() {
        super("未知错误。");
    }

    /**
     * 构造函数
     * @param reason 错误原因
     */
    public CommonError(String reason) {
        super(reason);
    }
}
