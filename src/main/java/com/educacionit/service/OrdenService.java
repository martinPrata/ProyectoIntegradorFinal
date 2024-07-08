package com.educacionit.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.educacionit.dto.OrdenDTO;
import com.educacionit.entity.Orden;
import com.educacionit.repository.OrdenRepository;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class OrdenService {

    @Autowired
    private OrdenRepository ordenRepository;

    public List<OrdenDTO> getAllOrders() {
        List<Orden> orders = ordenRepository.findAll();
        return orders.stream().map(this::convertToDto).collect(Collectors.toList());
    }

    public OrdenDTO getOrderById(Long id) {
        Orden order = ordenRepository.findById(id).orElseThrow(() -> new RuntimeException("Order not found"));
        return convertToDto(order);
    }

    public OrdenDTO createOrder(OrdenDTO ordenDTO) {
        Orden order = convertToEntity(ordenDTO);
        Orden savedOrder = ordenRepository.save(order);
        return convertToDto(savedOrder);
    }

    public OrdenDTO updateOrder(Long id, OrdenDTO ordenDTO) {
        Orden order = ordenRepository.findById(id).orElseThrow(() -> new RuntimeException("Order not found"));
        order.setField1(ordenDTO.getField1()); // Example field
        order.setField2(ordenDTO.getField2()); // Example field
        Orden updatedOrder = ordenRepository.save(order);
        return convertToDto(updatedOrder);
    }

    public void deleteOrder(Long id) {
        ordenRepository.deleteById(id);
    }

    private OrdenDTO convertToDto(Orden order) {
        OrdenDTO ordenDTO = new OrdenDTO();
        ordenDTO.setId(order.getId());
        ordenDTO.setField1(order.getField1());
        ordenDTO.setField2(order.getField2());
        return ordenDTO;
    }

    private Orden convertToEntity(OrdenDTO ordenDTO) {
        Orden order = new Orden();
        order.setField1(ordenDTO.getField1());
        order.setField2(ordenDTO.getField2());
        return order;
    }
}
