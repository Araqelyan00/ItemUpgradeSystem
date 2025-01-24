Item Upgrade System
Description
This project implements an item upgrade system for a game. 
Players can upgrade items using others from their inventory according to specified rules. 
The program demonstrates skills in object-oriented programming (OOP), working with collections, and error handling.

Features
1. Supported item rarities:
COMMON
GREAT
RARE
EPIC
LEGENDARY

2. Upgrade logic:
COMMON → GREAT → RARE → EPIC
EPIC → EPIC 1 → EPIC 2 → LEGENDARY

3. Fully console-based interface:
Add items to the inventory.
View inventory.
Upgrade items.

4.Error handling:
Attempting an upgrade without enough items.
Attempting to upgrade an item with an invalid rarity.


Installation and Run Instructions

1. Requirements
Java Development Kit (JDK): Version 17 or higher.
Development Tools: Any IDE (e.g., IntelliJ IDEA, Eclipse) or the command line.

2. Run Instructions
2.1. Clone the repository:
git clone <repository-URL>

2.2. Import the project into your IDE.

2.3. Run the Game class to test the entire functionality.
javac Game.java
java Game


Project Structure

src/
├── Item.java               // Class representing an item
├── ItemRarity.java         // Enum for item rarities
├── Inventory.java          // Class representing the player's inventory
├── UpgradeService.java     // Logic for upgrading items
├── Game.java               // Main testing class


Upgrade Rules

1. COMMON → GREAT → RARE → EPIC:

Upgrading to the next rarity requires 3 items of the same rarity.
For example, upgrading COMMON to GREAT needs 3 COMMON items.

2. EPIC → EPIC 1 → EPIC 2 → LEGENDARY:

EPIC → EPIC 1: Requires 1 additional EPIC item.
EPIC 1 → EPIC 2: Requires 1 additional EPIC item.
EPIC 2 → LEGENDARY: Requires 2 additional EPIC 2 items of the same type.

