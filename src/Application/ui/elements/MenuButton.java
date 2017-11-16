package Application.ui.elements;

import java.awt.*;

/**
 * Implements a menu button with set font and preferred size
 * Author: Carolien
 */
public class MenuButton extends Button{

    // make a new font to use for the buttons
    Font buttonFont = new Font("myButtonFont", Font.PLAIN, 18);

    /**
     * Implements a menu button, which inherits form button
     * @param text sets the text of the button
     */
    public MenuButton(String text) {
        super(text);
        this.setFont(buttonFont);
        this.setPreferredSize(new Dimension(200, 60));
    }
}
