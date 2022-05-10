package agenda.BussinessLogic.Commands;
import java.io.*;
import agenda.BussinessLogic.System.*;

/**
 * 批处理命令
 * 该命令用于批处理存储在文本文件 fileName 中的命令
 */
public class Batch extends Command {
    /**
     * 构造函数
     */
    public Batch() {
        name = "批处理";
    }

    /**
     * 检查参数数量应为2
     * @param argv 命令参数：batch [fileName]
     * @param agenda 议程表
     * @param table 用户表
     * @throws Exception 异常基类
     */
    public void check(String[] argv, Agenda agenda, UserTable table) throws Exception {
        argsCheck(argv, 2);
    }

    /**
     * 执行命令
     * 读取文件中的命令，调用解析器和执行器执行命令
     * @param argv 命令参数：batch [fileName]
     * @param agenda 议程表
     * @param table 用户表
     * @return 执行情况：各个命令的执行情况
     * @throws Exception 异常基类
     */
    public String exec(String[] argv, Agenda agenda, UserTable table) throws Exception {
        File file = new File(argv[1]);
        BufferedReader reader = null;
        Command execWorker;
        Parse parseWorker = new Parse();

        reader = new BufferedReader(new FileReader(file));
        String tempString = "";
        String message = "";
        while ((tempString = reader.readLine()) != null) {
            String []command = tempString.replaceAll(" {2,}", " ").strip().split(" ");
            execWorker = parseWorker.parse(command);
            execWorker.check(command, agenda, table);
            String receiveMessage = execWorker.exec(command, agenda, table);
            message += "-" + tempString + '\n' + receiveMessage + '\n';
        }
        reader.close();
        return message;
    }
}
