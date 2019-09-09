<%--
  Created by IntelliJ IDEA.
  User: wen972368
  Date: 2019/9/5
  Time: 17:02
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false" %>
<html>
<head>
    <title>Title</title>
    <script type="text/javascript" src="/js/jquery.min.js"></script>
    <script type="text/javascript" src="/js/jquery.easyui.min.js"></script>
    <script type="text/javascript" src="/js/ajaxFileUpload.js"></script>
    <link rel="stylesheet" type="text/css" href="/css/themes/default/easyui.css">
    <link rel="stylesheet" type="text/css" href="/css/themes/icon.css">
</head>
<body class="easyui-layout">
<div data-options="region:'west',title:'West',split:true,minWidth:180" style="width:100px;">
    <ul id="tt" class="easyui-tree">
        <li>
            <span>商品分类管理</span>
            <ul>

                <li data-options="attributes:{'url':'product_cat_list'}"><span>商品分类列表</span></li>
            </ul>
        </li>
        <li>
            <span>商品管理</span>
            <ul>

                <li data-options="attributes:{'url':'product_list'}"><span>商品列表</span></li>
                <li data-options="attributes:{'url':'product_add'}"><span>商品添加</span></li>
            </ul>
        </li>
    </ul>
</div>
<div data-options="region:'center',title:''" style="padding:5px;background:#eee;">
    <div id="tabs" class="easyui-tabs">
        <div title="首页" style="padding:20px;display:none;">
            tab1
        </div>
    </div>
</div>
<script>
    $('#tt').tree({
        onClick: function (node) {
            var tabs = $("#tabs");
            var tab = tabs.tabs("getTab", node.text);
            if (tab) {//选项卡没有被打开过
                tabs.tabs("selecte", node.text);
            } else {
                tabs.tabs('add', {
                    title: node.text,
                    content: 'Tab Body',
                    href:node.attributes.url,
                    closable: true
                });
            }
        }
    });
</script>
</body>
</html>
