
import com.ShoppingCartItems.{ItemServices, Items}
import org.scalatest.{AsyncFunSuite, FunSuite}

  class ItemServicesTest extends FunSuite {


    val itemService = new ItemServices()

    val description = "laptop"


    val item = Items(description, "abc.jpg", "DELL", "Vostro23", 3, 40000)
    val item1 = Items(description, "bcd.jpg", "DELL", "Vostro24", 2, 40500)


    test("should search based onn given category with success") {
      itemService.searchBasedOnCategory("laptop").map(list => assert(list == List(item, item1)))
    }

    test("test sort items with price low to high") {
      itemService.sortItems("price: low to high").map(list => assert(list == List(item, item1))
    }

    test("test sort items with rating high to low") {
      itemService.sortItems("rating: high to low").map(list => assert(list == List(item, item1)))
    }
    test("test sort items with price high to low`") {
      itemService.sortItems("price: high to low").map(list => assert(list == List(item1, item)))
    }


}
