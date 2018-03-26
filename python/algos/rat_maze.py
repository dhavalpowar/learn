
def isPath(m, i, j, N):

    if i == N or j == N:
        return False

    if i == N - 1 and j == N - 1:
        return m[i][j] == 1

    if m[i][j] == 1:
        if i < N and j < N:
            return isPath(m, i + 1, j, N) or isPath(m, i, j + 1, N)

        if i == N:
            return isPath(m, i, j + 1, N)
        
        if j == N:
            return isPath(m, i + 1, j, N)
    else:
        return False

m = [
    [1, 1, 0, 0],
    [0, 1, 1, 0],
    [1, 0, 1, 1],
    [1, 1, 1, 1]
]

print(isPath(m, 0, 0, len(m)))