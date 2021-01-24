package shop;

import shop.commands.AddToCart;
import shop.commands.Command;
import shop.discounts.DiscountStrategy;

import java.math.BigDecimal;
import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class ShoppingCart {

    private Stack<Command> undoStack = new Stack<>();
    private Stack<Command> redoStack = new Stack<>();

    private final Set<ShoppingCartItem> items = new HashSet<>();

    public Set<ShoppingCartItem> getItems() { return items; }

    public void addCartItem(ShoppingCartItem item){
        redoStack.clear();
        AddToCart addToCart = new AddToCart(items, item);
        addToCart.execute();
        undoStack.push(addToCart);
    }

    public Stream<ShoppingCartItem> stream(){
        return items.stream();
    }

    public BigDecimal calculatePrice(){
        var sum = BigDecimal.ZERO;

        for (var item: items) {
            sum = item.itemCost().multiply(BigDecimal.valueOf(item.quantity())).add(sum);
        }
        return sum;
    }

    public BigDecimal calculatePriceWithDiscount(DiscountStrategy discount) {
        return discount.calculatePrice(items, calculatePrice());
    }

    public void undo(){
        redoStack.push(undoStack.lastElement());
        undoStack.pop().unExecute();
    }


    public void redo(){
        redoStack.pop().execute();
    }

    public String receipt() {
        String line = "--------------------------------\n";
        StringBuilder sb = new StringBuilder();
        sb.append(line);
        var list = items.stream()
                .sorted(Comparator.comparing(item -> item.product().name()))
                .collect(Collectors.toList());
        for (var each : list) {
            sb.append(String.format("%-24s % 7.2f\n", each.product().name(), each.itemCost()));
        }
        sb.append(line);
        sb.append(String.format("%24s% 8.2f", "TOTAL:", calculatePrice()));
        return sb.toString();
    }
}
