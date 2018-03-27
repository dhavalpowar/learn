
newArr = [];

function flattenArray(arr) {
    for(var i in arr) {
        if (!Array.isArray(arr[i])) {
            newArr.push(arr[i]);
        } else {
            flattenArray(arr[i]);
        }
    }
}

function flattenArrayIterativeFromBack(arr) {
    stack = [];

    for (var i = arr.length - 1; i >= 0; i--) {
        stack.push(arr[i]);
    }

    while (stack.length > 0) {
        var popped = stack.pop();

        if(Array.isArray(popped)) {
            for (var j = popped.length-1; j >= 0; j--) {
                stack.push(popped[j]);
            }
        } else {
            newArr.push(popped);
        }
    }
}

function flattenArrayIterativeFromFront(arr) {

    stack = [];

    for (var i in arr) {
        if (!Array.isArray(arr[i])) {
            q = [];
            while (stack.length > 0) {
                popped = stack.pop();
                if (Array.isArray(popped)) {
                    for (var j in popped) {
                        stack.push(popped[j]);
                    }
                } else {
                    q.unshift(popped);
                }
            }
            newArr = newArr.concat(q);
            newArr.push(arr[i]);
        } else {
            stack.push(arr[i]);
        }
    }
}

var x = [1, [2, [3]], [4], 11];

flattenArrayIterativeFromBack(x);
console.log(newArr);