package agenda.Exceptions;

/**
 * 用户未找到异常类
 */
public class UserNotFound extends Exception {
    /**
     * 构造函数：用户未找到，请输入正确的用户名
     */
    public UserNotFound() {
        super("用户未找到，请输入正确的用户名。");
    }

    /**
     * 构造函数：用户 name 未找到，请输入正确的用户名
     * @param name 未找到的用户名
     */
    public UserNotFound(String name) {
        super("用户 " + name + " 未找到，请输入正确的用户名。");
    }
}
