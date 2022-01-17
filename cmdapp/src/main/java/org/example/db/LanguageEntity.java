package org.example.db;

import javax.persistence.*;
import java.util.Collection;

@Entity
@Table(name = "LANGUAGE", schema = "ROOT", catalog = "")
public class LanguageEntity {
    private int languageId;
    private String name;
    private Collection<CountryEntity> countries;

    @Id
    @Column(name = "LANGUAGE_ID")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public int getLanguageId() {
        return languageId;
    }

    public void setLanguageId(int languageId) {
        this.languageId = languageId;
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

        LanguageEntity that = (LanguageEntity) o;

        if (languageId != that.languageId) return false;
        if (name != null ? !name.equals(that.name) : that.name != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = languageId;
        result = 31 * result + (name != null ? name.hashCode() : 0);
        return result;
    }

    @OneToMany(mappedBy = "language")
    public Collection<CountryEntity> getCountries() {
        return countries;
    }

    public void setCountries(Collection<CountryEntity> countries) {
        this.countries = countries;
    }
}
