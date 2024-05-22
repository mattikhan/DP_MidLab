/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package midlab;

/**
 *
 * @author sp21-bse-030
 */
class StandardAccount extends Account {
  private double balance;

  public StandardAccount(double initialBalance) {
    this.balance = initialBalance;
  }

  @Override
  public double getBalance() {
    return balance;
  }

  @Override
  public void debit(double amount) {
    if (balance >= amount) {
      balance -= amount;
    } else {
      // Handle insufficient funds
      System.out.println("Insufficient funds for debit!");
    }
  }

  @Override
  public void credit(double amount) {
    balance += amount;
  }
}
