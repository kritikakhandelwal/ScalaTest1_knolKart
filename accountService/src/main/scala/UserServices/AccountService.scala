package UserServices
import scala.io.StdIn
import java.security.KeyStore.PasswordProtection

import UserModel._
import org.apache.log4j.Logger
//import org.apache.log4j.Logger


trait Account {

  def addUser():AccountService

  def login(userName: String, password: String): Long

  def authenticateUser(userName: String, password: String): Long

}

class AccountService(userMap: Map[Int, User]) extends Account {
  val logger=Logger.getLogger(this.getClass)
  override def addUser() : AccountService= {

    val userName = StdIn.readLine("enter User Name\n")
    val password = StdIn.readLine("enter password\n")
    logger.info("enter phone Number\n")
    val phoneNo = StdIn.readLong()
    val userList = userMap.keySet.toList
    val maxKey = userList.max
    val newItem = User(userName: String, password: String, phoneNo: Long)
    val tempMap = Map(maxKey + 1 -> newItem)
    new AccountService(this.userMap ++ tempMap)
  }

  override def login(userName: String, password: String): Long= {
    authenticateUser(userName, password)
//    user match {
//      case 0 => "LoginFail"
//      //case user(0)=>
//      case _ => user.phoneNo.toString
   // }

  }

  override def authenticateUser(userName: String, password: String): Long = {

    //val users = userMap.filter(x => x._2.userName == userName && x._2.password == password)
    for ((k,v) <- userMap){
      if(v.userName==userName && v.password==password) {
        return v.phoneNo
      }
    }
    return 0
  }
}

