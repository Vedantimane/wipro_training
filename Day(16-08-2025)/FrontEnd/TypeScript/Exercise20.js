var Pair = /** @class */ (function () {
    function Pair(value1, value2) {
        this.value1 = value1;
        this.value2 = value2;
    }
    Pair.prototype.getData = function () {
        return [this.value1, this.value2];
    };
    return Pair;
}());
// Example usage:
var p1 = new Pair(1, "vedanti");
console.log(p1.getData());
var p2 = new Pair(true, "tuple");
console.log(p2.getData());
