package DTO;

public class Bank {
    private int bankId;
    private String bankName;

    // Constructor mặc định
    public Bank() {
    }

    // Constructor đầy đủ
    public Bank(int bankId, String bankName) {
        this.bankId = bankId;
        this.bankName = bankName;
    }

    // Constructor sao chép
    public Bank(Bank d) {
        this.bankId = d.bankId;
        this.bankName = d.bankName;
    }

    // Getter và Setter
    public int getBankId() {
        return bankId;
    }

    public void setBankId(int bankId) {
        this.bankId = bankId;
    }

    public String getBankName() {
        return bankName;
    }

    public void setBankName(String bankName) {
        this.bankName = bankName;
    }

    // toString
    @Override
    public String toString() {
        return bankName;
    }
}
