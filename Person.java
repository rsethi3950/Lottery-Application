import java.io.*;
import java.util.*;
public class Person{
    public String name;
    public int lotteryNo ;
    public int age ;
    public String city;
    public String country;
    Person(){
    }
    Person(String name, int lotteryNo, int age, String city, String country ){
        this.name=name;
        this.lotteryNo=lotteryNo;
        this.age=age;
        this.city=city;
        this.country=country;
    }
}