package authentication.ui;

import org.junit.jupiter.api.Test;
import javax.swing.*;
import java.awt.*;
import static org.junit.jupiter.api.Assertions.*;

public class RegisterPanelTest {

    @Test
    public void testRegisterPanelComponents() {
        RegisterPanel panel = new RegisterPanel(new UserAuthApp());

        assertNotNull(panel.nameField);
        assertNotNull(panel.telField);
        assertNotNull(panel.emailField);
        assertNotNull(panel.passwordField);
        assertNotNull(panel.confirmPasswordField);

        Component[] buttons = ((JPanel) panel.getComponents()[panel.getComponentCount() - 1]).getComponents();
        assertEquals(2, buttons.length);
        assertTrue(buttons[0] instanceof JButton);
        assertTrue(buttons[1] instanceof JButton);
    }

    @Test
    public void testClearFields() {
        RegisterPanel panel = new RegisterPanel(new UserAuthApp());

        panel.nameField.setText("John");
        panel.telField.setText("12345");
        panel.emailField.setText("john@example.com");
        panel.passwordField.setText("password");
        panel.confirmPasswordField.setText("password");

        panel.clearFields();

        assertEquals("", panel.nameField.getText());
        assertEquals("", panel.telField.getText());
        assertEquals("", panel.emailField.getText());
        assertEquals("", new String(panel.passwordField.getPassword()));
        assertEquals("", new String(panel.confirmPasswordField.getPassword()));
    }

    @Test
    public void testBackToSignInButton() {
        TestUserAuthApp app = new TestUserAuthApp();
        RegisterPanel panel = new RegisterPanel(app);

        ((JButton) ((JPanel) panel.getComponents()[panel.getComponentCount() - 1]).getComponents()[1]).doClick();

        assertEquals("LOGIN", app.shownPanel);
    }
}

class TestUserAuthApp extends UserAuthApp {
    public String shownPanel;
    @Override public void showPanel(String panelName) { this.shownPanel = panelName; }
}
