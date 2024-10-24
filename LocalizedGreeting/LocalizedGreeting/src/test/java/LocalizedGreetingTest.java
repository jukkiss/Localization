import org.junit.Test;
import org.junit.jupiter.api.BeforeEach;

import java.util.Locale;
import java.util.ResourceBundle;
import static org.junit.Assert.assertEquals;


public class LocalizedGreetingTest {
    private ResourceBundle messages;

    @BeforeEach
    public void setUp() {
        //No specific setup requires
    }

    @Test
    public void testEnglishGreeting() {
        Locale locale = new Locale("en", "UK");
        ResourceBundle messages = ResourceBundle.getBundle("Message", locale);
        String greeting = messages.getString("greeting");
        assertEquals("Hello", greeting);
    }

    @Test
    public void testSpanishGreeting() {
        Locale locale = new Locale("es", "ES");
        ResourceBundle messages = ResourceBundle.getBundle("Message", locale);
        String greeting = messages.getString("greeting");
        assertEquals("Hola", greeting);
    }

    @Test
    public void testFrenchGreeting() {
        Locale locale = new Locale("fr", "FR");
        ResourceBundle messages = ResourceBundle.getBundle("Message", locale);
        String greeting = messages.getString("greeting");
        assertEquals("Bonjour", greeting);
    }

    @Test
    public void testFarsiGreeting() {
        Locale locale = new Locale("fa", "IR");
        ResourceBundle messages = ResourceBundle.getBundle("Message", locale);
        String greeting = messages.getString("greeting");
        assertEquals("سلام", greeting);
    }

    @Test
    public void testJapaneseGreeting() {
        Locale locale = new Locale("ja", "JP");
        ResourceBundle messages = ResourceBundle.getBundle("Message", locale);
        String greeting = messages.getString("greeting");
        assertEquals("こんにちは", greeting);
    }

    @Test
    public void testInvalidChoiceDefaultsToEnglish() {
        Locale locale = new Locale("en", "UK"); // Simulate default choice
        ResourceBundle messages = ResourceBundle.getBundle("Message", locale);
        String greeting = messages.getString("greeting");
        assertEquals("Hello", greeting); // Expected default is English
    }
}

