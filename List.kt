class List<A : Any> private constructor(
    val head: Option<A>,
    val tail: Option<List<A>>
) : Functor<A> {
	    
    constructor() : this(Option<A>(), Option<List<A>>())
	    
    constructor(head: A, tail: Option<List<A>>) : this(Option<A>(head), tail)
			    
    override fun <B: Any> fmap(f: (A) -> B): List<B> {
        return if (head.isEmpty()) {
            List()
        } else {
            return List<B>(head.fmap(f), tail.fmap { list: List<A> -> list.fmap(f) })
        }
    }
}
