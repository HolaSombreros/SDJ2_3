public class Valuable
{
  private int worth;
  private String name;

  public Valuable(String name) {
    this.name = name;
    switch (name) {
      case "Gold":
        this.worth = 25;
        break;
      case "Diamond":
        this.worth = 55;
        break;
      case "Emerald":
        this.worth = 35;
        break;
      case "Crystal":
        this.worth = 50;
        break;
      case "Bitcoin":
        this.worth = 75;
        break;
      case "Dogecoin":
        this.worth = 100;
        break;
      case "Ruby":
        this.worth = 30;
        break;
      case "Sapphire":
        this.worth = 5;
        break;
      case "Topaz":
        this.worth = 10;
        break;
      case "Amethyst":
        this.worth = 20;
        break;
      case "Jade":
        this.worth = 15;
        break;
      case "Coal":
        this.worth = 1;
        break;
    }
  }

  public int getWorth() {
    return worth;
  }

  public String getName() {
    return name;
  }
}
