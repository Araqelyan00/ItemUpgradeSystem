package am.mmtobacco;

public class Item {

    private String itemName;
    private ItemRarity rarity;
    private int upgradeCount;

    public Item() {}

    public Item(String itemName,ItemRarity rarity) {
        this.itemName = itemName;
        this.rarity = rarity;
        this.upgradeCount = 0;
    }


    public String getItemName() {
        return itemName;
    }

    public void setItemName(String itemName) {
        this.itemName = itemName;
    }

    public ItemRarity getRarity() {
        return rarity;
    }

    public void setRarity(ItemRarity rarity) {
        this.rarity = rarity;
    }

    public int getUpgradeCount() {
        return upgradeCount;
    }

    public void setUpgradeCount(int upgradeCount) {
        this.upgradeCount = upgradeCount;
    }

    @Override
    public String toString() {
        return "Item{name='" + itemName + "', rarity=" + rarity + ", upgradeCount=" + upgradeCount + '}';
    }
}
