// 商品详细信息

$(document).ready(function(){
        var id =  window.location.search.substr(1);
        $.get("/only/look",{"id": id},function (data) {
            if (data.Cid !== null)
            {
                var str = '<div style="width: 100%; height: 150px;"></div>\n' +
                    '            <div class="cm-middle-son">\n' +
                    '                <div class="cm-middle-all">\n' +
                    '                    <div class="cm-middle-left"><img class="" style="width: 430px; height: 430px;" src="../img/commodity_img/'+data.Image+'"></div>\n' +
                    '                </div>\n' +
                    '                <div class="cm-middle-all">\n' +
                    '                    <div class="cm-middle-right">\n' +
                    '                        <div class="cm-middle-right-name">'+ data.Cname+'</div>\n' +
                    '                        <div class="cm-middle-right-npic">\n' +
                    '                            <div class="cm-middle-right-npic-1">转&nbsp&nbsp卖&nbsp&nbsp价：</div>\n' +
                    '                            <div class="cm-middle-right-npic-2">￥</div>\n' +
                    '                            <div class="cm-middle-right-npic-3">'+ data.Price +'</div>\n' +
                    '                        </div>\n' +
                    '                        <div class="cm-middle-right-pic">\n' +
                    '                            <div class="cm-middle-right-npic-1">原&nbsp&nbsp&nbsp&nbsp&nbsp价：</div>\n' +
                    '                            <div class="cm-middle-right-pic-1">￥</div>\n' +
                    '                            <div class="cm-middle-right-pic-2">'+ data.Originalprice+'</div>\n' +
                    '                        </div>\n' +
                    '                        <div class="cm-middle-right-pic">\n' +
                    '                            <div class="cm-middle-right-npic-1">联系方式：</div>\n' +
                    '                            <div class="cm-middle-right-npic-1">'+ data.QQ+'</div>\n' +
                    '                        </div>\n' +
                    '                        <div class="cm-middle-right-intor">商品简介</div>\n' +
                    '                        <div>'+data.Intor+'</div>\n' +
                    '                    </div>\n' +
                    '                </div>\n' +
                    '            </div>';

                $("#detail_message").html(str);
            }
            else
            {
                $("#detail_message").html("在浏览商品时出现问题，请退回上一页面重试！");
            }
        })
    });