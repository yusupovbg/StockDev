import javax.swing.*;
import javax.swing.plaf.InsetsUIResource;
import java.awt.*;
import java.awt.event.*;

public class PortfolioGUI extends JFrame {
    private static JLabel stock;
    private static JPanel portfolioPanel;
    public static GridBagConstraints con = new GridBagConstraints();
    public static JFrame gui = new JFrame("Portfolio");
	public static PortfolioGUI content = new PortfolioGUI(gui);
    

    public static void Show(){
        /* gui.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); */
        content.getContentPane();

        gui.pack();
        gui.setVisible(true);
    }
    public PortfolioGUI(Container pane){
        pane.setLayout(new GridBagLayout());
        pane.setComponentOrientation(ComponentOrientation.RIGHT_TO_LEFT);
        con.fill = GridBagConstraints.HORIZONTAL;
        con.gridx = 0;
        con.gridy = 0;
        con.insets = new Insets(15, 15, 15, 15);
        portfolioPanel = new JPanel();
        portfolioPanel.setLayout(new GridBagLayout());
        pane.add(portfolioPanel, con);

        int count = 0;
        con.gridy = 0;
        con.gridx = 0;
		stock = new JLabel("");
        portfolioPanel.add(stock, con);

		for (int i = 0; i < App.inv1.length; i++){
            String thisInv1 = Double.toString(App.inv1[i]);
            String thisInv2 = Double.toString(App.inv2[i]);
            con.gridy = i;
            if(App.inv1[i] != 0){
                stock.setText(App.stocks[i]+" 	"+thisInv1+" shares at $"+thisInv2+" each.");
				count++;
            }
        }
        if (count == 0){
            stock.setText("You do not have any shares yet.");
        }

        
}
}