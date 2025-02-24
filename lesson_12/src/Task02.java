public class Task02 {
    public static void main(String[] args) {
        /*Task 2
        Найдите в Интернете данные по температуре в вашем городе за прошедшую неделю (или придумайте :) ).

        Вычислите среднюю температуру за неделю и выведите ее на печать.
        P.S. - правильно выберите типы данных*/

        //обычно дневную температуру дают в целых градусах
        int mondayTemp = -1;
        int tuesdayTemp = 0;
        int wednesdayTemp = -1;
        int thursdayTemp = 2;
        int fridayTemp = 5;
        int saturdayTemp = 6;
        int sundayTemp = 4;
        //а для средней за неделю, полагаю, стоит взять double. Если нет - тогда можно сильно всё упростить и взять int
        double averageTemp = (double)(mondayTemp + tuesdayTemp + wednesdayTemp + thursdayTemp + fridayTemp + saturdayTemp + sundayTemp)/7;

        System.out.printf("Average week temp: %.1f C", averageTemp);
    }
}
