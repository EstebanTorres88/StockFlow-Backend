package com.stockflow.stockflow_backend.controllers;

import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.stockflow.stockflow_backend.dtos.SaleDTOs.SaleDTO;
import com.stockflow.stockflow_backend.dtos.SaleDTOs.SaleRequestDTO;
import com.stockflow.stockflow_backend.facade.SaleFacade.ISaleFacade;
import com.stockflow.stockflow_backend.mappers.SaleMapper;
import com.stockflow.stockflow_backend.models.SaleModels.SaleRequestModel;
import com.stockflow.stockflow_backend.models.SaleModels.SaleResponseModel;

import jakarta.validation.Valid;

@RestController
@CrossOrigin("https://stock-flow-taupe.vercel.app")
@RequestMapping("/sales")
public class SaleController {
    @Autowired
    private ISaleFacade saleFacade;

    @Autowired
    private SaleMapper saleMapper;

    @GetMapping
    public ResponseEntity<Page<SaleResponseModel>> findAll(@RequestParam(defaultValue = "0") int page) {
        return ResponseEntity.ok(saleMapper.toSaleResponseModelPage(saleFacade.getAll(page)));
    }

    @PostMapping
    public ResponseEntity<SaleResponseModel> add(@RequestBody @Valid SaleRequestModel saleRequestModel) {

        SaleRequestDTO dto = saleMapper.toSaleRequestDTO(saleRequestModel);

        SaleDTO saleDto = saleFacade.addSale(dto);

        return ResponseEntity.ok(saleMapper.toSaleResponseModel(saleDto));
    }

    @GetMapping("/{resourceId}")
    public ResponseEntity<SaleResponseModel> findById(@PathVariable("resourceId") UUID resourceId) {
        SaleDTO saleDto = saleFacade.getByResourceId(resourceId);

        return ResponseEntity.ok(saleMapper.toSaleResponseModel(saleDto));
    }
}
