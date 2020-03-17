$("button").click(function(){
    var spm = $("input:eq(0)").val();
    var xj = $("input:eq(1)").val();
    var yj = $("input:eq(2)").val();
    var lb = $("select option:selected").text();
    var jj = $("textarea").val();

    if (spm === "" || xj === "" || yj === "")
    {
        $("#Tips").empty();
        $("#Tips").css("font-size","15px");
        $("#Tips").html("商品信息不能为空");
        return;
    }

    if (jj === "")
    {
        jj = "商家很帅，什么都没有留下...";
    }

    var message = JSON.parse(sessionStorage.getItem("head_message"));

    if (message!==null)
    {
        var id = message.Uid;
    }
    else
    {
        $("#Tips").empty();
        $("#Tips").css("font-size","15px");
        $("#Tips").html("请先登录后再添加商品");
        return;
    }
    console.log(id);
    var data = {"Uid":id,"Cname":spm, "Price":xj, "Originalprice":yj, "Intor":jj, "Classification":lb}
    $.post("/setcom", data, function (result) {
        if (result.Cid !== "0")
        {
            var form = new FormData();
            var file = $("#file")[0].files[0];
            var Cid = result.Cid;
            form.append("file", file);
            form.append("Cid", Cid);
            form.append("SP", "c");
            $.ajax({
                url:"/upload",
                type:"post",
                data:form,
                processData:false,
                contentType:false,
                success:function(data){
                    if (data === true)
                    {
                        $("#Tips").empty();
                        $("#Tips").css("font-size","15px");
                        $("#Tips").html("商品添加成功");
                    }
                    else
                    {
                        $("#Tips").empty();
                        $("#Tips").css("font-size","15px");
                        $("#Tips").html("图片添加失败，请稍后刷新重试");
                    }
                }
            });
        }
        else
        {
            $("#Tips").empty();
            $("#Tips").css("font-size","15px");
            $("#Tips").html("商品添加失败，请稍后刷新重试");
        }
    })
});