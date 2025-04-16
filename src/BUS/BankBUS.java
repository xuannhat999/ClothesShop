package BUS;

import DAO.BankAccountDAO;
import DAO.BankDAO;
import DTO.Bank;
import DTO.BankAccount;
import java.util.List;

public class BankBUS {
    private BankDAO bankdao = new BankDAO();
    private BankAccountDAO bankaccdao = new BankAccountDAO();
    public BankBUS(){}
    public List<Bank> getAllBank()
    {
        return bankdao.getAllBank();
    }
    public BankAccount getBankAccountFromUserBankId(int userid,int bankid)
    {
        return bankaccdao.getBankAccountFromUserBankId(userid, bankid);
    }
}
