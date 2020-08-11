#include <Wire.h> #include <DS1307.h> DS1307 rtc;
void setup ()
{
Serial.begin(9600); while (! Serial);
Serial.println("Init RTC...");
rtc.set(45, 9, 14, 12, 03, 2019);
rtc.start();
}
40
void loop ()
{
uint8_t sec, min, hour, day, month; uint16_t year;
get time from RTC
rtc.get(&sec, &min, &hour, &day, &month, &year); display.print(hour, DEC);
display.print(":"); display.print(min, DEC); display.print(":"); display.print(sec, DEC); display.print(day, DEC); display.print("."); display.print(month, DEC); display.print("."); display.print(year, DEC);
delay(1000);
}
