package com.tharuntech.Demo_MicroServ1.repository;

import com.tharuntech.Demo_MicroServ1.entity.ValorantSkinHub;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface ValoSkinHubRepo extends JpaRepository<ValorantSkinHub,Integer> {

    @Query("SELECT v.name FROM valorant_skin_hub v WHERE v.uuid = :uuid")
    Optional<ValorantSkinHub> existByuuid(String uuid);
}
