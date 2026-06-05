package com.stockflow.stockflow_backend.controllers;

import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.stockflow.stockflow_backend.dtos.PurchaseDTOs.PurchaseDTO;
import com.stockflow.stockflow_backend.dtos.PurchaseDTOs.PurchaseRequestDTO;
import com.stockflow.stockflow_backend.facade.PurchaseFacade.IPurchaseFacade;
import com.stockflow.stockflow_backend.mappers.PurchaseMapper;
import com.stockflow.stockflow_backend.models.PurchaseModels.PurchaseRequestModel;
import com.stockflow.stockflow_backend.models.PurchaseModels.PurchaseResponseModel;

import jakarta.validation.Valid;

@RestController
@CrossOrigin("*")
@RequestMapping("/purchases")
public class PurchaseController {

    @Autowired
    private IPurchaseFacade purchaseFacade;

    @Autowired
    private PurchaseMapper purchaseMapper;

    @GetMapping
    public ResponseEntity<List<PurchaseResponseModel>> findAll() {
        return ResponseEntity.ok( purchaseMapper.toPurchaseResponseModelList(purchaseFacade.getAll()));
    }

    @PostMapping
    public ResponseEntity<PurchaseResponseModel> add(@RequestBody @Valid PurchaseRequestModel purchaseRequestModel) {

        PurchaseRequestDTO dto = purchaseMapper.toPurchaseRequestDTO(purchaseRequestModel);

        PurchaseDTO purchaseDto = purchaseFacade.addPurchase(dto);

        return ResponseEntity.ok( purchaseMapper.toPurchaseResponseModel(purchaseDto));
    }

    @GetMapping("/{resourceId}")
    public ResponseEntity<PurchaseResponseModel> findById( @PathVariable("resourceId") UUID resourceId) {
        PurchaseDTO purchaseDto = purchaseFacade.getByResourceId(resourceId);

        return ResponseEntity.ok(purchaseMapper.toPurchaseResponseModel(purchaseDto));
    }

    @PutMapping("/{resourceId}")
    public ResponseEntity<PurchaseResponseModel> update( @PathVariable("resourceId") UUID resourceId, @RequestBody @Valid PurchaseRequestModel purchaseRequestModel) {

        PurchaseRequestDTO dto = purchaseMapper.toPurchaseRequestDTO(purchaseRequestModel);

        PurchaseDTO purchaseDto = purchaseFacade.updatePurchase(resourceId, dto);

        return ResponseEntity.ok(purchaseMapper.toPurchaseResponseModel(purchaseDto));
    }

    @DeleteMapping("/{resourceId}")
    public void delete( @PathVariable("resourceId") UUID resourceId) {
        purchaseFacade.removePurchase(resourceId);
    }
}
