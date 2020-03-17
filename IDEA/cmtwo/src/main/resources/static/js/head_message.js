// 用来处理头部数据
$(document).ready(function () {
    //从sessionStorage里取出存入的信息
    var message = JSON.parse(sessionStorage.getItem("head_message"));
    // var colorstr = "#FFC0CB";
    const dynamicInputs = document.querySelectorAll('input.input-color-picker');

    const handleThemeUpdate = (cssVars) => {
        const root = document.querySelector(':root');
        const keys = Object.keys(cssVars);
        keys.forEach(key => {
            root.style.setProperty(key, cssVars[key]);
        });
    }

    dynamicInputs.forEach((item) => {
        item.addEventListener('input', (e) => {
            const cssPropName = `--primary-${e.target.getAttribute('data-id')}`;
            console.log(cssPropName);
            handleThemeUpdate({
                [cssPropName]: e.target.value
            });
            $("#global").css("background-color", e.target.value)
        });
    });

    if (message!==null)
    {
        var str = "<a href=\"#\">\n" +
            "                                    <img src=\"../img/user_img/"+ message.headimg+"\" class=\"img-circle\" id=\"imgh\" style=\"margin: 0 auto;\">\n" +
            "                                </a>\n" +"<div class=\"appear\" id=\"app\">\n" +
            "                                    <div class=\"appear-son-less\"></div>\n" +
            "                                    <div class=\"appear-son-name\">\n" +
            "                                        <div class=\"appear-son-name-p\">"+ message.username +"</div>\n" +
            "                                    </div>\n" +
            "                                    <div class=\"appear-son-my\">\n" +
            "                                        <div class=\"appear-son-my-left\">\n" +
            "                                            <a title=\"我的订单\" href=\"#\">我的订单</a>\n" +
            "                                        </div>\n" +
            "                                        <div class=\"appear-son-my-right\">\n" +
            "                                            <a title=\"我的商品\" href=\"#\">我的商品</a>\n" +
            "                                        </div>\n" +
            "                                    </div>\n" +
            "                                    <div class=\"appear-son-my\">\n" +
            "                                        <div class=\"appear-son-my-left\">\n" +
            "                                            <a title=\"个人中心\" href=\"#\">个人中心</a>\n" +
            "                                        </div>\n" +
            "                                        <div class=\"appear-son-my-right\">\n" +
            "                                            <a title=\"我的建议\" href=\"#\">我的建议</a>\n" +
            "                                        </div>\n" +
            "                                    </div>\n" +
            "                                    <div class=\"appear-son-buttom\">\n" +
            "                                        <a title=\"退出\" class=\"appear-son-buttom-right\" href=\"#\">退出</a>\n" +
            "                                    </div>\n" +
            "                                </div>";

        $("#hove").empty();
        $("#hove").html(str);
    }

    $("#hove").hover(function () {
            $("#app").css("display", "block");
        },function () {
            $("#app").css("display", "none");
    });

    $("#hove").hover(function () {
        $("#imgh").css("height", "76px");
        $("#imgh").css("width", "76px");
        $("#imgh").css("border", "1px solid rgba(255, 253, 48, 0.5)");
        $("#imgh").css("box-shadow", "rgba(111, 176, 186, 0.67) 0 0 5px 1px");
    },function () {
        $("#imgh").css("height", "42px");
        $("#imgh").css("width", "42px");
        $("#imgh").css("border", "1px solid rgba(81, 49, 148, 0.1)");
        $("#imgh").removeClass("box-shadow");
    });

});