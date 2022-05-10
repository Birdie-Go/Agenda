package agenda.Exceptions;

/**
 * 密码错误类
 */
public class PasswordError extends Exception{
    /**
     * 构造函数：密码错误，请输入正确的密码
     */
    public PasswordError() {
        super("密码错误，请输入正确的密码。");
    }
}
