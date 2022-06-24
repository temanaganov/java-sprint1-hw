public class StepTracker {
    Converter converter;
    int[][] allSteps;
    int aim;

    StepTracker() {
        allSteps = new int[12][30];
        aim = 10_000;
        converter = new Converter();
    }

    void saveSteps(int month, int day, int steps) {
        allSteps[month][day] += steps;

    }

    void getStatistics(int month) {
        int stepsSum = 0;
        int stepsMax = 0;
        int bestSeries = 0;
        int bestSeriesTerm = 0;

        for (int i = 0; i < allSteps[month].length; i++) {
            // Считаем общую сумму шагов
            stepsSum += allSteps[month][i];

            // Находим максимальное кол-во шагов
            if (allSteps[month][i] > stepsMax) {
                stepsMax = allSteps[month][i];
            }

            // Считаем лучшую серию дней
            if (allSteps[month][i] >= aim) {
                bestSeriesTerm++;
            } else {
                if (bestSeriesTerm > bestSeries) {
                    bestSeries = bestSeriesTerm;
                }
                bestSeriesTerm = 0;
            }

            System.out.println((i + 1) + " день: " + allSteps[month][i]);
        }

        if (bestSeriesTerm > bestSeries) {
            bestSeries = bestSeriesTerm;
        }

        System.out.println("Общее кол-во шагов за месяц: " + stepsSum);
        System.out.println("Максимальное кол-во шагов за месяц: " + stepsMax);
        System.out.println("Среднее кол-во шагов за месяц: " + (stepsSum / 30));
        System.out.println("Пройденная дистанция: " + converter.convertStepsToKilometers(stepsSum) + " км");
        System.out.println("Кол-во сожженных килокалорий: " + converter.convertStepsToKilocalories(stepsSum) + " ккал");
        System.out.println("Лучшая серия: " + bestSeries + " дней\n");
    }

    void changeAim(int newAim) {
        aim = newAim;
        System.out.println("Цель успешно изменена\n");
    }
}
