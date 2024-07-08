package com.educacionit.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.educacionit.service.OrdenService;
import com.educacionit.dto.OrdenDTO;

import java.util.List;

@RestController
@RequestMapping("/orders")
public class OrdenResource {

    @Autowired
    private OrdenService ordenService;

    @GetMapping
    public List<OrdenDTO> getAllOrders() {
        return ordenService.getAllOrders();
    }

    @GetMapping("/{id}")
    public OrdenDTO getOrderById(@PathVariable Long id) {
        return ordenService.getOrderById(id);
    }

    @PostMapping
    public OrdenDTO createOrder(@RequestBody OrdenDTO ordenDTO) {
        return ordenService.createOrder(ordenDTO);
    }

    @PutMapping("/{id}")
    public OrdenDTO updateOrder(@PathVariable Long id, @RequestBody OrdenDTO ordenDTO) {
        return ordenService.updateOrder(id, ordenDTO);
    }

    @DeleteMapping("/{id}")
    public void deleteOrder(@PathVariable Long id) {
        ordenService.deleteOrder(id);
    }
}
