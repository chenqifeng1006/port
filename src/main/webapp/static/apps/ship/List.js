define([
    'BasePage',
    'Util',
    'List',
    'text!../../template/ship/listTpl.html'
],
function (BasePage,Util,List,listTpl) {
    return BasePage.extend({
        init:function(options){
            var that = this;
            that.parent = options.parent;
            BasePage.fn.init.call(that, options);
        },
        initPage:function(){
            var that = this;
            that._loadMainPage();
            that._loadListPage();
            that._bindEvent();
        },
        _loadMainPage:function(){
            var that = this;
            that.pageContent({
                parent:that.parent,
                template:listTpl
            });
        },
        _bindEvent:function(){
        	var that = this;
        	$('#add',that.parent).click(function(e){
                var item = that.list.getItemByEventTag(e);
                require(['ship/Add'],function(Page){
                    new Page({
                        parent:that.parent
                    }).initPage()
                })
            });
        },
        _loadListPage:function(){
            var that = this;
            that.list = new List().init({
                parent:$('#demoList',that.parent),
                colModel:[
                    {
                        name:'名称',
                        index:'name',
                    },
                    {
                        name:'状态',//在岗离岗
                        index:'status'
                    },
                    {
                        name:'类型',//客船货船
                        index:'type'
                    },
                    {
                    	name:'荷载',
                    	index:'hezai'
                    },
                    {
                    	name:'单位',
                    	index:'unit'
                    },
                    {
                        name:'操作',
                        fn:function(data){
                        	if(data.states === '在港'){
                        		return '<a class="leave button">离岗</a><a class="edit button">编辑</a><a class="delete button">删除</a>'
                        	}else {
                        		return '<a class="in button">入岗</a><a class="edit button">编辑</a><a class="delete button">删除</a>'
                        	}
                        }
                    }
                ],
                url:'setting/test1.json',
                data:{
                    startNum:0,
                    pageCount:10
                },
                bindEvent:function(){
                	$('.leave',that.parent).click(function(e){
                        var item = that.list.getItemByEventTag(e),
                        	id = item.id;
                        
                    });
                	$('.in',that.parent).click(function(e){
                		var item = that.list.getItemByEventTag(e),
                    	id = item.id;
                    });
                    $('.edit',that.parent).click(function(e){
                        var item = that.list.getItemByEventTag(e);
                        require(['ship/Edit'],function(Page){
                            new Page({
                                parent:that.parent,
                                item:item
                            }).initPage()
                        })
                    });
                    $('.delete',that.parent).click(function(e){
                        var item = that.list.getItemByEventTag(e);
                        if(confirm('确认删除么？')){
                            that.post({
                                url:'ship/delete',
                                data:{
                                    id:item.id
                                },
                                success:function(){
                                    that.alert('删除成功');
                                    that.list.reload();
                                }
                            });
                        }
                    })
                }
            })
        }
    });
});
