package agenda.Exceptions;

/**
 * 用户时间冲突异常类
 */
public class UserTimeConflict extends Exception {
    /**
     * 构造函数：用户时间冲突，请重新选择时间
     */
    public UserTimeConflict() {
        super("用户时间冲突，请重新选择时间。");
    }

    /**
     * 构造函数：用户 name 时间冲突，请重新选择时间
     * @param name 冲突的用户名
     */
    public UserTimeConflict(String name) {
        super("用户 " + name + " 时间冲突，请重新选择时间。");
    }
}
