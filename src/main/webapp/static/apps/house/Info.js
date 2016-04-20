define([
    'BasePage',
    'Util',
    'text!../../template/house/infoTpl.html'
],
function (BasePage,Util, infoTpl) {
    return BasePage.extend({
        init:function(options){
            var that = this;
            that.parent = options.parent
            BasePage.fn.init.call(that, options);
        },
        initPage:function(){
            var that = this;
            that._loadMainPage();
        },
        _loadMainPage:function(){
            var that = this;
            that.ajax({
            	url:'house/query',
            	success:function(data){
            		that.pageContent({
                        parent:that.parent,
                        data:data,
                        template:infoTpl
                    });
            	}
            })
            
        }
    });
});
