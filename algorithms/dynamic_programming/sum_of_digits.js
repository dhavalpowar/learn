/*
Given integers sum and numberLength, find the number of non-negative integers less than 10numberLength such that the sum of digits for each of them is equal to sum.

Example

For sum = 5 and numberLength = 2, the output should be
digitSumInverse(sum, numberLength) = 6.

These integers are: 5, 14, 23, 32, 41, 50.
*/

function digitSumInverse(sum, numberLength) {
    var lookup = [];
    
    for (var i = 0; i <= sum; i++) {
        lookup[i] = [];
    }
    
    // Initialize cache
    for (var i = 0; i <= sum; i++) {
        for (var j = 0; j <= numberLength; j++) {
            lookup[i][j] = -1;
        }
    }
    
    
    // My recursive function that uses the cache
    function countDigitsRec (tempSum, n) {
        var count = 0;
        
        // If the sum of all digits sum up to the given sum
        if (n == 0) {
            return tempSum == 0 ? 1 : 0;
        }
        
        // If the sum and digit combination is stored in cache,
        // return that instead of recomputing it.
        if (lookup [tempSum][n] != -1) {
            return lookup[tempSum][n];
        }
        
        // For each digit from 0-9, recursively compute their 
        for (var i = 0; i <= 9; i++) {
            if (tempSum - i >= 0) {
                count += countDigitsRec(tempSum - i, n - 1);
            }
        }
        
        return lookup[tempSum][n] = count;
    }

    
    // Main function
    var finalCount = 0;
    
    if (sum == 0) {
        return 1;
    }

    return countDigitsRec(sum, numberLength);
}