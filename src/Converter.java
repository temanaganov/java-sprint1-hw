public class Converter {
    double convertStepsToKilometers(int steps) {
        double stepLength = 0.75;
        double kilometerLength = 1000;

        return steps * stepLength / kilometerLength;
    }

    double convertStepsToKilocalories(int steps) {
        int caloriesInStep = 50;
        double caloriesInKilocalories = 1000;

        return steps * caloriesInStep / caloriesInKilocalories;
    }
}
