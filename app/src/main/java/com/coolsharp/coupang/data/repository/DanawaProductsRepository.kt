package com.coolsharp.coupang.data.repository

import com.coolsharp.coupang.data.model.Products
import com.coolsharp.coupang.data.network.DanawaProductService
import com.coolsharp.coupang.data.network.ProductService
import com.coolsharp.coupang.data.network.RetrofitDanawaHelper
import com.coolsharp.coupang.data.network.RetrofitHelper
import retrofit2.Response

class DanawaProductsRepository {
    suspend fun fetchProducts(): Response<String> {
        val productList = RetrofitDanawaHelper.getInstance().create(
            DanawaProductService::class.java)
        return productList.getProducts(
//            "gzip, deflate, br, zstd",
            "",
            "ko-KR,ko;q=0.9,en-US;q=0.8,en;q=0.7",
            "736",
            "application/x-www-form-urlencoded",
            "userAccessIP=211.215.144.188; userAccessTime=2024-07-04%2003%3A17%3A39; _INSIGHT_CK_8204=5eb4620ff1b9e139689483bead6b7c51_36209|88b7ec1da339711ea1a483bead6b7c51_36209:1719938167000; cookNewSearchKeyword=%EB%8F%85%EA%B1%B0%EB%AF%B8%20%ED%82%A4%EB%B3%B4%EB%93%9C>07.10|%EB%AF%B8%EB%8B%88%20%EB%AA%A8%EA%B8%B0%EC%B1%84>07.10|%EB%AA%A8%EA%B8%B0%EB%A7%9D>07.09|a3%20%EC%95%A1%EC%9E%90>07.09|%EC%89%AC%ED%8F%B0%EC%9B%90%ED%94%BC%EC%8A%A4>07.03; cookRecentlyPlans=7073; PHPSESSID=6cc09244f4fe5756a4639f6a9c9c43cd; cookSaveProdInfo=15%3A12662429%3A6900; cwd=%7B%22b%22%3A%22N%22%2C%22m%22%3A%22N%22%7D; cookSaveShopInfo=TP40F%3A2024-07-11; REPURCHASE=TRUE; wcs_bt=s_3b3fb74948b1:1720637566; _INSIGHT_CK_8203=d6a8e404f3df3155a2ce91e10f03265a_03524|19cda205a9ed319e32cc8d9068b132de_37118:1720641081000",
            "https://prod.danawa.com/list/?cate=21350396",
            "cors",
            "XMLHttpRequest",
            "\"Not/A)Brand\";v=\"8\", \"Chromium\";v=\"126\", \"Google Chrome\";v=\"126\"",
            "?0",
            "",
            "",
            "3",
            "50396",
            "50396",
            "220348",
            "220549",
            "220741",
            "0",
            "IMAGE",
            "NEW",
            "90",
            "21",
            "3",
            "",
            "",
            "",
            "0",
            "N",
            "퍼즐",
            "a:3:{i:1;i:49797;i:2;i:50388;i:3;i:50396;}",
            "undefined",
            "N",
            "",
            "N",
            "A",
            "",
            "Y",
            "TP40F",
            "",
            "N",
            "N",
            "N",
            "N",
            "",
            "search"
        )
    }
}