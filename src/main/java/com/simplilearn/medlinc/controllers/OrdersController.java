package com.simplilearn.medlinc.controllers;

import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.simplilearn.medlinc.dto.ResponseDto;
import com.simplilearn.medlinc.entity.Orders;
import com.simplilearn.medlinc.exceptions.AlreadyExistsException;
import com.simplilearn.medlinc.exceptions.NotFoundException;
import com.simplilearn.medlinc.service.OrdersService;

@RestController
@RequestMapping("/orders")
public class OrdersController {
	
	@Autowired
	OrdersService ordersService;
	
	/**
	 * Get all Orders or Search Orders by title like operation.
	 * @param title
	 * @return
	 */
	@GetMapping
	public List<Orders> getAll(@RequestParam(value="status", required=false) String status){
		if(status!=null && status!="") {
			return  ordersService.findByOrderStatusContaining(status);
		}
			return ordersService.findByAll();
	}
	
	/**
	 * Get one order by id
	 * @param orderId
	 * @return
	 */
	@GetMapping("/{orderId}")
	public Optional<Orders> getOne(@PathVariable("orderId") int orderId){
		Optional<Orders> orderData = ordersService.findById(orderId);
		if(orderData.isPresent()) {
			return orderData;
		}
		throw new NotFoundException("Order does not exist with orderId '"+ orderId +"'");
	}
	
	/**
	 * Save order.
	 * @param order
	 * @return
	 */
	@PostMapping
	public Orders save(@RequestBody Orders orders) {
		boolean exists =  ordersService.existsByOrderStatus(orders.getOrderStatus());
		if(!exists) {
			return  ordersService.save(orders);
		}
		throw new AlreadyExistsException("Order already exist with status '"+ orders.getOrderStatus() +"'");		
	}
	
	/**
	 * Update order
	 * @param order
	 * @return
	 */
	@PutMapping
	public Orders update(@RequestBody Orders orders) {
		boolean exists = ordersService.existsById(orders.getOrderId());
		if(exists) {
			return ordersService.save(orders);
		}
		throw new NotFoundException("Order does not exist with orderId '"+ orders.getOrderId() +"'");
	}
	
	/**
	 * Delete one order by id
	 * @param orderId
	 * @return Optional<Products>
	 */
	@DeleteMapping("/{orderId}")
	public ResponseDto deleteOne(@PathVariable("orderId") int orderId) {
		boolean exists = ordersService.existsById(orderId);
		if(exists) {
			ordersService.deleteById(orderId);
			return new ResponseDto("Success","Product deleted", new Date(), null);
		}
		throw new NotFoundException("Order does not exist with orderId '"+ orderId +"'");		
	}

}
