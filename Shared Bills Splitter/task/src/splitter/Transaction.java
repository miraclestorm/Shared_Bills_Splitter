package splitter;

public class Transaction {
    int pairID;
    String trDate;
    int trPay;
    String debtor;
    String creditor;

    public Transaction(int pairID, String trDate, int trPay, String debtor, String creditor) {
        this.pairID = pairID;
        this.trDate = trDate;
        this.trPay = trPay;
        this.debtor = debtor;
        this.creditor = creditor;
    }

    @Override
    public String toString() {
        return "Transaction{" +
                "pairID=" + pairID +
                ", trDate='" + trDate + '\'' +
                ", trPay=" + trPay +
                ", debtor='" + debtor + '\'' +
                ", creditor='" + creditor + '\'' +
                '}';
    }

    public int getPairID() {
        return pairID;
    }

    public void setPairID(int pairID) {
        this.pairID = pairID;
    }

    public String getTrDate() {
        return trDate;
    }

    public void setTrDate(String trDate) {
        this.trDate = trDate;
    }

    public int getTrPay() {
        return trPay;
    }

    public void setTrPay(int trPay) {
        this.trPay = trPay;
    }

    public String getDebtor() {
        return debtor;
    }

    public void setDebtor(String debtor) {
        this.debtor = debtor;
    }

    public String getCreditor() {
        return creditor;
    }

    public void setCreditor(String creditor) {
        this.creditor = creditor;
    }
}
