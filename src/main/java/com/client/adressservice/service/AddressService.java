package com.client.adressservice.service;

import com.client.adressservice.entity.Address;
import com.client.adressservice.repository.AddressRepo;
import com.client.adressservice.response.AddressResponse;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class AddressService {

    @Autowired
    private AddressRepo addressRepo;

    @Autowired
    private ModelMapper mapper;

    public AddressResponse findAddressByEmployeeId(int employeeId) {
        Optional<Address> addressByEmployeeId = addressRepo.findAddressByEmployeeId(employeeId);

        // Check if the address is present in the Optional
        if (addressByEmployeeId.isPresent()) {
            // Map the Address object to AddressResponse
            AddressResponse addressResponse = mapper.map(addressByEmployeeId.get(), AddressResponse.class);
            return addressResponse;
        } else {
            // Handle the case where the address is not found (return null, throw an exception, or return a default response)
            return null; // Modify this based on your specific use case
        }
    }
}
