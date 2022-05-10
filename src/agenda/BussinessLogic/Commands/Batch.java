package agenda.BussinessLogic.Commands;
import java.io.*;
import agenda.BussinessLogic.System.*;

/**
 * ����������
 * ����������������洢���ı��ļ� fileName �е�����
 */
public class Batch extends Command {
    /**
     * ���캯��
     */
    public Batch() {
        name = "������";
    }

    /**
     * ����������ӦΪ2
     * @param argv ���������batch [fileName]
     * @param agenda ��̱�
     * @param table �û���
     * @throws Exception �쳣����
     */
    public void check(String[] argv, Agenda agenda, UserTable table) throws Exception {
        argsCheck(argv, 2);
    }

    /**
     * ִ������
     * ��ȡ�ļ��е�������ý�������ִ����ִ������
     * @param argv ���������batch [fileName]
     * @param agenda ��̱�
     * @param table �û���
     * @return ִ����������������ִ�����
     * @throws Exception �쳣����
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
