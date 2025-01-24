package am.mmtobacco;


import java.util.ArrayList;
import java.util.List;

public class UpgradeService {

    public boolean canUpgrade(Item item, List<Item> inventory) {
        ItemRarity rarity = item.getRarity();
        long count = inventory.stream()
                .filter(i -> i.getItemName().equals(item.getItemName()) && i.getRarity() == rarity)
                .count();

        if (rarity == ItemRarity.COMMON || rarity == ItemRarity.GREAT || rarity == ItemRarity.RARE) {
            return count >= 3;
        }
        if (rarity == ItemRarity.EPIC) {
            return handleEpicUpgradeCheck(item, inventory);
        }

        return false;
    }

    private boolean handleEpicUpgradeCheck(Item item, List<Item> inventory) {
        if (item.getUpgradeCount() == 0 || item.getUpgradeCount() == 1) {
            return inventory.stream()
                    .anyMatch(i -> i.getRarity() == ItemRarity.EPIC && !i.equals(item));
        } else if (item.getUpgradeCount() == 2) {
            long epic2Count = inventory.stream()
                    .filter(i -> i.getRarity() == ItemRarity.EPIC && i.getUpgradeCount() == 2)
                    .count();
            return epic2Count >= 3;
        }
        return false;
    }

    public void upgradeItem(Item item, Inventory inventory) {
        if (!canUpgrade(item, inventory.getItemsByRarity(item.getRarity()))) {
            throw new IllegalArgumentException("Not enough items to upgrade.");
        }

        ItemRarity currentRarity = item.getRarity();

        if (currentRarity == ItemRarity.COMMON || currentRarity == ItemRarity.GREAT || currentRarity == ItemRarity.RARE) {
            removeItemsForUpgrade(item, inventory, 2);
            inventory.removeItem(item);
            ItemRarity newRarity = getNextRarity(currentRarity);
            item.setRarity(newRarity);
            inventory.addItem(item);
        } else if (currentRarity == ItemRarity.EPIC) {
            handleEpicUpgrade(item, inventory);
        }
    }


    private void handleEpicUpgrade(Item item, Inventory inventory) {
        if (item.getUpgradeCount() == 0 || item.getUpgradeCount() == 1) {
            removeItemsForUpgrade(item, inventory, 1);
            inventory.removeItem(item);
            item.setUpgradeCount(item.getUpgradeCount() + 1);
            inventory.addItem(item);
        } else if (item.getUpgradeCount() == 2) {
            removeItemsForUpgrade(item, inventory, 2);
            inventory.removeItem(item);
            item.setRarity(ItemRarity.LEGENDARY);
            item.setUpgradeCount(0);
            inventory.addItem(item);
        }
    }

    private void removeItemsForUpgrade(Item item, Inventory inventory, int countToRemove) {
        int removedCount = 0;

        List<Item> items = new ArrayList<>(inventory.getItemsByRarity(item.getRarity()));

        for (Item current : items) {
            if (removedCount >= countToRemove) {
                break;
            }
            if (current.getItemName().equals(item.getItemName()) && !current.equals(item)) {
                inventory.removeItem(current);
                removedCount++;
            }
        }

        if (removedCount < countToRemove) {
            throw new IllegalStateException("Could not remove enough items to upgrade.");
        }
    }


    private ItemRarity getNextRarity(ItemRarity rarity) {
        return switch (rarity) {
            case COMMON -> ItemRarity.GREAT;
            case GREAT -> ItemRarity.RARE;
            case RARE -> ItemRarity.EPIC;
            default -> throw new IllegalStateException("Rarity not supported: " + rarity);
        };
    }
}

