package com.stockflow.stockflow_backend.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.stockflow.stockflow_backend.facade.HistoryFacade.IHistoryFacade;
import com.stockflow.stockflow_backend.mappers.HistoryMapper;
import com.stockflow.stockflow_backend.models.HistoryModels.HistoryResponseModel;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;


@RestController
@CrossOrigin(origins = {
    "http://localhost:5173",
    "http://localhost:8080",
    "https://stock-flow-taupe.vercel.app"
  })
@RequestMapping("/history")
public class HistoryController {
    @Autowired
    private IHistoryFacade historyFacade;

    @Autowired
    private HistoryMapper historyMapper;

    @GetMapping
    public ResponseEntity<Page<HistoryResponseModel>> findAll(@RequestParam(defaultValue = "0") int page) {
        return ResponseEntity.ok(historyMapper.toHistoryResponseModelPage(historyFacade.getAll(page)));
    }    
}
