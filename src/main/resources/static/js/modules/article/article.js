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

$(function () {
    $("#jqGrid").jqGrid({
        url: baseURL + 'article/article/list',
        datatype: "json",
        colModel: [			
			{ label: 'articleId', name: 'articleId', index: 'article_id',hidden:true, width: 50, key: true },
			{ label: '主题', name: 'themeName', index: 'themeName', width: 80 }, 			
			{ label: '标题', name: 'title', index: 'title', width: 80 }, 			
			{ label: '类型', name: 'contentType', index: 'content_type', width: 80, formatter: function(item, index){
	        	if(item==1){
	        		return "文章";
	        	}else if(item==2){
	        		return "音频";
	        	}else if(item==3){
	        		return "视频";
	        	}
			}},					
			{ label: '封面图片', name: 'coverImg', index: 'cover_img', width: 80 , formatter: function(item, index){
	        	return item == null ? '' : '<img height="50" width="50"  src="'+item+'">';
			}},		
			{ label: '内容', name: 'url', index: 'url', width: 80 , formatter: function(item, index){
	        	return item == null ? '' : '<a  href="'+item+'"  target="_blank">点击查看</a>';
			}},			
			{ label: '时长/阅读时长', name: 'duration', index: 'duration', width: 80 }	,
			{ label: '创建时间', name: 'createTime', index: 'create_time', width: 80 }, 			
			{ label: '排序', name: 'playOrder', index: 'play_order', width: 80 }		
        ],
		viewrecords: true,
        height: 385,
        rowNum: 10,
		rowList : [10,30,50],
        rownumbers: true, 
        rownumWidth: 25, 
        autowidth:true,
        multiselect: true,
        pager: "#jqGridPager",
        jsonReader : {
            root: "page.list",
            page: "page.currPage",
            total: "page.totalPage",
            records: "page.totalCount"
        },
        prmNames : {
            page:"page", 
            rows:"limit", 
            order: "order"
        },
        gridComplete:function(){
        	//隐藏grid底部滚动条
        	$("#jqGrid").closest(".ui-jqgrid-bdiv").css({ "overflow-x" : "hidden" }); 
        }
    });
    vm.initUpload();
    vm.initUpload2();
});

var vm = new Vue({
	el:'#rrapp',
	data:{
		showList: true,
		title: null,
		theme:{
			parentName:null,
            parentId:0
            },
		article: {themeId:null,themeName:null,contentType:1,playOrder:0}
	},
	methods: {
        getTheme: function(themeId){
            //加载菜单树
            $.get(baseURL + "article/theme/select", function(r){
                ztree = $.fn.zTree.init($("#themeTree"), setting, r.themeList);
                var node = ztree.getNodeByParam("themeId", vm.article.themeId);
                ztree.selectNode(node);
                vm.article.themeName = node.name;
            })
        },
		query: function () {
			vm.reload();
		},
		add: function(){
			vm.showList = false;
			vm.title = "新增";
			vm.article = {themeId:null,themeName:null,contentType:1,playOrder:0};
			vm.getTheme();
		},
		update: function (event) {
			var articleId = getSelectedRow();
			if(articleId == null){
				return ;
			}
			vm.showList = false;
            vm.title = "修改";
            
            vm.getInfo(articleId)
		},
		saveOrUpdate: function (event) {
			var url = vm.article.articleId == null ? "article/article/save" : "article/article/update";
			$.ajax({
				type: "POST",
			    url: baseURL+url,
			    contentType: "application/json",
			    data: JSON.stringify(vm.article),
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
			var articleIds = getSelectedRows();
			if(articleIds == null){
				return ;
			}
			
			confirm('确定要删除选中的记录？', function(){
				$.ajax({
					type: "POST",
				    url:  baseURL +"article/article/delete",
				    contentType: "application/json",
				    data: JSON.stringify(articleIds),
				    success: function(r){
						if(r.code == 0){
							alert('操作成功', function(index){
								$("#jqGrid").trigger("reloadGrid");
							});
						}else{
							alert(r.msg);
						}
					}
				});
			});
		},
		getInfo: function(articleId){
			$.get(baseURL +"article/article/info/"+articleId, function(r){
                vm.article = r.article;
                var coverImg = vm.article.coverImg;
                vm.getTheme();
                if(coverImg!=null){
                	$("#upload").hide();
            		$(".multi-img-details").html('<div class="multi-item"><img src="'+coverImg+'" class="img-responsive img-thumbnail"><input type="hidden" class="form-control"  value="'+coverImg+'"><em class="close" title="删除这张图片" onclick="deleteMultiImage(this)">×</em></div>');
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
                    	$("#coverImg").val(r.url);
                    	vm.article.coverImg = r.url;
                    	$("#upload").hide();
                    	$(".multi-img-details").append('<div class="multi-item"><img src="'+r.url+'" class="img-responsive img-thumbnail"><input type="hidden" class="form-control"  value="'+r.url+'"><em class="close" title="删除这张图片" onclick="deleteMultiImage(this)">×</em></div>');
                    	alert("上传成功");
                    }else{
                        alert(r.msg);
                    }
                }
            }); 
        },
        initUpload2: function(){
            new AjaxUpload('#upload2', {
                action: baseURL + 'sys/oss/upload?token=' + token,
                name: 'file',
                autoSubmit:true,
                responseType:"json",
                onSubmit:function(file, extension){
                	if(vm.article.contentType==2&&!(extension && /^(wav|mp3|wma|ogg|ape|acc)$/.test(extension.toLowerCase()))){
                        alert('只支持wav|mp3|wma|ogg|ape|acc格式的音频！');
                        return false;
                	}else if(vm.article.contentType==3&&!(extension && /^(mp4|avi|mpeg|rmvb)$/.test(extension.toLowerCase()))){
                        alert('只支持mp4|avi|mpeg|rmvb格式的视频！');
                        return false;
                	}
                },
                onComplete : function(file, r){
                    if(r.code == 0){
                    	$("#url").val(r.url);
                    	vm.article.url = r.url;
                    	alert("上传成功");
                    }else{
                        alert(r.msg);
                    }
                }
            }); 
        },
        themeTree: function(){
            layer.open({
                type: 1,
                offset: '50px',
                skin: 'layui-layer-molv',
                title: "选择主题",
                area: ['300px', '450px'],
                shade: 0,
                shadeClose: false,
                content: jQuery("#themeLayer"),
                btn: ['确定', '取消'],
                btn1: function (index) {
                    var node = ztree.getSelectedNodes();
                    //选择上级菜单
                    if(node[0].type==0){
                    	alert("请选择具体主题");
                    	return false;
                    }
                    vm.article.contentType = node[0].contentType;
                    
                    vm.article.themeId = node[0].themeId;
                    vm.article.themeName = node[0].name;

                    layer.close(index);
                }
            });
        },
		reload: function (event) {
			vm.showList = true;
			var page = $("#jqGrid").jqGrid('getGridParam','page');
			$("#jqGrid").jqGrid('setGridParam',{ 
                page:page
            }).trigger("reloadGrid");
		}
	}
});