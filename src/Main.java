import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("Enter your name: ");
        String name = sc.nextLine();

        System.out.println("Enter your address: ");
        String address = sc.nextLine();

        System.out.println("Enter your monthly electric usage (in kWh): ");
        double electricUsage = sc.nextDouble();

        System.out.println("Enter your monthly gas usage: ");
        double gasUsage = sc.nextDouble();


        System.out.println("Do you have solar energy contributions? (yes/no)");
        String hasSolar = sc.next();

        //creating object for EnergyBill class and call calculateElectricCharge, calculateGasCharge method
        EnergyBill totalBill = new EnergyBill(name, address, electricUsage, gasUsage);
        double electricCharge = totalBill.calculateElectricCharge();
        double gasCharge = totalBill.calculateGasCharge();

        //allow user to choose to input their solar point or no
        if (hasSolar.equals("yes")) {
            System.out.println("Enter solar deduction percentage: ");
            double solarDeductionPoint = sc.nextDouble();
            if (solarDeductionPoint < 0 || solarDeductionPoint == 0) {
                System.out.println("Invalid solar deduction percentage");
            } else {
                //create object for GreenEnergyBill subclass and call getDeductionAmount, totalBill after applying deduction
                GreenEnergyBill greenEnergyBill = new GreenEnergyBill(name, address, electricUsage, gasUsage, solarDeductionPoint);
                double deduction = greenEnergyBill.getDeductionAmount();
                double billAfterDeduction = greenEnergyBill.totalBill();

                //print out customer name, address, amount of charge for electric and gas
                System.out.println("Customer: " + name);
                System.out.println("Address: " + address);
                System.out.println("Electric " + electricUsage + "/kWh: " + "$" + electricCharge);
                System.out.println("Gas " + gasUsage + "/units: " + "$" + gasCharge);
                System.out.println("Total charges: $" + totalBill.totalBill());

                //show output for amount of deduction and total bill after deduction
                System.out.println("Solar Deduction: -$" + deduction);
                System.out.println("Total amount: $" + billAfterDeduction);
            }
        } else if (hasSolar.equals("no")) {
            System.out.println("Customer: " + name);
            System.out.println("Address: " + address);
            System.out.println("Electricity " + electricUsage + "/kWh: " + "$" + electricCharge);
            System.out.println("Gas " + gasUsage + "/units: " + "$" + gasCharge);
            System.out.println("Solar Deduction: none");

            //show output for total bill and customer information if there's no solar contribution
            System.out.println("Total amount: $" + totalBill.totalBill());
        }
    }
}