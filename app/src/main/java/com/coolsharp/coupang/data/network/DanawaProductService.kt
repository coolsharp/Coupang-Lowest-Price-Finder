package com.coolsharp.coupang.data.network

import retrofit2.Response
import retrofit2.http.Field
import retrofit2.http.FormUrlEncoded
import retrofit2.http.Header
import retrofit2.http.POST

interface DanawaProductService {
    @FormUrlEncoded
    @POST("/list/ajax/getSearchProductList.ajax.php")
    suspend fun getProducts(
        @Header("Accept-Encoding") acceptEncoding: String?,
        @Header("Accept-Language") acceptLanguage: String?,
        @Header("Content-Length") contentLength: String?,
        @Header("Content-Type") contentType: String?,
        @Header("Cookie") cookie: String?,
        @Header("Referer") referer: String?,
        @Header("Sec-Fetch-Mode") secFetchMode: String?,
        @Header("X-Requested-With") xRequestedWith: String?,
        @Header("sec-ch-ua") secChUa: String?,
        @Header("sec-ch-ua-mobile") secChUaMobile: String?,
        @Field("priceRangeMinPrice") priceRangeMinPrice: String,
        @Field("priceRangeMaxPrice") priceRangeMaxPrice: String,
        @Field("page") page: String,
        @Field("listCategoryCode") listCategoryCode: String,
        @Field("categoryCode") categoryCode: String,
        @Field("physicsCate1") physicsCate1: String,
        @Field("physicsCate2") physicsCate2: String,
        @Field("physicsCate3") physicsCate3: String,
        @Field("physicsCate4") physicsCate4: String,
        @Field("viewMethod") viewMethod: String,
        @Field("sortMethod") sortMethod: String,
        @Field("listCount") listCount: String,
        @Field("group") group: String,
        @Field("depth") depth: String,
        @Field("brandName") brandName: String,
        @Field("makerName") makerName: String,
        @Field("searchOptionName") searchOptionName: String,
        @Field("sDiscountProductRate") sDiscountProductRate: String,
        @Field("sInitialPriceDisplay") sInitialPriceDisplay: String,
        @Field("sPowerLinkKeyword") sPowerLinkKeyword: String,
        @Field("oCurrentCategoryCode") oCurrentCategoryCode: String,
        @Field("sMallMinPriceDisplayYN") sMallMinPriceDisplayYN: String,
        @Field("quickDeliveryCategoryYN") quickDeliveryCategoryYN: String,
        @Field("quickDeliveryDisplay") quickDeliveryDisplay: String,
        @Field("priceUnitSort") priceUnitSort: String,
        @Field("priceUnitSortOrder") priceUnitSortOrder: String,
        @Field("innerSearchKeyword") innerSearchKeyword: String,
        @Field("sCompanyCategoryYN") sCompanyCategoryYN: String,
        @Field("sCompanyCode") sCompanyCode: String,
        @Field("sCompanySearchKeyword") sCompanySearchKeyword: String,
        @Field("isDpgZoneUICategory") isDpgZoneUICategory: String,
        @Field("isAssemblyGalleryCategory") isAssemblyGalleryCategory: String,
        @Field("addDelivery") addDelivery: String,
        @Field("coupangMemberSort") coupangMemberSort: String,
        @Field("coupangMemberSortLayerType") coupangMemberSortLayerType: String,
        @Field("sProductListApi") sProductListApi: String
    ): Response<String>
}