package agenda.BussinessLogic.Commands;
import agenda.BussinessLogic.System.*;
import agenda.Exceptions.*;

/**
 * 命令类，为各种命令的基类
 * 包括命令名称，登录检查，参数数目核对，检查和执行
 */
public abstract class Command {
   /**
    * 命令名称
    */
   protected String name;

   /**
    * 得到命令名称
    * @return 命令名称
    */
   public String getName() {
      return name;
   }

   /**
    * 登录检查，检查用户是否存在以及用户密码是否正确
    * @param table 用户表
    * @param user 待检查用户
    * @param password 输入的密码
    * @throws Exception 异常基类
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
    * 检查参数数目
    * @param argv 命令参数
    * @param number 应有命令参数数目
    * @throws Exception 异常基类
    */
   public void argsCheck(String []argv, int number) throws Exception {
      if (argv.length != number)
            throw new ArgvNumbersError(String.valueOf(number));
   }


   /**
    * 检查部分，用于执行命令前的检查
    * @param argv 命令参数列表
    * @param agenda 议程表
    * @param table 用户表
    * @throws Exception 异常基类
    */
   public abstract void check(String[] argv, Agenda agenda, UserTable table) throws Exception;

   /**
    * 命令执行部分，用于执行对应的命令
    * @param argv 命令参数列表
    * @param agenda 议程表
    * @param table 用户表
    * @return 命令执行结果
    * @throws Exception 异常基类
    */
   public abstract String exec(String[] argv, Agenda agenda, UserTable table) throws Exception;
}