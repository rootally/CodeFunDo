package com.bennyhawk.camera1api;

import okhttp3.MultipartBody;
import okhttp3.RequestBody;
import retrofit2.Call;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;
import retrofit2.converter.scalars.ScalarsConverterFactory;
import retrofit2.http.Multipart;
import retrofit2.http.POST;
import retrofit2.http.Part;

/**
 * Created by bennyhawk on 1/18/18.
 */

public class APICLient {
	private static Retrofit retrofit = null;
	private static Retrofit retrofitEgg = null;
	
	private static final String URL2 = "https://gameofthreads2.herokuapp.com/";
	private static final String URL = "https://gameofthreads.herokuapp.com/";
	
	
	
	public static APIInterface getEggAPIInterface(){
		
		if (retrofitEgg == null){
			retrofitEgg = new Retrofit.Builder().baseUrl(URL)
					.addConverterFactory(GsonConverterFactory.create())
					.addConverterFactory(ScalarsConverterFactory.create())
					.build();
			
		}
		
		return retrofitEgg.create(APIInterface.class);
	}
	public static APIInterface getEggAPI2Interface(){
		
		if (retrofitEgg == null){
			retrofitEgg = new Retrofit.Builder().baseUrl(URL2)
					.addConverterFactory(GsonConverterFactory.create())
					.addConverterFactory(ScalarsConverterFactory.create())
					.build();
			
		}
		
		return retrofitEgg.create(APIInterface.class);
	}
	
	public interface APIInterface{
		@Multipart
		@POST("upload")
		Call<Model> postImage(@Part MultipartBody.Part image, @Part("name") RequestBody name);
		
		@Multipart
		@POST("upload1")
		Call<Model> postImageDepth(@Part MultipartBody.Part image, @Part("name") RequestBody name);
		
		
		
	}
	
	
}
