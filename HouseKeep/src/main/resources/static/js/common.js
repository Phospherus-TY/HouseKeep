function getcode(code){
    var ref = decodeURI(window.location.href);
    var urlcodes = ref.split("?")[1];
    if (urlcodes != undefined){
        var codes = urlcodes.split("&");
        for (var i=0;i<codes.length;i++){
            var rescode = codes[i].split("=")[0];
            if (rescode == code){
                return codes[i].split("=")[1];
            }
        }
    }else {
        return "";
    }
}