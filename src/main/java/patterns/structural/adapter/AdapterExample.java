package patterns.structural.adapter;

import org.w3c.dom.html.HTMLImageElement;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

class PrinterData {
    LocalDateTime dateTime;
    String message;

    public PrinterData(LocalDateTime dateTime, String message) {
        this.dateTime = dateTime;
        this.message = message;
    }

    public static PrinterData of(String message) {
        return new PrinterData(LocalDateTime.now(), message);
    }
}

class Message{
    String msg;
    int prio = -1;
}

interface Printer {
    void printData(PrinterData object);
   // void printMessage(Message message);
}



class ConsolePrinter implements Printer {
    @Override
    public void printData(PrinterData object) {
        System.out.println(object.dateTime.format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss")));
        System.out.println(object.message);
    }
}

class IncompatiblePrinter {
    boolean oldAndUglyMethod(char[] mess, String date, String time) {
        System.out.println("Old print method...");
        System.out.println(date + " " + time);
        System.out.println(mess);
        return true; //No paper jam.
    }
}

class PrinterAdapter implements Printer {

    private IncompatiblePrinter printer = new IncompatiblePrinter();

    @Override
    public void printData(PrinterData data) {
        String date = data.dateTime.format(DateTimeFormatter.ofPattern("yyyy-MM-dd"));
        String time = data.dateTime.format(DateTimeFormatter.ofPattern("hh:mm:ss"));
        printer.oldAndUglyMethod(data.message.toCharArray(),
                date, time);
    }
}


public class AdapterExample {
    public static void main(String[] args) {
        Printer printer = new PrinterAdapter();
        printMessage(printer);
    }

    public static void printMessage(Printer printerToUse) {
        PrinterData data = PrinterData.of("This is the message to print");
        printerToUse.printData(data);
    }
}
