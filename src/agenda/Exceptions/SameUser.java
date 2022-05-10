package agenda.Exceptions;

/**
 * 用户重复异常类
 */
public class SameUser extends Exception {
    /**
     * 构造函数：会议需要至少两个用户，添加失败
     */
    public SameUser() {
        super("会议需要至少两个用户，添加失败。");
    }

    /**
     * 构造函数：用户 name 不能与  name 举行会议。会议需要至少两个用户，添加失败
     * @param name 重复的用户名
     */
    public SameUser(String name) {
        super("用户 " + name + " 不能与 " + name + " 举行会议。会议需要至少两个用户，添加失败。");
    }
}
