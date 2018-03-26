
/**
 * Implement a function that performs a debounce
 */


function debounce(fn, wait) {
    
    let timeout;

    return (...args) => {
        let context = this;
        clearTimeout(timeout);
        timeout = setTimeout(() => fn.apply(context, args), wait);
    };
}

function sayHello(a) {
    console.log('Hello - ' + this.name);
}

let amy = {
    name: 'amy',
    speak: debounce(sayHello, 1000)
};

amy.speak();