package Unit2.Sort.Using;

import Unit1.test1.Quene.Queue;
import Unit2.Sort.Shell.Shell;

import template.StdIn;
import template.StdOut;

public class SortTransaction {
    public static Transaction[] readTransactions() {
        Queue<Transaction> queue = new Queue<>();
        while (StdIn.hasNextLine()) {
            String line =StdIn.readLine();
            queue.enqueue(new Transaction(Double.parseDouble(line)));
        }
        Transaction[] transactions = new Transaction[queue.size()];
        for (int i = 0; i < transactions.length; i++) {
            transactions[i] = queue.dequeue();
        }
        return transactions;
    }

    public static  void main(String[] args){
        Transaction[] transactions = readTransactions();
        Shell.sort(transactions);
        for (Transaction t : transactions)
            StdOut.println(t);
    }
}
