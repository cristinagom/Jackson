package model;

import com.fasterxml.jackson.annotation.JsonGetter;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonRootName;
import com.fasterxml.jackson.annotation.JsonSetter;

import java.io.Serializable;

@JsonRootName(value="car")
public class Car{
    @JsonProperty("color") /*Innecesario*/
    private String color;
    @JsonProperty("type") /*Innecesario*/
    private String type;

    public Car() {
    }
    public Car(String color, String type) {
        this.color = color;
        this.type = type;
    }

    @JsonGetter("color") /*Innecesario*/
    public String getColor() {
        return color;
    }
    @JsonSetter("color") /*Innecesario*/
    public void setColor(String color) {
        this.color = color;
    }
    @JsonGetter("type") /*Innecesario*/
    public String getType() {
        return type;
    }
    @JsonGetter("type") /*Innecesario*/
    public void setType(String type) {
        this.type = type;
    }
}
