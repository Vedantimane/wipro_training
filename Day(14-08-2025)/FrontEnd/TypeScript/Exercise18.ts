enum HttpStatusCodes {
    Ok = 200,
    NOTFOUND=404,
    ACCESSDENIED=403,
    INTERNALERRO=500
}

var code1= HttpStatusCodes.Ok;
console.log(code1);

var code2= HttpStatusCodes.NOTFOUND;
console.log(code2);

var code3= HttpStatusCodes.ACCESSDENIED;
console.log(code3);

var code4= HttpStatusCodes.INTERNALERRO;
console.log(code4);

