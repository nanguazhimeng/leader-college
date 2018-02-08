var setting = {
    data: {
        simpleData: {
            enable: true,
            idKey: "goodscategoryId",
            pIdKey: "pid",
            rootPId: -1
        },
        key: {
            url:"nourl"
        }
    }
};
var ztree;
var Goodscategory = {
	    id: "goodscategoryTable",
	    table: null,
	    layerIndex: -1
	};
/**
 * 初始化表格的列
 */
Goodscategory.initColumn = function () {
    var columns = [
            {field: 'selectItem', radio: true},
            {title: 'goodscategoryId', field: 'goodscategoryId',visible: false, align: 'center', valign: 'middle', width: '80px'},
	        {title: '名称', field: 'name', align: 'center', valign: 'middle', sortable: true, width: '180px'},
            {title: '上级分类', field: 'parentName', align: 'center', valign: 'middle', sortable: true, width: '100px'},
	        {title: '分类图片', field: 'icon', align: 'center', valign: 'middle', sortable: true, width: '50px', formatter: function(item, index){
	        	return item.icon == null ? '' : '<img height="50" width="50"  src="'+item.icon+'">';
			}},
	        {title: '是否显示', field: 'enabled', align: 'center', valign: 'middle', sortable: true, width: '80px'},
	        {title: '首页推荐', field: 'ishome', align: 'center', valign: 'middle', sortable: true, width: '80px'},
	        {title: '排序', field: 'displayorder', align: 'center', valign: 'middle', sortable: true, width: '50px'}
           ]
    return columns;
}
function getGoodscategoryId () {
    var selected = $('#goodscategoryTable').bootstrapTreeTable('getSelections');
    if (selected.length == 0) {
        alert("请选择一条记录");
        return false;
    } else {
        return selected[0].id;
    }
}
$(function () {
    var colunms = Goodscategory.initColumn();
    var table = new TreeTable(Goodscategory.id, baseURL + "shop/goodscategory/list", colunms);
    table.setExpandColumn(2);
    table.setIdField("goodscategoryId");
    table.setCodeField("goodscategoryId");
    table.setParentCodeField("pid");
    table.setExpandAll(false);
    table.init();
    Goodscategory.table = table;
	
    vm.initUpload();
});

var vm = new Vue({
	el:'#rrapp',
	data:{
		showList: true,
		title: null,
		goodscategory: {
			 parentName:null,
		     pid:0,
			 type:0,
			 displayorder:0
		}
	},
	methods: {
		query: function () {
			vm.reload();
		},
		add: function(){
			vm.getGoodscategory();
			var selected = $('#goodscategoryTable').bootstrapTreeTable('getSelections');
			if (selected.length != 0 && selected[0].level == 1) {
		    	var goodscategoryId = selected[0].id;
		    	var level = 1;
		    } else{
		    	var level = 2;
		    }
			vm.showList = false;
			vm.title = "新增";
			vm.goodscategory = { parentName:null, pid:goodscategoryId, level:level,displayorder:0,ishome:0,enabled:1};
			
			$("#upload").show();
			$(".multi-img-details").html("");
		},
		update: function (event) {
//			vm.getGoodscategory();
			var goodscategoryId = getGoodscategoryId();
			if(goodscategoryId == null){
				return ;
			}
			vm.showList = false;
            vm.title = "修改";
            
            vm.getInfo(goodscategoryId)
		},
		saveOrUpdate: function (event) {
			var url = vm.goodscategory.goodscategoryId == null ? "shop/goodscategory/save" : "shop/goodscategory/update";
			$.ajax({
				type: "POST",
			    url: baseURL+url,
			    contentType: "application/json",
			    data: JSON.stringify(vm.goodscategory),
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
        goodscategoryTree: function(){
            layer.open({
                type: 1,
                offset: '50px',
                skin: 'layui-layer-molv',
                title: "选择分类",
                area: ['300px', '450px'],
                shade: 0,
                shadeClose: false,
                content: jQuery("#goodscategoryLayer"),
                btn: ['确定', '取消'],
                btn1: function (index) {
                    var node = ztree.getSelectedNodes();
                    //选择上级菜单
                    vm.goodscategory.pid = node[0].goodscategoryId;
                    vm.goodscategory.parentName = node[0].name;
                    
                    if(vm.goodscategory.pid == 0){
                    	vm.goodscategory.level = 1
                    }else{
                    	vm.goodscategory.level = 2
                    }
                    if(node[0].level==2){
                    	alert("最多只能两级分类");
                    	return false;
                    }
                    layer.close(index);
                }
            });
        },
		del: function (event) {
			var goodscategoryId = getGoodscategoryId();
			if(goodscategoryId == null){
				return ;
			}
			alert(goodscategoryId);
			confirm('确定要删除选中的记录？', function(){
				$.ajax({
					type: "POST",
				    url:  baseURL +"shop/goodscategory/delete",
				    data: "goodscategoryId=" + goodscategoryId,
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
		getInfo: function(goodscategoryId){
			$.get(baseURL +"shop/goodscategory/info/"+goodscategoryId, function(r){
                vm.goodscategory = r.goodscategory;
                var icon = vm.goodscategory.icon;
                if(icon!=null){
                	$("#upload").hide();
            		$(".multi-img-details").html('<div class="multi-item"><img src="'+icon+'" class="img-responsive img-thumbnail"><input type="hidden" class="form-control"  value="'+icon+'"><em class="close" title="删除这张图片" onclick="deleteMultiImage(this)">×</em></div>');
                }
                vm.getGoodscategory();
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
                  	vm.goodscategory.icon = r.url;
                  	$("#upload").hide();
            		$(".multi-img-details").append('<div class="multi-item"><img src="'+r.url+'" class="img-responsive img-thumbnail"><input type="hidden" class="form-control"  value="'+r.url+'"><em class="close" title="删除这张图片" onclick="deleteMultiImage(this)">×</em></div>');
                    alert("上传成功");
                  }else{
                      alert(r.msg);
                  }
              }
          }); 
      },
      getGoodscategory: function () {  
          //加载分类树
          $.get(baseURL + "shop/goodscategory/select", function(r){
              ztree = $.fn.zTree.init($("#goodscategoryTree"), setting, r.goodscategoryList);
              var node = ztree.getNodeByParam("goodscategoryId", vm.goodscategory.pid);
              ztree.selectNode(node);
              vm.goodscategory.parentName = node.name;
          })
       },
		reload: function (event) {
            vm.showList = true;
            Goodscategory.table.refresh();
		}
	}
});

