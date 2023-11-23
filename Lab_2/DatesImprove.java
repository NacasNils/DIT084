/*
  Origin from http://pages.cs.wisc.edu/~vernon/cs367/tutorials/jdb.tutorial.html
  Modified by Jeff C.
*/

import java.io.*;

class DatesImprove {

  /* Precondition: month is between 1 and 12, inclusive */
  /* Postcondition: returns the number of days in the given month */
public static int daysInMonth (int month) {
  if ((month == 4) || (month == 6) || (month == 9) || (month == 11)) {
    return 30;
  }
  if (month == 2){
    return 28;
  }
  else return 31;
}
public static void main (String[] args) {
    int someMonth, someDay;
    int laterMonth, laterDay;

    someMonth = Integer.parseInt(args[0]);
    someDay = Integer.parseInt(args[1]);

    laterMonth = Integer.parseInt(args[2]);
    laterDay = Integer.parseInt(args[3]);

    /* Used to record what day in the year the first day  */
    /* of someMonth and laterMonth are. */
    int someDayInYear = 0;
    int laterDayInYear = 0;

    for (int i = 1; i < someMonth; i++) {
        someDayInYear += daysInMonth(i);
    }
    someDayInYear += someDay;
    for (int i = 1 ; i < laterMonth; i++) {
        laterDayInYear += daysInMonth(i);
    }
    laterDayInYear += laterDay;

    /* The answer */
    int daysBetween = 0;
    System.out.println("The difference in days between " +
                       someMonth + "/" + someDay + " and " +
                       laterMonth + "/" + laterDay + " is: ");
    daysBetween = laterDayInYear - someDayInYear;
    System.out.println(daysBetween);
}
}