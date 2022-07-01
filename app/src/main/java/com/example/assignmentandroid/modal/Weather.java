package com.example.assignmentandroid.modal;

public class Weather {
    private String DateTime;
    private int EpochDateTime;
    private int WeatherIcon;
    private String IconPhrase;
    private boolean HasPrecipitation;
    private boolean IsDaylight;
    private Temperature Temperature;
    private int PrecipitationProbability;
    private String MobileLink;
    private String Link;

    public Weather() {
    }

    public Weather(String dateTime, int epochDateTime, int weatherIcon, String iconPhrase, boolean hasPrecipitation, boolean isDaylight, com.example.assignmentandroid.modal.Temperature temperature, int precipitationProbability, String mobileLink, String link) {
        DateTime = dateTime;
        EpochDateTime = epochDateTime;
        WeatherIcon = weatherIcon;
        IconPhrase = iconPhrase;
        HasPrecipitation = hasPrecipitation;
        IsDaylight = isDaylight;
        Temperature = temperature;
        PrecipitationProbability = precipitationProbability;
        MobileLink = mobileLink;
        Link = link;
    }

    public String getDateTime() {
        return DateTime;
    }

    public void setDateTime(String dateTime) {
        DateTime = dateTime;
    }

    public int getEpochDateTime() {
        return EpochDateTime;
    }

    public void setEpochDateTime(int epochDateTime) {
        EpochDateTime = epochDateTime;
    }

    public int getWeatherIcon() {
        return WeatherIcon;
    }

    public void setWeatherIcon(int weatherIcon) {
        WeatherIcon = weatherIcon;
    }

    public String getIconPhrase() {
        return IconPhrase;
    }

    public void setIconPhrase(String iconPhrase) {
        IconPhrase = iconPhrase;
    }

    public boolean isHasPrecipitation() {
        return HasPrecipitation;
    }

    public void setHasPrecipitation(boolean hasPrecipitation) {
        HasPrecipitation = hasPrecipitation;
    }

    public boolean isDaylight() {
        return IsDaylight;
    }

    public void setDaylight(boolean daylight) {
        IsDaylight = daylight;
    }

    public com.example.assignmentandroid.modal.Temperature getTemperature() {
        return Temperature;
    }

    public void setTemperature(com.example.assignmentandroid.modal.Temperature temperature) {
        Temperature = temperature;
    }

    public int getPrecipitationProbability() {
        return PrecipitationProbability;
    }

    public void setPrecipitationProbability(int precipitationProbability) {
        PrecipitationProbability = precipitationProbability;
    }

    public String getMobileLink() {
        return MobileLink;
    }

    public void setMobileLink(String mobileLink) {
        MobileLink = mobileLink;
    }

    public String getLink() {
        return Link;
    }

    public void setLink(String link) {
        Link = link;
    }
}
