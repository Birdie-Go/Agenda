package agenda.Exceptions;

/**
 * 用户权限不足异常类
 */
public class NoPermission extends Exception {
    /**
     * 构造函数：用户权限不足
     */
    public NoPermission() {
        super("用户权限不足");
    }
}
