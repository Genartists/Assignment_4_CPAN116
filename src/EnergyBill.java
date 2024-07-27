public class EnergyBill {
    //encapsulate
    private String name;
    private String address;
    private double electricityAmount;
    private double gasAmount;

    //constructor
    public EnergyBill(String name, String address, double electricityAmount, double gasAmount) {
        this.name = name;
        this.address = address;
        this.electricityAmount = electricityAmount;
        this.gasAmount = gasAmount;
    }
    // getter and setter for all attributes
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public double getElectricityAmount() {
        return electricityAmount;
    }

    public void setElectricityAmount(double electricityAmount) {
        this.electricityAmount = electricityAmount;
    }

    public double getGasAmount() {
        return gasAmount;
    }

    public void setGasAmount(double gasAmount) {
        this.gasAmount = gasAmount;
    }

    //function to calculate electric charge
    public double calculateElectricCharge() {
        double electricRate = 0.12;
        return electricityAmount * electricRate;
    }

    //function to calculate gas charge
    public double calculateGasCharge() {
        double gasRate = 0.08;
        return gasAmount * gasRate;
    }

    //function for total bill from electric and gas charge
    public double totalBill() {
        return calculateElectricCharge() + calculateGasCharge();
    }
}

// subclass GreenEnergyBill take attributes from EnergyBill
class GreenEnergyBill extends EnergyBill {
    private double solarDeductionPoint;

    public GreenEnergyBill(String name, String address, double electricityAmount, double gasAmount, double solarDeductionPoint) {
        super(name, address, electricityAmount, gasAmount);
        this.solarDeductionPoint = solarDeductionPoint;
    }
    public double getSolarPoint() {
        return solarDeductionPoint;
    }

    public void setSolarPoint(double solarDeductionPoint) {
        this.solarDeductionPoint = solarDeductionPoint;
    }

    //function to calculate the deduction amount
    public double getDeductionAmount() {
        double originalBill = super.totalBill(); //taking value of totalBill method in super class
        return originalBill * solarDeductionPoint / 100;
    }
    @Override
    //override the total bill function from super class to calculate new total bill with deduction amount
    public double totalBill() {
        double originalBill = super.totalBill();
        return originalBill - getDeductionAmount();
    }
}
