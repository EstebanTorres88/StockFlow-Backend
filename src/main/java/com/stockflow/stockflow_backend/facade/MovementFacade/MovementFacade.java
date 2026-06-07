package com.stockflow.stockflow_backend.facade.MovementFacade;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.stockflow.stockflow_backend.dtos.MovementDTOs.MovementDTO;
import com.stockflow.stockflow_backend.dtos.MovementDTOs.MovementRequestDTO;
import com.stockflow.stockflow_backend.entities.Movement;
import com.stockflow.stockflow_backend.mappers.MovementMapper;
import com.stockflow.stockflow_backend.services.MovementService.IMovementService;

import jakarta.transaction.Transactional;

@Component
public class MovementFacade implements IMovementFacade {

    @Autowired
    private IMovementService movementService;

    @Autowired
    private MovementMapper movementMapper;

    @Override
    public List<MovementDTO> getAll() {
        return movementMapper.toMovementDTOList(movementService.getAll());
    }

    @Override
    @Transactional
    public MovementDTO createMovement(MovementRequestDTO dto) {
        Movement movement = movementService.createMovement(dto);
        return movementMapper.toMovementDTO(movement);
    }
}
