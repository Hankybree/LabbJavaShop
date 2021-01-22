package shop.discounts;

import shop.ShoppingCartItem;

import java.math.BigDecimal;
import java.util.Set;

public class Get10PercentOver500 implements DiscountStrategy {

    public BigDecimal calculatePrice(Set<ShoppingCartItem> items, BigDecimal originalCost) {
        BigDecimal sum = originalCost;

        if (sum.doubleValue() >= 500) {
            sum = sum.multiply(BigDecimal.valueOf(0.9));
        }

        return sum;
    }
}
