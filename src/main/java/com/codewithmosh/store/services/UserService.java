package com.codewithmosh.store.services;

import com.codewithmosh.store.entities.*;
import com.codewithmosh.store.repositories.AddressRepository;
import com.codewithmosh.store.repositories.ProfileRepository;
import com.codewithmosh.store.repositories.UserRepository;
import com.codewithmosh.store.repositories.specifications.ProductSpec;
import jakarta.persistence.EntityManager;
import jakarta.transaction.Transactional;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.ExampleMatcher;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;


@AllArgsConstructor
@Service
public class UserService {




    private final UserRepository userRepository;
    private final ProfileRepository profileRepository;
    private final EntityManager entityManager;
    private final AddressRepository addressRepository;
    private final ProductRepository productRepository;
    private final CategoryRepository categoryRepository;

    @Transactional   // Uncomment this if you want to use transactions different result in the console
    public void showEntityStates() {
        var user = User.builder()
                .name("John Doe")
                .email("john.doe@example.com")
                .password("password")
                .build();

        if (entityManager.contains(user))
            System.out.println("Persistent");
        else
            System.out.println("Transient / Detached");

        userRepository.save(user);

        if (entityManager.contains(user))
            System.out.println("Persistent");
        else
            System.out.println("Transient / Detached");


    }

    @Transactional
    public void showRelatedEntities() {
        var profile = profileRepository.findById(2L).orElseThrow();
        System.out.println(profile.getUser().getEmail());
    }

    public void fetchAddress() {
        var address = addressRepository.findById(1L).orElseThrow();
    }

    public void persistRelated() {
        var user = User.builder()
                .name("John Doe")
                .email("john.doe@example.com")
                .password("password")
                .build();

        var address = Address.builder()
                .street("street")
                .city("city")
                .state("state")
                .zip("zip")
                .build();

        user.addAddress(address);

        userRepository.save(user);
    }

    @Transactional
    public void deleteRelated() {
        var user = userRepository.findById(3L).orElseThrow();
        var address = user.getAddresses().getFirst();
        user.removeAddress(address);
        userRepository.save(user);
    }

    @Transactional
    public void manageProducts() {
        productRepository.deleteById(4L);
    }

    @Transactional
    public void updateProductPrices() {
        productRepository.updatePriceByCategory(BigDecimal.valueOf(10), (byte)1);
    }

    @Transactional
    public void fetchProducts() {
        var product = new Product();
        product.setName("product");

        var matcher = ExampleMatcher.matching()
                .withIncludeNullValues()
                .withIgnorePaths("id", "description")
                .withStringMatcher(ExampleMatcher.StringMatcher.CONTAINING);

        var example = Example.of(product, matcher);

        var products = productRepository.findAll(example);
        products.forEach(System.out::println);
    }

    public void fetchProductsByCriteria() {
        var products = productRepository.findProductsByCriteria("prod", BigDecimal.valueOf(1), null);
        products.forEach(System.out::println);
    }

    public void fetchProductsBySpecifications(String name, BigDecimal minPrice, BigDecimal maxPrice) {
        Specification<Product> spec = Specification.where(null);

        if (name != null) {
            spec = spec.and(ProductSpec.hasName(name));
        }
        if (minPrice != null) {
            spec = spec.and(ProductSpec.hasPriceGreaterThanOrEqualTo(minPrice));
        }
        if (maxPrice != null) {
            spec = spec.and(ProductSpec.hasPriceLessThanOrEqualTo(maxPrice));
        }

        productRepository.findAll(spec).forEach(System.out::println);
    }

//    @Transactional
//    public void fetchUsers() {
//        var users = userRepository.findAllWithTags();
//        users.forEach(u -> {
//            System.out.println(u);
//            u.getAddresses().forEach(System.out::println);
//        });
//    }
//
//    public void fetchSortedProducts() {
//        var sort = Sort.by("name").and(
//            Sort.by("price").descending()
//        );

//        productRepository.findAll(sort).forEach(System.out::println);
//    }
//
//    public void fetchPaginatedProducts(int pageNumber, int size) {
//        PageRequest pageRequest = PageRequest.of(pageNumber, size);
//        Page<Product> page = productRepository.findAll(pageRequest);
//
//        var products = page.getContent();
//        products.forEach(System.out::println);
//
//        var totalPages = page.getTotalPages();
//        var totalElements = page.getTotalElements();
//        System.out.println("Total Pages: " + totalPages);
//        System.out.println("Total Elements: " + totalElements);
//    }
//
//    @Transactional
//    public void printLoyalProfiles() {
//        var users = userRepository.findLoyalUsers(2);
//        users.forEach(p -> System.out.println(p.getId() + ": " + p.getEmail()));
//    }
}
