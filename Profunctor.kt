interface Profunctor<A : Any, B : Any> {
    
    fun <C : Any> lmap(f: (C) -> A): Profunctor<C, B>
	    
    fun <D : Any> rmap(f: (B) -> D): Profunctor<A, D>
		    
    fun <C : Any, D : Any> dimap(f: (C) -> A, g: (B) -> D): Profunctor<C, D>
}

