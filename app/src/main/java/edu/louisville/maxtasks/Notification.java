package edu.louisville.maxtasks;

import java.util.Date;

enum FrequencyType{
    MINUTE, HOUR, DAY
}

public class Notification {
    String title;
    Date notificationTime;
    FrequencyType frequencyType;
    int frequency;

}
