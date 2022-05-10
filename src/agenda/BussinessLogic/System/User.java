package agenda.BussinessLogic.System;

/**
 * 用户类
 * 表达用户的用户名和密码
 */
public class User {
    private String userName;    // 用户名
    private String password;    // 密码

    /**
     * 构造函数
     * @param _userName 用户名
     * @param _password 密码
     */
    public User(String _userName, String _password) {
        userName = _userName;
        password = _password;
    }

    /**
     * 设置用户名
     * @param _userName 用户名
     */
    public void setUserName(String _userName) {
        userName = _userName;
    }

    /**
     * 设置密码
     * @param _password 密码
     */
    public void setPassword(String _password) {
        password = _password;
    }

    /**
     * 获取用户名
     * @return 用户名
     */
    public String getUserName() {
        return userName;
    }

    /**
     * 获取密码
     * @return 密码
     */
    public String getPassword() {
        return password;
    }
}
