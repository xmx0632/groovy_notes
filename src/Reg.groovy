('xy' =~ /(.)(.)/).each { all, x, y  ->
    assert all == 'xy'
    assert x == 'x'
    assert y == 'y'

    println all
    println(x)
    println(y)
}


('xyz' =~ /(.)(.)(.)/).each { all, x, y,z  ->
    assert all == 'xyz'
    assert x == 'x'
    assert y == 'y'
    assert z == 'z'

    println all
    println(x)
    println(y)
    println(z)
}