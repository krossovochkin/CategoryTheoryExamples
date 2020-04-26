class Option<A : Any> : Monad<A> {

    private val data: Any

    constructor(a: A) {
        data = Just(a)
    }

    constructor() {
        data = Unit
    }

    fun isEmpty(): Boolean = data is Unit

    override fun <C : Any> pure(c: C): Option<C> {
        return Option(c)
    }

    @Suppress("UNCHECKED_CAST")
    override fun <B : Any> flatMap(f: (A) -> Monad<B>): Option<B> {
        return if (data is Just<*>) {
            return f((data.a as A)) as Option<B>
        } else {
            Option<B>()
        }
    }

    @Suppress("UNCHECKED_CAST")
    override fun <B : Any> fmap(f: (A) -> B): Option<B> {
        return if (data is Just<*>) {
	    Option<B>(f(data.a as A))
	} else {
	    Option<B>()
	}
    }
}
