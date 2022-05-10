package agenda.Exceptions;

/**
 * 用户名已存在异常类
 */
public class UserNameExist extends Exception {
    /**
     * 构造函数：用户名存在，请重新输入用户名
     */
    public UserNameExist() {
        super("用户名存在，请重新输入用户名。");
    }

    /**
     * 构造函数：用户名 name 存在，请重新输入用户名
     * @param name 已存在的用户名
     */
    public UserNameExist(String name) {
        super("用户名 " + name + " 存在，请重新输入用户名。");
    }
}
