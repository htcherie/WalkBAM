
var _menus_oneLeve=[{"menuid":"0","menuname":"首页","icon":"fa-home"},{"menuid":"1","menuname":"数据管理","icon":"fa-list"}];
var _menus=[
    {"menuid":"00","icon":"fa-trophy","menuname":"今日数据",parentMenu:'0',
        "menus":[{"menuid":"000","menuname":"视图","icon":"fa-dashboard","url":"dashboard.html"}
            ]},{
     "menuid":"01","icon":"fa-television","menuname":"基础服务",parentMenu:'0',
        "menus":[
                {"menuid":"011","menuname":"公告通知","icon":"fa-volume-up","url":"dashboard.html"}
            ]
    },
	{"menuid":"11","icon":"fa-address-card","menuname":"用户管理",parentMenu:'1',
		"menus":[{"menuid":"110","menuname":"用户管理","icon":"fa-address-card","url":"userMag.html"}
			]},
    {"menuid":"12","icon":"fa-users","menuname":"商家管理",parentMenu:'1',
        "menus":[{"menuid":"120","menuname":"商家管理","icon":"fa-users","url":"merchantMag.html"},
            {"menuid":"121","menuname":"商家审核","icon":"fa-user-plus","url":"merchantAudit.html"}
        ]},
    {"menuid":"13","icon":"fa-trophy","menuname":"景点管理",parentMenu:'1',
        "menus":[{"menuid":"130","menuname":"景点管理","icon":"fa-window-restore","url":"sceneMag.html"}
        ]}
		
];

    //设置登录窗口
    function openPwd() {$('#updatePwd').window({title: '修改密码', width: 300, modal: true, shadow: true, closed: true, height: 160, resizable:false }); }
    //关闭登录窗口
    function closePwd() {$('#updatePwd').window('close');}

    //修改密码
    function serverLogin() {
        var $newpass = $('#txtNewPass');
        var $rePass = $('#txtRePass');

        if ($newpass.val() == '') {
            msgShow('系统提示', '请输入密码！', 'admin');
            return false;
        }
        if ($rePass.val() == '') {
            msgShow('系统提示', '请在一次输入密码！', 'admin');
            return false;
        }

        if ($newpass.val() != $rePass.val()) {
            msgShow('系统提示', '两次密码不一至！请重新输入', 'admin');
            return false;
        }

        $.ajax({
            url:"modifyPwd.action",
            type: "post",
            dataType: "json",
            data: {
                "pwd":$newpass.val()
            },
            success: function (data) {
                msgShow('系统提示', '恭喜，密码修改成功！<br>您的新密码为：' + data["res"], 'info');
                $newpass.val('');
                $rePass.val('');
                closePwd();
            }
        });

        
    }

    $(function() {
        openPwd();

        $('#editpass').click(function(){$('#updatePwd').window('open');});

        $('#btnEp').click(function(){serverLogin();});

		$('#btnCancel').click(function(){closePwd();});

        $('#loginOut').click(function() {
            $.messager.confirm('系统提示', '您确定要退出本次登录吗?', function(r) {

                if (r) {
                    location.href = 'escBAM.action';
                }
            });
        })
    });

$(function(){var mydate = new Date(); var tm=mydate.getFullYear(); $("#timeYear").text(tm); });