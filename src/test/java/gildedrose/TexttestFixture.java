package gildedrose;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

class TestItem extends Item{

    public TestItem(String name, int sellIn, int quality) {
        super(name, sellIn, quality);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        TestItem item = (TestItem) o;

        if (sellIn != item.sellIn) return false;
        if (quality != item.quality) return false;
        return name != null ? name.equals(item.name) : item.name == null;
    }

    @Override
    public int hashCode() {
        int result = name != null ? name.hashCode() : 0;
        result = 31 * result + sellIn;
        result = 31 * result + quality;
        return result;
    }
}


public class TexttestFixture {
    public static void main(String[] args) {
        System.out.println("OMGHAI!");

        Item[] items = new TestItem[]{
                new TestItem("+5 Dexterity Vest", 10, 20),
                new TestItem("Aged Brie", 2, 0),
                new TestItem("Elixir of the Mongoose", 5, 7),
                new TestItem("Sulfuras, Hand of Ragnaros", 0, 80),
                new TestItem("Sulfuras, Hand of Ragnaros", -1, 80),
                new TestItem("Backstage passes to a TAFKAL80ETC concert", 15, 20),
                new TestItem("Backstage passes to a TAFKAL80ETC concert", 10, 49),
                new TestItem("Backstage passes to a TAFKAL80ETC concert", 5, 49),
                // this conjured item does not work properly yet
                new TestItem("Conjured Mana Cake", 3, 6)};

        Item[] items2 = new TestItem[]{
                new TestItem("+5 Dexterity Vest", 10, 20),
                new TestItem("Aged Brie", 2, 0),
                new TestItem("Elixir of the Mongoose", 5, 7),
                new TestItem("Sulfuras, Hand of Ragnaros", 0, 80),
                new TestItem("Sulfuras, Hand of Ragnaros", -1, 80),
                new TestItem("Backstage passes to a TAFKAL80ETC concert", 15, 20),
                new TestItem("Backstage passes to a TAFKAL80ETC concert", 10, 49),
                new TestItem("Backstage passes to a TAFKAL80ETC concert", 5, 49),
                // this conjured item does not work properly yet
                new TestItem("Conjured Mana Cake", 3, 6)};


        GildedRose app = new GildedRose(items);
        GildedRoseRefactored refactored = new GildedRoseRefactored(items2);

        app.updateQuality();
        refactored.updateQuality();

        assertThat(items).isEqualTo(items2);

//
//
//        int days = 2;
//        if (args.length > 0) {
//            days = Integer.parseInt(args[0]) + 1;
//        }
//
//        for (int i = 0; i < days; i++) {
//            System.out.println("-------- day " + i + " --------");
//            System.out.println("name, sellIn, quality");
//            for (TestItem item : items) {
//                System.out.println(item);
//            }
//            System.out.println();
//        }
    }
}