package agenda.BussinessLogic.Commands;
import agenda.Exceptions.*;

/**
 * 解析类
 * 用于解析命令，得到命令的类型
 */
public class Parse {
    /**
     * 解析命令
     * @param tokens 命令参数
     * @return 具体的命令类的实例
     * @throws Exception 异常基类
     */
    public Command parse(String[] tokens) throws Exception {
        String mainCommand = tokens[0].toLowerCase();
        switch (mainCommand) {
            case "help":
                return new Help();
            case "register":
                return new Register();
            case "add":
                return new Add();
            case "query":
                return new Query();
            case "delete":
                return new Delete();
            case "clear":
                return new Clear();
            case "batch":
                return new Batch();
            case "quit":
                return new Quit();
            case "":
                return new NoCommand();
            default:
                throw new CommandNotFound();
        }
    }
}
