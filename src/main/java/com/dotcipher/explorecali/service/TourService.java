package com.dotcipher.explorecali.service;

import com.dotcipher.explorecali.domain.Difficulty;
import com.dotcipher.explorecali.domain.Region;
import com.dotcipher.explorecali.domain.Tour;
import com.dotcipher.explorecali.domain.TourPackage;
import com.dotcipher.explorecali.repository.TourPackageRepository;
import com.dotcipher.explorecali.repository.TourRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TourService {

    private TourRepository tourRepository;
    private TourPackageRepository tourPackageRepository;

    @Autowired
    public TourService(TourRepository tourRepository, TourPackageRepository tourPackageRepository) {
        this.tourRepository = tourRepository;
        this.tourPackageRepository = tourPackageRepository;
    }

    public Tour createTour(String title,
                           String description,
                           String blurb,
                           Integer price,
                           String duration,
                           String bullets,
                           String keywords,
                           String tourPackageName,
                           Difficulty difficulty,
                           Region region){
        TourPackage tourPackage = tourPackageRepository
                                    .findByName(tourPackageName)
                                    .orElseThrow(() -> new RuntimeException("Tour Package does not exist :  " + tourPackageName));

        return tourRepository.save(new Tour(title, description, blurb, price, duration, bullets, keywords, tourPackage, difficulty, region));
    }

    public long total() {
        return tourRepository.count();
    }

}
