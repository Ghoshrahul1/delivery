package com.shopping.delivery.Controller;


import com.shopping.delivery.DTO.ProductDetailsDto;
import com.shopping.delivery.ServiceImpl.ProductDetailsServiceImpl;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


@RestController
@RequiredArgsConstructor
@RequestMapping(value = "delivery/product")
public class ProductController {

    private ProductDetailsDto productDetailsDto;

    @Autowired
    private ProductDetailsServiceImpl productDetailsService;

    @PostMapping("/create")
    public ResponseEntity<String> createDeliveryOrder(@RequestBody ProductDetailsDto productDetailsDto) {
       productDetailsService.saveTheProduct(productDetailsDto);
       String msg = "Product is saved";
        return new ResponseEntity<>(msg, HttpStatus.CREATED);
    }

    @GetMapping("/{productId}")
    public ResponseEntity<ProductDetailsDto> getProductDetails(@PathVariable Long productId) {
        ProductDetailsDto productDetails = productDetailsService.getProductDetails(productId);
        return ResponseEntity.ok(productDetails);
    }

}
