package DTO;

public class BankAccount {
    private int bankAccountId;
    private int userId;
    private String bankAccountNumber;
    private int bankId;

    // Constructor mặc định
    public BankAccount() {
    }

    // Constructor đầy đủ
    public BankAccount(int bankAccountId, int userId, String bankAccountNumber, int bankId) {
        this.bankAccountId = bankAccountId;
        this.userId = userId;
        this.bankAccountNumber = bankAccountNumber;
        this.bankId = bankId;
    }

    // Constructor sao chép
    public BankAccount(BankAccount d) {
        this.bankAccountId = d.bankAccountId;
        this.userId = d.userId;
        this.bankAccountNumber = d.bankAccountNumber;
        this.bankId = d.bankId;
    }

    // Getter & Setter
    public int getBankAccountId() {
        return bankAccountId;
    }

    public void setBankAccountId(int bankAccountId) {
        this.bankAccountId = bankAccountId;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public String getBankAccountNumber() {
        return bankAccountNumber;
    }

    public void setBankAccountNumber(String bankAccountNumber) {
        this.bankAccountNumber = bankAccountNumber;
    }

    public int getBankId() {
        return bankId;
    }

    public void setBankId(int bankId) {
        this.bankId = bankId;
    }

}
