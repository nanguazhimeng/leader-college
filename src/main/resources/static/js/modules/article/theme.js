var setting = {
    data: {
        simpleData: {
            enable: true,
            idKey: "themeId",
            pIdKey: "parentId",
            rootPId: -1
        },
        key: {
            url:"nourl"
        }
    }
};
var ztree;
var Theme = {
	    id: "themeTable",
	    table: null,
	    layerIndex: -1
	};
/**
 * 初始化表格的列
 */
Theme.initColumn = function () {
    var columns = [
            {field: 'selectItem', radio: true},
            {title: 'themeId', field: 'themeId',visible: false, align: 'center', valign: 'middle', width: '80px'},
	        {title: '名称', field: 'name', align: 'center', valign: 'middle', sortable: true, width: '180px'},
            {title: '上级板块', field: 'parentName', align: 'center', valign: 'middle', sortable: true, width: '100px'},
	        {title: '图标', field: 'icon', align: 'center', valign: 'middle', sortable: true, width: '50px', formatter: function(item, index){
	        	return item.icon == null ? '' : '<img height="50" width="50"  src="'+item.icon+'">';
			}},
	        {title: '背景颜色', field: 'color', align: 'center', valign: 'middle', sortable: true, width: '100px'},
	        {title: '创建时间', field: 'createTime', align: 'center', valign: 'middle', sortable: true, width: '100px'},
	        {title: '排序', field: 'playOrder', align: 'center', valign: 'middle', sortable: true, width: '50px'}
           ]
    return columns;
};
function getThemeId () {
    var selected = $('#themeTable').bootstrapTreeTable('getSelections');
    if (selected.length == 0) {
        alert("请选择一条记录");
        return false;
    } else {
        return selected[0].id;
    }
}
$(function () {
    var colunms = Theme.initColumn();
    var table = new TreeTable(Theme.id, baseURL + "article/theme/list", colunms);
    console.log(table);
    table.setExpandColumn(2);
    table.setIdField("themeId");
    table.setCodeField("themeId");
    table.setParentCodeField("parentId");
    table.setExpandAll(false);
    table.init();
    Theme.table = table;
	
    vm.initUpload();
});

var vm = new Vue({
	el:'#rrapp',
	data:{
		showList: true,
		title: null,
		theme: {
			 parentName:null,
		     parentId:0,
			 type:0,
			 playOrder:0
		}
	},
	methods: {
		query: function () {
			vm.reload();
		},
		add: function(){
			vm.getParentTheme();
			var selected = $('#themeTable').bootstrapTreeTable('getSelections');
			if (selected.length != 0 && selected[0].type != 0) {
		    	var themeId = selected[0].id;
		    	var type = 1;
		    } else{
		    	var type = 0;
		    }
			vm.showList = false;
			vm.title = "新增";
			vm.theme = { parentName:null, parentId:themeId, type:type,playOrder:0};
			
			$("#upload").show();
			$(".multi-img-details").html("");
		},
		update: function (event) {
			vm.getParentTheme();
			var themeId = getThemeId();
			if(themeId == null){
				return ;
			}
			vm.showList = false;
            vm.title = "修改";
            
            vm.getInfo(themeId)
		},
		saveOrUpdate: function (event) {
			var url = vm.theme.themeId == null ? "article/theme/save" : "article/theme/update";
			$.ajax({
				type: "POST",
			    url: baseURL+url,
			    contentType: "application/json",
			    data: JSON.stringify(vm.theme),
			    success: function(r){
			    	if(r.code === 0){
						alert('操作成功', function(index){
							vm.reload();
						});
					}else{
						alert(r.msg);
					}
				}
			});
		},
		del: function (event) {
			var themeId = getThemeId();
			if(themeId == null){
				return ;
			}
			alert(themeId);
			confirm('确定要删除选中的记录？', function(){
				$.ajax({
					type: "POST",
				    url:  baseURL +"article/theme/delete",
				    data: "themeId=" + themeId,
				    success: function(r){
						if(r.code == 0){
							alert('操作成功', function(index){
								vm.reload();
							});
						}else{
							alert(r.msg);
						}
					}
				});
			});
		},
		getInfo: function(themeId){
			$.get(baseURL +"article/theme/info/"+themeId, function(r){
                vm.theme = r.theme;
                var icon = vm.theme.icon;
                if(icon!=null){
                	$("#upload").hide();
            		$(".multi-img-details").html('<div class="multi-item"><img src="'+icon+'" class="img-responsive img-thumbnail"><input type="hidden" class="form-control"  value="'+icon+'"><em class="close" title="删除这张图片" onclick="deleteMultiImage(this)">×</em></div>');
                }
            });
		},
        initUpload: function(){
          new AjaxUpload('#upload', {
              action: baseURL + 'sys/oss/upload?token=' + token,
              name: 'file',
              autoSubmit:true,
              responseType:"json",
              onSubmit:function(file, extension){
                  if (!(extension && /^(jpg|jpeg|png|gif)$/.test(extension.toLowerCase()))){
                      alert('只支持jpg、png、gif格式的图片！');
                      return false;
                  }
              },
              onComplete : function(file, r){
                  if(r.code == 0){
                  	$("#icon").val(r.url);
                  	vm.theme.icon = r.url;
                  	$("#upload").hide();
            		$(".multi-img-details").append('<div class="multi-item"><img src="'+r.url+'" class="img-responsive img-thumbnail"><input type="hidden" class="form-control"  value="'+r.url+'"><em class="close" title="删除这张图片" onclick="deleteMultiImage(this)">×</em></div>');
                    alert("上传成功");
                  }else{
                      alert(r.msg);
                  }
              }
          }); 
      },
      getParentTheme: function () {            
          $.get(baseURL + "article/theme/selectTheme", function(r){
       	   for ( var i = 0; i < r.length; i++) {
       		   $("#parentId").append("<option value='"+r[i].themeId+"'>"+r[i].name+"</option>");
       	   }
       	   
          })
       },
		reload: function (event) {
            vm.showList = true;
            Theme.table.refresh();
		}
	}
});