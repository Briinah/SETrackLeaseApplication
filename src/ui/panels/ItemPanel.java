package ui.panels;

import company.Company;
import company.TechCompany;

import java.awt.*;

public abstract class ItemPanel extends Panel {

    protected Label title;
    protected Company company;

    Font myFont = new Font("myfont", Font.BOLD, 20);

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
