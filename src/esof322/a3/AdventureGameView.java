/*Modified for esoff322.a2 by Nevin Leh, Aaron Newhall and  Tim Wegher
 * 
 */


package esof322.a3;

/*
 * Description of changes: In this class we added a Jlabel and a Jlabel Text area to get what index of item to pickup
 * or drop. We also added functionality to the drop() and pickup() methods such that the Jlabel text field is used to drop and
 * pickup the correct items.
 */

import javax.swing.*;

import BreezySwing.*;

public class AdventureGameView extends GBFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	// Window objects --------------------------------------
	JLabel welcomeLabel = addLabel(
			"Welcome to the Adventure Game " + "(inspired by an old game called the Colossal Cave Adventure)."
					+ " Java implementation Copyright (c) 1999-2012 by James M. Bieman",
			1, 1, 5, 1);

	JLabel viewLable = addLabel("Your View: ", 2, 1, 1, 1);
	JTextArea viewArea = addTextArea("Start", 3, 1, 4, 3);

	JLabel carryingLable = addLabel("You are carying: ", 6, 1, 1, 1);
	JTextArea carryingArea = addTextArea("Nothing", 7, 1, 4, 3);

	JLabel chooseLabel = addLabel("Enter index of item to pickup or drop with 1 being the first item listed", 11, 1, 1,
			1);

	JTextArea chooseItem = addTextArea("Enter index of chosen Item", 12, 1, 1, 1);

	JLabel choiceLabel = addLabel("Choose a direction, pick-up, or drop an item", 13, 1, 5, 1);

	JButton grabButton = addButton("Grab an item", 14, 5, 1, 1);
	JButton dropButton = addButton("Drop an item", 15, 5, 1, 1);

	JButton northButton = addButton("North", 13, 2, 1, 1);
	JButton southButton = addButton("South", 15, 2, 1, 1);
	JButton eastButton = addButton("East", 14, 3, 1, 1);
	JButton westButton = addButton("West", 14, 2, 1, 1);
	JButton upButton = addButton("Up", 13, 3, 1, 1);
	JButton downButton = addButton("Down", 15, 3, 1, 1);

	AdventureGameModelFacade model;

	// Constructor-----------------------------------------------

	public AdventureGameView() {
		setTitle("Adventure Game");
		model = new AdventureGameModelFacade();

		viewArea.setEditable(false);
		carryingArea.setEditable(false);
		displayCurrentInfo();
	}

	// buttonClicked method--------------------------------------

	public void buttonClicked(JButton buttonObj) {
		if (buttonObj == upButton)
			model.goUp();

		else if (buttonObj == downButton)
			model.goDown();

		else if (buttonObj == northButton)
			model.goNorth();

		else if (buttonObj == southButton)
			model.goSouth();

		else if (buttonObj == eastButton)
			model.goEast();

		else if (buttonObj == westButton)
			model.goWest();

		else if (buttonObj == grabButton)
			grab();

		else if (buttonObj == dropButton)
			drop();

		displayCurrentInfo();
	}

	// Private methods-------------------------------------------

	private void displayCurrentInfo() {
		viewArea.setText(model.getView());
		carryingArea.setText(model.getItems());
	}

	private void grab() {
		/*
		 * This try and catch is to handle text input that needs to be put into an int
		 */
		String item = chooseItem.getText();
		String result;
		
		try {
			int i = Integer.parseInt(item.trim());

			result = model.grab(i - 1);
			chooseItem.setText(result);

		} catch (NumberFormatException nfe) {
			chooseItem.setText("That is not a valid input");
		}
	}

	private void drop() {
		/*
		 * This try and catch is to handle text input that needs to be put into an int
		 */
		String item = chooseItem.getText();
		String result;
		try {
			int i = Integer.parseInt(item.trim());
			System.out.println(model.getItems());
			result = model.drop(i - 1);
			System.out.println(model.getItems());
			chooseItem.setText(result);

		} catch (NumberFormatException nfe) {
			chooseItem.setText("That is not a valid input");

		}
	}

	public static void main(String[] args) {
		JFrame view = new AdventureGameView();
		view.setSize(800, 600); /* was 400, 250 */
		view.setVisible(true);
	}
}
