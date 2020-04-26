interface Monad<A : Any> : Applicative<A> {
    
    override fun <C : Any> pure(c: C): Monad<C>
	    
    fun <B : Any> flatMap(f: (A) -> Monad<B>): Monad<B>
		    
    fun flatten(m: Monad<Monad<A>>): Monad<A> {
        return m.flatMap<A> { f -> f }
    }
			        
    override fun <B : Any> fmap(f: (A) -> B): Monad<B> {
        return flatMap { a -> pure<B>(f(a)) }
    }
							    
    override fun <B : Any> apply(f: Applicative<(A) -> B>): Monad<B> {
        return flatMap { a -> (f as Monad<(A) -> B>).fmap { ff -> ff(a) } }
    }
}
