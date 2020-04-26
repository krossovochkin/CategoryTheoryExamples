data class Just<A : Any>(val a: A): Functor<A> {

    override fun <B : Any> fmap(f: (A) -> B): Just<B> {
        return Just(f(a))
    }
}
