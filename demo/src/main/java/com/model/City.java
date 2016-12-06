package com.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.*;
import java.util.List;
import java.util.Set;

/**
 * Created by inastase on 11/22/2016.
 */
@Entity
public class City {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long cityId;

    @Column(name = "name")
    private String cityName;

    @Column(name = "jsonWeather",columnDefinition = "TEXT")
    private String jsonWeather;


//    @ManyToMany(fetch = FetchType.LAZY)
//    @JoinTable(joinColumns = {@JoinColumn(name = "cityId")},
//            inverseJoinColumns = {@JoinColumn(name = "userId")})
    @ManyToMany(cascade = CascadeType.ALL, mappedBy = "cities", fetch = FetchType.EAGER)
    @JsonBackReference
    private List<User> users;

    public City(String cityName, List<User> users, String jsonWeather) {
        this.cityName = cityName;
        this.users = users;
        this.jsonWeather = jsonWeather;
    }

    public City(String cityName){
        this.cityName = cityName;
    }

    public String getJsonWeather() {

        return jsonWeather;
    }

    public void setJsonWeather(String jsonWeather) {
        this.jsonWeather = jsonWeather;
    }

    public City() {
    }

    public Long getCityId() {
        return cityId;
    }

    public void setCityId(Long cityId) {
        this.cityId = cityId;
    }

    public String getCityName() {
        return cityName;
    }

    public void setCityName(String cityName) {
        this.cityName = cityName;
    }

    public List<User> getUsers() {
        return users;
    }

    public void setUsers(List<User> users) {
        this.users = users;
    }

    @Override
    public String toString() {
        return "City{" +
                "cityId=" + cityId +
                ", cityName='" + cityName + '\'' +
                ", users=" + users +
                '}';
    }
}
