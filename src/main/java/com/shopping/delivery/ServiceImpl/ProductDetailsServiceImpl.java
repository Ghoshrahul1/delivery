package com.shopping.delivery.ServiceImpl;

import com.shopping.delivery.DTO.ProductDetailsDto;
import com.shopping.delivery.Entity.ProductDetailsEntity;
import com.shopping.delivery.Repository.ProductDetails;
import com.shopping.delivery.Service.ProductDetailsService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class ProductDetailsServiceImpl implements ProductDetailsService {


    @Autowired
    private ProductDetails productDetailsRepo;

    @Override
    public void saveTheProduct(ProductDetailsDto productDetailsDto) {

        ProductDetailsEntity productDetailsEntity = mapDtoToEntity(productDetailsDto);

        productDetailsRepo.save(productDetailsEntity);

    }

    @Override
    public ProductDetailsDto getProductDetails(Long productId) {
        Optional<ProductDetailsEntity> productDetails = productDetailsRepo.findById(productId);

        if (productDetails.isEmpty()){
            throw new  IllegalArgumentException("No Products are available : "+ productId );
        }
        ProductDetailsEntity productDetailsEntity = productDetails.get();
        return mapEntitytoDto(productDetailsEntity);
    }

    private ProductDetailsEntity mapDtoToEntity(ProductDetailsDto productDetailsDto){
        ProductDetailsEntity productDetailsEntity = new ProductDetailsEntity();
        productDetailsEntity.setDescription(productDetailsDto.getDescription());
        productDetailsEntity.setProduct(productDetailsDto.getProduct());
        productDetailsEntity.setPrice(productDetailsDto.getPrice());
        productDetailsEntity.setQuantity(productDetailsEntity.getQuantity());
        return productDetailsEntity;
    }

    private ProductDetailsDto mapEntitytoDto(ProductDetailsEntity productDetailsEntity) {
        ProductDetailsDto productDetailsDto = new ProductDetailsDto();
        productDetailsDto.setId(productDetailsEntity.getId());
        productDetailsDto.setProduct(productDetailsEntity.getProduct());
        productDetailsDto.setDescription(productDetailsEntity.getDescription());
        productDetailsDto.setPrice(productDetailsEntity.getPrice());
        productDetailsDto.setQuantity(productDetailsEntity.getQuantity());
        return productDetailsDto;
    }
}
