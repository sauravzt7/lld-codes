package DifferentDesignPatterns.decorator;

public interface Item {

    String getDescription();
    int getPrice();

}

class BaseItem implements Item{
    private int basePrice;

    public BaseItem(int basePrice){
        this.basePrice = basePrice;
    }

    @Override
    public String getDescription() {
        return "This is item description";
    }

    @Override
    public int getPrice() {
        return basePrice;
    }


}

abstract class ItemDecorator implements Item{

    private Item item;
    public ItemDecorator(Item item){
        this.item = item;
    }
    @Override
    public String getDescription() {
        return item.getDescription();
    }

    @Override
    public int getPrice() {
        return 0;
    }

}

class AddOnDecorator extends ItemDecorator {

    public AddOnDecorator(Item item) {
        super(item);
    }

    @Override
    public String getDescription() {
        return "Item with AddOns";
    }

    @Override
    public int getPrice() {
        return 0;
    }

}
class VariantDecorator extends ItemDecorator{

    private String name;
    private int variantPrice;

    public VariantDecorator(Item item) {
        super(item);
    }

    @Override
    public int getPrice() {
        return super.getPrice() + variantPrice;
    }
}