package com.example.asuper.json;

/**
 * Created by bvxcx on 2017/3/8.
 */

public class Cafe {
    private String id;
    private String name;
    private float wifi;
    private float quiet;
    private float tasty ;
    private float cheap;
    private float music ;
    private String address ;
    private float latitude ;
    private float longitude ;
    private String url ;
    private String limited_time;
    private String  socket;
    private String standing_desk;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public float getWifi() {
        return wifi;
    }

    public void setWifi(float wifi) {
        this.wifi = wifi;
    }

    public float getQuiet() {
        return quiet;
    }

    public void setQuiet(float quiet) {
        this.quiet = quiet;
    }

    public float getTasty() {
        return tasty;
    }

    public void setTasty(float tasty) {
        this.tasty = tasty;
    }

    public float getCheap() {
        return cheap;
    }

    public void setCheap(float cheap) {
        this.cheap = cheap;
    }

    public float getMusic() {
        return music;
    }

    public void setMusic(float music) {
        this.music = music;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public float getLatitude() {
        return latitude;
    }

    public void setLatitude(float latitude) {
        this.latitude = latitude;
    }

    public float getLongitude() {
        return longitude;
    }

    public void setLongitude(float longitude) {
        this.longitude = longitude;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getLimited_time() {
        return limited_time;
    }

    public void setLimited_time(String limited_time) {
        this.limited_time = limited_time;
    }

    public String getSocket() {
        return socket;
    }

    public void setSocket(String socket) {
        this.socket = socket;
    }

    public String getStanding_desk() {
        return standing_desk;
    }

    public void setStanding_desk(String standing_desk) {
        this.standing_desk = standing_desk;
    }

    @Override
    public String toString() {
        return "Cafe{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                ", wifi=" + wifi +
                ", quiet=" + quiet +
                ", tasty=" + tasty +
                ", cheap=" + cheap +
                ", music=" + music +
                ", address='" + address + '\'' +
                ", latitude=" + latitude +
                ", longitude=" + longitude +
                ", url='" + url + '\'' +
                ", limited_time='" + limited_time + '\'' +
                ", socket='" + socket + '\'' +
                ", standing_desk='" + standing_desk + '\'' +
                '}';
    }
}
