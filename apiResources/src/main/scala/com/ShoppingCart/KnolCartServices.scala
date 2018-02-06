package com.ShoppingCart

import UserModel.User
import UserServices.AccountService
//import com.Checkout.CheckOutService
import com.ShoppingCartItems.ItemServices

object KnolCartDemo {
  val obj1 = User(" ", " ", 0)
  val userMap: Map[Int, User] = Map(0 -> obj1)
  val login = new AccountService(userMap)
  val inventory = new ItemServices
  //val checkOut = new CheckOutService()

}
