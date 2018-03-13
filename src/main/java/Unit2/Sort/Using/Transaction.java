package Unit2.Sort.Using;

public class Transaction implements Comparable<Transaction>{

    private final double amount;

    public Transaction(double amount) {
        this.amount = amount;
    }
    public Double amount(){return amount;}
    @Override
    public int compareTo(Transaction that) {
        if (this.amount < that.amount) return -1;
        if(this.amount > that.amount)  return  1;
        return 0;
    }
}
