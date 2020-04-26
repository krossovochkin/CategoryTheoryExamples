data class Const<C : Any, A : Any>(val c: C): Functor<A> {

    override fun <B : Any> fmap(f: (A) -> B): Const<C, B> {
        return Const<C, B>(c)
    }
}
