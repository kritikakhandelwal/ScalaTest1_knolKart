package com.knolCart

import UserServices.AccountService
import com.ShoppingCart.KnolCartDemo
import com.ShoppingCartItems.Items
import org.apache.log4j.Logger

import scala.io.StdIn

object Dashboard extends App {

  val logger = Logger.getLogger(this.getClass)

//  val loginApi = KnolCartDemo.login
//  val loginUser:AccountService = loginApi.addUser()
//  val username = StdIn.readLine("Enter Username")
//  val password = StdIn.readLine("Enter password")
//  val token = loginUser.login(username, password)
val token=10
  if (token != 0) {
    val inventoryApi = KnolCartDemo.inventory
    inventoryApi.viewAllItems()
    val description = StdIn.readLine("\n enter category of Item to view")
    logger.info(inventoryApi.searchBasedOnCategory(description))
    logger.info("\n Press 1:View Product list (Price:High to low) \n")
    logger.info("Press 2:View Product list (Price:Low to High)\n ")
    logger.info("Press 3:View Product list (Rating:Low to High)\n ")
    val parameterSelected = StdIn.readInt()
    parameterSelected match {
      case 1 => logger.info(inventoryApi.sortItems("price: high to low"))
      case 2 => logger.info(inventoryApi.sortItems("price: low to high"))
      case 3 => logger.info(inventoryApi.sortItems("rating: low to high"))
    }
//    logger.info("Do you want to checkout(Y or N)")
//    val choice=StdIn.readChar()
//    choice match{
//      case 'Y'=>val list= inventoryApi.searchBasedOnCategory(description)
//        val checkoutApi=KnolCartDemo.checkOut
//      //case 'N'=>
//    }
  }
  else{
    logger.info("Wrong UserName or Password entered ")
  }


}
