import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

fun main(args: Array<String>) {
    fun buildRetrofit() = Retrofit.Builder()
        .baseUrl("https://api.adviceslip.com/")
        .addConverterFactory(GsonConverterFactory.create())
        .build()

    fun adviceClient(): AdviceClient = buildRetrofit().create(AdviceClient::class.java)

    val advice = adviceClient().getRandomAdvice().execute().body()

    println("First Advice Random")
    println(advice.toString())

    val sameAdvice = advice?.slip?.let { adviceClient().getAdvice(it.id).execute().body() }

    println()
    println("The same Advice Random")
    println(sameAdvice.toString())

    val adviceAboutHealth = adviceClient().findAdvice("spiders").execute().body()

    println()
    println("Advice about health")
    println(adviceAboutHealth.toString())
}