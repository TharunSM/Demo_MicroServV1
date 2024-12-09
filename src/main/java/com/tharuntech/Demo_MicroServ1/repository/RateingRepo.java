package com.tharuntech.Demo_MicroServ1.repository;

import com.tharuntech.Demo_MicroServ1.entity.Model.BundleRateing;
import com.tharuntech.Demo_MicroServ1.entity.Model.ValorantSkinHub;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface RateingRepo extends JpaRepository<BundleRateing, String> {

    Optional<BundleRateing> findByUuid(String uuid);
}
