package darylle.baldove.com.eatsadeal;

public class Resto {
  public String name, place, type, budget;

  public Resto() {}

  public Resto(String name, String place, String type, String budget)
  {
    this.name = name;
    this.place = place;
    this.type = type;
    this.budget = budget;
  }

  public String getName() {
    return name;
  }

  public String getPlace() {
    return place;
  }

  public String getType() {
    return type;
  }

  public String getBudget() {
    return budget;
  }
}
