package authentication.ui;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import javax.swing.*;

public class UserAuthAppTest {
    private UserAuthApp app;

    @BeforeEach
    public void setUp() {
        app = new UserAuthApp();
    }

    @Test
    public void testShowLoginPanel() {
        app.showPanel("LOGIN");
        assertEquals("LOGIN", app.getPanel().getName());
    }

    @Test
    void testShowRegisterPanel() {
        app.showPanel("REGISTER");
        JPanel panel = app.getPanel();
        assertNotNull(panel, "Register panel should be shown");
    }

}
