package Week3HW2;

public class MusicStudio {
    private String name;
    private Employee director;
    private int minimalPricePerHour = 20;
    private int maxWorkingHours = 8;
    private int currentMoneyCollectedInLv = 0;
    private int price = 20;

    public void constructor(String name) {
        this.name = name;
    }

    public void setMusicStudioDirector(Employee employee) {
        this.director = employee;
    }

    public void rent(int hours) {
        int currentWorkingHours =  this.maxWorkingHours - hours;

        if (currentWorkingHours > 0) {
            this.maxWorkingHours = currentWorkingHours;
        }

        if (this.price >= this.minimalPricePerHour) {
            this.currentMoneyCollectedInLv = hours * this.price;
        } else {
            this.currentMoneyCollectedInLv = hours * this.minimalPricePerHour;
        }
    }

    public int getMinimalPricePerHour() {
        return minimalPricePerHour;
    }

    public Employee getDirector() {
        return director;
    }

    public int getPrice() {
        return price;
    }

    public void setPriceForRent(int newPrice) {
        if (newPrice > this.minimalPricePerHour) {
            this.price = newPrice;
        }
    }

    public int getCurrentMoneyCollected() {
        return currentMoneyCollectedInLv;
    }

    public double getCurrentMoneyCollected(Currency currency) {
        if (currency.getType() == "USD") {
            return currentMoneyCollectedInLv * 1.64;
        } else if (currency.getType() == "EUR") {
            return currentMoneyCollectedInLv * 1.95;
        }

        return currentMoneyCollectedInLv;
    }
}
