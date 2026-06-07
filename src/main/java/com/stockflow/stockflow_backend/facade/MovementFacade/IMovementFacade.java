package com.stockflow.stockflow_backend.facade.MovementFacade;

import java.util.List;

import com.stockflow.stockflow_backend.dtos.MovementDTOs.MovementDTO;
import com.stockflow.stockflow_backend.dtos.MovementDTOs.MovementRequestDTO;

public interface IMovementFacade {
    List<MovementDTO> getAll();
    MovementDTO createMovement(MovementRequestDTO dto);
}
