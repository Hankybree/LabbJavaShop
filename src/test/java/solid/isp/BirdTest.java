package solid.isp;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.assertj.core.api.Assertions.assertThat;

class BirdTest {
    private final ByteArrayOutputStream consoleContent = new ByteArrayOutputStream();
    private final Bird bird = new Bird();

    @BeforeEach
    public void setUp() {
        System.setOut(new PrintStream(consoleContent));
    }


    @Test
    void run() {
        bird.run();
        assertThat(consoleContent.toString())
                .hasToString("Bird is running");
    }

    @Test
    void fly() {
        bird.fly();
        assertThat(consoleContent.toString())
                .hasToString("Bird is flying");
    }
}