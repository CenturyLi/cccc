$(document).ready(function () {
    $.ajax({
        type:"post",
        url:"/userinformation",
        data:{},
        dataType:'json',
        success:function (data) {
            var str = "";
            str +="<tr>"+
                "<td>"+"<input type=\"checkbox\"/>"+"</td>"+
                "<td align='center'>"+data.name+"</td>"+
                "<td align='center'>"+data.author+"</td>"+
                "<td align='center'>"+data.pubicationData+"</td>"+
                "<td>\n"+
                "<a href=\"#\">修改</a>\n"+
                "<a href=\"#\">删除</a>\n"+
                "</td>"+"</tr>"
            $("#nihao").html(str);
            $("#ni").val(data.name);

        }

    })
