package com.ieeevit.componentbankredefined.NetworkAPIs;

import com.ieeevit.componentbankredefined.NetworkModels.AllComponentsModel;
import com.ieeevit.componentbankredefined.NetworkModels.BasicModel;
import com.ieeevit.componentbankredefined.NetworkModels.GetIssuersModel;
import com.ieeevit.componentbankredefined.NetworkModels.GetMemberComponentsModel;

import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.Header;
import retrofit2.http.POST;

/**
 * Created by luci4 on 5/2/18.
 */

public interface MemberAPI {

    @POST("delete")
    Call<BasicModel> delete(
            @Header("x-access-token") String token
    );

    @POST("requestComponent")
    @FormUrlEncoded
    Call<BasicModel> requestComponent(
            @Header("x-access-token") String token,
            @Field("id") String componentId,
            @Field("quantity") String quantity
    );

    @POST("getAllComponents")
    Call<AllComponentsModel> getAllComponents(
            @Header("x-access-token") String token
    );

    @POST("getIssuers")
    @FormUrlEncoded
    Call<GetIssuersModel> getIssuers(
            @Header("x-access-token") String token,
            @Field("id") String componentId
    );

    @POST("getIssuedComponents")
    Call<GetMemberComponentsModel> getIssuedComponents(
            @Header("x-access-token") String token
    );

    @POST("getHistory")
    Call<GetMemberComponentsModel> getHistory(
            @Header("x-access-token") String token
    );

    @POST("getRequestedComponents")
    Call<GetMemberComponentsModel> getRequestedComponents(
            @Header("x-access-token") String token
    );

}
