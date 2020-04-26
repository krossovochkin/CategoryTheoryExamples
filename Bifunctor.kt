interface Bifunctor<A : Any, B: Any> {
    
    fun <C : Any> first(f: (A) -> C): Bifunctor<C, B>
	    
    fun <D : Any> second(f: (B) -> D): Bifunctor<A, D>
		    
    fun <C : Any, D : Any> bimap(f: (A) -> C, g: (B) -> D): Bifunctor<C, D>

}
			
