package agenda.BussinessLogic.System;
import java.util.*;

/**
 * 用户表类
 * 用于存储所有的用户，提供增加、删除、修改、查找用户
 */
public class UserTable {
    private ArrayList <User> table; // 用户表数组

    /**
     * 构造函数
     * 初始化空表
     */
    public UserTable() {
        table = new ArrayList <User>();
    }

    /**
     * 根据用户名查找用户
     * @param userName 用户名
     * @return 该用户
     */
    public User findUser(String userName) {
        for (User user : table) {
            if (user.getUserName().equals(userName))
                return user;
        }
        return null;
    }

    /**
     * 查找用户userName是否存在
     * @param userName 待查找用户名
     * @return true-存在 false-不存在
     */
    public boolean checkExist(String userName) {
        for (User user : table) {
            if (user.getUserName().equals(userName))
                return true;
        }
        return false;
    }

    /**
     * 添加用户
     * @param newUser 用户名
     * @param password 密码
     */
    public void addUser(String newUser, String password) {
        User aUser = new User(newUser, password);
        table.add(aUser);
    }

    /**
     * 检查用户名的密码是否正确
     * @param userName 用户名
     * @param password 密码
     * @return true-正确 false-不正确
     */
    public boolean checkPassword(String userName, String password) {
        for (User user : table) {
            if (user.getUserName().equals(userName)) {
                if (user.getPassword().equals(password))
                    return true;
            }
        }
        return false;
    }
}