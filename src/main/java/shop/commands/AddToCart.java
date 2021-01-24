package shop.commands;

import shop.ShoppingCartItem;

import java.util.Set;

public class AddToCart implements Command {
    private Set<ShoppingCartItem> items;
    private ShoppingCartItem item;

    public AddToCart(Set<ShoppingCartItem> items, ShoppingCartItem item) {
        this.items = items;
        this.item = item;
    }

    public void execute() {
        items.add(item);
    }
    public void unExecute() {
        items.remove(item);
    }
}
