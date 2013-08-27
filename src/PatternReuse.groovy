twister = 'she sells sea shells at the sea shore of seychelles'
// some more complicated regex: 
// word that starts and ends with same letter
regex = /\b(\w)\w*\1\b/
start = System.currentTimeMillis()
100000.times{
    twister =~ regex
}
first = System.currentTimeMillis() - start
println "first:${first}"

start = System.currentTimeMillis()
pattern = ~regex
100000.times{
    pattern.matcher(twister)
}
second = System.currentTimeMillis() - start
println "second:${second}"




//3.5.5 Patterns for classification
assert (~/..../).isCase('bear')
switch('bear'){
    case ~/..../ : assert true; break
    default      : assert false
}
beasts = ['bear','wolf','tiger','regex']
assert beasts.grep(~/..../) == ['bear','wolf']

