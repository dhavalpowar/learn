
dictionary = { "is": "is", "the": "the", "sky": "sky", "blue": "blue", "i": "i" }
count = 0

# Recursive solution
def is_tokenized_rec(l, r, d):

    print(l, '\t', r)
    # global count
    # count += 1
    if not r:
        return l in d

    l_valid = False
    if l in d:
        l_valid = True

    if l_valid:
        return (l_valid and is_tokenized_rec("", r, d)) or is_tokenized_rec(l + r[0], r[1:], d)
        dp[r] = 
    else:
        return is_tokenized_rec(l + r[0], r[1:], d)

s = "blueisthesky"
print(is_tokenized_rec("", s, dictionary))
print(count)

