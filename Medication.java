package A6;

public class Medication {
    String Name ; 
    String dose;
    int amount;

    public Medication( String name, String dose,int amount) {
        Name = name;
        this.dose=dose;
        this.amount = amount;
    }
    @Override
    public String toString() {
        return String.format("Name= %s,dose= %s,amount= %d ",Name ,dose ,amount );
    }
    
    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }

    public String getDose() {
        return dose;
    }

    public void setDose(String dose) {
        this.dose = dose;
    }

    public int getAmount() {
        return amount;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }
}
