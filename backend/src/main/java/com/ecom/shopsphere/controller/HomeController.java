package com.ecom.shopsphere.controller;
import com.ecom.shopsphere.response.ApiResponse;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HomeController {
    @GetMapping("/")
    public ApiResponse homeControllerhandler() {
        ApiResponse apiResponse = new ApiResponse();
        apiResponse.setMessage("Welcome to Shop Sphere");
        return apiResponse;
    }
}
