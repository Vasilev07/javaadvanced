package Week3HW2;

public class Client {
    public MusicStudio comparePrices(MusicStudio first, MusicStudio second) {
        if (first.getPrice() > second.getPrice()) {
            return second;
        } else {
            return first;
        }
    }

    public void getDiscount(MusicStudio studio, int percent) {
           int currentPrice = studio.getPrice();
           int discountPrice = (currentPrice * percent) / 100;

           if (studio.getMinimalPricePerHour() < discountPrice) {
               studio.setPriceForRent(discountPrice);
           }
    }

    public MusicStudio compareByDirectorAge(MusicStudio studioOne, MusicStudio studioTwo, boolean younger) {
        if (younger) {
            if (studioOne.getDirector().getAge() > studioTwo.getDirector().getAge()) {
                return studioTwo;
            } else {
                return studioOne;
            }
        } else {
            if (studioOne.getDirector().getAge() < studioTwo.getDirector().getAge()) {
                return studioTwo;
            } else {
                return studioOne;
            }
        }
    }
}
