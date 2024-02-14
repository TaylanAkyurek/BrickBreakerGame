package ui;

import java.awt.Dimension;  
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemListener;
import java.awt.event.ItemEvent;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

import domain.BuildHandler;
import domain.GameMap;
import domain.Player;
import ymir.YmirFactory;

public class BuildingPanel extends JPanel implements ActionListener{

	private JTextField simpleText;
	private JTextField firmText;
	private JTextField explosiveText;
	private JTextField giftText;

	private JLabel simpleLabel;
	private JLabel firmLabel;
	private JLabel explosiveLabel;
	private JLabel giftLabel;
	private JLabel ymirLabel;

	private JComboBox ymirBox;

	private JButton addButton;
	private JOptionPane optionPane;


	public BuildingPanel() {
		Dimension dim = getPreferredSize();
		this.setPreferredSize(dim);
		this.setVisible(true);
		setLayout(null);

		this.simpleText = new JTextField(10);
		simpleText.setBounds(dim.width-175,10,100,20);

		this.firmText = new JTextField(10);
		firmText.setBounds(dim.width-175,30,100,20);

		this.explosiveText = new JTextField(10);
		explosiveText.setBounds(dim.width-175,50,100,20);

		this.giftText = new JTextField(10);
		giftText.setBounds(dim.width-175,70,100,20);

		String ymir[] = {"Yes", "No"};
		this.ymirBox = new JComboBox(ymir);
		ymirBox.setBounds(dim.width-175,90,100,20);
		ymirBox.setSelectedItem(null);
		ymirBox.addItemListener(new ItemListener() {
			@Override
			public void itemStateChanged(ItemEvent e) {
				Object selected = ymirBox.getSelectedItem();
				if ("Yes".equals(selected)) {
					YmirFactory.setActive(true);
					 
				}
			}
		});




		this.simpleLabel = new JLabel("Number Of Simple Obstacles: ");
		simpleLabel.setBounds(dim.width-375,10,210,20);

		this.firmLabel = new JLabel("Number Of Firm Obstacles: ");
		firmLabel.setBounds(dim.width-375,30,210,20);

		this.explosiveLabel = new JLabel("Number Of Explosive Obstacles: ");
		explosiveLabel.setBounds(dim.width-375,50,210,20);

		this.giftLabel = new JLabel("Number Of Gift Obstacles: ");
		giftLabel.setBounds(dim.width-375,70,210,20);

		this.ymirLabel = new JLabel("Select Ymir Option: ");
		ymirLabel.setBounds(dim.width-375,90,210,20);


		addButton = new JButton("Build");
		addButton.setBounds(dim.width-200,120, 75,25);

		add(simpleLabel);
		add(simpleText);

		add(firmLabel);
		add(firmText);

		add(explosiveLabel);
		add(explosiveText);

		add(giftLabel);
		add(giftText);

		add(ymirLabel);
		add(ymirBox);

		add(addButton);


		addButton.addActionListener(this);
	}

	public Dimension getPreferredSize() {
		return new Dimension(1000,1000);
	}

	public GameMap getGameMap() {
		return GameMap.gameMap;
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		int simpleNum = Integer.parseInt(simpleText.getText());
		int firmNum = Integer.parseInt(firmText.getText());
		int explosiveNum = Integer.parseInt(explosiveText.getText());
		int giftNum = Integer.parseInt(giftText.getText());

		if (simpleNum >= 75 && firmNum >= 10 && explosiveNum >= 5) {
			BuildHandler buildHandler;
			try {
				buildHandler = new BuildHandler(simpleNum, firmNum, explosiveNum, giftNum);
				GameMap.gameMap = buildHandler.getGameMap();
				Player.player = buildHandler.getPlayer();

			} catch (Exception e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			this.setVisible(false);
			AnimationPanel animPanel = new AnimationPanel(GameMap.gameMap, Player.player);
			AnimatorMain.f.addKeyListener(animPanel);
			AnimatorMain.f.add(animPanel);

		}else {
			optionPane.showMessageDialog(null, "Invalid number of obstacles", "Invalid number of obstacles", JOptionPane.WARNING_MESSAGE);
		}


	}



}
