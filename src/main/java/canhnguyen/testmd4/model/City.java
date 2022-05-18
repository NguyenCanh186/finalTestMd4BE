package canhnguyen.testmd4.model;

import javax.persistence.*;

@Entity
@Table(name= "city")
public class City {
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private Long id;

    private String name;

    private int acreage;

    private int population;

    private int gdp;

    private String description;

    @ManyToOne
    @JoinColumn(name = "country_id")
    private Country country;

    public City() {
    }

    public City(Long id, String name, int acreage, int population, int gdp, String description, Country country) {
        this.id = id;
        this.name = name;
        this.acreage = acreage;
        this.population = population;
        this.gdp = gdp;
        this.description = description;
        this.country = country;
    }

    public City(String name, int acreage, int population, int gdp, String description, Country country) {
        this.name = name;
        this.acreage = acreage;
        this.population = population;
        this.gdp = gdp;
        this.description = description;
        this.country = country;
    }

    public int getGDP() {
        return gdp;
    }

    public void setGDP(int gdp) {
        this.gdp = gdp;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAcreage() {
        return acreage;
    }

    public void setAcreage(int acreage) {
        this.acreage = acreage;
    }

    public int getPopulation() {
        return population;
    }

    public void setPopulation(int population) {
        this.population = population;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Country getCountry() {
        return country;
    }

    public void setCountry(Country country) {
        this.country = country;
    }
}
