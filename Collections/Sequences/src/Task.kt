// Find the most expensive product among all the delivered products
// ordered by the customer. Use `Order.isDelivered` flag.
fun findMostExpensiveProductBy(customer: Customer): Product? {
    return customer.orders
            .filter { it.isDelivered }
            .flatMap { it.products }
            .maxWithOrNull{ p1, p2 -> p1.price.compareTo(p2.price) }
}

// Count the amount of times a product was ordered.
// Note that a customer may order the same product several times.
fun Shop.getNumberOfTimesProductWasOrdered(product: Product): Int {
    return customers.flatMap { it.getOrderedProducts() }
            .count { it == product }
}

fun Customer.getOrderedProducts(): Sequence<Product> =
        orders.flatMap { it.products }.asSequence()
