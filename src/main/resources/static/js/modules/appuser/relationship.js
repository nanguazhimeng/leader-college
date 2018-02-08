$(function () {
    $("#jqGrid").jqGrid({
        url: baseURL + 'appuser/relationship/list',
        datatype: "json",
        colModel: [			
			{ label: '代理商ID', name: 'relationshipId', index: 'RELATIONSHIP_ID', width: 50, key: true },
			{ label: '用户', name: 'uid', index: 'UID', width: 150 ,formatter: function(item, index,object){
				return object.mobile+"|"+object.username;
			}},
			{ label: '等级', name: 'rolename', index: 'rolename', width: 80 },
			{ label: '上级', name: 'pname', index: 'pname', width: 80 }, 
			{ label: '个人消费', name: 'personal', index: 'PERSONAL', width: 80 ,formatter: function(item, index){
				return item.toFixed(2);
			}},		 
			{ label: '个人业绩', name: 'individualPerformance', index: 'INDIVIDUAL_PERFORMANCE', width: 80 ,formatter: function(item, index){
				return item.toFixed(2);
			}},		  			
			{ label: '团队业绩', name: 'teamPerformance', index: 'TEAM_PERFORMANCE', width: 80 ,formatter: function(item, index){
				return item.toFixed(2);
			}},		  			
			{ label: '总佣金', name: 'totalCommission', index: 'TOTAL_COMMISSION', width: 80 ,formatter: function(item, index){
				return item.toFixed(2);
			}},		  			
			{ label: '未提佣金', name: 'commission', index: 'COMMISSION', width: 80 ,formatter: function(item, index){
				return item.toFixed(2);
			}},		  			
			{ label: '真实姓名', name: 'realname', index: 'REALNAME', width: 80 }, 
			{ label: '银行信息', name: 'account', index: 'ACCOUNT', width: 200 ,formatter: function(item, index,object){
				if(object.account!=null){
					return object.account+"|"+object.bankname;
				}else{
					return "";
				}
			}},	
			{ label: '状态', name: 'status', index: 'REALNAME', width: 80 ,formatter: function(item, index){
				if(item==0){
					return '<span class="text-default">未审核</span>';
				}else if(item==1){
					return '<span class="text-success">审核通过</span>';
				}else if(item==2){
					return '<span class="text-danger">审核中</span> <a class="btn btn-success btn-xs" onclick="confirmStatus(\''+object.orderId+'\',\''+object.status+'\');">审核</a>';
				}
			}},	
			{ label: '通过时间', name: 'checkTime', index: 'CHECK_TIME', width: 80 }
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
});

var vm = new Vue({
	el:'#rrapp',
	data:{
		q:{
			keywords: null,
			commission:'',
			roleId: null
		},
		showList: true,
		title: null,
		relationship: {}
	},
	methods: {
		query: function () {
			vm.reload();
		},
		add: function(){
			vm.showList = false;
			vm.title = "新增";
			vm.relationship = {};
		},
		update: function (event) {
			var relationshipId = getSelectedRow();
			if(relationshipId == null){
				return ;
			}
			vm.showList = false;
            vm.title = "修改";
            
            vm.getInfo(relationshipId)
		},
		saveOrUpdate: function (event) {
			var url = vm.relationship.relationshipId == null ? "appuser/relationship/save" : "appuser/relationship/update";
			$.ajax({
				type: "POST",
			    url: baseURL+url,
			    contentType: "application/json",
			    data: JSON.stringify(vm.relationship),
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
		withdraw:function(event){
			var relationshipId = getSelectedRow();
			if(relationshipId == null){
				return ;
			}
			vm.getInfo(relationshipId);
			var commission = vm.relationship.commission;
			if(commission==null||commission<=0){
				alert("佣金不足");
				return ;
			}
			vm.getInfo(relationshipId);
			var user = vm.relationship.username+"|"+vm.relationship.account;
			var commission = vm.relationship.commission;
			
			confirm('确定已打款给用户《'+user+'》'+commission+'元？', function(){
				$.ajax({
					type: "POST",
				    url:  baseURL +"appuser/relationship/withdraw",
				    contentType: "application/json",
				    data: JSON.stringify(relationshipId),
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
		del: function (event) {
			var relationshipIds = getSelectedRows();
			if(relationshipIds == null){
				return ;
			}
			
			confirm('确定要删除选中的记录？', function(){
				$.ajax({
					type: "POST",
				    url:  baseURL +"appuser/relationship/delete",
				    contentType: "application/json",
				    data: JSON.stringify(relationshipIds),
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
		getInfo: function(relationshipId){
			$.get(baseURL +"appuser/relationship/info/"+relationshipId, function(r){
                vm.relationship = r.relationship;
            });
		},
		reload: function (event) {
			vm.showList = true;
			var page = $("#jqGrid").jqGrid('getGridParam','page');
			$("#jqGrid").jqGrid('setGridParam',{ 
				postData:{'keywords': vm.q.keywords,'roleId': vm.q.roleId,'commission':vm.q.commission},
                page:page
            }).trigger("reloadGrid");
		}
	}
});