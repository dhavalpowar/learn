#!/usr/bin/env python

""" This is my first Python program """
NUMBER = 10
def my_func():
    """My first function """
    msg = '''Printing
    the
    List'''
    print msg
    num_list = range(10)
    for num in num_list:
        print num

def some_function():
    """My second function """
    try:
        # Division by zero raises an exception
        10 / 1
    except ZeroDivisionError:
        print "Oops, invalid."
    finally:
        # This is executed after the code block is run
        # and all exceptions have been handled, even
        # if a new exception is raised while handling.
        print "We're done with that."

def anotherfunc():
    # This raises an exception because the variable has not
    # been bound before printing. Python knows that it an
    # object will be bound to it later and creates a new, local
    # object instead of accessing the global one.
    # print(number)
    myvar = 233242324234324323234324234234234243.34234324234234234234234234234234234324
    print type(myvar)

anotherfunc()
