package agenda.BussinessLogic.Commands;
import agenda.Exceptions.*;

/**
 * ������
 * ���ڽ�������õ����������
 */
public class Parse {
    /**
     * ��������
     * @param tokens �������
     * @return ������������ʵ��
     * @throws Exception �쳣����
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
