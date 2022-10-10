package com.bootcamp3.MoonlightHotelAndSpa.converter;

import com.bootcamp3.MoonlightHotelAndSpa.dto.transfer.CarCategoryRequest;
import com.bootcamp3.MoonlightHotelAndSpa.dto.transfer.CarCategoryResponse;
import com.bootcamp3.MoonlightHotelAndSpa.model.car.CarCategory;

public class CarCategoryConverter {

    public static CarCategory convertToCarCategory(CarCategoryRequest request) {

        CarCategory carCategory = new CarCategory();

        return createCarCategoryFromRequest(carCategory, request);
    }

    public static CarCategoryResponse convertToCarCategoryResponse(CarCategory carCategory) {

        CarCategoryResponse response = new CarCategoryResponse();
        response.setId(carCategory.getId());
        response.setTitle(carCategory.getTitle());
        response.setSeats(carCategory.getSeats());
        response.setPrice(carCategory.getPrice());

        return response;
    }

    public static CarCategory update(CarCategory carCategory, CarCategoryRequest carCategoryRequest) {

        return createCarCategoryFromRequest(carCategory, carCategoryRequest);
    }

    private static CarCategory createCarCategoryFromRequest(CarCategory carCategory, CarCategoryRequest carCategoryRequest) {

        carCategory.setTitle(carCategoryRequest.getTitle());
        carCategory.setSeats(carCategoryRequest.getSeats());
        carCategory.setPrice(carCategoryRequest.getPrice());

        return carCategory;
    }
}
