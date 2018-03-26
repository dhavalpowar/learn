
def is_hoppable(towers):
    memo = [-1 for i in range(len(towers))]
    return is_hoppable_rec(towers, 0), is_hoppable_mem(towers, 0, memo)


def is_hoppable_rec(towers, index):
    if towers[index] == 0:
        return False
    if index + towers[index] >= len(towers):
        return True

    max_jump = towers[index]
    result = False
    for i in range(1, max_jump + 1):
        result = result or is_hoppable_rec(towers, index + i)
    return result


def is_hoppable_mem(towers, index, memo):
    if towers[index] == 0:
        return False
    if index + towers[index] >= len(towers):
        return True
    if memo[index] != -1:
        return memo[index]

    max_jump = towers[index]
    result = False
    for i in range(1, max_jump + 1):
        memo[index + i] = is_hoppable_rec(towers, index + i)
        result = result or memo[index + i]
    return result

print(is_hoppable([4, 2, 0, 0, 1, 1]))