package ui.panels;

import company.Company;
import java.awt.*;

public abstract class ItemPanel extends Panel {

    protected Label title;

    Font myFont = new Font("myfont", Font.BOLD, 20);
    protected Company company;

    public ItemPanel(){
        title = new Label("Woooh");
        title.setFont(myFont);
    }

    public void setTitle(String title){
        this.title.setText("Company: "+ title);
        this.title.setVisible(true);

        this.repaint();
    }

    public abstract void setCompany(Company company);
}
