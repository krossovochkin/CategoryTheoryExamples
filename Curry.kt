fun <A : Any, B : Any, C : Any> ((Pair<A, B>) -> C).curry(): (A) -> ((B) -> C) {
    return { a: A -> { b: B -> this(Pair(a, b)) }}
}

fun <A : Any, B : Any, C : Any> ((A) -> ((B) -> C)).uncurry(): (Pair<A, B>) -> C {
    return { pair: Pair<A, B> -> this(pair.a)(pair.b) }
}
