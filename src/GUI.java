import javax.swing.*;
import javax.swing.plaf.InsetsUIResource;
import java.awt.*;
import java.awt.event.*;

public class GUI extends JFrame {
    private static JButton buyOibes, buyRhodesia, buyUpGo, buyMariana, buyKrasnyi, nextRound, portfolio, sell;
    private static JLabel companyName, priceOibes, priceRhodesia, priceUpGo, priceMariana, priceKrasnyi , balance, debt, stock;
    private static JPanel buyStocks;
    public static GridBagConstraints con = new GridBagConstraints();
    public static JFrame gui = new JFrame("StockDev v.1.0.0");
	public static GUI content = new GUI(gui);
    

    public static void Show(){
        gui.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        content.getContentPane();

        gui.pack();
        gui.setVisible(true);
    }
    public GUI(Container pane){
        pane.setLayout(new GridBagLayout());
        pane.setComponentOrientation(ComponentOrientation.RIGHT_TO_LEFT);
        con.fill = GridBagConstraints.HORIZONTAL;
        con.gridx = 0;
        con.gridy = 0;
        con.insets = new Insets(15, 15, 15, 15);
        buyStocks = new JPanel();
        buyStocks.setLayout(new GridBagLayout());
        pane.add(buyStocks, con);

        companyName = new JLabel("Oibes & Co.");
        buyOibes = new JButton("Buy");
        con.gridx = 0;
        con.gridy = 1;
        buyStocks.add(companyName, con);
        con.gridx = 2;
        buyStocks.add(buyOibes, con);

        companyName = new JLabel("Rhodesia Decoder Integrations");
        buyRhodesia = new JButton("Buy");
        con.gridx = 0;
		con.gridy++;
        buyStocks.add(companyName, con);
        con.gridx = 2;
        buyStocks.add(buyRhodesia, con);

        companyName = new JLabel("Up&Go");
        buyUpGo = new JButton("Buy");
        con.gridx = 0;
		con.gridy++;
        buyStocks.add(companyName, con);
        con.gridx = 2;
        buyStocks.add(buyUpGo, con);

        companyName = new JLabel("Mariana-Monokai-Webster.");
        buyMariana = new JButton("Buy");
        con.gridx = 0;
		con.gridy++;
        buyStocks.add(companyName, con);
        con.gridx = 2;
        buyStocks.add(buyMariana, con);

        companyName = new JLabel("Krasnyi Byk Ltd.");
        buyKrasnyi = new JButton("Buy");
        con.gridx = 0;
		con.gridy++;
        buyStocks.add(companyName, con);
        con.gridx = 2;
        buyStocks.add(buyKrasnyi, con);   


        showPrices(pane, false);
		con.gridy = App.stocks.length;
        con.gridx = 0;
		nextRound = new JButton("Next Round");
		buyStocks.add(nextRound, con);
		con.gridy = App.stocks.length;
        con.gridx++;
		portfolio = new JButton("Portfolio");
		buyStocks.add(portfolio, con);
        con.gridx++;
		sell = new JButton("Sell");
		buyStocks.add(sell, con);

        HandlerClass handler = new HandlerClass();
		buyOibes.addActionListener(handler);
		buyRhodesia.addActionListener(handler);
		buyUpGo.addActionListener(handler);
		buyMariana.addActionListener(handler);
		buyKrasnyi.addActionListener(handler);
		nextRound.addActionListener(handler);
		portfolio.addActionListener(handler);
		sell.addActionListener(handler);
    }

    public static void showPrices(Container pane, boolean update){
        con.gridx = 1;
        con.gridy = 0;
        con.weighty = 0.0;
        JPanel sharePrice = new JPanel();
        sharePrice.setLayout(new GridBagLayout());
        pane.add(sharePrice, con);
        if (update == false){
            String thisBalance = Double.toString(Money.balance);
            String thisBalanceDiffirence = Double.toString(Money.balanceDifference);
    
            con.gridx = 0;
            con.gridy = 0;
            balance = new JLabel("Balance: $"+thisBalance+" ("+thisBalanceDiffirence+")");
            buyStocks.add(balance, con);
    
            con.gridx++;
            con.gridy = 0;
            debt = new JLabel("");
            buyStocks.add(debt, con);

			con.gridy = 1;
			
			con.gridx = 1;
			String thisPrice = Double.toString(App.exchange[con.gridy]);
            String thisDiffirence = Double.toString(App.difference[con.gridy]);
			priceOibes = new JLabel("$"+thisPrice+" ("+thisDiffirence+")");
			buyStocks.add(priceOibes, con);
			
			con.gridy++;
			con.gridx = 1;
			thisPrice = Double.toString(App.exchange[con.gridy]);
            thisDiffirence = Double.toString(App.difference[con.gridy]);
			priceRhodesia	= new JLabel("$"+thisPrice+" ("+thisDiffirence+")");
			buyStocks.add(priceRhodesia, con);

			con.gridy++;
			con.gridx = 1;
			thisPrice = Double.toString(App.exchange[con.gridy]);
            thisDiffirence = Double.toString(App.difference[con.gridy]);
			priceUpGo = new JLabel("$"+thisPrice+" ("+thisDiffirence+")");
			buyStocks.add(priceUpGo, con);

			con.gridy++;
			con.gridx = 1;
			thisPrice = Double.toString(App.exchange[con.gridy]);
            thisDiffirence = Double.toString(App.difference[con.gridy]);
			priceMariana = new JLabel("$"+thisPrice+" ("+thisDiffirence+")");
			buyStocks.add(priceMariana, con);

			con.gridy++;
            con.gridx = 1;
			thisPrice = Double.toString(App.exchange[con.gridy]);
            thisDiffirence = Double.toString(App.difference[con.gridy]);
			priceKrasnyi = new JLabel("$"+thisPrice+" ("+thisDiffirence+")");
			buyStocks.add(priceKrasnyi, con);

			con.gridy++;
        } else {
            String thisBalance = Double.toString(Money.balance);
            String thisBalanceDiffirence = Double.toString(Money.balanceDifference);
            String thisDebt = Double.toString(Money.debt);
    
            balance.setText("Balance: $"+thisBalance+" ("+thisBalanceDiffirence+")");
    
            if(Money.borrowed == true){
                con.gridx = 1;
                con.gridy = 0;
                debt.setText("You are $"+thisDebt+" in debt");
                buyStocks.add(debt, con);
            } else{
                debt.setText("");
            }
			int count = 0;
			String thisPrice = Double.toString(App.exchange[count]);
			String thisDiffirence = Double.toString(App.difference[count]);
			priceOibes.setText("$"+thisPrice+" ("+thisDiffirence+")");
			count++;
			thisPrice = Double.toString(App.exchange[count]);
            thisDiffirence = Double.toString(App.difference[count]);
			priceRhodesia.setText("$"+thisPrice+" ("+thisDiffirence+")");
			count++;
			thisPrice = Double.toString(App.exchange[count]);
            thisDiffirence = Double.toString(App.difference[count]);
			priceUpGo.setText("$"+thisPrice+" ("+thisDiffirence+")");
			count++;
			thisPrice = Double.toString(App.exchange[count]);
            thisDiffirence = Double.toString(App.difference[count]);
			priceMariana.setText("$"+thisPrice+" ("+thisDiffirence+")");
			count++;
			thisPrice = Double.toString(App.exchange[count]);
            thisDiffirence = Double.toString(App.difference[count]);
			priceKrasnyi.setText("$"+thisPrice+" ("+thisDiffirence+")");
			pane.repaint();
		}
    }
    private class HandlerClass implements ActionListener {
		int amount;
		JOptionPane yesNo;
		Object[] options = new String[] {"Yes", "No"};
		JDialog dialog;
		public void actionPerformed(ActionEvent event) {
			if(event.getSource() == nextRound) {
				App.nextRound();
				/* App.menu(); */
				showPrices(gui, true);
				SellGUI.showPrices(gui, true);
				Game.showNews();
			}
			if(event.getSource() == portfolio) {
				Portfolio.Show();
				PortfolioGUI.Show();
				/* App.menu(); */
			}
			if(event.getSource() == sell) {
				SellGUI.Show();
				/* Money.sellStock(); */
			}
			if(event.getSource() == buyOibes || event.getSource() == buyRhodesia || event.getSource() == buyUpGo || event.getSource() == buyMariana || event.getSource() == buyKrasnyi) {
				String StAmount	= JOptionPane.showInputDialog("How many shares would you like to buy?");
				amount = Integer.parseInt(StAmount);
			}
			
			if(event.getSource() == buyOibes) {
				yesNo	= new JOptionPane("Buy "+amount+" shares in Oibes & Co. for $"+App.exchange[0]+" each? (Total $"+(amount*App.exchange[0])+")");
				yesNo.setOptions(options);
				dialog = yesNo.createDialog(new JFrame(), "Dialog");
				dialog.setVisible(true);
				Money.amount = amount;
				Money.input = 1;
				Money.buyGUI();
			}
			
			if(event.getSource() == buyRhodesia) {
				yesNo	= new JOptionPane("Buy "+amount+" shares in Rhodesia Decoder Integrations for $"+App.exchange[1]+" each? (Total $"+(amount*App.exchange[1])+")");
				yesNo.setOptions(options);
				dialog = yesNo.createDialog(new JFrame(), "Dialog");
				dialog.setVisible(true);
				Money.amount = amount;
				Money.input = 2;
				Money.buyGUI();
			}
			
			if(event.getSource() == buyUpGo) {
				yesNo = new JOptionPane("Buy "+amount+" shares in Up&Go for $"+App.exchange[2]+" each? (Total $"+(amount*App.exchange[2])+")");
				yesNo.setOptions(options);
				dialog = yesNo.createDialog(new JFrame(), "Dialog");
				dialog.setVisible(true);
				Money.amount = amount;
				Money.input = 3;
				Money.buyGUI();
			}
			
			if(event.getSource() == buyMariana) {
				yesNo	= new JOptionPane("Buy "+amount+" shares in Mariana-Monokai-Webster. for $"+App.exchange[3]+" each? (Total $"+(amount*App.exchange[3])+")");
				yesNo.setOptions(options);
				dialog = yesNo.createDialog(new JFrame(), "Dialog");
				dialog.setVisible(true);
				Money.amount = amount;
				Money.input = 4;
				Money.buyGUI();
			}
			
			if(event.getSource() == buyKrasnyi) {
				yesNo	= new JOptionPane("Buy "+amount+" shares in Krasnyi Byk Ltd. for $"+App.exchange[4]+" each? (Total $"+(amount*App.exchange[4])+")");
				yesNo.setOptions(options);
				dialog = yesNo.createDialog(new JFrame(), "Dialog");
				dialog.setVisible(true);
				Money.amount = amount;
				Money.input = 5;
				Money.buyGUI();
			}
		}
	}
}
