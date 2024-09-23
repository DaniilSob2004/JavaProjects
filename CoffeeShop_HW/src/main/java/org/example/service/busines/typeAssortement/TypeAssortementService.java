package org.example.service.busines.typeAssortement;

import org.example.model.TypeAssortement;

import java.util.List;

public interface TypeAssortementService {
    List<TypeAssortement> getAllTypeAssortement();
    TypeAssortement getTypeAssortementByName(String name);
}
