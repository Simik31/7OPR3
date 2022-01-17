package org.example.db;

import javax.persistence.*;

@Entity
@Table(name = "COUNTRY", schema = "ROOT", catalog = "")
public class CountryEntity {
    private int countryId;
    private String name;
    private LanguageEntity language;

    @Id
    @Column(name = "COUNTRY_ID")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public int getCountryId() {
        return countryId;
    }

    public void setCountryId(int countryId) {
        this.countryId = countryId;
    }

    @Basic
    @Column(name = "NAME")
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        CountryEntity that = (CountryEntity) o;

        if (countryId != that.countryId) return false;
        if (name != null ? !name.equals(that.name) : that.name != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = countryId;
        result = 31 * result + (name != null ? name.hashCode() : 0);
        return result;
    }

    @ManyToOne
    @JoinColumn(name = "LANGUAGE_ID", referencedColumnName = "LANGUAGE_ID", nullable = false)
    public LanguageEntity getLanguage() {
        return language;
    }

    public void setLanguage(LanguageEntity language) {
        this.language = language;
    }
}
