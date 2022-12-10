import javax.swing.*;
import javax.swing.plaf.InsetsUIResource;
import java.awt.*;
import java.awt.event.*;

public class SellGUI extends JFrame {
    private static JButton sellOibes, sellRhodesia, sellUpGo, sellMariana, sellKrasnyi;
    private static JLabel companyName, priceOibes, priceRhodesia, priceUpGo, priceMariana, priceKrasnyi, debt;
    private static JPanel sellStocks;
    public static GridBagConstraints con = new GridBagConstraints();
    public static JFrame gui = new JFrame("Sell Stocks");
	public static SellGUI content = new SellGUI(gui);
    

    public static void Show(){
        content.getContentPane();

        gui.pack();
        gui.setVisible(true);
    }
    public SellGUI(Container pane){
        pane.setLayout(new GridBagLayout());
        pane.setComponentOrientation(ComponentOrientation.RIGHT_TO_LEFT);
        con.fill = GridBagConstraints.HORIZONTAL;
        con.gridx = 0;
        con.gridy = 0;
        con.insets = new Insets(15, 15, 15, 15);
        sellStocks = new JPanel();
        sellStocks.setLayout(new GridBagLayout());
        pane.add(sellStocks, con);

        companyName = new JLabel("Oibes & Co.");
        sellOibes = new JButton("Sell");
        con.gridx = 0;
        con.gridy = 1;
        sellStocks.add(companyName, con);
        con.gridx = 2;
        sellStocks.add(sellOibes, con);

        companyName = new JLabel("Rhodesia Decoder Integrations");
        sellRhodesia = new JButton("Sell");
        con.gridx = 0;
		con.gridy++;
        sellStocks.add(companyName, con);
        con.gridx = 2;
        sellStocks.add(sellRhodesia, con);

        companyName = new JLabel("Up&Go");
        sellUpGo = new JButton("Sell");
        con.gridx = 0;
		con.gridy++;
        sellStocks.add(companyName, con);
        con.gridx = 2;
        sellStocks.add(sellUpGo, con);

        companyName = new JLabel("Mariana-Monokai-Webster.");
        sellMariana = new JButton("Sell");
        con.gridx = 0;
		con.gridy++;
        sellStocks.add(companyName, con);
        con.gridx = 2;
        sellStocks.add(sellMariana, con);

        companyName = new JLabel("Krasnyi Byk Ltd.");
        sellKrasnyi = new JButton("Sell");
        con.gridx = 0;
		con.gridy++;
        sellStocks.add(companyName, con);
        con.gridx = 2;
        sellStocks.add(sellKrasnyi, con);   


        showPrices(pane, false);

        HandlerClass handler = new HandlerClass();
		sellOibes.addActionListener(handler);
		sellRhodesia.addActionListener(handler);
		sellUpGo.addActionListener(handler);
		sellMariana.addActionListener(handler);
		sellKrasnyi.addActionListener(handler);
    }

    public static void showPrices(Container pane, boolean update){
        con.gridx = 1;
        con.gridy = 0;
        con.weighty = 0.0;
        JPanel sharePrice = new JPanel();
        sharePrice.setLayout(new GridBagLayout());
        pane.add(sharePrice, con);
        if (update == false){    
            con.gridx++;
            con.gridy = 0;
            debt = new JLabel("");
            sellStocks.add(debt, con);

			con.gridy = 1;
			
			con.gridx = 1;
			String thisInv1 = Double.toString(App.inv1[con.gridy]);
			priceOibes = new JLabel("("+thisInv1+")");
			sellStocks.add(priceOibes, con);
			
			con.gridy++;
			con.gridx = 1;
			thisInv1 = Double.toString(App.inv1[con.gridy]);
			priceRhodesia = new JLabel("("+thisInv1+")");
			sellStocks.add(priceRhodesia, con);

			con.gridy++;
			con.gridx = 1;
			thisInv1 = Double.toString(App.inv1[con.gridy]);
			priceUpGo = new JLabel("("+thisInv1+")");
			sellStocks.add(priceUpGo, con);

			con.gridy++;
			con.gridx = 1;
			thisInv1 = Double.toString(App.inv1[con.gridy]);
			priceMariana = new JLabel("("+thisInv1+")");
			sellStocks.add(priceMariana, con);

			con.gridy++;
            con.gridx = 1;
			thisInv1 = Double.toString(App.inv1[con.gridy]);
			priceKrasnyi = new JLabel("("+thisInv1+")");
			sellStocks.add(priceKrasnyi, con);

			con.gridy++;
        } else {
			int count = 0;
			String thisInv1 = Double.toString(App.inv1[count]);
			priceOibes.setText("("+thisInv1+")");
			count++;
			thisInv1 = Double.toString(App.inv1[count]);
			priceRhodesia.setText("("+thisInv1+")");
			count++;
			thisInv1 = Double.toString(App.inv1[count]);
			priceUpGo.setText("("+thisInv1+")");
			count++;
			thisInv1 = Double.toString(App.inv1[count]);
			priceMariana.setText("("+thisInv1+")");
			count++;
			thisInv1 = Double.toString(App.inv1[count]);
			priceKrasnyi.setText("("+thisInv1+")");
			pane.repaint();
		}
    }

    private class HandlerClass implements ActionListener {
		int amount;
		JOptionPane yesNo;
		Object[] options = new String[] {"Yes", "No"};
		JDialog dialog;
		public void actionPerformed(ActionEvent event) {
			if(event.getSource() == sellOibes || event.getSource() == sellRhodesia || event.getSource() == sellUpGo || event.getSource() == sellMariana || event.getSource() == sellKrasnyi) {
				String StAmount	= JOptionPane.showInputDialog("How many shares would you like to Sell?");
				amount = Integer.parseInt(StAmount);
                
			}
			
			if(event.getSource() == sellOibes) {
                if(amount > App.inv1[0]) {
                    JOptionPane.showConfirmDialog(null, "You only have "+ App.inv1[0]+" shares in that company.");
                    Game.sleep(800);
                    Money.sellStockGUI();
                } else{
                    yesNo	= new JOptionPane("Sell "+amount+" shares in Oibes & Co. for $"+App.exchange[0]+" each? (Total $"+(amount*App.exchange[0])+")");
				    yesNo.setOptions(options);
				    dialog = yesNo.createDialog(new JFrame(), "Dialog");
				    dialog.setVisible(true);
				    Money.amount = amount;
				    Money.input = 1;
				    Money.sellStockGUI();
                    showPrices(gui, true);
                }
			}
			
			if(event.getSource() == sellRhodesia) {
                if(amount > App.inv1[1]) {
                    JOptionPane.showConfirmDialog(null, "You only have "+ App.inv1[1]+" shares in that company.");
                    Game.sleep(800);
                    Money.sellStockGUI();
                } else{
                    yesNo = new JOptionPane("Sell "+amount+" shares in Rhodesia Decoder Integrations for $"+App.exchange[1]+" each? (Total $"+(amount*App.exchange[1])+")");
				    yesNo.setOptions(options);
				    dialog = yesNo.createDialog(new JFrame(), "Dialog");
				    dialog.setVisible(true);
				    Money.amount = amount;
				    Money.input = 2;
				    Money.sellStockGUI();
                    showPrices(gui, true);
                }
			}
			
			if(event.getSource() == sellUpGo) {
                if(amount > App.inv1[2]) {
                    JOptionPane.showConfirmDialog(null, "You only have "+ App.inv1[2]+" shares in that company.");
                    Game.sleep(800);
                    Money.sellStockGUI();
                } else{
                    yesNo = new JOptionPane("Sell "+amount+" shares in Up&Go for $"+App.exchange[2]+" each? (Total $"+(amount*App.exchange[2])+")");
				    yesNo.setOptions(options);
				    dialog = yesNo.createDialog(new JFrame(), "Dialog");
				    dialog.setVisible(true);
				    Money.amount = amount;
				    Money.input = 3;
				    Money.sellStockGUI();
                    showPrices(gui, true);
                }
			}
			
			if(event.getSource() == sellMariana) {
                if(amount > App.inv1[3]) {
                    JOptionPane.showConfirmDialog(null, "You only have "+ App.inv1[3]+" shares in that company.");
                    Game.sleep(800);
                    Money.sellStockGUI();
                } else{
                    yesNo	= new JOptionPane("Sell "+amount+" shares in Mariana-Monokai-Webster. for $"+App.exchange[3]+" each? (Total $"+(amount*App.exchange[3])+")");
				    yesNo.setOptions(options);
				    dialog = yesNo.createDialog(new JFrame(), "Dialog");
				    dialog.setVisible(true);
				    Money.amount = amount;
				    Money.input = 4;
				    Money.sellStockGUI();
                    showPrices(gui, true);
                }
			}
			
			if(event.getSource() == sellKrasnyi) {
                if(amount > App.inv1[4]) {
                    JOptionPane.showConfirmDialog(null, "You only have "+ App.inv1[4]+" shares in that company.");
                    Game.sleep(800);
                    Money.sellStockGUI();
                } else{
                    yesNo	= new JOptionPane("Sell "+amount+" shares in Krasnyi Byk Ltd. for $"+App.exchange[4]+" each? (Total $"+(amount*App.exchange[4])+")");
				    yesNo.setOptions(options);
				    dialog = yesNo.createDialog(new JFrame(), "Dialog");
				    dialog.setVisible(true);
				    Money.amount = amount;
				    Money.input = 5;
				    Money.sellStockGUI();
                    showPrices(gui, true);
                }
			}
		}
	}
}