interface Contravariant<A : Any> {

    fun <B : Any> contramap(f: (B) -> A): Contravariant<B>

}

