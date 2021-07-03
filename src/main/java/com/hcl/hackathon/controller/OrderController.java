/**
 * Documenting Spring Boot REST API with SpringDoc + OpenAPI 3 (https://www.dariawan.com)
 * Copyright (C) 2019 Dariawan <hello@dariawan.com>
 *
 * Creative Commons Attribution-ShareAlike 4.0 International License
 *
 * Under this license, you are free to:
 * # Share - copy and redistribute the material in any medium or format
 * # Adapt - remix, transform, and build upon the material for any purpose,
 *   even commercially.
 *
 * The licensor cannot revoke these freedoms
 * as long as you follow the license terms.
 *
 * License terms:
 * # Attribution - You must give appropriate credit, provide a link to the
 *   license, and indicate if changes were made. You may do so in any
 *   reasonable manner, but not in any way that suggests the licensor
 *   endorses you or your use.
 * # ShareAlike - If you remix, transform, or build upon the material, you must
 *   distribute your contributions under the same license as the original.
 * # No additional restrictions - You may not apply legal terms or
 *   technological measures that legally restrict others from doing anything the
 *   license permits.
 *
 * Notices:
 * # You do not have to comply with the license for elements of the material in
 *   the public domain or where your use is permitted by an applicable exception
 *   or limitation.
 * # No warranties are given. The license may not give you all of
 *   the permissions necessary for your intended use. For example, other rights
 *   such as publicity, privacy, or moral rights may limit how you use
 *   the material.
 *
 * You may obtain a copy of the License at
 *   https://creativecommons.org/licenses/by-sa/4.0/
 *   https://creativecommons.org/licenses/by-sa/4.0/legalcode
 */
package com.hcl.hackathon.controller;


import com.hcl.hackathon.model.OrderDTO;
import com.hcl.hackathon.model.OrderInfoDTO;
import com.hcl.hackathon.service.OrderService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping("/api")
@Tag(name = "order", description = "The Order API")
public class OrderController {
    
    private final Logger logger = LoggerFactory.getLogger(this.getClass());
    
    private final int ROW_PER_PAGE = 5;
    
    @Autowired
    private OrderService contactService;


    @Operation(summary = "Find order by OrderNumber", description = "Returns a order List", tags = { "contact" })
    @ApiResponses(value = {
        @ApiResponse(responseCode = "200", description = "successful operation",
                content = @Content(schema = @Schema(implementation = OrderInfoDTO.class))),
        @ApiResponse(responseCode = "404", description = "Contact not found") })
    @GetMapping(value = "/orders/{userId}", produces = { "application/json", "application/xml" })
    public ResponseEntity<OrderInfoDTO> findOrdersByUserId(
            @Parameter(description="Id of the order to be obtained. Cannot be empty.", required=true)
            @PathVariable long contactId) {
        return ResponseEntity.ok().build();
    }
    
    @Operation(summary = "Add a new Order", description = "", tags = { "Order" })
    @ApiResponses(value = { 
        @ApiResponse(responseCode = "201", description = "Order created",
                content = @Content(schema = @Schema(implementation = OrderInfoDTO.class))),
        @ApiResponse(responseCode = "400", description = "Invalid input"), 
        @ApiResponse(responseCode = "409", description = "Order already exists") })
    @PostMapping(value = "/order", consumes = { "application/json", "application/xml" })
    public ResponseEntity<OrderDTO> createOrder(
            @Parameter(description="Order to add. Cannot null or empty.",
                    required=true, schema=@Schema(implementation = OrderInfoDTO.class))
            @Valid @RequestBody OrderInfoDTO OrderInfoDTO) {
        return ResponseEntity.ok().build();
    }
    
    @Operation(summary = "Update an existing Order status", description = "", tags = { "Order" })
    @ApiResponses(value = {
        @ApiResponse(responseCode = "200", description = "successful operation"),
        @ApiResponse(responseCode = "400", description = "Invalid ID supplied"),
        @ApiResponse(responseCode = "404", description = "Contact not found"),
        @ApiResponse(responseCode = "405", description = "Validation exception") })
    @PutMapping(value = "/Order/{orderNo}", consumes = { "application/json", "application/xml" })
    public ResponseEntity<Void> updateOrderStatus(
            @Parameter(description="Id of the Order status to be update. Cannot be empty.",
                    required=true)
            @PathVariable long contactId,
            @Parameter(description="Order to update. Cannot null or empty.",
                    required=true, schema=@Schema(implementation = OrderDTO.class))
            @Valid @RequestBody OrderDTO orderDTO) {

        return ResponseEntity.ok().build();
    }
    

}