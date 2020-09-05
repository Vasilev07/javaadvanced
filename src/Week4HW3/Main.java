package Week4HW3;

public class Main {
    public static void main(String[] args) {
        Manufacturer beko = new Manufacturer("Beko");
        
        Cooker bekoGasCooker = new Cooker(beko, CookerType.GAS, 100);
        bekoGasCooker.setWarranty(CookerType.GAS);

        System.out.println(bekoGasCooker.getWarranty());

        Cooker bekoElectricalCooker = new Cooker(beko, CookerType.ELECTRICAL, 200);
        bekoElectricalCooker.setWarranty(CookerType.ELECTRICAL);

        System.out.println(bekoElectricalCooker.getWarranty());
    }
}
