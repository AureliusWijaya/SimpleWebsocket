package com.example.demo;

import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/user")
@AllArgsConstructor
public class Controller {

    private final UserService userService;

    @PostMapping("/register")
    public ResponseEntity<ApiResponse<UserResponse>> register(@Valid @RequestBody UserRequest userRequest) {
        ApiResponse apiResponse = new ApiResponse<>(
                "sukses",
                "berhasil membuat akun",
                userService.save(userRequest)
        );

        return ResponseEntity.status(HttpStatus.CREATED).body(apiResponse);
    }
    @GetMapping("/data")
    public ResponseEntity<ApiResponse<List<User>>> getAll() {
        ApiResponse<List<User>> apiResponse = new ApiResponse<>(
                "sukses",
                "berhasil membuat akun",
                userService.findAll()
        );
        return ResponseEntity.status(HttpStatus.OK).body(apiResponse);
    }
}

