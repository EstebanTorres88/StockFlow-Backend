package com.stockflow.stockflow_backend.services.MovementService;

import java.util.List;

import com.stockflow.stockflow_backend.dtos.MovementDTOs.MovementRequestDTO;
import com.stockflow.stockflow_backend.entities.Movement;

public interface IMovementService {
    List<Movement> getAll();
    Movement createMovement(MovementRequestDTO dto);
}
