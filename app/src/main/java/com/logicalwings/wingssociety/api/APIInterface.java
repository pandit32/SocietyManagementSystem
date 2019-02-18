package com.logicalwings.wingssociety.api;

import com.logicalwings.wingssociety.model.BaseModel;
import com.logicalwings.wingssociety.model.DashboardResponse;
import com.logicalwings.wingssociety.model.ForgetPassword;
import com.logicalwings.wingssociety.model.ForgetPasswordResponseData;
import com.logicalwings.wingssociety.model.LoginRequest;
import com.logicalwings.wingssociety.model.User;
import com.logicalwings.wingssociety.model.UserResponseData;
import com.logicalwings.wingssociety.utils.AppConstants;

import retrofit2.Response;
import retrofit2.http.Body;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Query;
import rx.Observable;

public interface APIInterface {

    @FormUrlEncoded
    @POST(AppConstants.AUTH_TOKEN)
    Observable<Response<User>> userLogin(@Field("grant_type") String grant, @Field("username") String username, @Field("password") String password, @Field("client_id") int clientId, @Field("logintype") int loginId, @Field("mobileDeviceId") String mobileDeviceId, @Field("deviceOSType") int deviceOsType, @Field("Imei") String imei, @Field("deviceNotificationToken") String deviceNotification);

    @POST(AppConstants.SEND_OTP)
    Observable<BaseModel> sendOtp(@Query("emailormobileno") String emailMobile);

    @POST(AppConstants.VERIFY_USER)
    Observable<ForgetPasswordResponseData> verifyUser(@Query("emailormobileno") String emailOrMobile, @Query("otp") String otp);

    @POST(AppConstants.RESET_PASSWORD)
    Observable<BaseModel> resetPassword(@Query("id") String userId, @Query("Password") String password);

    /*@POST(AppConstants.GET_DASHBOARD_DATA)
    Observable<DashboardResponse> getDashboardResponse(@Query("id") String userId);*/

}
