package patterns.behavioral.strategy;

import java.util.List;

public class PrintListOnSameLine implements PrintingStrategy{
    @Override
    public void printList(List<?> list) {
        for (var p: list) {
            System.out.print(p.toString());
        }
    }
}
