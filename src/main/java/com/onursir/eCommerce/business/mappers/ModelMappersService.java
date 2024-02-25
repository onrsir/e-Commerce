package com.onursir.eCommerce.business.mappers;

import org.modelmapper.ModelMapper;

public interface ModelMappersService {
    ModelMapper forResponse();
    ModelMapper forRequest();
}
