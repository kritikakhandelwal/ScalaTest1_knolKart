package com.ShoppingCartItems

import org.apache.log4j.Logger

import scala.concurrent.Future

trait ItemFunctions {
  def viewAllItems()
  def searchBasedOnCategory(category: String):Option[List[Items]]

  def sortItems(searchParameter: String):List[Items]

}

class ItemServices extends ItemFunctions {
  val logger=Logger.getLogger(this.getClass)
  val description = "Laptop"
  val item = Items(description, "abc.jpg", "DELL", "Vostro23", 3, 40000)
  val item1 = Items(description, "bcd.jpg", "DELL", "Vostro24", 2, 40500)
  val item2 = Items(description, "efg.jpg", "DELL", "Vostro20", 5, 45500)
  val item3 = Items(description, "hij.jpg", "DELL", "Vostro24", 6, 45000)
  val item4 = Items(description, "lmn.jpg", "DELL", "Vostro23", 7, 46000)


  val itemMap = Map(description -> List(item1, item2,item3,item4))
  override def viewAllItems(): Unit={
    val list=itemMap.get(description)
    logger.info("Category : "+description)
    for(i<-list){
      logger.info(i)
    }
  }

  override def searchBasedOnCategory(description: String): Option[List[Items]] = {
    itemMap.get(description)
  }

  override def sortItems(searchParameter: String): List[Items] = {

    searchParameter match {
      case "price: high to low" => itemMap.values.toList.flatten.sortWith(_.price > _.price)
      case "price: low to high" => itemMap.values.toList.flatten.sortWith(_.price < _.price)
      case "rating: low to high" => itemMap.values.toList.flatten.sortWith(_.rating < _.rating)
      case _ => itemMap.values.toList.flatten.sortWith(_.rating > _.rating)
    }

  }


}