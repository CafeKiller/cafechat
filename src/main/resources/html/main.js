var main = {};

main.append = function (html) {
    var ele = document.createElement("div");
    ele.innerHTML = html;
    document.getElementById("content").appendChild(ele);
    window.scrollTo(0, document.body.scrollHeight);
};

main.clear = function () {
    document.getElementById("content").innerHTML = "";
};
