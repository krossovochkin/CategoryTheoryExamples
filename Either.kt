class Either<A : Any, B: Any> private constructor(
    val left: Option<A>,
    val right: Option<B>
): Bifunctor<A, B> {

    companion object {
	            
        fun <A : Any, B : Any> left(a: A): Either<A, B> = Either<A, B>(Option(a), Option<B>())
			            
        fun <A : Any, B : Any> right(b: B): Either<A, B> = Either<A, B>(Option<A>(), Option(b))
    }
						    
    override fun <C : Any> first(f: (A) -> C): Either<C, B> {
        return Either(left.fmap(f), right)
    }
								        
    override fun <D : Any> second(f: (B) -> D): Either<A, D> {
        return Either(left, right.fmap(f))
    }
											    
    override fun <C : Any, D : Any> bimap(f: (A) -> C, g: (B) -> D): Either<C, D> {
        return Either(left.fmap(f), right.fmap(g))
    }
												        
}

