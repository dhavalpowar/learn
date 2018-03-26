
def print_matrix_in_circular(m):

    r, c = len(m), len(m[0])
    j, k = 0, 0


    while j < r and k < c:

        for i in range(j, c):
            print(m[k][i])

        k += 1

        for i in range(k, r):
            print(m[i][c - 1])

        c -= 1

        if j < r:
            for i in range(c - 1, j - 1, -1):
                print(m[r - 1][i])

            r -= 1

        if k < c:
            for i in range(r - 1, k - 1, -1):
                print(m[i][j])

            j += 1

def print_matrix_diagonal(m):
    r1, c1 = 0, 0
    r, c = len(m), len(m[0])
        
    print(m[r1][c1])
    r1 += 1
    
    while r1 < r:
        r2 = 0
        c2 = r1
        while r1 >= r2:
            print(m[r1][c1])
            r1 -= 1
            c1 += 1
        
        r1 = c1 + 1

def print_matrix_in_zigzag(m):

    r,c,j = len(m), len(m[0]), 0

    while j < r:

        if j % 2 == 0:
            for i in range(0, c):
                print(m[j][i])
        else:
            for i in range(c - 1, -1, -1):
                print(m[j][i])
        
        j += 1

print_matrix_diagonal([[1,3,6],[2,5,8],[4,7,9]])
