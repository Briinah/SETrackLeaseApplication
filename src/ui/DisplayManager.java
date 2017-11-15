package ui;

import ui.panels.PanelType;

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
        if(panelType == PanelType.TechCompanyItemPanel || panelType == PanelType.LeaseCompanyItemPanel){
            System.out.println("No item was selected");
        }
        else {
            display.switchToPanel(panelType);
        }
    }

    /**
     * If new panel is an item panel, set current item to given item
     * @param panelType panel type
     * @param itemName the name of the viewed item
     */
    public void setCurrentPanel(PanelType panelType, String itemName){
        if(panelType == PanelType.TechCompanyItemPanel || panelType == PanelType.LeaseCompanyItemPanel) {
            if(itemName.equals("")) {
                System.out.println("No item was selected");
                return;
            }

            display.setItemName(itemName);
            display.switchToPanel(panelType);
        }
    }

    private Display display;

}
