var HttpStatusCodes;
(function (HttpStatusCodes) {
    HttpStatusCodes[HttpStatusCodes["Ok"] = 200] = "Ok";
    HttpStatusCodes[HttpStatusCodes["NOTFOUND"] = 404] = "NOTFOUND";
    HttpStatusCodes[HttpStatusCodes["ACCESSDENIED"] = 403] = "ACCESSDENIED";
    HttpStatusCodes[HttpStatusCodes["INTERNALERRO"] = 500] = "INTERNALERRO";
})(HttpStatusCodes || (HttpStatusCodes = {}));
var code1 = HttpStatusCodes.Ok;
console.log(code1);
var code2 = HttpStatusCodes.NOTFOUND;
console.log(code2);
var code3 = HttpStatusCodes.ACCESSDENIED;
console.log(code3);
var code4 = HttpStatusCodes.INTERNALERRO;
console.log(code4);
