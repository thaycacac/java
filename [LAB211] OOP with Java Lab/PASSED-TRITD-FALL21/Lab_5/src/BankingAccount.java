
public class BankingAccount {
    private int balance;
    
    public BankingAccount() {
    }
    
    public BankingAccount(Startup s) {
        this.balance = s.getBalance();
    }
    
    public void debit(Debit d) {
        balance -= d.getBalance();
    }
        public void credit(Credit c) {
        balance += c.getBalance();
    }
        
    public int getBalance() {
        return balance;
    }
    
    public  class Startup {
        private int balance;
        public Startup(int balance) {
            this.balance = balance;
        }
        public int getBalance() {
            return balance;
        }
    }
    
    public  class Debit {
        private int balance;
        public Debit(int balance) {
            this.balance = balance;
        }
        public int getBalance() {
            return balance;
        }
    }
    
    public  class Credit {
        private int balance;
        
        public Credit(int balance) {
            this.balance = balance;
        }
        
        public int getBalance() {
            return balance;
        }
    }
}
