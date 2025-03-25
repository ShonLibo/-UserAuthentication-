package authentication.ui;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import javax.swing.*;
import static org.junit.jupiter.api.Assertions.*;

class LoginPanelTest {

    private UserAuthApp app;
    private LoginPanel loginPanel;

    @BeforeEach
    void setUp() {
        app = new UserAuthApp();
        loginPanel = new LoginPanel(app);
    }
    @Test
    void testClearFields() {
        // Fill the fields and clear them
        loginPanel.emailField.setText("test@example.com");
        loginPanel.passwordField.setText("password");
        loginPanel.clearFields();

        assertEquals("", loginPanel.emailField.getText());
        assertEquals("", new String(loginPanel.passwordField.getPassword()));
    }
}
