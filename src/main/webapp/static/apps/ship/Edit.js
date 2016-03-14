define([
    'BasePage',
    'Util',
    'text!../../template/ship/editTpl.html'
],
function (BasePage,Util,editTpl) {
    return BasePage.extend({
        init:function(options){
            var that = this;
            that.parent = options.parent;
            that.item = options.item;
            that.id = options.item.id;
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
                data:that.item,
                template:editTpl,
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
                	hezai = $('#hezai').val(),
                    unit = $('#unit').val();
                if(!humidity || !unit){
                    that.alert('信息有误，请重新输入')
                }else{
                    that.item.name = name;
                    that.item.type = type;
                    that.item.hezai = hezai;
                    that.item.unit = unit;
                    that.post({
                        url:'ship/update',
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
