package ui.panels;

import java.awt.*;

/**
 * @author Koen Griffioen
 * date 14-11-2017
 * PanelType Class which describes all paneltypes. Used for convenient switching between panels.
 */
public enum PanelType {
    MainPanel(new MainPanel(), "MainPanel"),
    TechCompanyListPanel(new TechCompanyListPanel(), "TechCompanyListPanel"),
    TechCompanyItemPanel(new TechCompanyItemPanel(), "TechCompanyItemPanel"),
    LeaseCompanyListPanel(new LeaseCompanyListPanel(), "LeaseCompanyListPanel"),
    LeaseCompanyItemPanel(new LeaseCompanyItemPanel(), "LeaseCompanyItemPanel");

    public Panel getPanel() {
        return panel;
    }

    public void setPanel(Panel panel) {
        this.panel = panel;
    }

    // Panel field
    private Panel panel;

    public String getName(){
        return name;
    }

    private String name;

    // Constructor
    PanelType(Panel panel, String name){
        this.name = name;
        this.panel = panel;
    }

}
