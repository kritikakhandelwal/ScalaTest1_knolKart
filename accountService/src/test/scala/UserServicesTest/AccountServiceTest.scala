//package UserServicesTest
//import UserModel._
//import UserServices.AccountService
//import org.scalatest.{AsyncFunSuite, FunSuite}
//import sun.text.normalizer.ICUBinary.Authenticate
//
//class AccountServiceTest extends  FunSuite {
//
// // val user = User("USER", "abcd", 9582202539L)
// val userMap:Map[Int,User]
//  val accountService = new AccountService(userMap)
//
//
//  test("Testing log In method for non-existing customer")
//  {
//    accountService.login("Kritika","Knoldus").map(authenticate=> assert())
//  }
//
//  test("authenticate user with success") {
//    assert(accountService.authenticateUser("USER", "abcd").equals("pass"))
//  }
//
//  test("fail to authenticate user ") {
//    assert(!authenticateUser("sajit123", "qwerty123").equals("fail"))
//  }
//}