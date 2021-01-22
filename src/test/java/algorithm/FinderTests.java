package algorithm;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;

class FinderTests {

    Thing sue = new Thing();
    Thing greg = new Thing();
    Thing sarah = new Thing();
    Thing mike = new Thing();

    @BeforeEach
    public void setup() {
        sue.name = "Sue";
        sue.birthDate = new Date(50, 0, 1);
        greg.name = "Greg";
        greg.birthDate = new Date(52, 5, 1);
        sarah.name = "Sarah";
        sarah.birthDate = new Date(82, 0, 1);
        mike.name = "Mike";
        mike.birthDate = new Date(79, 0, 1);
    }

    @Test
    void Returns_Empty_Results_When_Given_Empty_List() {
        List<Thing> list = new ArrayList<>();
        Finder finder = new Finder(list);

        F result = finder.Find(FT.One);
        assertNull(result.P1);

        assertNull(result.P2);
    }

    @Test
    void Returns_Empty_Results_When_Given_One_Person() {
        List<Thing> list = new ArrayList<>();
        list.add(sue);

        Finder finder = new Finder(list);

        F result = finder.Find(FT.One);

        assertNull(result.P1);
        assertNull(result.P2);
    }

    @Test
    void Returns_Closest_Two_For_Two_People() {
        List<Thing> list = new ArrayList<>();
        list.add(sue);
        list.add(greg);
        Finder finder = new Finder(list);

        F result = finder.Find(FT.One);

        assertEquals(sue, result.P1);
        assertEquals(greg, result.P2);
    }

    @Test
    void Returns_Furthest_Two_For_Two_People() {
        List<Thing> list = new ArrayList<>();
        list.add(mike);
        list.add(greg);

        Finder finder = new Finder(list);

        F result = finder.Find(FT.Two);

        assertEquals(greg, result.P1);
        assertEquals(mike, result.P2);
    }

    @Test
    void Returns_Furthest_Two_For_Four_People() {
        List<Thing> list = new ArrayList<>();
        list.add(sue);
        list.add(sarah);
        list.add(mike);
        list.add(greg);
        Finder finder = new Finder(list);

        F result = finder.Find(FT.Two);

        assertEquals(sue, result.P1);
        assertEquals(sarah, result.P2);
    }

    @Test
    void Returns_Closest_Two_For_Four_People() {
        List<Thing> list = new ArrayList<>();
        list.add(sue);
        list.add(sarah);
        list.add(mike);
        list.add(greg);

        Finder finder = new Finder(list);

        F result = finder.Find(FT.One);

        assertEquals(sue, result.P1);
        assertEquals(greg, result.P2);
    }

}
