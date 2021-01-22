package patterns.creational.builder;

class House{
    boolean hasPool;
    boolean hasGarden;
    boolean hasGarage;
    int rooms;

    public House(int rooms, boolean hasPool, boolean hasGarden, boolean hasGarage) {
        this.rooms = rooms;
        this.hasPool = hasPool;
        this.hasGarden = hasGarden;
        this.hasGarage = hasGarage;
    }
}

interface HouseBuilder1 {
    HouseBuilder2 setRooms(int rooms);
}

interface HouseBuilder2 {
    HouseBuilder2 withPool();
    HouseBuilder2 withGarage();
    HouseBuilder2 withGarden();
    House create();
}


class HouseBuilder implements HouseBuilder1, HouseBuilder2{
    private boolean hasPool;
    private boolean hasGarden;
    private boolean hasGarage;
    private int rooms;

    public HouseBuilder2 withPool() {
        hasPool = true;
        return this;
    }

    public HouseBuilder2 withGarden() {
        hasGarden = true;
        return this;
    }

    public HouseBuilder2 withGarage(){
        hasGarage = true;
        return this;
    }

    public HouseBuilder2 setRooms(int rooms) {
        this.rooms = rooms;
        return this;
    }

    public House create() {
        return new House(rooms,hasPool,hasGarden,hasGarage);
    }

    public static HouseBuilder1 builder(){
        return new HouseBuilder();
    }
}


public class BuilderExample {

    public static void main(String[] args) {
        House house = HouseBuilder.builder()
                        .setRooms(2)
                        .withPool()
                        .withGarden()
                        .create();
    }
}
