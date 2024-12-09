package com.tharuntech.Demo_MicroServ1.repository;

import com.tharuntech.Demo_MicroServ1.entity.Model.ValorantSkinHub;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface ValoSkinHubRepo extends JpaRepository<ValorantSkinHub, Integer> {

    @Query("SELECT v.uuid FROM ValorantSkinHub v WHERE v.uuid = :uuid_check")

    public Optional<String> existdataByuuid(@Param("uuid_check") String uuid_check);

}
