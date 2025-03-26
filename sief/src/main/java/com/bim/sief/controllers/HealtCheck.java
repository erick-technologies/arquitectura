package com.bim.sief.controllers;

import com.bim.sief.services.HealtCheckService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class HealtCheck {

    HealtCheckService healtCheckService;

    public HealtCheck(HealtCheckService healtCheckService ) {
        this.healtCheckService = healtCheckService;
    }

    @GetMapping("/test/{var}")
    @Operation(summary = "Regresa la salud del servicio", description = "Metodo para verificar que el servicio esta funcionando")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Successful retrieval of users"),
            @ApiResponse(responseCode = "500", description = "Internal server error")   })
    public String test(@PathVariable(value = "var", required = true) String id) {
        return healtCheckService.methodX(id);
    }

}
