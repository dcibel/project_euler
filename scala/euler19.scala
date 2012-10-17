

// monday is 0th day of week
def computeDayOfWeek(day:Int, month:Int, year:Int):Int = {
  var dayOfWeek:Int = -1;
  forEachDayInRange(1, 1, 1900, day, month, year)  { (currentDay, currentMonth, currentYear) => 
    dayOfWeek = (dayOfWeek + 1) % 7;
  }
  return dayOfWeek;
}

// january is 1st month of year
def numberOfDaysInMonth(month:Int, year:Int):Int = {
  if (month == 2 && isLeapYear(year)) {
    return 29;
  } else {
    val monthLengths = List(31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31);
    return monthLengths(month - 1);
  }
}

def isLeapYear(year:Int):Boolean = {
  return (year % 400 == 0) || ((year % 4 == 0) && (year % 100) != 0);
}

def isDateNotAfterDate(day:Int, month:Int, year:Int, comparedDay:Int, comparedMonth:Int, comparedYear:Int):Boolean = {
  if (year > comparedYear) {
    return false;
  }
  if (year == comparedYear) {
    if (month > comparedMonth) {
      return false;
    }
    if (month == comparedMonth && day > comparedDay) {
      return false;
    }
  }
  return true;
}

def forEachDayInRange(startDay:Int, startMonth:Int, startYear:Int, endDay:Int, endMonth:Int, endYear:Int)(callback : ((Int, Int, Int) => Unit)) {
  var day:Int = startDay;
  var month:Int = startMonth;
  var year:Int = startYear;

  while (isDateNotAfterDate(day, month, year, endDay, endMonth, endYear)) {
    callback(day, month, year);
    val maxDay = numberOfDaysInMonth(month, year);
    day = day + 1;
    if (day > maxDay) {
      day = 1;
      month = month + 1;
      if (month > 12) {
        month = 1;
        year = year + 1;
      }
    }
  } 
}

def forEachDayWithDayOfWeekInRange(startDay:Int, startMonth:Int, startYear:Int, endDay:Int, endMonth:Int, endYear:Int)(callback : ((Int, Int, Int, Int) => Unit)) {
  var dayOfWeek:Int = computeDayOfWeek(startDay, startMonth, startYear);
  forEachDayInRange(startDay, startMonth, startYear, endDay, endMonth, endYear) { (day, month, year) => 
    callback(day, month, year, dayOfWeek);
    dayOfWeek = (dayOfWeek + 1) % 7;
  }
}


def countNumberOfSundaysThatOccurOnFirstDayOfMonth():Int={
  var count:Int = 0;
  forEachDayWithDayOfWeekInRange(1,1,1901, 31,12,2000) { (day, month, year, dayOfWeek) => 
    if (day == 1 && dayOfWeek == 6) {
      count = count + 1;
    }
  }
  return count;
}

println(countNumberOfSundaysThatOccurOnFirstDayOfMonth());
