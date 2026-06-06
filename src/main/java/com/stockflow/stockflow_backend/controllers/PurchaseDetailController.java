package com.stockflow.stockflow_backend.controllers;

import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.stockflow.stockflow_backend.dtos.PurchaseDetailDTOs.PurchaseDetailDTO;
import com.stockflow.stockflow_backend.dtos.PurchaseDetailDTOs.PurchaseDetailRequestDTO;
import com.stockflow.stockflow_backend.facade.PurchaseDetailFacade.IPurchaseDetailFacade;
import com.stockflow.stockflow_backend.mappers.PurchaseDetailMapper;
import com.stockflow.stockflow_backend.models.PurchaiseDetailModels.PurchaseDetailRequestModel;
import com.stockflow.stockflow_backend.models.PurchaiseDetailModels.PurchaseDetailResponseModel;

import jakarta.validation.Valid;

@RestController
@CrossOrigin("*")
@RequestMapping("/purchase-details")
public class PurchaseDetailController {

    @Autowired
    private IPurchaseDetailFacade purchaseDetailFacade;

    @Autowired
    private PurchaseDetailMapper purchaseDetailMapper;

    @GetMapping
    public ResponseEntity<List<PurchaseDetailResponseModel>> findAll() {
        return ResponseEntity.ok(
            purchaseDetailMapper.toPurchaseDetailResponseModelList(purchaseDetailFacade.getAll())
        );
    }

    @PostMapping
    public ResponseEntity<PurchaseDetailResponseModel> add(@RequestBody @Valid PurchaseDetailRequestModel model) {
        PurchaseDetailRequestDTO dto = purchaseDetailMapper.toPurchaseDetailRequestDTO(model);
        PurchaseDetailDTO purchaseDetailDto = purchaseDetailFacade.addPurchaseDetail(dto);
        return ResponseEntity.ok(purchaseDetailMapper.toPurchaseDetailResponseModel(purchaseDetailDto));
    }

    @GetMapping("/{resourceId}")
    public ResponseEntity<PurchaseDetailResponseModel> findById(@PathVariable("resourceId") UUID resourceId) {
        PurchaseDetailDTO purchaseDetailDto = purchaseDetailFacade.getByResourceId(resourceId);
        return ResponseEntity.ok(purchaseDetailMapper.toPurchaseDetailResponseModel(purchaseDetailDto));
    }

    @PutMapping("/{resourceId}")
    public ResponseEntity<PurchaseDetailResponseModel> update(@PathVariable("resourceId") UUID resourceId, @RequestBody @Valid PurchaseDetailRequestModel model) {
        PurchaseDetailRequestDTO dto = purchaseDetailMapper.toPurchaseDetailRequestDTO(model);
        PurchaseDetailDTO purchaseDetailDto = purchaseDetailFacade.updatePurchaseDetail(resourceId, dto);
        return ResponseEntity.ok(purchaseDetailMapper.toPurchaseDetailResponseModel(purchaseDetailDto));
    }

    @DeleteMapping("/{resourceId}")
    public void delete(@PathVariable("resourceId") UUID resourceId) {
        purchaseDetailFacade.removePurchaseDetail(resourceId);
    }
}