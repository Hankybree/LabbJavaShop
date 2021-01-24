package shop;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import shop.discounts.Buy3For2;
import shop.discounts.Get10PercentOver500;
import shop.discounts.GetCheapestForFree;

import java.math.BigDecimal;

import static org.assertj.core.api.Assertions.assertThat;

class ShopTest {

    final ShoppingCart shoppingCart = new ShoppingCart();

    @BeforeEach
    void putSomeItemsInShoppingCart() {
        shoppingCart.addCartItem(new ShoppingCartItem(new Product("Milk"), 9.99, 2));
        shoppingCart.addCartItem(new ShoppingCartItem(new Product("Bread"), 3.0, 3));
        shoppingCart.addCartItem(new ShoppingCartItem(new Product("Butter"), 44.95, 1));
    }

    @Test
    void undoOnce() {
        shoppingCart.undo();
        assertThat(shoppingCart.stream().mapToInt(ShoppingCartItem::quantity).sum()).isEqualTo(5);
        assertThat(shoppingCart.calculatePrice()).isEqualTo(BigDecimal.valueOf(28.98));
    }

    @Test
    void undoTwice() {
        shoppingCart.undo();
        shoppingCart.undo();
        assertThat(shoppingCart.stream().mapToInt(ShoppingCartItem::quantity).sum()).isEqualTo(2);
        assertThat(shoppingCart.calculatePrice()).isEqualTo(BigDecimal.valueOf(19.98));
    }

    @Test
    void undoTwiceThenRedo() {
        shoppingCart.undo();
        shoppingCart.undo();
        shoppingCart.redo();
        assertThat(shoppingCart.stream().mapToInt(ShoppingCartItem::quantity).sum()).isEqualTo(5);
        assertThat(shoppingCart.calculatePrice()).isEqualTo(BigDecimal.valueOf(28.98));
    }


    @Test
    void payingFullPrice() {
        assertThat(shoppingCart.stream().mapToInt(ShoppingCartItem::quantity).sum()).isEqualTo(6);
        assertThat(shoppingCart.calculatePrice()).isEqualTo(BigDecimal.valueOf(73.93));
    }

    @Test
    void payWith3For2Discount() {
        assertThat(shoppingCart.stream().mapToInt(ShoppingCartItem::quantity).sum()).isEqualTo(6);
        assertThat(shoppingCart.calculatePriceWithDiscount(new Buy3For2())).isEqualTo(BigDecimal.valueOf(70.93));
    }

    @Test
    void payWithCheapestFreeDiscount() {
        assertThat(shoppingCart.stream().mapToInt(ShoppingCartItem::quantity).sum()).isEqualTo(6);
        assertThat(shoppingCart.calculatePriceWithDiscount(new GetCheapestForFree())).isEqualTo(BigDecimal.valueOf(70.93));
    }
    @Test
    void payWith10PercentOver500Discount() {
        assertThat(shoppingCart.stream().mapToInt(ShoppingCartItem::quantity).sum()).isEqualTo(6);
        assertThat(shoppingCart.calculatePriceWithDiscount(new Get10PercentOver500())).isEqualTo(BigDecimal.valueOf(73.93));
    }

    @Test
    void payWith10PercentOver500DiscountMoreWares() {
        shoppingCart.addCartItem(new ShoppingCartItem(new Product("Kalaspuffar"), 29.95, 20));
        assertThat(shoppingCart.stream().mapToInt(ShoppingCartItem::quantity).sum()).isEqualTo(26);
        assertThat(shoppingCart.calculatePriceWithDiscount(new Get10PercentOver500())).isEqualTo(BigDecimal.valueOf(605.637));
    }

    @Test
    void createReceiptReturnsTextStringWithAllProducts(){
        assertThat(shoppingCart.receipt()).isEqualTo("""
                --------------------------------
                Bread                       3,00
                Butter                     44,95
                Milk                        9,99
                --------------------------------
                                  TOTAL:   73,93""");
    }
}
