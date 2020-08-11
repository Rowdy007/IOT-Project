#include <LiquidCrystal.h>

#include <SPI.h> #include <Wire.h>
#include <Adafruit_GFX.h> #include <Adafruit_SSD1306.h> #include "modified_font.h"
#define OLED_RESET LED_BUILTIN
Adafruit_SSD1306 display(OLED_RESET);
#if (SSD1306_LCDHEIGHT != 64)
//#error("Height incorrect, please fix Adafruit_SSD1306.h!");
38
#endif
void setup() { display.begin(SSD1306_SWITCHCAPVCC, 0x3C); display.clearDisplay();
display.setTextSize(1); display.setTextColor(WHITE);
}
void loop() {
display.setCursor(0,5); display.println("Ashutosh");
display.setCursor(0,15); display.println("Om Tiwari");
display.setCursor(0,25); display.println("Moavia");
display.display(); display.clearDisplay();
}
