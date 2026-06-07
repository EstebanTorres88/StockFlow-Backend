package com.stockflow.stockflow_backend.services.MovementService;

import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.stockflow.stockflow_backend.dtos.MovementDTOs.MovementRequestDTO;
import com.stockflow.stockflow_backend.entities.Movement;
import com.stockflow.stockflow_backend.entities.Stock;
import com.stockflow.stockflow_backend.repositories.MovementRepository;
import com.stockflow.stockflow_backend.repositories.StockRepository;
import com.stockflow.stockflow_backend.services.StockService.IStockService;

import jakarta.transaction.Transactional;

@Service
public class MovementService implements IMovementService {

    @Autowired
    private MovementRepository movementRepository;

    @Autowired
    private IStockService stockService;

    @Autowired
    private StockRepository stockRepository;

    @Override
    public List<Movement> getAll() {
        return movementRepository.findAll();
    }

    @Override
    @Transactional
    public Movement createMovement(MovementRequestDTO dto) {
        Stock stock = stockService.findByResourceId(dto.getStockResourceId());

        int newQuantity = stock.getQuantity() + dto.getQuantity();
        if (newQuantity < 0) {
            throw new IllegalArgumentException("Movement cannot make stock quantity negative");
        }

        stock.setQuantity(newQuantity);
        stockRepository.save(stock);

        Movement movement = Movement.builder()
            .stock(stock)
            .quantity(dto.getQuantity())
            .note(dto.getNote())
            .createdAt(LocalDateTime.now())
            .resourceId(UUID.randomUUID())
            .build();

        return movementRepository.save(movement);
    }
}
