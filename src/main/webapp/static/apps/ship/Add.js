define([
    'BasePage',
    'Util',
    'text!../../template/ship/addTpl.html'
],
function (BasePage,Util,addTpl) {
    return BasePage.extend({
        init:function(options){
            var that = this;
            that.parent = options.parent;
            BasePage.fn.init.call(that, options);
        },
        initPage:function(){
            var that = this;
            that._loadMainPage();
        },
        _loadMainPage:function(){
            var that = this;
            that.pageContent({
                parent:that.parent,
                template:addTpl,
                callback:function(){
                    that._bindEvent();
                }
            });
        },
        _bindEvent:function(){
            var that = this;
            $('#submit').click(function(){
                var name = $('#name').val(),
                	type = $('#type').val(),
                	status = $('#status').val(),
                	hezai = $('#hezai').val(),
                    unit = $('#unit').val();
                if(!humidity || !unit){
                    that.alert('信息有误，请重新输入')
                }else{
                	that.item = {};
                    that.item.name = name;
                    that.item.type = type;
                    that.item.hezai = hezai;
                    that.item.unit = unit;
                    that.item.status = status;
                    that.post({
                        url:'ship/add',
                        data:that.item,
                        success:function(){
                            require(['ship/List'],function(Page){
                                new Page({parent:$('#rightContent')}).initPage();
                            })
                        }
                    })
                }
            })
        }
    });
});
