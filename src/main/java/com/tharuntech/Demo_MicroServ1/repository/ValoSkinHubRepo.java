package com.tharuntech.Demo_MicroServ1.repository;

import com.tharuntech.Demo_MicroServ1.entity.ValorantSkinHub;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ValoSkinHubRepo extends JpaRepository<ValorantSkinHub,Integer> {
}
