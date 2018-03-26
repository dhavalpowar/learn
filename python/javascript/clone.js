
/**
 * Write a function to deep clone an obect
 *
 */

 function deepClone(obj) {
    
    var copied;

    if (Array.isArray(obj)) {
        copied = [];
    } else if (typeof obj === 'object' && obj !== null) {
        copied = {};
    } else {
        return obj;
    }

    for (var p in obj) {
        copied[p] = deepClone(obj[p]);        
    }

    return copied;
 }

 x = [ {a : 13, aa: function() { return this.a; }}, 2, 3, 4, 5, 6, 7]
 y = deepClone(x);

 x[0].aa = 100;
 console.log(x);
 console.log(y[0].aa());