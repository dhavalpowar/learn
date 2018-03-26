import timeit
simple_list = [chr(i+65) for i in range(10)]
list_generator = (chr(i+65) for i in range(10))

def list_sum():
    return sum([x*x for x in range(100000000)])

def gen_sum():
    return sum(x*x for x in range(100000000))

timeit.timeit(list_sum)
timeit.timeit(gen_sum)