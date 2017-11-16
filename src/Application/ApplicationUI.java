package Application;

import Application.ui.Display;
import Application.ui.DisplayManager;

public class ApplicationUI {

    public static void main(String[] args) {
        Display display = new Display(800,600);
        DisplayManager.getInstance().setDisplay(display);
    }
}
