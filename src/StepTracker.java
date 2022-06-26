public class StepTracker {
    Converter converter;
    MonthData[] monthData;
    int aim;

    StepTracker() {
        monthData = new MonthData[12];
        aim = 10_000;
        converter = new Converter();

        for (int i = 0; i < monthData.length; i++) {
            monthData[i] = new MonthData();
        }
    }

    void saveSteps(int month, int day, int steps) {
        monthData[month].setDaySteps(day, steps);
    }

    void getAllDaysStatistics(int month) {
        for (int i = 0; i < monthData[month].getDays().length; i++) {
            System.out.println((i + 1) + " день: " + monthData[month].getDaySteps(i));
        }
    }

    void getSumOfStepsPerMonth(int month) {
        int sum = monthData[month].getSumOfSteps();
        System.out.println("Общее кол-во шагов за месяц: " + sum);
    }

    void getMaxOfStepsPerMonth(int month) {
        int max = 0;

        for (int i = 0; i < monthData[month].getDays().length; i++) {
            if (monthData[month].getDaySteps(i) > max) {
                max = monthData[month].getDaySteps(i);
            }
        }

        System.out.println("Максимальное кол-во шагов за месяц: " + max);
    }

    void getAverageStepsPerMonth(int month) {
        int sum = monthData[month].getSumOfSteps();
        int days = monthData[month].getDays().length;
        System.out.println("Среднее кол-во шагов за месяц: " + (sum / days));
    }

    void getDistance(int month) {
        int sum = monthData[month].getSumOfSteps();
        System.out.println("Пройденная дистанция: " + converter.convertStepsToKilometers(sum) + " км");
    }

    void getKilocalories(int month) {
        int sum = monthData[month].getSumOfSteps();
        System.out.println("Кол-во сожженных килокалорий: " + converter.convertStepsToKilocalories(sum) + " ккал");
    }

    void getBestSeries(int month) {
        int bestSeries = 0;
        int bestSeriesTerm = 0;

        for (int i = 0; i < monthData[month].getDays().length; i++) {
            if (monthData[month].getDaySteps(i) >= aim) {
                bestSeriesTerm++;
            } else {
                if (bestSeriesTerm > bestSeries) {
                    bestSeries = bestSeriesTerm;
                }
                bestSeriesTerm = 0;
            }
        }

        if (bestSeriesTerm > bestSeries) {
            bestSeries = bestSeriesTerm;
        }

        System.out.println("Лучшая серия: " + bestSeries + " дней\n");
    }

    void changeAim(int newAim) {
        aim = newAim;
        System.out.println("Цель успешно изменена\n");
    }

    void getStatistics(int month) {
        getAllDaysStatistics(month);
        getSumOfStepsPerMonth(month);
        getMaxOfStepsPerMonth(month);
        getAverageStepsPerMonth(month);
        getDistance(month);
        getKilocalories(month);
        getBestSeries(month);
    }

    class MonthData {
        int[] days;

        MonthData() {
            days = new int[30];
        }

        int[] getDays() {
            return days;
        }

        int getDaySteps(int day) {
            return days[day];
        }

        void setDaySteps(int day, int steps) {
            days[day] = steps;
        }

        int getSumOfSteps() {
            int sum = 0;

            for (int i = 0; i < days.length; i++) {
                sum += days[i];
            }

            return sum;
        }
    }
}
