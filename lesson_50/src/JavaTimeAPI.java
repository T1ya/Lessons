import java.time.*;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;

public class JavaTimeAPI {
    public static void main(String[] args) {

        /*
        util.DAte

         */
        LocalDate date = LocalDate.now();// текущая дата
        System.out.println("date: " + date);

        LocalDate tomorrow = date.plusDays(1);
        System.out.println("tomorrow: " + tomorrow);
        System.out.println("plusWeks: " + date.plusWeeks(4));
        System.out.println("minusMonth: " + date.minusMonths(2));
        LocalDate date1 = LocalDate.of(2002 , 2 , 15);
        System.out.println("date1: " + date1 );

        date1 = LocalDate.of(2002 , Month.FEBRUARY , 15);
        System.out.println("date1: " + date1 );
        System.out.println("Год: " + date.getYear() + "; Месяц: " + date.getMonth()+ "; месяц-цифра: " + date.getMonthValue());
        System.out.println("число: " + date.getDayOfMonth() + "; день недели: " + date.getDayOfWeek() + "; деньгода: " + date.getDayOfYear());
        System.out.println("сколько дней в месяце: " + date.lengthOfMonth() + "; дней в году: " + date.lengthOfYear() + "; высокосный?:  " +  date.isLeapYear());

        String dateString = "2000-10-25";
        LocalDate date2 = LocalDate.parse(dateString);
        System.out.println(date2.getDayOfMonth() + " : " + date2.getMonthValue());

        System.out.println("\n\n\n ======================localTime================");
        LocalTime time = LocalTime.now();
        System.out.println(time);

        LocalTime time1 = LocalTime.of(21 ,33);
        time1 = LocalTime.of(21 ,33 , 44);
        time1 = LocalTime.of(21 ,33 , 44 , 54875);
        System.out.println(time1);
        LocalTime time2 = time.plusHours(1);
        System.out.println(time2);
        System.out.println(time.plusMinutes(65));
        System.out.println(time.minusSeconds(30));
        System.out.println(time.getHour()+ " | " + time.getMinute() + " | " + time.getSecond() + " | " + time.getNano() );

        System.out.println("\n\n\n ======================LocalDateTime================");
        //LocalDateTime - текущие дата и время
        LocalDateTime now = LocalDateTime.now();
        System.out.println("Now is: "+ now);

        //варианты конструктора (перегрузки)
        LocalDate date3 = LocalDate.of(2011, Month.AUGUST,15);
        LocalTime time3 = LocalTime.of(15,22,59);
        LocalDateTime dateTime3 = LocalDateTime.of(date3,time3);
        System.out.println("Local date time: " + dateTime3);
        dateTime3 = LocalDateTime.of(2056,12,31,23,59);
        System.out.println("It would be " + dateTime3.getDayOfWeek());

        //внутри есть все методы из LocalDate LocalTime
        System.out.println("After 1 hour it would be "+ dateTime3.plusHours(1).getDayOfWeek());
        System.out.println("Year before it was "+ dateTime3.minusYears(1).getDayOfWeek());

        System.out.println("\n\n\n ======================ZonedDateTime================");
        //ZonedDateTime - текущие дата и время с часовым поясом
        ZonedDateTime zonedDateTime = ZonedDateTime.now();
        System.out.println("zonedDateTime " +zonedDateTime.getHour() + ":" + zonedDateTime.getMinute() + " for "+ zonedDateTime.getZone());

        System.out.println("\n\n\n ======================isAfter, isBefore, until, equals================");
        LocalDateTime dateTime4 = LocalDateTime.of(2012,4,25,13,44,22);
        LocalDateTime dateTime5 = LocalDateTime.of(2012,5,5,8,5);

        boolean isAfter = dateTime5.isAfter(dateTime4);
        System.out.println("dateTime5 is after dateTime4: " + isAfter);

        boolean isBefore = dateTime5.isBefore(dateTime4);

        System.out.println("dateTime5 is before dateTime4: " + isBefore);

        boolean isEquals = dateTime5.equals(dateTime4);
        System.out.println("dateTime5 equals dateTime4: " + isEquals);

        long hoursBetween = dateTime4.until(dateTime5, ChronoUnit.HOURS);
        long daysBetween = dateTime5.until(dateTime4, ChronoUnit.DAYS);
        System.out.println("hours between dateTime4 and dateTime5: "+ hoursBetween);
        System.out.println("days between dateTime4 and dateTime5: "+ daysBetween);

        LocalDateTime dateTime6 = dateTime4.plus(10, ChronoUnit.DAYS);
        System.out.println(dateTime4.getDayOfWeek() + " + 10 days = " + dateTime6.getDayOfWeek());


        System.out.println("\n\n\n ======================Instant, Duration, Period================");
        //Instant - точка на временной шкале в Григонианском календаре (милисекунд)
        //  *Unix epoch/epoch/epoch time - началась с 1 января 1970г. Момент времени отсчитывается от этой даты

        Instant nowInstant = Instant.now();
        long millis = nowInstant.toEpochMilli();
        System.out.println("passed millis: " + millis);

        System.out.println("\n\n\n ======================DateTimeFormatter================");

        LocalDateTime nowLDT = LocalDateTime.now();
        System.out.println("now LTD: " + nowLDT);
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss");
        String formatedDT = nowLDT.format(formatter);
        System.out.println("now (formatted): " + formatedDT);

        System.out.println("\n\n\n ======================Parsed date================");

        String parseString = "15-12-2022 20-46";
        DateTimeFormatter formatter2 = DateTimeFormatter.ofPattern("dd-MM-yyyy HH-mm");
        LocalDateTime parsedDate = LocalDateTime.parse(parseString, formatter2);
        System.out.println(parsedDate);
        System.out.println("Month: " + parsedDate.getMonth());
        System.out.println("Day 1 is: " + parsedDate.getDayOfWeek());
        System.out.println("Hour: " + parsedDate.getHour());

        String parseString2 = "13-01-2023 00-47";
        LocalDateTime parsedDate2 = LocalDateTime.parse(parseString2, formatter2);
        System.out.println("Day 2 is: " + parsedDate2.getDayOfWeek());

        System.out.println("Days between: " + parsedDate.until(parsedDate2, ChronoUnit.DAYS));
    }
}
