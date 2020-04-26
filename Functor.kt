interface Functor<A : Any> {

    fun <B : Any> fmap(f: (A) -> B): Functor<B>
}
