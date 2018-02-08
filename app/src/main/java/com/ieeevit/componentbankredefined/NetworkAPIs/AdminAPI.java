package com.ieeevit.componentbankredefined.NetworkAPIs;

import com.ieeevit.componentbankredefined.NetworkModels.BasicModel;
import com.ieeevit.componentbankredefined.NetworkModels.GetMemberReqIssueModel;
import com.ieeevit.componentbankredefined.NetworkModels.UnauthorizedUsersModel;

import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.Header;
import retrofit2.http.POST;

/**
 * Created by luci4 on 5/2/18.
 */

public interface AdminAPI {


    @POST("registerComponent")
    @FormUrlEncoded
    Call<BasicModel> registerComponent(
            @Header("x-access-token") String token,
            @Field("name") String name,
            @Field("quantity") String quantity,
            @Field("value") String value
    );

    @POST("deleteComponent")
    @FormUrlEncoded
    Call<BasicModel> deleteComponent(
            @Header("x-access-token") String token,
            @Field("id") String id
    );

    @POST("deleteRequest")
    @FormUrlEncoded
    Call<BasicModel> deleteRequest(
            @Header("x-access-token") String token,
            @Field("id") String id
    );

    @POST("authorize")
    @FormUrlEncoded
    Call<BasicModel> authorize(
            @Header("x-access-token") String token,
            @Field("regno") String regno
    );

    @POST("unauthorizedUsers")
    Call<UnauthorizedUsersModel> getUnauthorizedUsers(
            @Header("x-access-token") String token
    );

    @POST("approve")
    @FormUrlEncoded
    Call<BasicModel> approve(
            @Header("x-access-token") String token,
            @Field("id") String transactionId
    );

    @POST("return")
    @FormUrlEncoded
    Call<BasicModel> returnComponent(
            @Header("x-access-token") String token,
            @Field("id") String transactionId
    );

    @POST("addComponents")
    @FormUrlEncoded
    Call<BasicModel> addComponents(
            @Header("x-access-token") String token,
            @Field("id") String componentId,
            @Field("quantity") String quantity
    );

    @POST("requests")
    Call<GetMemberReqIssueModel> getRequests(
            @Header("x-access-token") String token
    );

    @POST("issuers")
    Call<GetMemberReqIssueModel> getIssuers(
            @Header("x-access-token") String token
    );
}
