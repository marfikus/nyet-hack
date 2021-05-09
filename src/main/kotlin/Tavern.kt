
fun main(args: Array<String>) {
    var beverage: String? = ""

    beverage = readLine()

    beverage?.let {
        if (it.isNotBlank()) {
            beverage = it.capitalize()
        } else {
            "Buttered Ale"
        }
    } ?: println("is null")

/*    if (beverage != null) {
        if (beverage.isNotBlank()) {
            beverage = beverage.capitalize()
        } else {
            println("is is empty")
        }
    }*/

    val beverageServed = beverage ?: "Buttered Ale"
    println(beverageServed)
}