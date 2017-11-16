package Application.ui;

import Application.ui.panels.PanelType;

public class DisplayManager {
    // Set using the createDisplayManager().
    private static DisplayManager ourInstance;

    public static DisplayManager getInstance() {
        if(ourInstance == null) ourInstance = new DisplayManager();
        return ourInstance;
    }

    private DisplayManager() {
    }

    public Display getDisplay() {
        return display;
    }

    public void setDisplay(Display display) {
        this.display = display;
    }

    public void setCurrentPanel(PanelType panelType){
        display.switchToPanel(panelType);
    }
    private Display display;

}
