define([
    'BasePage',
    'Util',
    'List',
    'text!../../template/seaFood/listTpl.html'
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
        },
        _loadMainPage:function(){
            var that = this;
            that.pageContent({
                parent:that.parent,
                template:listTpl
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
                        name:'编号',//在岗离岗
                        index:'no'
                    },
                    {
                        name:'数量',
                        index:'count'
                    },
                    {
                    	name:'单位',
                    	index:'unit'
                    },
                    {
                    	name:'分类',
                    	index:'category'
                    },
                    {
                    	name:'状态',
                    	fn:function(data){
                    		if(data.status === 'in'){
                    			return '在库'
                    		}else if(data.status === 'out'){
                    			return '离库'
                    		}
                    	}
                    },
                    {
                    	name:'入库时间',
                    	fn:function(data){
                    		if(data.intime){
                    			return Util.formatDate(new Date(data.intime),'YYYY-MM-DD hh:mm:ss')
                    		}else{
                    			return ''
                    		}
                    	}
                    },
                    {
                    	name:'出库时间',
                    	fn:function(data){
                    		if(data.outtime){
                    			return Util.formatDate(new Date(data.outtime),'YYYY-MM-DD hh:mm:ss')
                    		}else{
                    			return ''
                    		}
                    	}
                    },
                    {
                        name:'操作',
                        fn:function(data){
                        	if(data.status === 'in'){
//                        		return '<a class="outEvent button">出库</a><a class="delete button">删除</a>'
                        		return '<a class="outEvent button">出库</a>'
                        	}else {
                        		return ''
//                        		return '<a class="delete button">删除</a>'
                        	}
                        }
                    }
                ],
                url:'seaFood/queryPage',
                data:{
                    startNum:0,
                    pageCount:10
                },
                bindEvent:function(){
                	$('.outEvent',that.parent).click(function(e){
                        var item = that.list.getItemByEventTag(e);
                        delete item.intime;
                        delete item.outtime;
                        that.post({
                        	url:'seaFood/out',
                        	data:item,
                        	success:function(){
                        		that.list.currentPageRefresh();
                        	}
                        })
                        
                    });
                	$('.delete',that.parent).click(function(e){
                        var item = that.list.getItemByEventTag(e);
                        that.post({
                        	url:'seaFood/delete',
                        	data:item,
                        	success:function(){
                        		that.list.currentPageRefresh();
                        	}
                        })
                        
                    });
                }
            })
        }
    });
});
