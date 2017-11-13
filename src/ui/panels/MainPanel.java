package ui.panels;

import java.awt.*;

public class MainPanel extends Panel {

    Button companyButton;

    public MainPanel(){

        companyButton = new Button("Companies");
        this.add(companyButton);
    }
}
