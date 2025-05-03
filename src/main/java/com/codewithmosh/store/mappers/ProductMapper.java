package com.codewithmosh.store.mappers;


import com.codewithmosh.store.dtos.ProductDTO;
import com.codewithmosh.store.dtos.ProductSummaryDTO;
import com.codewithmosh.store.entities.Product;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface ProductMapper {
    @Mapping(source = "category.id", target = "categoryId")
    ProductDTO productToProductDTO(

            Product product);

//    Product productDTOToProduct(ProductDTO productDTO);
//
//    ProductSummaryDTO productToProductSummaryDTO(Product product);
//
//    Product productSummaryDTOToProduct(ProductSummaryDTO productSummaryDTO);
}
