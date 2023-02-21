
public class Potion extends Item {

	private String type;
	private String description;

	public Potion(String color) {
		super("flask_big_" + color + ".png");
		type = determineType(color);
	}
	
	public String getDescription() {
		return this.description;
	}

	private String determineType(String color) {
		if (color.equals("blue")) {
			setGoldCost(250);
			description = "Become invincible for 10 seconds.";
			return "Invincibility";
		}
		else if (color.equals("green")) {
			setGoldCost(500);
			description = "Increase your maximum health.";
			return "Max Health";
		}
		else if (color.equals("red")) {
			setGoldCost(350);
			description = "Increase attack damage by 1.";
			return "Attack Damage";
		}
		setGoldCost(400);
		description = "Increase your health. Max health is " + RPGGame.getPlayer().getMaxHealth() + ".";
		return "Health";
	}

	public void activate() {
		if (type.equals("Invincibility")) { // invincibility potion
			int startTime = RPGGame.ticks;
			RPGGame.getPlayer().setInvincibility(true);
			if (RPGGame.ticks == startTime + 1000) { // turns off invincibility after 10 secs
				RPGGame.getPlayer().setInvincibility(false);
			}
		} else if (type.equals("Attack Damage")) { // increase attack damage potion
			RPGGame.getPlayer().addDamage(1.0);
		} else if (type.equals("Max Health")) { // increase maximum health potion
			RPGGame.getPlayer().increaseMaxHealth(Map.getLevel());
		} else if (type.equals("Health")) { // health potion
			RPGGame.getPlayer().incrementHealth(5 + (int)(Map.roomCount * 1.5));
		}
	}

	@Override
	public String toString() {
		return type + " Potion";
	}
}
