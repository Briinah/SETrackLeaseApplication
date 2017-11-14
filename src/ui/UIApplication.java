package ui;

import java.awt.*;

public class UIApplication extends Frame {

    private Panel panel1 = new Panel();
    private Panel panel2 = new Panel();

    public UIApplication() {
        initMenu();
        panel1.setBackground(Color.BLUE);
        panel2.setBackground(Color.RED);
        setLayout(new BorderLayout());
    }

    private void initMenu() {
        MenuBar menubar = new MenuBar();
        Menu menu = new Menu("Menu");
        MenuItem menuItem1 = new MenuItem("Panel1");
        MenuItem menuItem2 = new MenuItem("Panel2");
        menubar.add(menu);
        menu.add(menuItem1);
        menu.add(menuItem2);
        setMenuBar(menubar);
    }

    public void changePanel(Panel panel) {
        removeAll();
        add(panel, BorderLayout.CENTER);
        doLayout();
        update(getGraphics());
    }

}
