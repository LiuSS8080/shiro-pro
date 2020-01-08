<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2020/1/7
  Time: 16:07
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>后台首页面</title>
    <link rel="stylesheet" type="text/css" href="
<%=request.getContextPath()%>/statics/zTree_v3/css/bootstrapStyle/bootstrapStyle.css">
    <script type="text/javascript" src="
<%=request.getContextPath()%>/statics/zTree_v3/js/jquery-1.4.4.min.js"></script>
    <script type="text/javascript" src="
<%=request.getContextPath()%>/statics/zTree_v3/js/jquery.ztree.all.min.js"></script>
    <style type="text/css" >
        #leftsdd{
            width: 200px;
            height: 500px;
            float: left;
            border: 1px solid #ccc;
        }
        #right{
            width: 1000px;
            height: 500px;
            float: left;
            border: 1px solid #ccc;
        }
    </style>
</head>
</head>
<body>
<div style="width: 80%; height: 100px">
    <h1>蜗牛学院权限管理系统</h1>
</div>
<div>
    <div id="leftsdd">
        <ul id="regionZTree" class="ztree"></ul>
    </div>
    <div id="right">
        <h3 id="title" style="margin-left: 20px"></h3>
        </iframe><iframe id="content" width="100%" height="450px" style="border: none"></iframe>
    </div>
</div>
</body>
</html>
<script>
    $(function(){
        var setting = {
            view: {
                showLine: true,//是否显示节点之间的连线
                fontCss:{'color':'black','font-weight':'bold'},//字体样式函数
            },
            data: {
                simpleData: {//简单数据模式
                    enable:true,
                    idKey: "id",
                    pIdKey: "pid",
                    rootPId: null
                }
            },
            callback: {
                onClick:zTreeBeforeExpand
            }
        };
        $.ajax({
            url:"indexMenu.html",
            type:"get",
            dataType:"json",
            success:function(data){
                zNodes=data;
                zTreeObj = $.fn.zTree.init($("#regionZTree"), setting, data);//初始化操作
                zTreeObj.expandAll(true);
            }
        });
    });
    function zTreeBeforeExpand(param1,param2,param3){
        $("#title").text(param3.name);
        $("#content").attr("src",param3.url);
        event.preventDefault();
    }
</script>
</body>
</html>
