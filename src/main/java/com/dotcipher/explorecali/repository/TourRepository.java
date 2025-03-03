package com.dotcipher.explorecali.repository;


import com.dotcipher.explorecali.domain.Tour;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RestResource;

import java.util.Optional;

/**
 * Tour Repository Interface
 *
 * Created by Mary Ellen Bowman
 */
public interface TourRepository extends PagingAndSortingRepository<Tour,Integer> {
    Optional<Tour> findById(Integer tourId);

    /**
     * Lookup a Page of Tours associated with a TourPackage
     *
     * @param code the tour Package code.
     * @param pageable details for finding the correct page.
     * @return A page of tours if found, empty otherwise.
     */

    Page<Tour> findByTourPackageCode(@Param("code") String code, Pageable pageable);

    //Not exposed by Spring Data REST

    @RestResource(exported = false)
    <S extends Tour> S save(S s);

    //Not exposed by Spring Data REST

    @RestResource(exported = false)
    <S extends Tour> Iterable<S> saveAll(Iterable<S> iterable);

    //Not exposed by Spring Data REST

    @RestResource(exported = false)
    void deleteById(Integer integer);

    //Not exposed by Spring Data REST

    @RestResource(exported = false)
    void delete(Tour tour);

    //Not exposed by Spring Data REST
    @RestResource(exported = false)
    void deleteAll(Iterable<? extends Tour> iterable);

    //Not exposed by Spring Data REST

    @RestResource(exported = false)
    void deleteAll();

    long count();
}
