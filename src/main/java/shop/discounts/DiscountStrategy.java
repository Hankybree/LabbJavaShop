package shop.discounts;

import shop.ShoppingCartItem;

import java.math.BigDecimal;
import java.util.Set;

public interface DiscountStrategy {
    BigDecimal calculatePrice(Set<ShoppingCartItem> items, BigDecimal originalCost);
}
