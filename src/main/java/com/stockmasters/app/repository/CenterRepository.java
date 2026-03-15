package com.stockmasters.app.repository;

import com.stockmasters.app.model.DistributionCenter;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CenterRepository extends JpaRepository<DistributionCenter, Long> {

}