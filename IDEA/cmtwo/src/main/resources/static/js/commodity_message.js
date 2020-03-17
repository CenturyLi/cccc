// 主页商品的显示

var i = 0;
$(document).ready(
    function getinfor() {
    if (i === 4)
    {
        return;
    }
    var bt = ["xx","zl", "sm", "qt"];
    var d = {"Class":bt[i],"Many":"less"};
    var idbt = "#"+bt[i];
    $.get("/commodity/message",d, function (data) {
        for (var dataindex in data)
        {
            var datatrue = data[dataindex];
            var str = '<a href="html/look.html?'+datatrue.Cid+'" onclick="only"><div class="cm-main-goods">\n' +
                '                    <div class="cm-main-goods-picture">\n' + '<img class="cm-main-goods-picture-width" src="img/commodity_img/'+datatrue.Image+'">' +
                '\n' +
                '                    </div>\n' +
                '                    <div class="cm-main-goods-text">\n' +
                '                        <div class="cm-main-goods-text-price">￥'+datatrue.Price+'</div>\n' +
                '                        <div class="cm-main-goods-text-ex">'+datatrue.Cname+'</div>\n' +
                '                        <div class="cm-main-goods-text-data">'+'上架日期：'+ datatrue.Publicdata+'</div>\n'+
                '                    </div>\n' +
                '                </div></a>';
            $(idbt).append(str);
        }
        i++;
        getinfor();
    })
});

