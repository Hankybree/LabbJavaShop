package shop.discounts;

import shop.ShoppingCartItem;

import java.math.BigDecimal;
import java.util.Set;

public class Buy3For2 implements DiscountStrategy {

    public BigDecimal calculatePrice(Set<ShoppingCartItem> items, BigDecimal originalCost) {
        BigDecimal sum = originalCost;

        for (var item: items) {
            if (item.quantity() > 2) {
                sum = sum.subtract(item.itemCost());
            }
        }

        return sum;
    }
}
