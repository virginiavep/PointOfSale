
public class Receipt {
    final Transaction transaction;
   
    public Receipt(Transaction t){
        this.transaction = t; 
    }

    public Transaction getTransaction() {
        return transaction;
    }
    
    public String getReceiptString(){
        String itemList = "";
        double total = transaction.getSubTotal() + transaction.getTax();
        for(Item i : transaction.getItems()){
            itemList += i.toString() + "\n";
        }
        String paymentType = "";
        for(Payment j : transaction.getPayments()){
            if (null != j.getType())switch (j.getType()) {
                case CASH:
                    paymentType += "\nCash: " +'\t'+'\t'+ j.getAmount();
                    break;
                case DEBIT_CARD:
                    paymentType += "\nDebit: " +'\t'+'\t'+ j.getAmount();
                    break;
                case CREDIT_CARD:
                    paymentType += "\nCredit: " +'\t'+ j.getAmount();
                    break;
                case CHECK:
                    paymentType += "\nCheck: " +'\t'+'\t'+ j.getAmount();
                    break;
                default:
                    break;
            }
        }
        return "\n" + itemList + "--------------------------\n" + "Subtotal: " 
                + '\t' + transaction.getSubTotal() + "\nTax: " + '\t' + '\t'  
                + transaction.getTax() + "\nTotal: " 
                + '\t' + '\t' + total + paymentType + "\nChange: " + '\t'
                + transaction.getChange();
    }
    
}
