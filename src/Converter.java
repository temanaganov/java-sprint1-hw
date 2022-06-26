public class Converter {
    final double STEP_LENGTH = 0.75;
    final double KILOMETER_LENGTH = 1000;
    final int CALORIES_STEP = 50;
    final double CALORIES_IN_KILOCALORIES = 1000;

    double convertStepsToKilometers(int steps) {
        return steps * STEP_LENGTH / KILOMETER_LENGTH;
    }

    double convertStepsToKilocalories(int steps) {
        return steps * CALORIES_STEP / CALORIES_IN_KILOCALORIES;
    }
}
