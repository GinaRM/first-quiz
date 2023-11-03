package org.velezreyes.quiz.question6;

import java.util.HashMap;
import java.util.Map;

public class VendingMachineImpl implements VendingMachine{

  private int quarterInserted;
  private final Map<String, Drink> availableDrinks;
  private static VendingMachine instance = null;
  private VendingMachineImpl() {
    this.quarterInserted = 0;
    this.availableDrinks = new HashMap<>();
    availableDrinks.put("ScottCola", new DrinkImpl("ScottCola", true, 3));
    availableDrinks.put("KarenTea", new DrinkImpl("KarenTea", false, 4));

  }
  public static VendingMachine getInstance() {
    if (instance == null) {
      instance = new VendingMachineImpl();
    }
    return instance;
  }


  @Override
  public void insertQuarter() {
    quarterInserted++;
  }

  @Override
  public Drink pressButton(String name) throws NotEnoughMoneyException, UnknownDrinkException {
    if (!availableDrinks.containsKey(name)) {
      throw new UnknownDrinkException();
    }
    int drinkPrice = availableDrinks.get(name).getPrice();
    if (quarterInserted >= drinkPrice) {
      quarterInserted -= drinkPrice;
      return availableDrinks.get(name);
    } else {
      throw new NotEnoughMoneyException();
    }
  }
}
