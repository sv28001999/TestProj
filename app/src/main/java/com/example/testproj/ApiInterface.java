package com.example.testproj;

import com.example.testproj.models.BankTransferReqBody;
import com.example.testproj.models.BankTransferResBody;
import com.example.testproj.models.DashBoardRes;
import com.example.testproj.models.LoginRequestBody;
import com.example.testproj.models.LoginResponse;
import com.example.testproj.models.PaymentReq;
import com.example.testproj.models.PaymentRes;
import com.example.testproj.models.TransactionData;
import com.example.testproj.models.TransactionReqBody;
import com.example.testproj.models.UserDataRequestBody;
import com.example.testproj.models.UserDataResponseBody;
import com.example.testproj.models.VerifyOTPReq;
import com.example.testproj.models.VerifyOTPRes;
import com.example.testproj.models.WalletBalanceResponse;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.Header;
import retrofit2.http.Headers;
import retrofit2.http.POST;
import retrofit2.http.Query;

public interface ApiInterface {

    @POST("auth/login")
    Call<LoginResponse> login(@Body LoginRequestBody loginRequestBody);

    @POST("auth/validate-otp")
    Call<VerifyOTPRes> verifyOtp(@Body VerifyOTPReq verifyOTPReq);

    @POST("user/dashboard")
    Call<DashBoardRes> getDashboardData(@Header("Authorization") String authToken);

    @POST("crypnet/userdetails")
    Call<UserDataResponseBody> getUserDetails(@Body UserDataRequestBody userDataRequestBody);

    @POST("payout_api/upi_txn")
    Call<PaymentRes> startUpiTranscation(@Body PaymentReq paymentReq);

    @POST("payout_api/imps_txn")
    Call<BankTransferResBody> startBankTransfer(@Body BankTransferReqBody bankTransferReqBody);

    @POST("crypnet/Txn_sum")
    Call<TransactionData> getTransactionSummary(@Body TransactionReqBody transactionReqBody);

    @GET("payout_api/check-balance")
    Call<WalletBalanceResponse> getWalletBalance(@Query("_wallet") String walletBalance);
}
