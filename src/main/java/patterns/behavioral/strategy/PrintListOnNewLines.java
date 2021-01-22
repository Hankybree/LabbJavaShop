package patterns.behavioral.strategy;

import java.util.List;

public class PrintListOnNewLines implements PrintingStrategy{
    @Override
    public void printList(List<?> list) {
        for (var p: list) {
            System.out.println(p.toString());
        }
    }
}
