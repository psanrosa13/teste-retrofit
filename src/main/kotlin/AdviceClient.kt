import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Path

interface AdviceClient {

    @GET("advice")
    fun getRandomAdvice(): Call<Advice>

    @GET("advice/{slip_id}")
    fun getAdvice(@Path("slip_id") id:Int) : Call<Advice>

    @GET("advice/search/{query}")
    fun findAdvice(@Path("query") query:String): Call<Any>

}