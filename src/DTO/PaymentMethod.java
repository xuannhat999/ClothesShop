package DTO;

public class PaymentMethod {
    private int paymentmethodid;
    private String paymentmethodname;
    public PaymentMethod(){}
    public PaymentMethod(int id,String name)
    {
        this.paymentmethodid=id;
        this.paymentmethodname=name;
    }
    public PaymentMethod(PaymentMethod d)
    {
        this.paymentmethodid=d.paymentmethodid;
        this.paymentmethodname=d.paymentmethodname;
    }
    public int getPaymentMethodId()
    {
        return paymentmethodid;
    }
    public String getPaymentMethodName()
    {
        return paymentmethodname;
    }
    @Override 
    public String toString()
    {
        return paymentmethodname;
    }
}
