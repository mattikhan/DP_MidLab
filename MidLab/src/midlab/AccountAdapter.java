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
class AccountAdapter extends Account {
  private OffshoreAccount offshoreAccount;

  public AccountAdapter(OffshoreAccount offshoreAccount) {
    this.offshoreAccount = offshoreAccount;
  }

  @Override
  public double getBalance() {
    // Convert offshore balance to standard account balance (consider tax implications)
    double offshoreBalance = offshoreAccount.getOffshoreBalance();
    double taxRate = offshoreAccount.getTaxRate();
    return offshoreBalance * (1 - taxRate);
  }

  @Override
  public void debit(double amount) {
    // Delegate debit operation to offshore account after converting amount
    double amountInOffshoreCurrency = amount / (1 - offshoreAccount.getTaxRate());
    offshoreAccount.debit(amountInOffshoreCurrency);
  }

  @Override
  public void credit(double amount) {
    // Delegate credit operation to offshore account after converting amount
    double amountInOffshoreCurrency = amount / (1 - offshoreAccount.getTaxRate());
    offshoreAccount.credit(amountInOffshoreCurrency);
  }
}
