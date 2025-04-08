package org.example;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class BankAccountTest {
    private BankAccount account;
    private static final double DELTA = 0.0001; // Pour comparer les doubles

    @BeforeEach
    void setUp() {
        account = new BankAccount(1000.0, 0.05); // Solde initial 1000, taux 5%
    }

    // Tests pour deposit
    @Test
    void depositPositiveAmountShouldIncreaseBalance() {
        account.deposit(500.0);
        assertEquals(1500.0, account.getBalance(), DELTA);
    }

    @Test
    void depositZeroAmountShouldThrowException() {
        assertThrows(IllegalArgumentException.class, () -> account.deposit(0.0));
    }

    @Test
    void depositNegativeAmountShouldThrowException() {
        assertThrows(IllegalArgumentException.class, () -> account.deposit(-100.0));
    }

    // Tests pour withdraw
    @Test
    void withdrawValidAmountShouldDecreaseBalance() {
        account.withdraw(300.0);
        assertEquals(700.0, account.getBalance(), DELTA);
    }

    @Test
    void withdrawAmountGreaterThanBalanceShouldThrowException() {
        assertThrows(IllegalStateException.class, () -> account.withdraw(1500.0));
    }

    @Test
    void withdrawZeroAmountShouldThrowException() {
        assertThrows(IllegalArgumentException.class, () -> account.withdraw(0.0));
    }

    @Test
    void withdrawNegativeAmountShouldThrowException() {
        assertThrows(IllegalArgumentException.class, () -> account.withdraw(-100.0));
    }

    // Tests pour transfer
    @Test
    void transferValidAmountShouldUpdateBothAccounts() {
        BankAccount other = new BankAccount(500.0, 0.02);
        account.transfer(200.0, other);
        assertEquals(800.0, account.getBalance(), DELTA);
        assertEquals(700.0, other.getBalance(), DELTA);
    }

    @Test
    void transferToNullAccountShouldThrowException() {
        assertThrows(NullPointerException.class, () -> account.transfer(100.0, null));
    }

    @Test
    void transferAmountGreaterThanBalanceShouldThrowException() {
        BankAccount other = new BankAccount(500.0, 0.02);
        assertThrows(IllegalStateException.class, () -> account.transfer(1500.0, other));
    }

    @Test
    void transferZeroAmountShouldThrowException() {
        BankAccount other = new BankAccount(500.0, 0.02);
        assertThrows(IllegalArgumentException.class, () -> account.transfer(0.0, other));
    }

    // Tests pour addInterest
    @Test
    void addInterestWithPositiveRateShouldIncreaseBalance() {
        account.addInterest();
        assertEquals(1050.0, account.getBalance(), DELTA); // 1000 * (1 + 0.05)
    }

    @Test
    void addInterestWithZeroRateShouldNotChangeBalance() {
        BankAccount zeroRateAccount = new BankAccount(1000.0, 0.0);
        zeroRateAccount.addInterest();
        assertEquals(1000.0, zeroRateAccount.getBalance(), DELTA);
    }

    @Test
    void addInterestWithNegativeRateShouldDecreaseBalance() {
        BankAccount negativeRateAccount = new BankAccount(1000.0, -0.1);
        negativeRateAccount.addInterest();
        assertEquals(900.0, negativeRateAccount.getBalance(), DELTA); // 1000 * (1 - 0.1)
    }

    @Test
    void addInterestWithZeroBalanceShouldNotChangeBalance() {
        BankAccount zeroBalanceAccount = new BankAccount(0.0, 0.05);
        zeroBalanceAccount.addInterest();
        assertEquals(0.0, zeroBalanceAccount.getBalance(), DELTA);
    }

    // Test pour getBalance
    @Test
    void getBalanceShouldReturnCorrectBalance() {
        assertEquals(1000.0, account.getBalance(), DELTA);
    }
}