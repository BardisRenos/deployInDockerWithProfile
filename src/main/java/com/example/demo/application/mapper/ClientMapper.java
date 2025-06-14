package com.example.demo.application.mapper;

import com.example.demo.application.dto.AddressDTO;
import com.example.demo.application.dto.ClientDTO;
import com.example.demo.application.dto.OrderDTO;
import com.example.demo.application.resource.Address;
import com.example.demo.application.resource.Client;
import com.example.demo.application.resource.ClientOrder;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper(componentModel = "spring")
public interface ClientMapper {

    ClientMapper INSTANCE = Mappers.getMapper(ClientMapper.class);

    ClientDTO toDto(Client client);

    AddressDTO toDto(Address address);

    @Mapping(source = "product", target = "product")
    OrderDTO toDto(ClientOrder order);

    List<ClientDTO> toDtoList(List<Client> clients);
}
