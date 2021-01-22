package shop.discounts;

import shop.ShoppingCartItem;

import java.math.BigDecimal;
import java.util.Set;

public class GetCheapestForFree implements DiscountStrategy {

    public BigDecimal calculatePrice(Set<ShoppingCartItem> items, BigDecimal originalCost) {
        BigDecimal sum = originalCost;
        BigDecimal lowestPrice = originalCost;

        for (var item: items) {
            if (item.itemCost().doubleValue() < lowestPrice.doubleValue()) {
                lowestPrice = item.itemCost();
            }
        }

        sum = sum.subtract(lowestPrice);

        return sum;
    }
}
