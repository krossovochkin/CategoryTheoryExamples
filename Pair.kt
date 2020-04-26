data class Pair<A : Any, B : Any>(
    val a: A,
    val b: B
) : Bifunctor<A, B> {
	    
    override fun <C : Any> first(f: (A) -> C): Pair<C, B> {
        return Pair(f(a), b)
    }
			        
    override fun <D : Any> second(f: (B) -> D): Pair<A, D> {
        return Pair(a, f(b))
    }
						    
    override fun <C : Any, D : Any> bimap(f: (A) -> C, g: (B) -> D): Pair<C, D> {
        return Pair(f(a), g(b))
    }
}
