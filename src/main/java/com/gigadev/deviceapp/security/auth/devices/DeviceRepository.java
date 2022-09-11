package com.gigadev.deviceapp.security.auth.devices;

import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DeviceRepository extends PagingAndSortingRepository<Device, Long> {

}
