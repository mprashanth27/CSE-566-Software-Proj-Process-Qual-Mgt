public class InventoryManagementSystem {
    private static final int MAX_ITEMS = 100; // Maximum number of items allowed in inventory
    private Item[] items; // Array to store inventory items
    private int numItems; // Current number of items in inventory

    public InventoryManagementSystem() {
        items = new Item[MAX_ITEMS];
        numItems = 0;
    }

    public void addItem(String name, double price, int quantity) {
        if (numItems >= MAX_ITEMS) {
            System.out.println("Inventory full! Cannot add more items.");
            return;
        }

        items[numItems] = new Item(name, price, quantity);
        numItems++;
        System.out.println("Item added successfully!");
    }

    public void removeItem(String name, int quantity) {
        int foundIndex = findItemByName(name);
        if (foundIndex == -1) {
            System.out.println("Item not found in inventory.");
            return;
        }

        if (items[foundIndex].getQuantity() < quantity) {
            System.out.println("Insufficient quantity available for " + name + ".");
            return;
        }

        items[foundIndex].removeQuantity(quantity);
        numItems--;
        System.out.println(quantity + " units of " + name + " removed from inventory.");
    }

    public void updateItemPrice(String name, double newPrice) {
        int foundIndex = findItemByName(name);
        if (foundIndex == -1) {
            System.out.println("Item not found in inventory.");
            return;
        }

        items[foundIndex].setPrice(newPrice);
        System.out.println("Price of " + name + " updated successfully.");
    }

    public void searchItemByName(String name) {
        int foundIndex = findItemByName(name);
        if (foundIndex == -1) {
            System.out.println("Item not found in inventory.");
            return;
        }

        System.out.println(items[foundIndex].toString());
    }

    public void displayInventory() {
        if (numItems == 0) {
            System.out.println("Inventory is empty.");
            return;
        }

        System.out.println("Inventory List:");
        for (int i = 0; i < numItems; i++) {
            System.out.println(items[i].toString());
        }
    }

    private int findItemByName(String name) {
        for (int i = 0; i < numItems; i++) {
            if (items[i].getName().equals(name)) {
                return i;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        InventoryManagementSystem inventory = new InventoryManagementSystem();

        inventory.addItem("Shirt", 19.99, 10);
        inventory.addItem("Pants", 29.95, 5);
        inventory.addItem("Hat", 14.50, 20);

        inventory.searchItemByName("Shirt");
        inventory.updateItemPrice("Pants", 32.00);
        inventory.removeItem("Hat", 15);

        inventory.displayInventory();
    }
}

class Item {
    private String name;
    private double price;
    private int quantity;

    public Item(String name, double price, int quantity) {
        this.name = name;
        this.price = price;
        this.quantity = quantity;
    }

    public String getName() {
        return name;
    }

    public double getPrice() {
        return price;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setPrice(double newPrice) {
        this.price = newPrice;
    }

    public void removeQuantity(int amount) {
        this.quantity -= amount;
    }

    @Override
    public String toString() {
        return "Name: " + name + ", Price: $" + price + ", Quantity: " + quantity;
    }
}
