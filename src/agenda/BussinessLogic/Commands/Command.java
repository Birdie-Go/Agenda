package agenda.BussinessLogic.Commands;
import agenda.BussinessLogic.System.*;
import agenda.Exceptions.*;

/**
 * �����࣬Ϊ��������Ļ���
 * �����������ƣ���¼��飬������Ŀ�˶ԣ�����ִ��
 */
public abstract class Command {
   /**
    * ��������
    */
   protected String name;

   /**
    * �õ���������
    * @return ��������
    */
   public String getName() {
      return name;
   }

   /**
    * ��¼��飬����û��Ƿ�����Լ��û������Ƿ���ȷ
    * @param table �û���
    * @param user ������û�
    * @param password ���������
    * @throws Exception �쳣����
    */
   public void loginCheck(UserTable table, String user, String password) throws Exception {
      boolean isExist = table.checkExist(user);
      if (!isExist)
         throw new UserNotFound(user);

      boolean isRight = table.checkPassword(user, password);
      if (!isRight)
         throw new PasswordError();
   }

   /**
    * ��������Ŀ
    * @param argv �������
    * @param number Ӧ�����������Ŀ
    * @throws Exception �쳣����
    */
   public void argsCheck(String []argv, int number) throws Exception {
      if (argv.length != number)
            throw new ArgvNumbersError(String.valueOf(number));
   }


   /**
    * ��鲿�֣�����ִ������ǰ�ļ��
    * @param argv ��������б�
    * @param agenda ��̱�
    * @param table �û���
    * @throws Exception �쳣����
    */
   public abstract void check(String[] argv, Agenda agenda, UserTable table) throws Exception;

   /**
    * ����ִ�в��֣�����ִ�ж�Ӧ������
    * @param argv ��������б�
    * @param agenda ��̱�
    * @param table �û���
    * @return ����ִ�н��
    * @throws Exception �쳣����
    */
   public abstract String exec(String[] argv, Agenda agenda, UserTable table) throws Exception;
}