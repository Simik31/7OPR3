package org.example;

import org.example.db.CountryEntity;
import org.example.db.CountryRepository;
import org.example.db.LanguageEntity;
import org.example.db.LanguageRepository;

public class App
{
    public static void main( String[] args )
    {
        createLng();
        createCountry();
    }

    public static void createLng() {
        LanguageEntity lng = new LanguageEntity();
        lng.setName("Cestina");
        LanguageRepository repo = new LanguageRepository();
        repo.save(lng);
    }

    public static void createCountry() {
        LanguageRepository lngRepo = new LanguageRepository();
        LanguageEntity lng = lngRepo.getById(1);

        CountryEntity cnt = new CountryEntity();
        cnt.setName("Cesko");
        cnt.setLanguage(lng);

        CountryRepository cntRepo = new CountryRepository();
        cntRepo.save(cnt);
    }
}
