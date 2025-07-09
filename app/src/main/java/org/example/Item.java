package org.example;

public class Item {
  private String name;
  private int hpRecoveryAmount;
  private int mpRecoveryAmount;

  public Item(String name, int hpRecoveryAmount, int mpRecoveryAmount) {
    this.name = name;
    this.hpRecoveryAmount = hpRecoveryAmount;
    this.mpRecoveryAmount = mpRecoveryAmount;
  }

  public String getName() {
    return name;
  }

  public int getHpRecoveryAmount() {
    return hpRecoveryAmount;
  }

  public int getMpRecoveryAmount() {
    return mpRecoveryAmount;
  }

  @Override
  public String toString() {
    String description = name;
    if (hpRecoveryAmount > 0) {
      description += " (HP回復: " + hpRecoveryAmount + ")";
    }
    if (mpRecoveryAmount > 0) {
      if (hpRecoveryAmount > 0) {
        description += ", ";
      } else {
        description += " (";
      }
      description += "MP回復: " + mpRecoveryAmount + ")";
    }
    return description;
  }
}
