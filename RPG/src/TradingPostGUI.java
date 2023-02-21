import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;

public class TradingPostGUI extends GameGUI {

	// instance variables for Trading Post
	private Item slot1;
	private Item slot2;
	private Item slot3;
	private Item slot4;
	private Potion slot5;
	private String[] weapons = new String[] { "regular_sword.png", "rusty_sword.png", "saw_sword.png",
			"spiked_baton.png", "dueling_sword.png", "axe.png", "golden_sword.png", "hammer.png", "mace.png",
			"machete.png", "katana.png", "big_hammer.png", "green_staff.png", "diamond_cleaver.png",
			"lavish_gold_sword.png", "diamond_great_sword.png", "platinum_sword.png", "red_gem_sword.png",
			"red_magic_staff.png" };
	private String[] potions = new String[] { "blue", "green", "red", "yellow"};

	// constructor #1 for Trading Post
	public TradingPostGUI() {
		super(true, "TradingPostBckgrnd.jpg"); // uses constructor #2 from GameGUI
		refreshItems();
	}


	public void refreshItems() {
		slot1 = new Weapon(weapons[GameObject.randInt(0, 3)]);
		slot2 = new Weapon(weapons[GameObject.randInt(4, 8)]);
		slot3 = new Weapon(weapons[GameObject.randInt(9, 13)]);
		slot4 = new Weapon(weapons[GameObject.randInt(14, 18)]);
		slot5 = new Potion(potions[GameObject.randInt(0, 3)]);
	}
	// these are getters and setters
	public Item getSlot1() {
		return this.slot1;
	}

	public Item getSlot2() {
		return this.slot2;
	}

	public Item getSlot3() {
		return this.slot3;
	}

	public Item getSlot4() {
		return this.slot4;
	}

	public Potion getSlot5() {
		return this.slot5;
	}

	public void draw(Graphics g) {
		int LEFT_MARGIN = StartGame.SCREEN_WIDTH * 2 / 10;
		int LEFT_INDENT = 25;
		int yVal = StartGame.SCREEN_HEIGHT * 1 / 5 - 18;
		g.setColor(new Color(35, 140, 35)); // color: green
		super.draw(g);

		g.setColor(new Color(255, 255, 255));
		g.setFont(new Font(FONT_NAME, 0, TITLE_FONT - 25));
		g.drawString("TRADING POST", LEFT_MARGIN, yVal);
		yVal += 50;

		g.setFont(new Font(FONT_NAME, 0, BODY_FONT));
		g.drawString("Welcome to my shop, traveler.", LEFT_MARGIN, yVal);
		yVal += 35;
		g.drawString("You have " + InventoryGUI.getGold() + " gold coins.", LEFT_MARGIN, yVal);
		yVal += 35;
		g.drawString("Type the corresponding number to purchase an item.", LEFT_MARGIN, yVal);
		yVal += 55;

		g.drawString("[1] " + slot1, LEFT_MARGIN, yVal);
		yVal += 25;
		g.setFont(new Font(FONT_NAME, 0, END_FONT));
		g.drawString("Cost: " + slot1.getGoldCost() + ", Attack damage: +" + retrieveAtkDmg(slot1, RPGGame.getPlayer()), LEFT_MARGIN + LEFT_INDENT, yVal);
		yVal += 40;

		g.setFont(new Font(FONT_NAME, 0, BODY_FONT));
		g.drawString("[2] " + slot2, LEFT_MARGIN, yVal);
		yVal += 25;
		g.setFont(new Font(FONT_NAME, 0, END_FONT));
		g.drawString("Cost: " + slot2.getGoldCost() + ", Attack damage: +" + retrieveAtkDmg(slot2, RPGGame.getPlayer()), LEFT_MARGIN + LEFT_INDENT, yVal);
		yVal += 40;

		g.setFont(new Font(FONT_NAME, 0, BODY_FONT));
		g.drawString("[3] " + slot3, LEFT_MARGIN, yVal);
		yVal += 25;
		g.setFont(new Font(FONT_NAME, 0, END_FONT));
		g.drawString("Cost: " + slot3.getGoldCost() + ", Attack damage: +" + retrieveAtkDmg(slot3, RPGGame.getPlayer()), LEFT_MARGIN + LEFT_INDENT, yVal);
		yVal += 40;

		g.setFont(new Font(FONT_NAME, 0, BODY_FONT));
		g.drawString("[4] " + slot4, LEFT_MARGIN, yVal);
		yVal += 25;
		g.setFont(new Font(FONT_NAME, 0, END_FONT));
		g.drawString("Cost: " + slot4.getGoldCost() + ", Attack damage: +" + retrieveAtkDmg(slot4, RPGGame.getPlayer()), LEFT_MARGIN + LEFT_INDENT, yVal);
		yVal += 40;

		g.setFont(new Font(FONT_NAME, 0, BODY_FONT));
		g.drawString("[5] " + slot5, LEFT_MARGIN, yVal);
		yVal += 25;
		g.setFont(new Font(FONT_NAME, 0, END_FONT));
		g.drawString("Cost: " + slot5.getGoldCost() + "  /  " + slot5.getDescription(), LEFT_MARGIN + LEFT_INDENT, yVal);
		yVal += 40;

		g.setFont(new Font(FONT_NAME, 0, END_FONT));
		g.drawString("Press I to return to game.", LEFT_MARGIN, yVal);
		yVal += 20;
		g.drawString("Thanks for playing Endless Doors!", LEFT_MARGIN, yVal);
	}

	private int retrieveAtkDmg(Item itm, Player player) {
		if (player instanceof Archer) {
			return ((Weapon) itm).getAtkDmg() / 2;
		}
		return ((Weapon) itm).getAtkDmg();
	}
}
