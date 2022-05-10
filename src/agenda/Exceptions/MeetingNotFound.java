package agenda.Exceptions;

/**
 * 会议未找到异常类
 */
public class MeetingNotFound extends Exception {
    /**
     * 构造函数：会议未找到，请输入正确的会议号
     */
    public MeetingNotFound() {
        super("会议未找到，请输入正确的会议号。");
    }

    /**
     * 构造函数：会议 name 未找到，请输入正确的会议号
     * @param name 未找到的会议号
     */
    public MeetingNotFound(String name) {
        super("会议 " + name + " 未找到，请输入正确的会议号。");
    }
}
