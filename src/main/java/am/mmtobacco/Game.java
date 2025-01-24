package am.mmtobacco;


public class Game {
    public static void main(String[] args) {
        testingStandards();
        testingEpics();
    }

    public static void testingStandards(){
        Inventory inventory = new Inventory();
        UpgradeService upgradeService = new UpgradeService();

        Item sword1 = new Item("Iron Sword", ItemRarity.COMMON);
        Item sword2 = new Item("Iron Sword", ItemRarity.COMMON);
        Item sword3 = new Item("Iron Sword", ItemRarity.COMMON);

        inventory.addItem(sword1);
        inventory.addItem(sword2);
        inventory.addItem(sword3);

        System.out.println();
        inventory.displayInventory();

        if (upgradeService.canUpgrade(sword1, inventory.getItemsByRarity(ItemRarity.COMMON))) {
            upgradeService.upgradeItem(sword1, inventory);
        }

        System.out.println();
        inventory.displayInventory();
    }


    public static void testingEpics(){
        Inventory inventory = new Inventory();
        UpgradeService upgradeService = new UpgradeService();

        Item epic1 = new Item("Golden Sword", ItemRarity.EPIC);
        Item epic2 = new Item("Golden Sword", ItemRarity.EPIC);

        inventory.addItem(epic1);
        inventory.addItem(epic2);

        System.out.println();
        inventory.displayInventory();

        if (upgradeService.canUpgrade(epic1, inventory.getItemsByRarity(ItemRarity.EPIC))) {
            upgradeService.upgradeItem(epic1, inventory);
        }

        System.out.println();
        inventory.displayInventory();


        Item epic4 = new Item("Golden Sword", ItemRarity.EPIC);
        inventory.addItem(epic4);

        System.out.println();
        inventory.displayInventory();


        if (upgradeService.canUpgrade(epic1, inventory.getItemsByRarity(ItemRarity.EPIC))) {
            upgradeService.upgradeItem(epic1, inventory);
        }

        System.out.println();
        inventory.displayInventory();


        Item epic2_1 = new Item("Golden Sword", ItemRarity.EPIC);
        Item epic2_2 = new Item("Golden Sword", ItemRarity.EPIC);
        epic2_1.setUpgradeCount(2);
        epic2_2.setUpgradeCount(2);
        inventory.addItem(epic2_1);
        inventory.addItem(epic2_2);

        System.out.println();
        inventory.displayInventory();


        if (upgradeService.canUpgrade(epic1, inventory.getItemsByRarity(ItemRarity.EPIC))) {
            upgradeService.upgradeItem(epic1, inventory);
        }

        System.out.println();
        inventory.displayInventory();
    }
}

