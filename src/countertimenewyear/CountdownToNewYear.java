/**
 * Программа подсчёта времени оставшегося до нового года
 * Алгоритм:
 *  получить дату нового года newYearDate
 *  создать таймер с интервалом 1 секунду {
 *      получить текущую дату currentDate
 *      вычислить разницу между currentDate и newYearDate
 *      вывести в консоль результат
 * }
 */
package countertimenewyear;

import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;
import java.util.Timer;
import java.util.TimerTask;

/**
 *
 * @author pupil
 */
public class CountdownToNewYear {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
    Timer timer = new Timer();

        LocalDateTime startOfNextYear = calculateStartOfNextYear();

        TimerTask task = new TimerTask() {
            @Override
            public void run() {
                LocalDateTime currentDateTime = LocalDateTime.now();

                long monthsUntilNewYear = ChronoUnit.MONTHS.between(currentDateTime, startOfNextYear);
                long daysUntilNewYear = ChronoUnit.DAYS.between(currentDateTime, startOfNextYear);
                long hoursUntilNewYear = ChronoUnit.HOURS.between(currentDateTime, startOfNextYear) % 24;
                long minutesUntilNewYear = ChronoUnit.MINUTES.between(currentDateTime, startOfNextYear) % 60;
                long secondsUntilNewYear = ChronoUnit.SECONDS.between(currentDateTime, startOfNextYear) % 60;

                String timeUntilNewYear = String.format("%d месяцев, %d дней, %d часов, %d минут, %d секунд",
                        monthsUntilNewYear, daysUntilNewYear, hoursUntilNewYear, minutesUntilNewYear, secondsUntilNewYear);

                System.out.println("Время до нового года: " + timeUntilNewYear);
            }
        };

        timer.scheduleAtFixedRate(task, 0, 1000);
    }

    private static LocalDateTime calculateStartOfNextYear() {
        LocalDateTime currentDateTime = LocalDateTime.now();
        return currentDateTime.plusYears(1).withDayOfYear(1).withHour(0).withMinute(0).withSecond(0).withNano(0);
    }
}
    

