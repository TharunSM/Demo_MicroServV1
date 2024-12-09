package com.tharuntech.Demo_MicroServ1.repository;

import com.tharuntech.Demo_MicroServ1.entity.Model.BundleRateing;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.Optional;

public interface RateingRepo extends JpaRepository<BundleRateing, String> {

    Optional<BundleRateing> findByUuid(String uuid);

    @Query("SELECT r.rateingCount FROM BundleRateing r WHERE r.uuid = :uuid")
    Optional<Integer> findRatingCount(String uuid);

    @Query("SELECT r.rateing FROM BundleRateing r WHERE r.uuid = :uuid")
    Optional<Integer> findCurrentRating(String uuid);
}
