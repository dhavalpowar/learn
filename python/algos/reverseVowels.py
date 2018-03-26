vowels = {
    'a': 'a',
    'e': 'e',
    'i': 'i',
    'o': 'o',
    'u': 'u',
    'xy': None
}

def reverseVowels(str):
    p1 = 0
    p2 = len(str) - 1
    
    strin = list(str)
    while (p1 < p2):
        if strin[p1] in vowels and strin[p2] in vowels:
            strin[p1], strin[p2] = strin[p2], strin[p1]
            p1 += 1
            p2 -= 1

        while strin[p1] not in vowels:
            p1 += 1
        
        while strin[p2] not in vowels:
            p2 -= 1
    
    return ''.join(strin)

print(reverseVowels('hello'))
