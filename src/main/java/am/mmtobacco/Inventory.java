package am.mmtobacco;

import java.util.ArrayList;
import java.util.TreeMap;
import java.util.List;
import java.util.Map;

public class Inventory {
    private final Map<ItemRarity, List<Item>> items;

    public Inventory() {
        this.items = new TreeMap<>();
        for (ItemRarity rarity : ItemRarity.values()) {
            items.put(rarity, new ArrayList<>());
        }
    }

    public void addItem(Item item) {
        items.get(item.getRarity()).add(item);
    }

    public void removeItem(Item item) {
        items.get(item.getRarity()).remove(item);
    }

    public List<Item> getItemsByRarity(ItemRarity rarity) {
        return new ArrayList<>(items.get(rarity));
    }

    public void displayInventory() {
        System.out.println("Inventory:");
        for (ItemRarity rarity : items.keySet()) {
            System.out.println(rarity + ": " + items.get(rarity));
        }
    }
}
