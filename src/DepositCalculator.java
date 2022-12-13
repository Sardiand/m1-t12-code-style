import java.util.Scanner;

public class DepositCalculator {

    double calculateComplexPercent(double amount, double yearRate, int period) {
        double pay = amount * Math.pow((1 + (yearRate / 12)), 12 * period);
        return roundNumber(pay);
    }
    double calculateSimplePercent(double amount, double yearRate, int period) {
        return roundNumber(amount + amount * yearRate * period);
    }
    double roundNumber(double value) {
        double roundArgument = Math.pow(10, 2);
        return Math.round(value* roundArgument) / roundArgument;
    }

    void calculateDeposit() {
        double depositSumToFinal = 0;
        double yearRate = 0.06;
        Scanner scanner = new Scanner(System.in);

        System.out.println("Введите сумму вклада в рублях:");
        int amount = scanner.nextInt();

        System.out.println("Введите срок вклада в годах:");
        int period = scanner.nextInt();

        System.out.println("Выберите тип вклада, 1 - вклад с обычным процентом, 2 - вклад с капитализацией:");
        int action = scanner.nextInt();

        if (action == 1) {
            depositSumToFinal = calculateSimplePercent(amount, yearRate, period);
        } else if (action == 2) {
            depositSumToFinal = calculateComplexPercent(amount, yearRate, period);
        }
        System.out.println("Результат вклада: " + amount + " за " + period +
                " лет превратятся в " + depositSumToFinal);
    }

    public static void main(String[] args) {
        new DepositCalculator().calculateDeposit();
    }
}
