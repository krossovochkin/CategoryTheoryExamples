interface Applicative<A : Any> : Functor<A>{
    
    fun <C : Any> pure(c: C): Applicative<C>
	    
    fun <B: Any> apply(f: Applicative<(A) -> B>): Applicative<B>
		    
    override fun <B : Any> fmap(f: (A) -> B): Applicative<B> {
        return apply(pure(f))
    }
}
