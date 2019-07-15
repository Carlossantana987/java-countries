package com.countriesapp.countries;

import java.util.concurrent.atomic.AtomicLong;

public class Country
{

    //Fields or attributes
    private static final AtomicLong counter = new AtomicLong();
    private long id;
    private String cname;
    private int population;
    private double landMassSize;
    private double medianAge;


    //constructor
    public Country(String cname, int population, double landMassSize, double medianAge)
    {
        this.id = counter.incrementAndGet();
        this.cname = cname;
        this.population = population;
        this.landMassSize = landMassSize;
        this.medianAge = medianAge;
    }

    // GETTERS && SETTERS
    public long getId()
    {
        return id;
    }

    public String getCname()
    {
        return cname;
    }

    public void setCname(String cname)
    {
        this.cname = cname;
    }

    public int getPopulation()
    {
        return population;
    }

    public void setPopulation(int population)
    {
        this.population = population;
    }

    public double getLandMassSize()
    {
        return landMassSize;
    }

    public void setLandMassSize(double landMassSize)
    {
        this.landMassSize = landMassSize;
    }

    public double getMedianAge()
    {
        return medianAge;
    }

    public void setMedianAge(double medianAge)
    {
        this.medianAge = medianAge;
    }

    @Override
    public String toString()
    {
        return "Country{" + "id=" + id + ", cname='" + cname + '\'' + ", population=" + population + ", landMassSize" +
                "=" + landMassSize + ", medianAge=" + medianAge + '}';
    }
}
